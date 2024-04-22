package board.workwear.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import board.workwear.dto.request.WorkwearDetailRequest;
import board.workwear.dto.request.WorkwearRequest;
import board.workwear.dto.request.WorkwearWriteRequest;
import board.workwear.dto.response.WorkwearDetailResponse;
import board.workwear.dto.response.WorkwearResponse;
import common.DBConnectionUtil;

public class WorkwearDAO {
    // 이미지 정보 가져오기 및 저장
    public WorkwearResponse getImageInfoAndSave(WorkwearRequest request) {
        int boardId = request.getBoardId();
        WorkwearResponse response = null;
        String imageName = request.getImageName();
        String userNickname = request.getUserNickname();
        String querySelect = "SELECT * FROM board WHERE category = 'W';";
        String queryInsert = "INSERT INTO workwear (boardId, imgId, nickname) VALUES (?, ?, ?)";
        
        try (Connection con = DBConnectionUtil.getConnection();
             PreparedStatement selectStatement = con.prepareStatement(querySelect);
             PreparedStatement insertStatement = con.prepareStatement(queryInsert)) {
            // 이미지 정보 조회
            try (ResultSet resultSet = selectStatement.executeQuery()) {
                if (resultSet.next()) {
                    imageName = resultSet.getString("imgId");
                    userNickname = resultSet.getString("nickname");
                    response = new WorkwearResponse(boardId, imageName, userNickname);
                }
            }
            
            // 이미지 정보 저장
            insertStatement.setInt(1, boardId);
            insertStatement.setString(2, imageName);
            insertStatement.setString(3, userNickname);
            insertStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return response;
    }

    // 작업복 상세 정보 가져오기
    public WorkwearDetailResponse getWorkwearDetail(WorkwearDetailRequest request) {
        int boardId = request.getBoardId();
        WorkwearDetailResponse workwearDetail = null;
        String sql = "SELECT * FROM board WHERE boardId = ? AND category = 'W'";

        try (Connection conn = DBConnectionUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, boardId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    String imageName = rs.getString("imgId");
                    String userNickname = rs.getString("nickname");
                    workwearDetail = new WorkwearDetailResponse(boardId, imageName, userNickname);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return workwearDetail;
    }

    // 작업복 글 작성
    public boolean writeWorkwear(WorkwearWriteRequest request) {
        String sql = "INSERT INTO board (title, contents, category) VALUES (?, ?, 'W')";

        try (Connection conn = DBConnectionUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, request.getTitle());
            pstmt.setString(2, request.getContent());

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
