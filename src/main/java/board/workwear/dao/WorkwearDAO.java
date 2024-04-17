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
    // 특정 boardId에 해당하는 이미지 정보 가져오기
    public WorkwearResponse getImageInfo(WorkwearRequest request) {
        int boardId = request.getBoardId();
        WorkwearResponse response = null;
        // 데이터베이스에서 이미지 정보를 조회하는 SQL 쿼리
        String query = "SELECT IMG_ID, NICKNAME FROM workwear WHERE BOARD_ID = ?";
        try (Connection con = DBConnectionUtil.getConnection();
             PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setInt(1, boardId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    String imageName = resultSet.getString("IMG_ID");
                    String userNickname = resultSet.getString("NICKNAME");
                    response = new WorkwearResponse(boardId, imageName, userNickname);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return response;
    }

    // 이미지 정보 저장
    public void saveImageInfo(WorkwearRequest request) {
        int boardId = request.getBoardId();
        String imageName = request.getImageName();
        String userNickname = request.getUserNickname();
        // 데이터베이스에 이미지 정보를 저장하는 SQL 쿼리
        String query = "INSERT INTO workwear (BOARD_ID, IMG_ID, NICKNAME) VALUES (?, ?, ?)";
        try (Connection con = DBConnectionUtil.getConnection();
             PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setInt(1, boardId);
            preparedStatement.setString(2, imageName);
            preparedStatement.setString(3, userNickname);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 작업복 상세 정보 가져오기
    public WorkwearDetailResponse getWorkwearDetail(WorkwearDetailRequest request) {
        int boardId = request.getBoardId();
        WorkwearDetailResponse workwearDetail = null;
        String sql = "SELECT * FROM workwear WHERE BOARD_ID = ?";

        try (Connection conn = DBConnectionUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, boardId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    String imageName = rs.getString("IMG_ID");
                    String userNickname = rs.getString("NICKNAME");
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
