package db;

import java.sql.Connection;
import java.sql.*;

import org.apache.log4j.Logger;

public class Query {

	private final static Logger LOGGER = Logger.getLogger(Query.class);
	Statement statement = null;

	public void infoPlanes() {

		Connection connection = Connector.connector();
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			LOGGER.error(e);
		}
		ResultSet result = null;
		try {
			String sql = "SELECT * FROM planes";
			LOGGER.debug("SQL: " + sql);
			result = statement.executeQuery(sql);
		} catch (SQLException e) {
			LOGGER.error(e);
		}
		LOGGER.info("Printing statement");
		while (true) {
			try {
				if (!result.next())
					break;
			} catch (SQLException e) {
				LOGGER.error(e);
			}
			try {
				System.out.println("id:" + result.getInt("id") + "\t" + result.getString("name") + "\t\t model: "
						+ result.getString("model"));
			} catch (SQLException e) {
				LOGGER.error(e);
			}
		}
	}

	public void addToDB(String name, int speed) {
		Connection connection = Connector.connector();
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			LOGGER.error(e);
		}
		try {
			String sql = "INSERT INTO CollectionPlanes(name, speed) values('" + name + "', '" + speed + "')";
			LOGGER.debug("SQL: " + sql);
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			LOGGER.error(e);
		}
	}

}