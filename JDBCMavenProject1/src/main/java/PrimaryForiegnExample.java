import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

public class PrimaryForiegnExample {
    public static void main(String[] args) throws Exception {
		
    	String url="jdbc:mysql://localhost:3306/utkarsh";
    	String username = "root";
    	String password = "Utkarsh@123";
    	
    	String q1 = "insert into T1 values('Utkarsh',23,100000)";
    	String q2 = "insert into T1 values('Mahima',22,50000)";
    	String q3 = "insert into T1 values('Sarthak',21,30000)";
    	
    	String q4 = "insert into T2 values('Utkarsh','Lucknow',6387555198)";
    	String q5 = "insert into T2 values('Mahima','Karnal',9685471236)";
    	String q6 = "insert into T2 values('Adi','Himachal',7278569423)";
    	
    	String q7 = "insert into T1 values('Shally',19,40000)";
    	String q8 = "insert into T2 values('Varun','Kanpur',60000)";
    	
    	String delete = "DELETE FROM T2 WHERE name = 'Varun'";
    	
    	String deleteRow = "DELETE FROM T2 WHERE address = 'Kanpur'";
    	
    	String update= "UPDATE T2 SET contact=9865745632 WHERE name = 'Varun'";
    	
    	String findName = "SELECT name FROM T1 WHERE salary BETWEEN 30000 AND 50000"; 
    	
//    	String highestSalary = "SELECT name, salary FROM T1 ORDER BY salary DESC LIMIT 1";
    	String highestSalary = "SELECT name, salary FROM T1 WHERE salary = (SELECT MAX(salary) FROM T1)";
    	
    	String SecondhighestSalary = "SELECT name, salary FROM T1 WHERE salary = (SELECT MAX(salary) FROM T1 WHERE salary < (SELECT MAX(salary) FROM T1));";
    	
    	String addColumn ="ALTER Table T1 ADD COLUMN DOJ date";
    	
    	String commonNames = "SELECT T1.name FROM T1 INNER JOIN T2 ON T1.name=T2.name";
//    	String commonNames = "SELECT name FROM T1 INTERSECT SELECT name FROM T2";
    	
    	
    	String descending="SELECT * FROM T1 ORDER BY SALARY DESC";

    	
//    	Class.forName("org.mysql.Driver");
    	Connection con = DriverManager.getConnection(url,username,password);
    	System.out.println("Connection established Successfully");
    	
    	Statement st1 = con.createStatement();
    	Statement st2 = con.createStatement();
    	Statement st3 = con.createStatement();
//    	Statement st4 = con.createStatement();
//    	Statement st5 = con.createStatement();
    	
    	
    	
    	
    	
    	
//    	st1.addBatch(q1);
//    	st1.addBatch(q2);
//    	st1.addBatch(q3);
//    	
//    	st1.executeBatch();
    	
//    	st2.addBatch(q4);
//    	st2.addBatch(q5);
//    	st2.addBatch(q6);
    	
//    	st2.addBatch(deleteRow);
//    	
//    	st2.executeBatch();
    	
//    	st2.addBatch(addColumn);
//    	st2.executeBatch();
    	
//    	st1.addBatch(q7);
//    	st1.executeBatch();
//    	st2.addBatch(q8);
//    	st2.executeBatch();
    	
//    	st2.addBatch(update);
//    	st2.executeBatch();
    	
    	
    	
    	
    	ResultSet rs1 = st1.executeQuery("SELECT * FROM T1");
    	ResultSet rs2 = st2.executeQuery("SELECT * FROM T2");
    	
    	ResultSet rs3 = st3.executeQuery(findName);
    	
    	ResultSet rs4 = st3.executeQuery(highestSalary);
    	
    	ResultSet rs5 = st3.executeQuery(commonNames);
    	
    	ResultSet rs6= st3.executeQuery(SecondhighestSalary);
    	
    	ResultSet rs7= st3.executeQuery(descending);
    	
    	
    	
    	
    	
    	while(rs1.next()) {
    		System.out.println(rs1.getString(1)+ " "+ rs1.getString(2)+ " "+ rs1.getString(3));
    	}
    	System.out.println();
    	while(rs2.next()) {
    		System.out.println(rs2.getString(1)+ " "+ rs2.getString(2)+ " "+ rs2.getString(3));
    	}
    	
//    	System.out.println();
//    	 System.out.println("Employees with salary between 30,000 and 50,000:");
//    	while(rs3.next()) {
//    		System.out.println(rs3.getString("name"));
//    	}
    	
//    	System.out.println("Employee with the highest salary:");
//    	while(rs4.next()) {
//    		System.out.println(rs4.getString("name"));
//    	}
    	
//    	System.out.println("Employees with the common names:");
//    	while(rs5.next()) {
//    		System.out.println(rs5.getString("name"));
//    	}
    	
//    	System.out.println("Employee with the second highest salary:");
//    	while(rs6.next()) {
//    		System.out.println(rs6.getString("name"));
//    	}
    	System.out.println("T1 record in descending order:");
    	while(rs7.next()) {
    		System.out.println(rs7.getString(1)+ " "+ rs7.getString(2)+ " "+ rs7.getString(3));
    	}
  
    	

//    	st1.close();
//    	st2.close();
//    	st3.close();  // result set automatically closes when you close statement
    	con.close();
    	System.out.println("Connection closed successfully");
    	
	}
}
