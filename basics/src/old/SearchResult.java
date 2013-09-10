package old;

public class SearchResult {
	
	public String documentTitle;
	public float documentScore;
	
	public SearchResult(String documentTitle, float documentScore) {
		this.documentTitle = documentTitle;
		this.documentScore = documentScore;
	}
	
	public String toString() {
		return String.format("%s (%s)", documentTitle, documentScore);
	}
}
