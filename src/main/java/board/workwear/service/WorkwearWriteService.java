package board.workwear.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import board.workwear.dto.request.WorkwearWriteRequest;

//WorkwearWriteService.java

public class WorkwearWriteService {

 public boolean writeWorkwear(WorkwearWriteRequest workwearWriteRequest) {
     try {
         // Establish database connection
         Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "username", "password");

         // Define the SQL query
         String sql = "INSERT INTO board (title, contents) VALUES (?, ?)";

         // Create prepared statement
         PreparedStatement statement = connection.prepareStatement(sql);
         statement.setString(1, workwearWriteRequest.getTitle());
         statement.setString(2, workwearWriteRequest.getContent());
         //statement.setString(3, workwearWriteRequest.getMemberId());

         // Execute the query
         int rowsInserted = statement.executeUpdate();

         // Close resources
         statement.close();
         connection.close();

         // Check if data is successfully inserted
         return rowsInserted > 0;
     } catch (SQLException e) {
         e.printStackTrace();
         return false;
     }
 }
}

