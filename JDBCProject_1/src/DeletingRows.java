import java.sql.*;

class DeletingRows {
    public static void main(String[] args) throws Exception {
        String url = "jdbc:mysql://localhost:3306/utkarsh";
        String username = "root";
        String password = "Utkarsh@123";
        
        // Establish connection
        Connection con = DriverManager.getConnection(url, username, password);
        System.out.println("Connection Established successfully");

        // Create a statement
        Statement st = con.createStatement();
        
        // Delete queries for each specific row
        String delete1 = "DELETE FROM student WHERE id = 15";
        String delete2 = "DELETE FROM student WHERE id = 16";
        String delete3 = "DELETE FROM student WHERE id = 17";
        String delete4 = "DELETE FROM student WHERE id = 18";
        
        // Execute the delete statements
        st.addBatch(delete1);
        st.addBatch(delete2);
        st.addBatch(delete3);
        st.addBatch(delete4);
        st.executeBatch();
        
        System.out.println("4 rows deleted successfully");
        
        // Verify deletion by selecting remaining records
        ResultSet rs = st.executeQuery("SELECT * FROM student");
        while (rs.next()) {
            System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3));
        }

        // Close resources
        st.close();
        con.close();
        System.out.println("Connection Closed");
    }
}