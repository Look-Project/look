package board.freecycling.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import board.freecycling.dto.request.FreeEditDTO;
import board.freecycling.dto.request.FreeInsertDTO;
import board.freecycling.dto.request.FreecyclingUpdateDTO;
import board.freecycling.dto.response.FreeOneContentDTO;
import board.freecycling.dto.response.FreeMainListDTO;
import common.DBConnectionUtil;



public class freecyclingBoardDAO {

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

// FreeInsertCon 하나의 게시글을 저장하는 메서드 호출
	public int insertBoard(FreeInsertDTO dto) {
		con = DBConnectionUtil.getConnection();
		int res = 0;
		
		String c = "C";
		try {
			//text 타입 게시글 insert
	         String boardText = "insert into board(USER_ID,TITLE,CONTENTS,CATEGORY) values(?,?,?,?)";
	         pstmt = con.prepareStatement(boardText);
	         
	         //값을 매핑하기
	         pstmt.setInt(1,dto.getMemberId() );
	         pstmt.setString(2, dto.getTitle());
	         pstmt.setString(3, dto.getContents());
	         pstmt.setString(4, c);
	         
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
	         pstmt.setString(2, dto.getImgSrc());
	         pstmt.setString(3, dto.getImgName());
	         
	         res = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("데이터 삽입 시 에러발생");
			e.printStackTrace();
		} finally {
			DBConnectionUtil.close(con, pstmt, rs);
		}
		return res;
	}

// freeMainListCon전체게시글을 보는 메서드

	  public List<FreeMainListDTO> mainListBoard(){
		  List<FreeMainListDTO> listdto = new ArrayList<>();
		  
		  con = DBConnectionUtil.getConnection();
		  
		  String sql = "select m.nickname, b.title, b.board_id, bi.img_src, bi.img_name "
				 + "from member m inner join board b "
				 + "on m.user_id = b.user_id "
				 + "inner join board_img bi "
				 + "on b.board_id = bi.board_id "
				 + "where b.category = 'C' and b.delete_yn = 'N' "
				 + "order by b.board_id desc ";
	  try {
		  pstmt = con.prepareStatement(sql);

		  rs = pstmt.executeQuery();
	    while(rs.next()) {
	    	FreeMainListDTO mldto = new FreeMainListDTO();
	    	mldto.setNickname(rs.getString("nickname"));
	    	mldto.setTitle(rs.getString("title"));
	    	mldto.setBoardId(rs.getInt("board_id"));
	    	mldto.setImgSrc(rs.getString("img_src"));
	    	mldto.setImgName(rs.getString("img_name"));
			//패키징한 데이터를 List에 저장
	    	listdto.add(mldto);
		}
	  } catch (Exception e) {
		  System.out.println("게시글 목록보기 시 에러발생");
			e.printStackTrace();
		} finally {
			DBConnectionUtil.close(con, pstmt, rs);
		}
	   return listdto; 
	  }
	  
//게시글 상세보기
	  public FreeOneContentDTO getoneBoard(int num) throws SQLException {
		   
		  con = DBConnectionUtil.getConnection();
				//한 게시글에 대한 정보를 리턴해주는 쿼리를 작성
		  String sql = "select m.nickname, b.board_id, b.create_at, b.title, b.contents, b.views, bi.img_name, bi.img_src "
				  + "from member m inner join board b "
				  + "on m.user_id = b.user_id "
				  + "inner join board_img bi "
				  + "on b.board_id = bi.board_id "
				  + "where b.board_id=? ";
		  FreeOneContentDTO blonedto = new FreeOneContentDTO();
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
		  System.out.println("게시글 상세보기 시 에러발생");
			e.printStackTrace();
		} finally {
			DBConnectionUtil.close(con, pstmt, rs);
		}
	   return blonedto;
	  }
	  
//FreecyclingUpdaterequestCon 수정할 글 읽어오기 메서드	  
	  public FreecyclingUpdateDTO getoneUpdateBoard(int num) {
		    con = DBConnectionUtil.getConnection();
		    FreecyclingUpdateDTO boardupReqdto = new FreecyclingUpdateDTO();
		
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
				  System.out.println("수정할 게시글 폼 가져오기 에러발생");
					e.printStackTrace();
				} finally {
					DBConnectionUtil.close(con, pstmt, rs);
				}
			   return boardupReqdto;
			  }
//FreecyclingUpdateresponseCon 게시글 수정 
	  public void updateBoard(int num,FreecyclingUpdateDTO boardupdto) {
		  con = DBConnectionUtil.getConnection();
		  //PreparedStatement pstmt2 = null;
			try {
				String sql = "UPDATE board SET title = ?, contents = ? "
						   + "WHERE board_id = ? ";
//				String sql2 = "UPDATE board_img SET img_src = ?, img_name = ? "
//				           	+ "WHERE board_id = ? ; ";

		    
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1, boardupdto.getTitle());
				pstmt.setString(2, boardupdto.getContents());
				pstmt.setInt(3,num);
				
//				pstmt2=con.prepareStatement(sql2);
//				pstmt2.setString(1, upresdto.getImgSrc());
//				pstmt2.setString(2, upresdto.getImgName());
//				pstmt2.setInt(3,num);
				//pstmt.setString(4, "imgSrc");
				//pstmt.setString(5, "imgname");
				
				pstmt.executeUpdate();
//				pstmt2.executeUpdate();
			  } catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBConnectionUtil.close(con, pstmt, rs);
//				DBConnectionUtil.close(null,pstmt2,null);
			}
			
	  }
	  
//FreeEditCon의 doget요청시 게시글 수정폼 보여주는 메서드
	    // 게시글 데이터를 받아 DB에 저장되어 있던 내용을 갱신합니다(파일 업로드 지원).
		/*
		 * public int updatePost(MVCBoardDTO dto) { int result = 0; try { // 쿼리문 템플릿 준비
		 * String query = "UPDATE mvcboard" +
		 * " SET title=?, name=?, content=?, ofile=?, sfile=? " +
		 * " WHERE idx=? and pass=?";
		 * 
		 * // 쿼리문 준비 psmt = con.prepareStatement(query); psmt.setString(1,
		 * dto.getTitle()); pstmt.setString(2, dto.getName()); psmt.setString(3,
		 * dto.getContent()); pstmt.setString(4, dto.getOfile()); psmt.setString(5,
		 * dto.getSfile()); pstmt.setString(6, dto.getIdx()); psmt.setString(7,
		 * dto.getPass());
		 * 
		 * // 쿼리문 실행 result = psmt.executeUpdate(); } catch (Exception e) {
		 * System.out.println("게시물 수정 중 예외 발생"); e.printStackTrace(); } return result; }
		 */    
//게시글 상세보기
/*		  public FreeEditDTO getEditBoard(int num) throws SQLException {
			   
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
			
			 * if (board_id != null) { String countsql =
			 * "UPDATE board SET views = views + 1 WHERE board_id = ?"; pstmt =
			 * con.prepareStatement(countsql); pstmt.setInt(1, board_id); } else { //
			 * board_id가 null인 경우에 대한 처리 }
			 * 
			 			//쿼리실행
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
			  System.out.println("게시글 상세보기 시 에러발생");
				e.printStackTrace();
			} finally {
				DBConnectionUtil.close(con, pstmt, rs);
			}
		   return FreeEditDTO;
		  }*/
}
