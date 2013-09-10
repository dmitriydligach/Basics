package lucene;

import java.io.File;
import java.io.IOException;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

import com.google.common.base.Charsets;
import com.google.common.io.Files;

public class CreateLuceneIndex {

	public static void main(String[] args) throws IOException {
		
		Directory directory = FSDirectory.open(new File("/home/dima/data/mimic/index/"));
		Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_35);
		IndexWriterConfig indexWriterConfig = new IndexWriterConfig(Version.LUCENE_35, analyzer);
		IndexWriter indexWriter = new IndexWriter(directory, indexWriterConfig);

		File rootDir = new File("/home/dima/mnt/pub/resources/mimic/text/");
		for(File dir : rootDir.listFiles()) {
			for(File file : dir.listFiles()) {
				String text = Files.toString(file, Charsets.UTF_8);
				Document document = new Document();
				document.add(new Field("content", text, Field.Store.YES, Field.Index.ANALYZED, Field.TermVector.YES));
				indexWriter.addDocument(document);
			}
		}

		indexWriter.close();
		System.out.println("done!");
	}
}
