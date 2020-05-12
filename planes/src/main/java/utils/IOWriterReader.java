package utils;

import java.io.*;
import java.util.Scanner;

import org.apache.log4j.Logger;

import menu.Menu;

import java.util.Properties;

public class IOWriterReader {

	private String separator = File.separator;
	private String path = "C:" + separator + "Users" + separator + "Serg" + separator + "Desktop" + separator + "text1";

	private static final Logger LOGGER = Logger.getLogger(Menu.class);
	
	public void writeToFile(String value) {

		File file = new File(path);
		try {

			FileWriter wf = new FileWriter(file);
			wf.write(value);
			wf.close();

		} catch (IOException e) {

			LOGGER.error(e.getMessage());
		}
	}

	public String readFromFile() {

		File file = new File(path);

		Scanner scanner = null;

		try {
			FileReader rf = new FileReader(file);
			scanner = new Scanner(rf);

			System.out.println(scanner.nextLine());
			rf.close();

		} catch (IOException e) {

			LOGGER.error(e.getMessage());

		} finally {
			scanner.close();

		}

		return "default";
	}

}
