package old;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.queryParser.ParseException;

public class TestIndexSearch {

	public static void main(String[] args) throws CorruptIndexException, IOException, ParseException {
		
		WikipediaIndex wikipediaIndex = new WikipediaIndex();
		wikipediaIndex.initialize();
		
		for(SearchResult searchResult : wikipediaIndex.search("mammogram picked up mass in right breast")) {
			System.out.println(searchResult.documentTitle + " => " + searchResult.documentScore);
		}
		
		wikipediaIndex.close();
	}
}
