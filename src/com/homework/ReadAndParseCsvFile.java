package com.homework;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Reaing a simple document csv file
 * @author student
 *
 */
public class ReadAndParseCsvFile {
	
	/**
	 * Object using to store one document
	 * @author student
	 *
	 */
	class Document {
		private int docId = -1;
		private int catId = -1;
		private int topicId = -1;
		private List<String> tags = new ArrayList<>();
		private String fileName = "";
		
		// Constructors
		// No args
		public Document() {
			;
		}
		// Can be used to initialize all fields 
		public Document(int docId, int catId, int topicId, String tags, String fileName) {
			super();
			this.docId = docId;
			this.catId = catId;
			this.topicId = topicId;
			this.tags = Arrays.asList(tags.split(" "));
			this.fileName = fileName;
		}
		public int getDocId() {
			return docId;
		}
		public void setDocId(int docId) {
			this.docId = docId;
		}
		public int getCatId() {
			return catId;
		}
		public void setCatId(int catId) {
			this.catId = catId;
		}
		public int getTopicId() {
			return topicId;
		}
		public void setTopicId(int topicId) {
			this.topicId = topicId;
		}
		public List<String> getTags() {
			return tags;
		}
		public void setTags(List<String> tags) {
			this.tags = tags;
		}
		public String getFileName() {
			return fileName;
		}
		public void setFileName(String fileName) {
			this.fileName = fileName;
		}
		@Override
		public String toString() {
			return "Document [docId=" + docId + ", catId=" + catId + ", topicId=" + topicId + ", tags=" + tags
					+ ", fileName=" + fileName + "]";
		}
		
		
	}
	
	/**
	 * You can pass in a fully qualified file name as a parameter on the command line
	 * or the program will default to the file name document.txt and expect it to be in
	 * the same folder as the class or jar file
	 * @param args
	 */
	public static void main(String[] args) {
		ReadAndParseCsvFile sfcf = new ReadAndParseCsvFile();
		String useFile = (args.length == 0 ? "Document.txt" : args[0]);
		sfcf.execute(useFile);
	}
	
	public void execute(String fileToLoad) {
		
		// First load-up the student data and abort if needed
		
		List<Document> documentList = null;
		
		try {
			documentList = getDocumentsFromFile(fileToLoad);
		} catch (IOException e) {
			System.err.println("The file: " + fileToLoad + " can't be opened or is empty.  Aborting");
			return;
		}
	
		// Dump them to the console
		
		documentList.forEach(System.out::println);
		
		return;
		
	}
	
	/**
	 * Uses java 8 Files static method to read all the lines from the file into a
	 * list of strings.  Very nice 
	 * @param fileNameToLoad should be the name of the file
	 * @return List[Document
	 * @throws IOException, FileNotFoundException 
	 */
	public List<Document> getDocumentsFromFile(String fileNameToLoad) throws IOException, FileNotFoundException {
		List<Document> documentList = new ArrayList<>();
			
		// Java 7 beauty..
		List<String> content = Files.readAllLines(Paths.get(fileNameToLoad));

		// If the list is empty or null then we'll assume the file was not there
		if (content.isEmpty()) {
			throw new FileNotFoundException("The file: " + fileNameToLoad + " is not locatable.");
		}
		
		// Now we'll build out the list
		// The first line is the header and we don't want that
		
		content.remove(0);
		
		// Now stream thru and transforms the lines of input into a list of grad/undergrad students
		// The String.split method will return a an array and split the line based on a space
		documentList = content
						.stream()
						.map(thisLine -> {
							String cols[] = thisLine.split(",");
							Document thisDocument = new Document(Integer.parseInt(cols[0]), Integer.parseInt(cols[1]), Integer.parseInt(cols[2]), cols[3], cols[4]);
							return thisDocument;
						})
						.collect(Collectors.toList());
						
		
		return documentList;
		
	}
}
