package db;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.log4j.Logger;
import utils.*;

public class Connector {

	private static final Logger LOGGER = Logger.getLogger(Connector.class);
	static String separator = File.separator;
	static String pathtodb = "C:" + separator + "Users" + separator + "Serg" + separator + "mavenworkspace" + separator
			+ "planes" + separator + "src" + separator + "main" + separator + "resources" + separator
			+ "pathtodb.properties";

	public static Connection connector() {
		IOPropWriterReader dbproperty = new IOPropWriterReader();
		Connection connection = null;

		try {

			String url = dbproperty.getPath(pathtodb, "url");
			String user = dbproperty.getPath(pathtodb, "user");
			String password = dbproperty.getPath(pathtodb, "password");
			connection = DriverManager.getConnection(url, user, password);

		} catch (SQLException e) {
			LOGGER.error(e.getMessage());
		}
		return connection;
	}

}
