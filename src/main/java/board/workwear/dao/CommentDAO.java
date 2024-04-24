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
	
	
	//하나의 새로운 게시글이 저장되는 메서드
	public int insertComment(CommentRequest cr) {
		con = DBConnectionUtil.getConnection();
		//데이터 초기화
		int res = 0;
		try {
			//text 타입 게시글 insert
			String commentText = "insert into board_comment(USER_ID,CONTENTS) values(?,?)";
			pstmt = con.prepareStatement(commentText);
			
			//값을 매핑하기
			pstmt.setString(1,cr.getNickname());
			pstmt.setString(2, cr.getContents());
			
			res = pstmt.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			//커넥션 반납
			DBConnectionUtil.close(con, pstmt, rs);
		}
		return res;
	}
	
	//모든 게시글 불러오는 메서드
	public List<CommentResponse> getAllComment() {
		con = DBConnectionUtil.getConnection();
		List<CommentResponse> crlr = new ArrayList<CommentResponse>();
		
		//쿼리 실행 준비
		String sql = "SELECT m.NICKNAME, bc.CONTENTS"
				+ "FROM MEMBER m inner join BOARD_CONMMENT bc "
				+ "on m.user_id = bc.user_id "
				+ "ORDER BY bc.CREATE_AT desc";
		
		try {
			//쿼리 실행할 객체 선언
			pstmt = con.prepareStatement(sql);
			
			//쿼리 실행 후 결과 저장
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				CommentResponse tmp = new CommentResponse();
				
				tmp.setNickname(rs.getString("NICKNAME"));
				tmp.setContents(rs.getString("CONTENTS"));
				
				
				//불러온 값 저장
				crlr.add(tmp);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//커넥션 반납
			DBConnectionUtil.close(con, pstmt, rs);
		}
		return crlr;
	}
	
}
