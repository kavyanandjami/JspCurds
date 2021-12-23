package login;



	
		import java.sql.Connection;
		import java.sql.DriverManager;
		import java.sql.PreparedStatement;
		import java.sql.SQLException;

		public class DeleteData {
			
			static final String DELETE_USERS_SQL = "Delete from login where username = ?;";
		 public static void main(String[] argv) throws SQLException {
			 DeleteData deleteStatementExample = new DeleteData();
			deleteStatementExample.deleteRecord();
		 }
		 private void deleteRecord() throws SQLException{
			// TODO Auto-generated method stub
			
			 System.out.println(DELETE_USERS_SQL);
			 // Step 1: Establishing a Connection
			 try (Connection connection = DriverManager
			 
			.getConnection("jdbc:mysql://localhost:3306/Elite?useSSL=false", "root", "");
			 // Step 2:Create a statement using connection object
			 PreparedStatement preparedStatement =
			connection.prepareStatement(DELETE_USERS_SQL)) {
				 preparedStatement.setString(1, "Kavya");
			 
			 // Step 3: Execute the query or update query
			 preparedStatement.executeUpdate();
			 } catch (SQLException e) {
			 // print SQL exception information
			 printSQLException(e);
			 }
			 // Step 4: try-with-resource statement will auto close the connection.
			 }
		 
		 public static void printSQLException(SQLException ex) {
		 for (Throwable e: ex) {
		 if (e instanceof SQLException) {
		 e.printStackTrace(System.err);
		 System.err.println("SQLState: " + ((SQLException) 
		e).getSQLState());
		 System.err.println("Error Code: " + ((SQLException) 
		e).getErrorCode());
		 System.err.println("Message: " + e.getMessage());
		 Throwable t = ex.getCause();
		 while (t != null) {
		 System.out.println("Cause: " + t);
		 t = t.getCause();
		 }
		 }
		 }
		 }
	}


