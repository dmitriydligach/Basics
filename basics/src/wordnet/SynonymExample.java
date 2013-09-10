package wordnet;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;

import edu.mit.jwi.IDictionary;

public class SynonymExample {

	public static void main(String[] args) throws IOException {
		
		String word = "dogs";
		String pos = "NNS";
		
		IDictionary iDictionary = WordNetUtils.getDictionary();
		List<String> stems = WordNetUtils.getStems(word, pos, iDictionary);

		if(stems.size() > 0) {
			HashSet<String> synonyms = WordNetUtils.getSynonyms(iDictionary, stems.get(0), pos, true);
			System.out.println(synonyms);
		}
	}
}
