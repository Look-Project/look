package board.workwear.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import board.workwear.dto.request.WorkwearDetailRequest;
import board.workwear.dto.response.WorkwearDetailResponse;
import common.DBConnectionUtil;

public class WorkwearDetailDAO {

    public WorkwearDetailResponse getWorkwearDetail(WorkwearDetailRequest request) {
        int boardId = request.getBoardId();
        WorkwearDetailResponse workwearDetail = null;
        String sql = "SELECT * FROM workwear WHERE boardId = ?";

        try (Connection conn = DBConnectionUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, boardId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    String imageName = rs.getString("imageName");
                    String userNickname = rs.getString("userNickname");
                    workwearDetail = new WorkwearDetailResponse(boardId, imageName, userNickname);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return workwearDetail;
    }
}