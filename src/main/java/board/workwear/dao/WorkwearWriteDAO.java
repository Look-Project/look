package board.workwear.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import common.DBConnectionUtil;

public class WorkwearWriteDAO {

	public boolean writeWorkwear(String title, String content, String filePath) {
        String sql = "INSERT INTO BOARD WHERE CATEGORY = 'W' (title, content, file_path) "
        		+ "												VALUES (:title, :content, :filePath)";

        try (Connection conn = DBConnectionUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, title);
            pstmt.setString(2, content);
            pstmt.setString(3, filePath);

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
