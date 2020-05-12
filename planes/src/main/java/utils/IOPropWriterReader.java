package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

import menu.Menu;

public class IOPropWriterReader {

	static final String SEPARATOR = File.separator;
	static final String PATH_TO_PROPERTIES = "C:" + SEPARATOR + "Users" + SEPARATOR + "Serg" + SEPARATOR + "Desktop"
			+ SEPARATOR + "my";
	
	private static final Logger LOGGER = Logger.getLogger(Menu.class);
	
	public static String getValueFromProperties(String key) {

		Properties properties = new Properties();
		try {
			FileInputStream fileInput = new FileInputStream(PATH_TO_PROPERTIES);
			properties.load(fileInput);
			fileInput.close();
			return properties.getProperty(key);
		} catch (IOException e) {
			LOGGER.error(e.getMessage());
		}

		return "default";

	}

	public void setValueToProperties(String key, String value) {

		Properties properties = new Properties();

		try {
			FileInputStream fileInput = new FileInputStream(PATH_TO_PROPERTIES);
			properties.load(fileInput);

			properties.setProperty(key, value);

			FileOutputStream fileOutput = new FileOutputStream(PATH_TO_PROPERTIES);
			properties.store(fileOutput, "property write test");
			fileOutput.close();
		} catch (IOException e) {
			LOGGER.error(e.getMessage());
		}
	}
}
