import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.*;

public class PreparedStatementExample  {
	public static void main(String[] args) throws Exception {

		String url = "jdbc:mysql://localhost:3306/utkarsh";
		String username = "root";
		String password = "Utkarsh@123";
		
		

		String query = "Select * from student where id= ? and name= ?";

		
		Connection con = DriverManager.getConnection(url,username,password);
    	System.out.println("Connection established Successfully");
		PreparedStatement st = con.prepareStatement(query);

		
		st.setInt(1, 6);
		st.setString(2, "Reva");
		
		ResultSet rs = st.executeQuery();
		
		while (rs.next()) {
		    System.out.println("ID: " + rs.getInt("id") + 
		                       ", Name: " + rs.getString("name") + 
		                       ", Age:" + rs.getInt("age"));
		}
		
		
	}
}
