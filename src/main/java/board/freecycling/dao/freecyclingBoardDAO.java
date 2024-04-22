package board.freecycling.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import board.freecycling.dto.request.FreecyclingBoardDTO;
import board.freecycling.dto.request.FreecyclingUpdaterequestDTO;
import board.freecycling.dto.response.FreecyclingBoardContentsViewDTO;
import board.freecycling.dto.response.FreecyclingBoardListViewDTO;
import board.freecycling.dto.response.FreecyclingUpdateresponseDTO;
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
		  
		  String sql = "select m.nickname, b.title, b.board_id, bi.img_src, bi.img_name "
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
	    	blvdto.setBoardId(rs.getInt(3));
	    	blvdto.setImg_src(rs.getString(4));
	    	blvdto.setImg_name(rs.getString(5));
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
//게시글 상세보기
	  public FreecyclingBoardContentsViewDTO getoneBoard(int num) throws SQLException {
		   
		  con = DBConnectionUtil.getConnection();
				//한 게시글에 대한 정보를 리턴해주는 쿼리를 작성
		  String sql = "select m.nickname, b.board_id, b.create_at, b.title, b.contents, b.views, bi.img_name, bi.img_src "
				  + "from member m inner join board b "
				  + "on m.user_id = b.user_id "
				  + "left outer join board_img bi "
				  + "on b.board_id = bi.board_id "
				  + "where b.board_id=? ";
		  FreecyclingBoardContentsViewDTO blonedto = new FreecyclingBoardContentsViewDTO();
	  try {
		//하나의 게시글을 읽었다는 조회수 증가
		/*
		 * if (board_id != null) { String countsql =
		 * "UPDATE board SET views = views + 1 WHERE board_id = ?"; pstmt =
		 * con.prepareStatement(countsql); pstmt.setInt(1, board_id); } else { //
		 * board_id가 null인 경우에 대한 처리 }
		 * 
		 */			//쿼리실행
		//	pstmt.executeUpdate();
			
		  pstmt = con.prepareStatement(sql);
		  pstmt.setInt(1, num);
		  rs = pstmt.executeQuery();
		  
	    while(rs.next()) {
	    	blonedto.setImgSrc(rs.getString("img_src"));
	    	blonedto.setImgName(rs.getString("img_name"));
	    	blonedto.setBoardId(rs.getInt("board_id"));
	    	blonedto.setTitle(rs.getString("title"));
	    	blonedto.setContents(rs.getString("contents"));
	    	blonedto.setViews(rs.getInt("views"));
	    	blonedto.setCreateAt(rs.getDate("create_at"));
	    	blonedto.setNickname(rs.getString("nickname"));
		}
	  } catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnectionUtil.close(con, pstmt, rs);
		}
	   return blonedto;
	  }
	  
//FreecyclingUpdaterequestCon 수정할 글 읽어오기 메서드	  
	  public FreecyclingUpdaterequestDTO getoneUpdateBoard(int num) {
		    con = DBConnectionUtil.getConnection();
		    FreecyclingUpdaterequestDTO boardupReqdto = new FreecyclingUpdaterequestDTO();
		
			try {
				//한 게시글에 대한 정보를 리턴해주는 쿼리를 작성
				String sql = "select m.nickname, b.board_id, b.create_at, b.title, b.contents, b.views, bi.img_name, bi.img_src "
						  + "from member m inner join board b "
						  + "on m.user_id = b.user_id "
						  + "left outer join board_img bi "
						  + "on b.board_id = bi.board_id "
						  + "where b.board_id=? ";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, num);
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					boardupReqdto.setImgSrc(rs.getString("img_src"));
					boardupReqdto.setImgName(rs.getString("img_name"));
					boardupReqdto.setBoardId(rs.getInt("board_id"));
					boardupReqdto.setTitle(rs.getString("title"));
					boardupReqdto.setContents(rs.getString("contents"));
					boardupReqdto.setViews(rs.getInt("views"));
					boardupReqdto.setCreateAt(rs.getDate("create_at"));
					boardupReqdto.setNickname(rs.getString("nickname"));
				}
			  } catch (Exception e) {
					e.printStackTrace();
				} finally {
					DBConnectionUtil.close(con, pstmt, rs);
				}
			   return boardupReqdto;
			  }
//FreecyclingUpdateresponseCon 게시글 수정 
	  public void updateBoard(int num,FreecyclingUpdateresponseDTO upresdto) {
		  con = DBConnectionUtil.getConnection();
		  
			try {
				String sql = "UPDATE board b "
		                   + "SET b.title = ?, b.contents = ? "
		                   + "WHERE b.board_id = ? "
		                   + "AND EXISTS (SELECT 1 FROM board_img bi WHERE bi.board_id = b.board_id)";

		    
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1, upresdto.getTitle());
				pstmt.setString(2, upresdto.getContents());
				//pstmt.setString(3, upresdto.getImgSrc());
				//pstmt.setString(4, upresdto.getImgName());
				pstmt.setInt(3,num);
				//pstmt.setString(4, "imgSrc");
				//pstmt.setString(5, "imgname");
				
				pstmt.executeUpdate();
			  } catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBConnectionUtil.close(con, pstmt, rs);
			}
		
	  }
}
