package utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import planes.Cargo;
import planes.Planes;

public class WorkWithJson {

	private static String separator = File.separator;
	private static String path = "C:" + separator + "Users" + separator + "Serg" + separator + "Desktop" + separator
			+ "jsonfile";
	private static final Logger LOGGER = Logger.getLogger(WorkWithJson.class);

	public static String convertJavaToJsonStr(Object object) {

		String jsonString = "";

		try {
			jsonString = new ObjectMapper().writeValueAsString(object);
			LOGGER.info("Converted to string");
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return jsonString;

	}

	public static void convertJavaToJsonFile(Object object, String path) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.writeValue(Paths.get(path).toFile(), object);
			LOGGER.info("Finished writing to file");
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Planes convertJsonStrToPlanePOJO(String planeJson) {
		Cargo plane = null;
		try {
			ObjectMapper mapper = new ObjectMapper();
			plane = mapper.readValue(planeJson, Cargo.class);
			LOGGER.info("Finished converting to POJO");
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return plane;
	}

	public static Planes convertJsonFileToPlanePOJO(String path) {
		Cargo plane = null;
		try {
			ObjectMapper mapper = new ObjectMapper();
			plane = mapper.readValue(Paths.get(path).toFile(), Cargo.class);
			LOGGER.info("Finished converting to POJO");
		} catch (IOException e) {
			e.printStackTrace();
		}

		return plane;
	}

}