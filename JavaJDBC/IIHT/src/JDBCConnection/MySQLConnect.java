package JDBCConnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLConnect {
	

	public Connection Connect() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");

	}

}
