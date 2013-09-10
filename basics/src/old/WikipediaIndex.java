package old;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.Term;
import org.apache.lucene.index.TermFreqVector;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.DefaultSimilarity;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

/**
 * A wrapper for a wikipedia lucene index.
 * 
 * @author dmitriy dligach
 *
 */
public class WikipediaIndex {

	private final int defaultTotalHits = 10;
	private final String defaultIndexPath = "/home/dima/i2b2/wiki-index/index_vectors_notext/";
	
	private int totalHits;
	private String indexPath;
	
	private IndexReader indexReader;
  private IndexSearcher indexSearcher;
  private Analyzer standardAnalyzer;
  private QueryParser queryParser;
  private DefaultSimilarity defaultSimilarity;
  
  public WikipediaIndex(int totalHits, String indexPath) {
  	this.totalHits = totalHits;
  	this.indexPath = indexPath;
  }
  
  public WikipediaIndex() {
  	totalHits = defaultTotalHits;
  	indexPath = defaultIndexPath;
  }
  
  public void initialize() throws CorruptIndexException, IOException {

  	indexReader = IndexReader.open(FSDirectory.open(new File(indexPath)));
  	indexSearcher = new IndexSearcher(indexReader);
  	standardAnalyzer = new StandardAnalyzer(Version.LUCENE_35);
  	queryParser = new QueryParser(Version.LUCENE_35, "text", standardAnalyzer);
  	defaultSimilarity = new DefaultSimilarity();
  }
  
  /**
   * Search the index. Return a list of article titles and their scores.
   */
  public ArrayList<SearchResult> search(String queryText) throws ParseException, IOException {

  	ArrayList<SearchResult> articleTitles = new ArrayList<SearchResult>();
  	
  	String escaped = QueryParser.escape(queryText);
  	Query query = queryParser.parse(escaped);
  	
  	ScoreDoc[] scoreDocs = indexSearcher.search(query, null, totalHits).scoreDocs;
  	for(int i = 0; i < scoreDocs.length; i++) {
  		Document doc = indexSearcher.doc(scoreDocs[i].doc);
  		articleTitles.add(new SearchResult(doc.get("title"), scoreDocs[i].score));
  	}
  	
  	return articleTitles;
  }

  /**
   * Send two queries to the index. 
   * Return cosine similarity between the two top matching documents.
   */
  public double getCosineSimilarityUsingTopHit(String queryText1, String queryText2) throws ParseException, IOException {

  	String escaped1 = QueryParser.escape(queryText1);
  	Query query1 = queryParser.parse(escaped1);
  	ScoreDoc[] scoreDocs1 = indexSearcher.search(query1, null, totalHits).scoreDocs;
  	
  	if(scoreDocs1.length == 0) {
  		return 0;
  	}

  	// for the first query, map words in the top hit to their tfidf scores
  	HashMap<String, Double> vector1 = makeTfIdfVector(indexReader.getTermFreqVector(scoreDocs1[0].doc, "text"));
  	
  	String escaped2 = QueryParser.escape(queryText2);
  	Query query2 = queryParser.parse(escaped2);
  	ScoreDoc[] scoreDocs2 = indexSearcher.search(query2, null, totalHits).scoreDocs;
  	
  	if(scoreDocs2.length == 0) {
  		return 0;
  	}
  	
  	// for the second query, map words in the top hit to their tfidf scores
  	HashMap<String, Double> vector2 = makeTfIdfVector(indexReader.getTermFreqVector(scoreDocs2[0].doc, "text"));
  	
  	double dotProduct = computeDotProduct(vector1, vector2);
  	double norm1 = computeEuclideanNorm(vector1);
  	double norm2 = computeEuclideanNorm(vector2);
  	
  	return dotProduct / (norm1 * norm2);
  }

  /**
   * Send two queries to the index.
   * For each query, form a tfidf vector that represents N top matching documents.
   * Return cosine similarity between the two tfidf vectors.
   */
  public double getCosineSimilarityUsingNHits(String queryText1, String queryText2) throws ParseException, IOException {

  	String escaped1 = QueryParser.escape(queryText1);
  	Query query1 = queryParser.parse(escaped1);
  	ScoreDoc[] scoreDocs1 = indexSearcher.search(query1, null, totalHits).scoreDocs;
  	
  	if(scoreDocs1.length == 0) {
  		return 0;
  	}

  	ArrayList<TermFreqVector> termFreqVectors1 = new ArrayList<TermFreqVector>();
  	for(ScoreDoc scoreDoc : scoreDocs1) {
  		termFreqVectors1.add(indexReader.getTermFreqVector(scoreDoc.doc, "text"));
  	}
  	HashMap<String, Double> vector1 = makeTfIdfVector(termFreqVectors1);
  	
  	String escaped2 = QueryParser.escape(queryText2);
  	Query query2 = queryParser.parse(escaped2);
  	ScoreDoc[] scoreDocs2 = indexSearcher.search(query2, null, totalHits).scoreDocs;
  	
  	if(scoreDocs2.length == 0) {
  		return 0;
  	}
  	
  	ArrayList<TermFreqVector> termFreqVectors2 = new ArrayList<TermFreqVector>();
  	for(ScoreDoc scoreDoc : scoreDocs2) {
  		termFreqVectors2.add(indexReader.getTermFreqVector(scoreDoc.doc, "text"));
  	}
  	HashMap<String, Double> vector2 = makeTfIdfVector(termFreqVectors2);
  	
  	double dotProduct = computeDotProduct(vector1, vector2);
  	double norm1 = computeEuclideanNorm(vector1);
  	double norm2 = computeEuclideanNorm(vector2);
  	
  	return dotProduct / (norm1 * norm2);
  }
  
  /**
   * Return a hash table that maps terms to their tfidf values. 
   * The input is a single TermFreqVector object.
   */
  private HashMap<String, Double> makeTfIdfVector(TermFreqVector termFreqVector) throws IOException {

  	// map terms to their tfidf values
  	HashMap<String, Double> tfIdfVector = new HashMap<String, Double>(); 
  	
  	String[] terms = termFreqVector.getTerms();
  	int[] freqs = termFreqVector.getTermFrequencies();
  	
  	for(int i = 0; i < terms.length; i++) {
  		double tf = defaultSimilarity.tf(freqs[i]);
  		double idf = defaultSimilarity.idf(indexReader.docFreq(new Term("text", terms[i])), indexReader.numDocs());
  		tfIdfVector.put(terms[i], tf * idf);
  	}
  	
  	return tfIdfVector;
  }


  /**
   * Return a hash table that maps terms to their tfidf values.
   * The input is a list of TermFreqVector objects. The return
   * value is formed by summing up individual tfidf vectors.
   */
  private HashMap<String, Double> makeTfIdfVector(ArrayList<TermFreqVector> termFreqVectors) throws IOException {

  	// map terms to their tfidf values
  	HashMap<String, Double> tfIdfVector = new HashMap<String, Double>(); 

  	for(TermFreqVector termFreqVector : termFreqVectors) {
  		String[] terms = termFreqVector.getTerms();
  		int[] freqs = termFreqVector.getTermFrequencies();

  		for(int i = 0; i < terms.length; i++) {
  			double tf = defaultSimilarity.tf(freqs[i]);
  			double idf = defaultSimilarity.idf(indexReader.docFreq(new Term("text", terms[i])), indexReader.numDocs());
  			
  			if(tfIdfVector.containsKey(terms[i])) {
  				tfIdfVector.put(terms[i], tfIdfVector.get(terms[i]) + tf * idf);
  			}
  			else {
  				tfIdfVector.put(terms[i], tf * idf);
  			}
  		}
  	}
  	
  	return tfIdfVector;
  }
  
  private double computeEuclideanNorm(HashMap<String, Double> tfIdfVector) {
  	
  	double sumOfSquares = 0;
  	
  	for(double tfidf : tfIdfVector.values()) {
  		sumOfSquares = sumOfSquares + Math.pow(tfidf, 2);
  	}
  	
  	return Math.sqrt(sumOfSquares);
  }
  
  private double computeDotProduct(HashMap<String, Double> vector1, HashMap<String, Double> vector2) {
  	
  	double dotProduct = 0;
  	
  	for(String term : vector1.keySet()) {
  		if(vector1.containsKey(term) && vector2.containsKey(term)) {
  			dotProduct = dotProduct + vector1.get(term) * vector2.get(term);
  		}
  	}
  	
  	return dotProduct;
  }
  
  public void close() throws IOException {
  	
  	indexReader.close();
  	indexSearcher.close();
  	standardAnalyzer.close();
  }
}
