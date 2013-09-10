package old;

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
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

public class Lucene {
  
  public static void main(String[] args) {

  	IndexReader reader = null;
    IndexSearcher searcher = null;
    Analyzer analyzer = null;
    QueryParser parser = null;

    try {
    	reader = IndexReader.open(FSDirectory.open(new File("/home/dima/i2b2/wiki-index/index_vectors_notext/")));
    	searcher = new IndexSearcher(reader);
    	analyzer = new StandardAnalyzer(Version.LUCENE_35);
    	parser = new QueryParser(Version.LUCENE_35, "text", analyzer);
    } catch (CorruptIndexException e) {
    	System.out.println("Corrupt Index during init");
    	System.exit(-1);
    } catch (IOException e) {
    	System.out.println("IOException initializing index.");
    	System.exit(-1);
    }

    try {
    	Query query = parser.parse("aspirin");
    	
    	ScoreDoc[] hits = searcher.search(query, null, 10).scoreDocs;
    	
    	for(int i = 0; i < hits.length; i++) {
    		Document hitDoc = searcher.doc(hits[i].doc);
    		System.out.println(hitDoc.get("title"));
    	}
    	
    	System.out.println();
    } catch (ParseException e) {
    	System.out.println("Error parsing query");
    	e.printStackTrace();
    } catch (IOException e) {
    	System.out.println("IOException doing search");
    	e.printStackTrace();
    }
  }
}
