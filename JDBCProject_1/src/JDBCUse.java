// 1) Import the java.sql package
// 2) Load or Register the JDBC driver through MAVEN or adding jar file
// 3) Create a connection to the database
// 4) Create a statement to Execute the SQL query
// 5) Display the Result of a Database Query in Console
// 6) Close the statement and Connection

import java.sql.*;

class JDBCUse 
{
    public static void main(String[] args) throws Exception 
    {
    	
        String url = "jdbc:mysql://localhost:3306/utkarsh"; // Database details
        String username = "root"; // MySQL credentials
        String password = "Utkarsh@123";
        String q1 = "insert into student values(3,'Deva',30)"; // Query to be run
        String q2 = "insert into student values(4,'MOti',30)";
        String q3 = "insert into student values(5,'Tuki',31)";
        String q4 = "insert into student values(6,'Reva',28)";
       
        // Establish connection through Connection Interface
        Connection con = DriverManager.getConnection(url, username, password);
        System.out.println("Connection Established successfully");

        // Create a statement
        Statement st = con.createStatement(); // Interface
        st.addBatch(q1);
        st.addBatch(q2);
        st.addBatch(q3);
        st.addBatch(q4);
        
        st.executeBatch(); // Execute the Batch
        
        // Execute the query, ResultSet acts as a cursor, stores the result of a database query 
        ResultSet rs = st.executeQuery("select *from student"); // Interface
       

        // Process the results
        while (rs.next()) 
        {
            System.out.println(rs.getString(1)+rs.getString(2)+rs.getString(3)); // Give the column numbers as index value
        } 

        // Close the statement and connection
        st.close();
        
        con.close();
        System.out.println("Connection Closed");
    	
    	
    }
}