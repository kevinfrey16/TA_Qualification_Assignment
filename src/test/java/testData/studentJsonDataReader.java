package testData;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;

import managers.fileReaderManager;

public class studentJsonDataReader {

    private final String studentFilePath = fileReaderManager.getInstance().getConfigReader().getTEST_DATA_RESOURCE_PATH() + "Student.json";
    private List<students> StudentList;

public studentJsonDataReader(){
	StudentList = getStudentData();
}

private List<students> getStudentData() {

	Gson gson = new Gson();
	BufferedReader bufferReader = null;

	try {
		bufferReader = new BufferedReader(new FileReader(studentFilePath));
		students[] students = gson.fromJson(bufferReader, students[].class);
		return Arrays.asList(students);
	}catch(FileNotFoundException e) {
		throw new RuntimeException("Json file not found at path : " + studentFilePath);
	}finally {
		try { if(bufferReader != null) bufferReader.close();}
		catch (IOException ignore) {}
	}
}
	
public final students getStudentByID(String student_ID){
    
	for(students student : StudentList) {
		if(student.id.equalsIgnoreCase(student_ID)) return student;
	}
	return null;
}

}
