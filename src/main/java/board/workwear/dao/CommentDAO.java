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
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs;
	
    public void addComment(CommentRequest cr) {
        String sql = "INSERT INTO BOARD_COMMENT (BOARD_ID, USER_ID, CONTENTS) VALUES (?, ?, ?)";

        try (Connection conn = DBConnectionUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
        	pstmt.setInt(1, cr.getBoardId());
            pstmt.setInt(2, cr.getMemberId());
            pstmt.setString(3, cr.getComment());
            
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
			//커넥션 반납
			DBConnectionUtil.close(con, pstmt, rs);
		}
    }
    
    public List<CommentResponse> getAllComments(int boardId) {
    	con = DBConnectionUtil.getConnection();
        List<CommentResponse> cr = new ArrayList<CommentResponse>();
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
				CommentResponse tmp = new CommentResponse();
				
				tmp.setNickName(rs.getString("NICKNAME"));
				tmp.setComment(rs.getString("CONTENTS"));
				
				//불러온 값 저장
				cr.add(tmp);
				}
			
             }catch (SQLException e) {
            e.printStackTrace();
            
             }finally {
     			//커넥션 반납
     			DBConnectionUtil.close(con, pstmt, rs);
     		}

        return cr;
    }
    
}
