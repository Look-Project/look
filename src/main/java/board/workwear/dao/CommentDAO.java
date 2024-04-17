package board.workwear.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import board.workwear.dto.request.CommentRequest;
import board.workwear.dto.response.CommentResponse;
import common.DBConnectionUtil;

public class CommentDAO {

    public List<CommentResponse> getAllComments() {
        List<CommentResponse> comments = new ArrayList<>();
        String sql = "SELECT * FROM BOARD_COMMENT";

        try (Connection conn = DBConnectionUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                String id = rs.getString("userId");
                String comment = rs.getString("contents");
                comments.add(new CommentResponse(id, comment));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return comments;
    }

    public void addComment(CommentRequest request) {
        String sql = "INSERT INTO BOARD_COMMENT (userId, contents) VALUES (?, ?)";

        try (Connection conn = DBConnectionUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, request.getId());
            pstmt.setString(2, request.getComment());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
