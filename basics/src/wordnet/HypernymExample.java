package wordnet;

import java.io.IOException;
import java.util.HashSet;

public class HypernymExample {

	public static void main(String[] args) throws IOException {
		
		HashSet<String> hypernyms = WordNetUtils.getHypernyms(WordNetUtils.getDictionary(), "call", "VB", true);
		System.out.println(hypernyms);
	}
}
