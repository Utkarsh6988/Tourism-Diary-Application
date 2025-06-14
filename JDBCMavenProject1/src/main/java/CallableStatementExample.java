import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

public class CallableStatementExample {
	public static void main(String[] args) throws Exception {
		
		String url="jdbc:mysql://localhost:3306/utkarsh";
		String username="root";
		String password="Utkarsh@123";
		
		Connection con = DriverManager.getConnection(url,username,password);
		
		CallableStatement cstmt = con.prepareCall("{call myfunction2()}");
		
//		    cstmt.setInt(1, 11);      // First parameter
//	        cstmt.setString(2, "mahi"); // Second parameter
//	        cstmt.setInt(3, 19); // Third parameter
		
		ResultSet rs= cstmt.executeQuery(); 	
		while(rs.next())
		{
			System.out.println(rs.getString(1)+ " "+rs.getString(2)+ " "+ rs.getString(3));
		}
		}
}
 