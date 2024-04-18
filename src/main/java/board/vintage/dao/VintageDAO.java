package board.vintage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import board.vintage.dto.request.VintageWriteRequest;
import board.vintage.dto.response.VintageBoardListResponse;
import common.DBConnectionUtil;

public class VintageDAO {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs;
	
	
	//하나의 새로운 게시글이 저장되는 메서드
	public int insertBoard(VintageWriteRequest vwr) {
		con = DBConnectionUtil.getConnection();
		//데이터 초기화
		String v = "V"; //게시판 카테고리
		int res = 0;
		try {
			//실제로 USER_ID,TITLE,CONTENTS,CATEGORY에 해당하는 값을 테이블에 저장
			String sql = "insert into board(USER_ID,TITLE,CONTENTS,CATEGORY) values(?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			
			//값을 매핑하기
			pstmt.setInt(1, 1);
			pstmt.setString(2, vwr.getTitle());
			pstmt.setString(3, vwr.getContents());
			pstmt.setString(4, v);
			
			//쿼리 실행
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
	public List<VintageBoardListResponse> getAllBoard() {
		con = DBConnectionUtil.getConnection();
		List<VintageBoardListResponse> vblr = new ArrayList<VintageBoardListResponse>();
		
		//쿼리 실행 준비
		String sql = "SELECT b.BOARD_ID, b.USER_ID, b.TITLE, b.CONTENTS, b.VIEWS, b.DELETE_YN, b.CREATE_AT, i.IMG_SRC "
				+ "FROM BOARD b "
				+ "left outer JOIN BOARD_IMG i ON b.BOARD_ID = i.BOARD_ID "
				+ "WHERE CATEGORY = 'V' AND DELETE_YN = 'N'";
		
		try {
			//쿼리 실행할 객체 선언
			pstmt = con.prepareStatement(sql);
			
			//쿼리 실행 후 결과 저장
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				VintageBoardListResponse tmp = new VintageBoardListResponse();
				tmp.setBoardId(rs.getInt(1));
				tmp.setUserId(rs.getInt(2));
				tmp.setTitle(rs.getString(3));
				tmp.setContents(rs.getString(4));
				tmp.setViews(rs.getInt(5));
				tmp.setDeleteYn(rs.getString(6));
				tmp.setCreateAt(rs.getDate(7));
				tmp.setImgSrc(rs.getString(8));
				
				//불러온 값 저장
				vblr.add(tmp);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//커넥션 반납
			DBConnectionUtil.close(con, pstmt, rs);
		}
		return vblr;
	}
	
}

