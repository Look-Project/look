package board.freecycling.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import board.freecycling.dto.request.FreecyclingBoardDTO;
import board.freecycling.dto.response.FreecyclingBoardListViewDTO;
import common.DBConnectionUtil;


public class freecyclingBoardDAO {

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	// 하나의 게시글을 저장하는 메서드 호출
	public int insertBoard(FreecyclingBoardDTO bdto) {
		con = DBConnectionUtil.getConnection();
		int res = 0;
		String c = "C";
		try {

			// 데이터를 삽입하는 쿼리
			String sql = "insert into board(USER_ID,TITLE,CONTENTS,CATEGORY) values (?,?,?,?)";
			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, 1);
			pstmt.setString(2, bdto.getTitle());
			pstmt.setString(3, bdto.getContents());
			pstmt.setString(4, c);

			res = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnectionUtil.close(con, pstmt, rs);
		}
		return res;
	}

	// 전체게시글을 보는 메서드

	  public List<FreecyclingBoardListViewDTO> getAllBoard(){
		  List<FreecyclingBoardListViewDTO> resListdto = new ArrayList<>();
		  
	 
		  con = DBConnectionUtil.getConnection();
		  
		  String sql = "select m.nickname, b.title, bi.img_src, bi.img_name "
				  +"from member m inner join board b "
				  + "on m.user_id = b.user_id "
				  + "left outer join board_img bi "
				  + "on b.board_id = bi.board_id "
				  + "where b.category = 'C' and b.delete_yn = 'N' ";
		  
	  try {
	 
		  pstmt = con.prepareStatement(sql);

		  rs = pstmt.executeQuery();
	    while(rs.next()) {
	    	FreecyclingBoardListViewDTO blvdto = new FreecyclingBoardListViewDTO();
	    	blvdto.setNickname(rs.getString(1));
	    	blvdto.setTitle(rs.getString(2));
	    	blvdto.setImg_src(rs.getString(3));
	    	blvdto.setImg_name(rs.getString(4));
			
			//패키징한 데이터를 List에 저장
	    	resListdto.add(blvdto);
		}
		
	  } catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnectionUtil.close(con, pstmt, rs);
		}
	   return resListdto; 
	   
	  }
}
