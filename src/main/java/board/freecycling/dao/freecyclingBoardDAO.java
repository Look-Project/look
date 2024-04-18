package board.freecycling.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import board.freecycling.dto.request.FreecyclingBoardDTO;
import common.DBConnectionUtil;



public class freecyclingBoardDAO {

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	//하나의 게시글을 저장하는 메서드 호출
			public int insertBoard(FreecyclingBoardDTO bdto){
				con = DBConnectionUtil.getConnection();
				int res = 0;
				String c = "C";
				try {
				
					//데이터를 삽입하는 쿼리
					String sql="insert into board(USER_ID,TITLE,CONTENTS,CATEGORY) values (?,?,?,?)";
					pstmt = con.prepareStatement(sql);
					
					pstmt.setInt(1, 1);
					pstmt.setString(2, bdto.getTitle());
					pstmt.setString(3, bdto.getContents());
					pstmt.setString(4,c);
					
					
					res = pstmt.executeUpdate();
					
				} catch (Exception e) {
					e.printStackTrace();
				}finally {
					DBConnectionUtil.close(con, pstmt, rs);
				}
				return res;
			}
			
	//전체게시글을 보는 메서드
	/*
	 * public List<FreecyclingBoardDTO> getAllBoard{ List<FreecyclingBoardDTO> v =
	 * new ArrayList<>();
	 * 
	 * try {
	 * 
	 * String sql="select * from  (select * from board" +"where category = C";
	 * pstmt=con.prepareStatement(sql);
	 * 
	 * rs = pstmt.executeQuery();
	 * 
	 * while(rs.next()) { BoardBean bean = new BoardBean();
	 * bean.setNum(rs.getInt(1)); bean.setWriter(rs.getString(2));
	 * bean.setEmail(rs.getString(3)); bean.setSubject(rs.getString(4));
	 * bean.setPassword(rs.getString(5));
	 * bean.setReg_date(rs.getDate(6).toString()); bean.setRef(rs.getInt(7));
	 * bean.setRe_step(rs.getInt(8)); bean.setRe_level(rs.getInt(9));
	 * bean.setReadcount(rs.getInt(10)); bean.setContent(rs.getString(11)); //패키징한
	 * 데이터를 벡터에 저장 v.add(bean); } con.close(); } catch (Exception e) {
	 * e.printStackTrace(); } return v; }
	 * 
	 */	
}
