package comment.vintage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import board.workwear.dto.response.CommentResponse;
import comment.vintage.dto.request.VintageCommentRequest;
import comment.vintage.dto.response.VintageCommentResponse;
import common.DBConnectionUtil;

public class VintageCommentDAO {
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs;
	
    public void addComment(VintageCommentRequest vcr) {
        String sql = "INSERT INTO BOARD_COMMENT (BOARD_ID, USER_ID, CONTENTS) VALUES (?, ?, ?)";

        try (Connection conn = DBConnectionUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
        	pstmt.setInt(1, vcr.getBoardId());
            pstmt.setInt(2, vcr.getMemberId());
            pstmt.setString(3, vcr.getComment());
            
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
			//커넥션 반납
			DBConnectionUtil.close(con, pstmt, rs);
		}
    }
    
    public List<VintageCommentResponse> getAllComments(int boardId) {
    	con = DBConnectionUtil.getConnection();
        List<VintageCommentResponse> vcr = new ArrayList<VintageCommentResponse>();
        String sql = "select m.NICKNAME, c.CONTENTS "
        		+ "from BOARD_COMMENT c inner join MEMBER m "
        		+ "on c.USER_ID = m.USER_ID "
        		+ "where c.BOARD_ID = ? and HIDDEN_YN = 'N' "
        		+ "order by c.CREATE_AT desc ";

        try {
        	//쿼리 실행할 객체 선언
        	pstmt = con.prepareStatement(sql);
        	
        	pstmt.setInt(1, boardId );
			//쿼리 실행 후 결과 저장
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				VintageCommentResponse tmp = new VintageCommentResponse();
				
				tmp.setNickName(rs.getString("NICKNAME"));
				tmp.setComment(rs.getString("CONTENTS"));
				
				//불러온 값 저장
				vcr.add(tmp);
				}
			
             }catch (SQLException e) {
            e.printStackTrace();
            
             }finally {
     			//커넥션 반납
     			DBConnectionUtil.close(con, pstmt, rs);
     		}

        return vcr;
    }
    
}
