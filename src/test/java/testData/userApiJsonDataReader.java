package testData;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;

import managers.fileReaderManager;

public class userApiJsonDataReader {

private final String userFilePath = fileReaderManager.getInstance().getConfigReader().getTEST_DATA_RESOURCE_PATH() + "API_User.json";
private List<users_API> UserList;

public userApiJsonDataReader(){
	UserList = getUserData();
}

private List<users_API> getUserData() {

	Gson gson = new Gson();
	BufferedReader bufferReader = null;

	try {
		bufferReader = new BufferedReader(new FileReader(userFilePath));
		users_API[] users_API = gson.fromJson(bufferReader, users_API[].class);
		return Arrays.asList(users_API);
	}catch(FileNotFoundException e) {
		throw new RuntimeException("Json file not found at path : " + userFilePath);
	}finally {
		try { if(bufferReader != null) bufferReader.close();}
		catch (IOException ignore) {}
	}
}
	
public final users_API getUser_requested(String user_requested){
	
	for(users_API user : UserList) {
		if(user.username.equalsIgnoreCase(user_requested)) return user;
	}
	return null;
}

}
