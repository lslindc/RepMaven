package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class Connector {

	private static final Logger LOGGER = Logger.getLogger(Connector.class);

	public Connection connector() {

		Connection connection = null;
		
		try {

			String url = "jdbc:postgresql://127.0.0.1:5432/postgres";

			Properties properties = new Properties();
			properties.setProperty("user", "postgres");
			properties.setProperty("password", "postgres");
			properties.setProperty("ssl", "true");
			connection = DriverManager.getConnection(url, properties);
		} catch (SQLException e) {
			LOGGER.error(e.getMessage());
		}
		return connection;
	}

}
