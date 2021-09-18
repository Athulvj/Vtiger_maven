package jdbc_sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class UpdateDataInTable {
	public static void main(String[] args) throws SQLException {
		Connection con= null;

		try {
			//loading SQl Database
			Driver driverRef = new Driver();
			DriverManager.registerDriver(driverRef);

			//connect to datatbase

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "root");

			//create SQL statement

			Statement stat = con.createStatement();
			String query = "insert into students_info (regno,firstname,middlename,lastname) values('11','jam','bam','gam')";

			int result = stat.executeUpdate(query);

			if(result==1) {
				System.out.println("yes we did it");
			}
		}

		catch(Exception e){
			System.err.println("Duplicate data inserted");
		}
		finally {
			con.close();
		}



	}
}



