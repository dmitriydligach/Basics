package old;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.queryParser.ParseException;

public class TestCosineSimilarity {

	public static void main(String[] args) throws CorruptIndexException, IOException, ParseException {
		
		WikipediaIndex wikipediaIndex = new WikipediaIndex();
		wikipediaIndex.initialize();
		
    double cosine1 = wikipediaIndex.getCosineSimilarityUsingNHits("heart disease", "smoking");
    System.out.println(cosine1);

    double cosine2 = wikipediaIndex.getCosineSimilarityUsingNHits("aspirin", "tylenol");
    System.out.println(cosine2);
    
    double cosine3 = wikipediaIndex.getCosineSimilarityUsingNHits("aspirin", "ibuprofen");
    System.out.println(cosine3);
    
		wikipediaIndex.close();
	}
}
