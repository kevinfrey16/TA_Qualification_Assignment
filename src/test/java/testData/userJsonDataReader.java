package testData;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;

import managers.fileReaderManager;

public class userJsonDataReader {

private final String userFilePath = fileReaderManager.getInstance().getConfigReader().getTEST_DATA_RESOURCE_PATH() + "User.json";
private List<users> UserList;

public userJsonDataReader(){
	UserList = getUserData();
}

private List<users> getUserData() {

	Gson gson = new Gson();
	BufferedReader bufferReader = null;

	try {
		bufferReader = new BufferedReader(new FileReader(userFilePath));
		users[] users = gson.fromJson(bufferReader, users[].class);
		return Arrays.asList(users);
	}catch(FileNotFoundException e) {
		throw new RuntimeException("Json file not found at path : " + userFilePath);
	}finally {
		try { if(bufferReader != null) bufferReader.close();}
		catch (IOException ignore) {}
	}
}
	
public final users getUser_requested(String user_requested){
	
	for(users user : UserList) {
		if(user.user.equalsIgnoreCase(user_requested)) return user;
	}
	return null;
}


}
