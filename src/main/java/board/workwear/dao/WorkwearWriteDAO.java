package board.workwear.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import board.workwear.dto.request.WorkwearWriteRequest;
import common.DBConnectionUtil;

public class WorkwearWriteDAO {

    public boolean writeWorkwear(WorkwearWriteRequest request) {
        String sql = "INSERT INTO BOARD (title, content, file_path) VALUES (?, ?, ?)";

        try (Connection conn = DBConnectionUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, request.getTitle());
            pstmt.setString(2, request.getContent());
            //pstmt.setString(3, request.getFilePath());

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
