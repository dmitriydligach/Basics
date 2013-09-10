package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Sample code for running an SQL query against PostgreSQL using JDBC
 */
public class DBConnection {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		// check if JDBC driver is in the classpath
		Class.forName("org.postgresql.Driver");
		
		Connection connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/MIMIC2", "dima", "dima");
		String query = "select charttime, category from mimic2v26.noteevents limit 10";
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(query);
		
		while(resultSet.next()) {
			System.out.println(resultSet.getString(1)); // print first column
			System.out.println(resultSet.getString(2)); // print second column
			System.out.println();
		}
		
		connection.close();
	}
}
