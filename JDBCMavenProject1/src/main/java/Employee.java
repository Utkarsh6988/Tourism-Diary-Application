import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Employee {
	public static void main(String[] args) throws Exception{
		
		String url="jdbc:mysql://localhost:3306/utkarsh";
		String username= "root";
		String password= "Utkarsh@123";
		
		Connection con = DriverManager.getConnection(url,username, password);
		System.out.println("Connection esablished successfully");
		Statement st = con.createStatement();
		
		CallableStatement cst = con.prepareCall("{call myfunction1()}");
		
//		String createTable= "CREATE TABLE Employee (\r\n"
//				+ "  id INT AUTO_INCREMENT PRIMARY KEY,\r\n"
//				+ "  name VARCHAR(100) NOT NULL,\r\n"
//				+ "  age INT,\r\n"
//				+ "  address VARCHAR(100),\r\n"
//				+ "  salary INT,\r\n"
//				+ "  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP\r\n"
//				+ ")";
//		
//		 st.executeUpdate(createTable);
//		 System.out.println("Table Created Successfully");
				
//		 String insertData = "INSERT INTO Employee (name, age, address, salary) VALUES "
//	                + "('Utkarsh', 23, 'Lucknow', 100000), "
//	                + "('Sarthak', 22, 'Kanpur', 50000), "
//	                + "('Mahima', 21, 'Karnal', 60000), "
//	                + "('Shubham', 20, 'Delhi', 70000)";
//		 
//		 st.executeUpdate(insertData);
//		 System.out.println("Data Inserted Successfully");
		 
		
//		 cst.execute();
		 
		 ResultSet rs= st.executeQuery("SELECT * FROM Employee");
		 
		 System.out.println("\nEmployee Table:");
		 System.out.println("ID\tName\t\tAge\tAddress\t\tSalary\tCreated At");
	        System.out.println("------------------------------------------------------------");
	        
	        while (rs.next()) {
	            System.out.println(
	                rs.getInt("id") + "\t" +
	                rs.getString("name") + "\t" + "\t"+
	                rs.getInt("age") + "\t" +
	                rs.getString("address") + "\t" + "\t"+
	                rs.getInt("salary") + "\t" + 
	                rs.getTimestamp("created_at")
	            );
	        }
//	        rs.close();
//	        st.close();
//	        cst.close();
//	        con.close();
	}

}
