package testData;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;

import managers.fileReaderManager;

public class petsApiJsonDataReader {

private final String petFilePath = fileReaderManager.getInstance().getConfigReader().getTEST_DATA_RESOURCE_PATH() + "API_Pets.json";
private List<pets_API> PetList;

public petsApiJsonDataReader(){
	PetList = getPetData();
}

private List<pets_API> getPetData() {

	Gson gson = new Gson();
	BufferedReader bufferReader = null;

	try {
		bufferReader = new BufferedReader(new FileReader(petFilePath));
		pets_API[] pets_API = gson.fromJson(bufferReader, pets_API[].class);
		return Arrays.asList(pets_API);
	}catch(FileNotFoundException e) {
		throw new RuntimeException("Json file not found at path : " + petFilePath);
	}finally {
		try { if(bufferReader != null) bufferReader.close();}
		catch (IOException ignore) {}
	}
}
	
public final pets_API getPetById(int pet_id){
	
	for(pets_API pet : PetList) {
		if(pet.id == pet_id) return pet;
		
	}
	return null;
}

}
