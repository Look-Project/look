package board.vintage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import board.vintage.dto.request.VintageEditRequest;
import board.vintage.dto.request.VintageWriteRequest;
import board.vintage.dto.response.VintageBoardListResponse;
import board.vintage.dto.response.VintageBoardResponse;
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
			//text 타입 게시글 insert
			String boardText = "insert into board(USER_ID,TITLE,CONTENTS,CATEGORY) values(?,?,?,?)";
			pstmt = con.prepareStatement(boardText);
			
			//값을 매핑하기
			pstmt.setInt(1,vwr.getMemberId() );
			pstmt.setString(2, vwr.getTitle());
			pstmt.setString(3, vwr.getContents());
			pstmt.setString(4, v);
			
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
			pstmt.setString(2, vwr.getImgSrc());
			pstmt.setString(3, vwr.getImgName());
			
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
		String sql = "SELECT m.NICKNAME, m.PROFILE_SRC, m.PROFILE_NAME, b.TITLE, b.BOARD_ID, i.IMG_SRC, i.IMG_NAME "
				+ "FROM BOARD b inner join MEMBER m "
				+ "on b.USER_ID = m.USER_ID "
				+ "inner join Board_IMG i "
				+ "on b.BOARD_ID = i.BOARD_ID "
				+ "WHERE CATEGORY = 'V' AND DELETE_YN = 'N' "
				+ "ORDER BY b.CREATE_AT desc";
		
		try {
			//쿼리 실행할 객체 선언
			pstmt = con.prepareStatement(sql);
			
			//쿼리 실행 후 결과 저장
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				VintageBoardListResponse tmp = new VintageBoardListResponse();
				
				tmp.setBoardId(rs.getInt("BOARD_ID"));
				tmp.setNickname(rs.getString("NICKNAME"));
				tmp.setUserImgSrc(rs.getString("PROFILE_SRC"));
				tmp.setUserImgName(rs.getString("PROFILE_NAME"));
				tmp.setTitle(rs.getString("TITLE"));
				tmp.setImgSrc(rs.getString("IMG_SRC"));
				tmp.setImgName(rs.getString("IMG_NAME"));
				
				
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
	
	//상세 게시글 불러오는 메서드
	public VintageBoardResponse getDetailBoard(int boardId) {
		con = DBConnectionUtil.getConnection();
		VintageBoardResponse vbr = new VintageBoardResponse();
		
		//쿼리 실행 준비
		String sql = "SELECT b.USER_ID, m.NICKNAME, b.BOARD_ID, b.TITLE, b.CONTENTS, i.IMG_SRC, i.IMG_NAME "
					+ "FROM BOARD b inner join MEMBER m "
					+ "on b.USER_ID = m.USER_ID "
					+ "inner join Board_IMG i "
					+ "on b.BOARD_ID = i.BOARD_ID "
					+ "WHERE b.CATEGORY = 'V' AND b.DELETE_YN = 'N' AND b.BOARD_ID = ? "
					+ "ORDER BY b.CREATE_AT desc";
		
		try {
			//쿼리 실행할 객체 선언
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, boardId );
			//쿼리 실행 후 결과 저장
			rs = pstmt.executeQuery();
				
			if(rs.next()) {
				vbr.setMemberId(rs.getInt("USER_ID"));
				vbr.setNickname(rs.getString("NICKNAME"));
				vbr.setBoardId(rs.getInt("BOARD_ID"));
				vbr.setTitle(rs.getString("TITLE"));
				vbr.setContents(rs.getString("CONTENTS"));
				vbr.setImgSrc(rs.getString("IMG_SRC"));
				vbr.setImgName(rs.getString("IMG_NAME"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//커넥션 반납
			DBConnectionUtil.close(con, pstmt, rs);
		}
		return vbr;
	}
	
	//게시글 수정 메서드
	public int setEditBoard(VintageEditRequest dto) {
		con = DBConnectionUtil.getConnection();
		//데이터 초기화
		String v = "V"; //게시판 카테고리
		int res = 0;
		
		try {
			//text 타입 게시글 update
			 String boardText = "update board SET title = ?, contents = ? WHERE board_id = ?";
	         pstmt = con.prepareStatement(boardText);
	         
	         pstmt.setString(1, dto.getTitle());
	         pstmt.setString(2, dto.getContents());
	         pstmt.setInt(3, dto.getBoardId());
	         
	         res = pstmt.executeUpdate();
	         
	         if(dto.getImgSrc() != null) {
		         //이미지 파일 update
		         String boardImg = "update board_img set img_src = ?, img_name= ? WHERE board_id = ?";
		         pstmt = con.prepareStatement(boardImg);
		         
		         //값을 매핑하기
		         pstmt.setString(1, dto.getImgSrc());
		         pstmt.setString(2, dto.getImgName());
		         pstmt.setInt(3, dto.getBoardId());
		         
		         res = pstmt.executeUpdate();
					 } 
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			//커넥션 반납
			DBConnectionUtil.close(con, pstmt, rs);
		}
		
		return res;
	}
	
	//게시글 삭제 메서드
	public int setDeleteBoard(int boardId) {
		con = DBConnectionUtil.getConnection();
		System.out.println("DAO boardId = " + boardId);
		//데이터 초기화
		String v = "V"; //게시판 카테고리
		int res = 0;
		try {
			//게시글 삭제
			String boardText = "update BOARD "
					+ "set DELETE_YN = 'Y' "
					+ "where CATEGORY = 'V' and BOARD_ID = ? ";
			pstmt = con.prepareStatement(boardText);
			
			//값을 매핑하기
			pstmt.setInt(1, boardId);
			
			res = pstmt.executeUpdate();
		
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			//커넥션 반납
			DBConnectionUtil.close(con, pstmt, rs);
		}
		return res;
	}
}