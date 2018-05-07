package JDBCConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySQLConnect {

	public Connection Connect() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");

	}

	public static int rowCount(ResultSet rs) throws SQLException {
		rs.last();
		return rs.getRow();
	}

}
