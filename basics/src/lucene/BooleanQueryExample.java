package lucene;

import java.io.File;
import java.io.IOException;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.search.BooleanClause;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.FSDirectory;

public class BooleanQueryExample {
	
	public static void main(String[] args) throws CorruptIndexException, IOException, ParseException {

		final int maxHits = 3;
		final String field = "content";
		String queryText1 = "colonoscopy";
		String queryText2 = "yesterday";
		
  	IndexReader indexReader = IndexReader.open(FSDirectory.open(new File("/home/dima/data/mimic/index/")));
  	IndexSearcher indexSearcher = new IndexSearcher(indexReader);

  	// can create query using query parser
  	// Analyzer standardAnalyzer = new StandardAnalyzer(Version.LUCENE_35);
  	// QueryParser queryParser = new QueryParser(Version.LUCENE_35, field, standardAnalyzer);
  	// Query query1 = queryParser.parse(queryText1);
  	// Query query2 = queryParser.parse(queryText2);
  	
  	// can create query directly from terms (without query parser)
  	Query query1 = new TermQuery(new Term(field, queryText1));
  	Query query2 = new TermQuery(new Term(field, queryText2));
  	
  	BooleanQuery booleanQuery = new BooleanQuery();
  	booleanQuery.add(query1, BooleanClause.Occur.MUST);
  	booleanQuery.add(query2, BooleanClause.Occur.MUST);
  	
  	TopDocs topDocs = indexSearcher.search(booleanQuery, maxHits);
  	ScoreDoc[] scoreDocs = topDocs.scoreDocs;
  	
  	for(ScoreDoc scoreDoc : scoreDocs) {
  		Document doc = indexSearcher.doc(scoreDoc.doc);
  		String text = doc.get(field);
  		System.out.println("*** " + text.replace("\n", " "));
  	}
	}
}

