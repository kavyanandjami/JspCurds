package login;



	
		


		import java.sql.Connection;
		import java.sql.DriverManager;
		import java.sql.PreparedStatement;
		import java.sql.SQLException;
		public class Insertdata {
		 private static final String INSERT_USERS_SQL = "INSERT INTO login" +" (username,password) VALUES " +" (?, ?);";
		 public static void main(String[] argv) throws SQLException {
			 Insertdata createTableExample = new Insertdata();
		 createTableExample.insertRecord();
		 }
		 public void insertRecord() throws SQLException {
		 System.out.println(INSERT_USERS_SQL);
		 // Step 1: Establishing a Connection
		 try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Elite?useSSL=false", "root", "");
		 // Step 2:Create a statement using connection object
		 PreparedStatement preparedStatement =connection.prepareStatement(INSERT_USERS_SQL)) {
		 preparedStatement.setString(1, "Kavyanand");
		 preparedStatement.setString(2, "kavya123");
		 preparedStatement.setString(1, "Kavya");
		 preparedStatement.setString(2, "jami12");

		 System.out.println(preparedStatement);
		 // Step 3: Execute the query or update query
		 preparedStatement.executeUpdate();
		 } catch (SQLException e) {

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


