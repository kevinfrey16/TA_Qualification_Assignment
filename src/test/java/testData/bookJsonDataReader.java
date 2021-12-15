package testData;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;

import managers.fileReaderManager;

public class bookJsonDataReader {

private final String bookFilePath = fileReaderManager.getInstance().getConfigReader().getTEST_DATA_RESOURCE_PATH() + "Book.json";
private List<books> BookList;

public bookJsonDataReader(){
	BookList = getBookData();
}

private List<books> getBookData() {

	Gson gson = new Gson();
	BufferedReader bufferReader = null;

	try {
		bufferReader = new BufferedReader(new FileReader(bookFilePath));
		books[] books = gson.fromJson(bufferReader, books[].class);
		return Arrays.asList(books);
	}catch(FileNotFoundException e) {
		throw new RuntimeException("Json file not found at path : " + bookFilePath);
	}finally {
		try { if(bufferReader != null) bufferReader.close();}
		catch (IOException ignore) {}
	}
}
	
public final books getBook_requested(String book_requested){
    
	for(books book : BookList) {
		if(book.bookName.equalsIgnoreCase(book_requested)) return book;
	}
	return null;
}

}
