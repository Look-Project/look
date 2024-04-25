package board.workwear.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import board.vintage.dto.response.VintageBoardResponse;
import board.workwear.dto.request.WorkwearWriteRequest;
import board.workwear.dto.response.WorkwearBoardResponse;
import board.workwear.dto.response.WorkwearResponse;
import common.DBConnectionUtil;
import common.SessionUtil;


public class WorkwearDAO {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs;
	
	
	//하나의 새로운 게시글이 저장되는 메서드
	public int insertBoard(WorkwearWriteRequest wwr) {
		con = DBConnectionUtil.getConnection();
		//데이터 초기화
		String w = "W"; //게시판 카테고리
		int res = 0;
		try {
			//text 타입 게시글 insert
			String boardText = "insert into board(USER_ID,TITLE,CONTENTS,CATEGORY) values(?,?,?,?)";
			pstmt = con.prepareStatement(boardText);
			
			//값을 매핑하기
			pstmt.setInt(1,wwr.getMemberId() );
			pstmt.setString(2, wwr.getTitle());
			pstmt.setString(3, wwr.getContents());
			pstmt.setString(4, w);
			
			res = pstmt.executeUpdate();
			
			//마지막 게시글 board Id 받아오는 쿼리문
			String boardId = "select max(BOARD_ID) from BOARD "; 
			pstmt = con.prepareStatement(boardId);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				res = rs.getInt(1);
			}
			
			//이미지 파일 insert
			String boardImg = "insert into board_img(board_id, img_src, img_name) values(?,?,?)";
			pstmt = con.prepareStatement(boardImg);
			
			//값을 매핑하기
			pstmt.setInt(1, res);
			pstmt.setString(2, wwr.getImgSrc());
			pstmt.setString(3, wwr.getImgName());
			
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
	public List<WorkwearResponse> getAllBoard() {
		con = DBConnectionUtil.getConnection();
		List<WorkwearResponse> wblr = new ArrayList<WorkwearResponse>();
		
		//쿼리 실행 준비
		String sql = "SELECT b.BOARD_ID, m.NICKNAME, b.TITLE, i.IMG_SRC, i.IMG_NAME "
				+ "FROM BOARD b inner join MEMBER m "
				+ "on b.USER_ID = m.USER_ID "
				+ "inner join Board_IMG i "
				+ "on b.BOARD_ID = i.BOARD_ID "
				+ "WHERE CATEGORY = 'W' AND DELETE_YN = 'N' "
				+ "ORDER BY b.CREATE_AT desc";
		
		try {
			//쿼리 실행할 객체 선언
			pstmt = con.prepareStatement(sql);
			
			//쿼리 실행 후 결과 저장
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				WorkwearResponse tmp = new WorkwearResponse();
				
				tmp.setNickname(rs.getString("NICKNAME"));
				tmp.setTitle(rs.getString("TITLE"));
				tmp.setImgSrc(rs.getString("IMG_SRC"));
				tmp.setImgName(rs.getString("IMG_NAME"));
				tmp.setBoardId(rs.getInt("BOARD_ID"));
				
				//불러온 값 저장
				wblr.add(tmp);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//커넥션 반납
			DBConnectionUtil.close(con, pstmt, rs);
		}
		return wblr;
	}
	//상세 게시글 불러오는 메서드
	public WorkwearBoardResponse getDetailBoard(int boardId) {
		con = DBConnectionUtil.getConnection();
		WorkwearBoardResponse wbr = new WorkwearBoardResponse();
		
		//쿼리 실행 준비
		String sql = "SELECT m.NICKNAME, b.BOARD_ID, b.TITLE, b.CONTENTS, i.IMG_SRC, i.IMG_NAME "
				+ "FROM BOARD b inner join MEMBER m "
				+ "on b.USER_ID = m.USER_ID "
				+ "inner join Board_IMG i "
				+ "on b.BOARD_ID = i.BOARD_ID "
				+ "WHERE b.CATEGORY = 'W' AND b.DELETE_YN = 'N' AND b.BOARD_ID = ? "
				+ "ORDER BY b.CREATE_AT desc";
		
		try {
			//쿼리 실행할 객체 선언
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, boardId );
			//쿼리 실행 후 결과 저장
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				wbr.setNickname(rs.getString("NICKNAME"));
				wbr.setBoardId(rs.getInt("BOARD_ID"));
				wbr.setTitle(rs.getString("TITLE"));
				wbr.setContents(rs.getString("CONTENTS"));
				wbr.setImgSrc(rs.getString("IMG_SRC"));
				wbr.setImgName(rs.getString("IMG_NAME"));
				System.out.println(rs.getString("NICKNAME"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//커넥션 반납
			DBConnectionUtil.close(con, pstmt, rs);
		}
		return wbr;
	}

}


