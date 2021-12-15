package managers;

import testData.bookJsonDataReader;
import testData.configFileReader;
import testData.userJsonDataReader;
import testData.studentJsonDataReader;
import testData.userApiJsonDataReader;
import testData.petsApiJsonDataReader;

public class fileReaderManager {

	private static fileReaderManager fileReaderManager = new fileReaderManager();
	private static configFileReader configFileReader;
    private static userJsonDataReader userJsonDataReader;
    private static bookJsonDataReader bookJsonDataReader;
    private static studentJsonDataReader studentJsonDataReader;
    private static userApiJsonDataReader userApiJsonDataReader;
    private static petsApiJsonDataReader petsApiJsonDataReader;

	private fileReaderManager() {
	}

	public static fileReaderManager getInstance( ) {
	    return fileReaderManager;
	}

	public configFileReader getConfigReader() {
	    return (configFileReader == null) ? new configFileReader() : configFileReader;
	}

    public userJsonDataReader getUserJsonReader(){
        return (userJsonDataReader == null) ? new userJsonDataReader() : userJsonDataReader;
    }

    public bookJsonDataReader getBookJsonReader(){
        return (bookJsonDataReader == null) ? new bookJsonDataReader() : bookJsonDataReader;
    }

    public studentJsonDataReader getStudentJsonReader(){
        return (studentJsonDataReader == null) ? new studentJsonDataReader() : studentJsonDataReader;
    }

    public userApiJsonDataReader getUserApiJsonReader(){
        return (userApiJsonDataReader == null) ? new userApiJsonDataReader() : userApiJsonDataReader;
    }

    public petsApiJsonDataReader getPetsApiJsonReader(){
        return (petsApiJsonDataReader == null) ? new petsApiJsonDataReader() : petsApiJsonDataReader;
    }

}