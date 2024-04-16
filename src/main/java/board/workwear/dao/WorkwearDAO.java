package board.workwear.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import board.workwear.dto.request.WorkwearRequest;
import board.workwear.dto.response.WorkwearResponse;
import common.DBConnectionUtil;

public class WorkwearDAO {
    // 특정 boardId에 해당하는 이미지 정보 가져오기
    public WorkwearResponse getImageInfo(WorkwearRequest request) {
        int boardId = request.getBoardId();
        WorkwearResponse response = null;
        // 데이터베이스에서 이미지 정보를 조회하는 SQL 쿼리
        String query = "SELECT imageName, userNickname FROM workwear WHERE boardId = ?";
        try (Connection con = DBConnectionUtil.getConnection();
             PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setInt(1, boardId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    String imageName = resultSet.getString("imageName");
                    String userNickname = resultSet.getString("userNickname");
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
        String query = "INSERT INTO workwear (boardId, imageName, userNickname) VALUES (?, ?, ?)";
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
}
