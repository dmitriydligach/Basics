package lucene;

import java.io.File;
import java.io.IOException;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

public class SearchLuceneIndex {
	
	public static void main(String[] args) throws CorruptIndexException, IOException, ParseException {

		final int maxHits = 3;
		final String field = "content";
		String queryText = "colonoscopy";
		
  	IndexReader indexReader = IndexReader.open(FSDirectory.open(new File("/home/dima/data/mimic/index/")));
  	IndexSearcher indexSearcher = new IndexSearcher(indexReader);
  	Analyzer standardAnalyzer = new StandardAnalyzer(Version.LUCENE_35);
  	QueryParser queryParser = new QueryParser(Version.LUCENE_35, field, standardAnalyzer);
  	
  	String escaped = QueryParser.escape(queryText);
  	Query query = queryParser.parse(escaped);
  	
  	TopDocs topDocs = indexSearcher.search(query, maxHits);
  	ScoreDoc[] scoreDocs = topDocs.scoreDocs;
  	
  	for(ScoreDoc scoreDoc : scoreDocs) {
  		Document doc = indexSearcher.doc(scoreDoc.doc);
  		String text = doc.get(field);
  		System.out.println("*** " + text.replace("\n", " "));
  	}
	}
}

