
package jdbc_sql;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;


public class ReadDataFRrom_MySQL {
	public static void main(String[] args) throws SQLException {
		//loading SQl Database
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);

		//connect to datatbase

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "root");

		//create SQL statement

		Statement stat = con.createStatement();
		String query = "select * from students_info";

		//executing statement query

		ResultSet result = stat.executeQuery(query);

		while(result.next()) {
			System.out.println(result.getInt(1)+ "\t" + result.getString(2) + "\t" + result.getString(3) + "\t" + result.getString(4) );
			
		}
		
		con.close();
		




	}
}
