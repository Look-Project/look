package board.freecycling.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import board.freecycling.dto.request.FreeEditDTO;
import board.freecycling.dto.request.FreeInsertDTO;
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
		  
		  String sql = "select m.nickname, m.profile_src, m.profile_name, b.title, b.board_id, bi.img_src, bi.img_name "
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
	    	mldto.setProfileSrc(rs.getString("profile_src"));
	    	mldto.setProfileName(rs.getString("profile_name"));
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
	  public FreeOneContentDTO getoneBoard(int num) {
		   
		  con = DBConnectionUtil.getConnection();
				//한 게시글에 대한 정보를 리턴해주는 쿼리를 작성
		  String sql = "select m.user_id, m.nickname, b.board_id, b.create_at, b.title, b.contents, b.views, bi.img_name, bi.img_src "
				  + "from member m inner join board b "
				  + "on m.user_id = b.user_id "
				  + "inner join board_img bi "
				  + "on b.board_id = bi.board_id "
				  + "where b.board_id=? ";
		  FreeOneContentDTO onedto = new FreeOneContentDTO();
	  try { 
		  	pstmt = con.prepareStatement(sql);

		 	//쿼리실행
			//pstmt.executeUpdate();
			
		    pstmt.setInt(1, num);
		    rs = pstmt.executeQuery();
		  
	    while(rs.next()) {
	    	onedto.setImgSrc(rs.getString("img_src"));
	    	onedto.setImgName(rs.getString("img_name"));
	    	onedto.setBoardId(rs.getInt("board_id"));
	    	onedto.setTitle(rs.getString("title"));
	    	onedto.setContents(rs.getString("contents"));
	    	onedto.setViews(rs.getInt("views"));
	    	onedto.setCreateAt(rs.getDate("create_at"));
	    	onedto.setNickname(rs.getString("nickname"));
	    	onedto.setUserId(rs.getInt("user_id"));
		}
	    
	    //조회수 증가 함수 호출
	    viewUp(num);
	    
	  } catch (Exception e) {
		  System.out.println("게시글 상세보기 시 에러발생");
			e.printStackTrace();
		} finally {
			DBConnectionUtil.close(con, pstmt, rs);
		}
	   return onedto;
	  }

//게시글 조회수 증가
		
	  	public void viewUp(int num) {
	  	  con = DBConnectionUtil.getConnection();
		  String viewsql = "UPDATE board SET " + " views=views+1 "
				  		    + " WHERE board_id=?"; 
		  try { 
		  pstmt = con.prepareStatement(viewsql);
		  pstmt.setInt(1, num); 
		  pstmt.executeQuery(); 
		  }catch(Exception e) {
		 System.out.println("게시물 조회수 증가 중 예외 발생"); 
		 e.printStackTrace();
		  }finally {
				DBConnectionUtil.close(con, pstmt, rs);
		}
	  	}
//FreeEditCon 게시글 수정 
	  public int updateBoard(FreeEditDTO dto) {
		  con = DBConnectionUtil.getConnection();
			int res = 0;			
			String c = "C";
			
			try {
				//text 타입 게시글 insert
		         String boardText = "update board SET title = ?, contents = ? WHERE board_id = ?";
		         pstmt = con.prepareStatement(boardText);
		         
		         //값을 매핑하기
		         pstmt.setString(1, dto.getTitle());
		         pstmt.setString(2, dto.getContents());
		         pstmt.setInt(3, dto.getBoardId());
		         
		         res = pstmt.executeUpdate();
		         
		        
		         //이미지 파일 insert
		         String boardImg = "update board_img set img_src = ?, img_name= ? WHERE board_id = ?";
		         pstmt = con.prepareStatement(boardImg);
		         
		         //값을 매핑하기
		         pstmt.setString(1, dto.getImgSrc());
		         pstmt.setString(2, dto.getImgName());
		         pstmt.setInt(3, dto.getBoardId());
		         
		         res = pstmt.executeUpdate();
			} catch (Exception e) {
				System.out.println("데이터 삽입 시 에러발생");
				e.printStackTrace();
			} finally {
				DBConnectionUtil.close(con, pstmt, rs);
			}
			return res;
	 
}

//FreeDeleteCon 게시글 삭제 
	  public int deleteBoard(int num) throws SQLException {
		  con = DBConnectionUtil.getConnection();
		  int res = 0;
		  
		  try {
				//text 타입 게시글 insert
		         String sql = "update board SET delete_yn = 'Y' WHERE category = 'C' and board_id = ? ";
		         pstmt = con.prepareStatement(sql);
		         
		         //값을 매핑하기
		         
		         pstmt.setInt(1, num);
		         
		         res = pstmt.executeUpdate();
		         
		       
			} catch (Exception e) {
				System.out.println("데이터 삭제 시 에러발생");
				e.printStackTrace();
			} finally {
				DBConnectionUtil.close(con, pstmt, rs);
			}
			return res;
	 
	  }
	  
// 게시글 페이지 처리를 위한 전체 게시글 갯수 끌어오는 함수
		
		public int getAllCount() {
			con = DBConnectionUtil.getConnection();
			int count = 0;
			
			try {
				String sql="select count(*) from board where delete_yn = 'N' ";
				pstmt=con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				if(rs.next()) {//데이터가 있다면
					count=rs.getInt(1);
					
				}
			 } catch (Exception e) {
			  System.out.println("게시글 숫자 반환 메서드 에러발생");
				e.printStackTrace();
			} finally {
				DBConnectionUtil.close(con, pstmt, rs);
			}
		   return count;
		  }

	
}