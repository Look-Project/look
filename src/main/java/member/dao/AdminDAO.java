package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import board.vintage.dto.response.VintageBoardListResponse;
import common.DBConnectionUtil;
import member.dto.request.AdminMemberUpdateRequest;
import member.dto.response.AdminMemberResponse;
import member.dto.response.MemberResponse;

public class AdminDAO {

	Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    
	public int selectCount(Map<String, Object> map) {
		int totalCount=0;
		
		//쿼리문 준비
		String query="SELECT COUNT(*) FROM member";
		
		//검색 조건 WHERE절
        if (map.get("searchWord") != null) {
            query += " WHERE " + map.get("searchField") + " "
                   + " LIKE '%" + map.get("searchWord") + "%'";
        }
        try {
        	con = DBConnectionUtil.getConnection();
        	//쿼리문 생성
        	pstmt = con.prepareStatement(query);
        	//쿼리문 실행
        	rs = pstmt.executeQuery();
        	rs.next();
        	//검색된 게시물 개수 저장
        	totalCount = rs.getInt(1);
        }
        catch(Exception e) {
        	System.out.println("게시물 카운트 중 예외 발생");
        	e.printStackTrace();
        }finally {
			DBConnectionUtil.close(con, pstmt, rs);
		}
    	//게시물 개수 서블릿으로 반환
    	return totalCount;
	}
	
    // 검색 조건에 맞는 게시물 목록을 반환합니다(페이징 기능 지원).
    public List<AdminMemberResponse> selectListPage(Map<String,Object> map) {
    	List<AdminMemberResponse> memberList = new ArrayList<>();
    	int no = 1;
    	
        String query = " "
                     + "SELECT * FROM ( "
                     + "    SELECT Tb.*, ROWNUM rNum FROM ( "
                     + "        SELECT * FROM member ";

        if (map.get("searchWord") != null)
        {
            query += " WHERE " + map.get("searchField")
                   + " LIKE '%" + map.get("searchWord") + "%' ";
        }

        query += "        ORDER BY create_at ASC "
               + "    ) Tb "
               + " ) "
               + " WHERE rNum BETWEEN ? AND ?";

        
        try {
        	con = DBConnectionUtil.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, map.get("start").toString());
			pstmt.setString(2, map.get("end").toString());
            rs = pstmt.executeQuery();

            while (rs.next()) {
            	AdminMemberResponse member = new AdminMemberResponse();
				
				member.setNo(rs.getInt("rNum"));
				member.setLoginId(rs.getString("login_id"));
				member.setMemberId(rs.getInt("user_id"));
				member.setNickname(rs.getString("nickname"));
				member.setAdminYn(rs.getString("admin_yn"));
				member.setProfileName(rs.getString("profile_name"));
				member.setIntro(rs.getString("intro"));
				member.setCreateAt(rs.getDate("create_at"));

				memberList.add(member);
            }
        }
        catch (Exception e) {
            System.out.println("게시물 조회 중 예외 발생");
            e.printStackTrace();
        }finally {
			DBConnectionUtil.close(con, pstmt, rs);
		}
        //목록 반환
        return memberList;
    }
    
    public List<AdminMemberResponse> selectAllMember() {
		String sql = "select user_id, login_id, nickname, admin_yn, profile_name, intro, create_at from member";
		List<AdminMemberResponse> memberList = new ArrayList<>();
		int no = 1;
		try {
			con = DBConnectionUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				AdminMemberResponse member = new AdminMemberResponse();
				
				member.setNo(no++);
				member.setLoginId(rs.getString("login_id"));
				member.setMemberId(rs.getInt("user_id"));
				member.setNickname(rs.getString("nickname"));
				member.setAdminYn(rs.getString("admin_yn"));
				member.setProfileName(rs.getString("profile_name"));
				member.setIntro(rs.getString("intro"));
				member.setCreateAt(rs.getDate("create_at"));
				
				//불러온 값 저장
				memberList.add(member);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBConnectionUtil.close(con, pstmt, rs);
		}
		
		return memberList;
    }
    
	public boolean updateMember(AdminMemberUpdateRequest updateMember) {
		String sql = "update member set admin_yn = ?, nickname = ? where user_id = ?";
		int result = 0;
		
		try {
			con = DBConnectionUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, updateMember.getAdminYn());
			pstmt.setString(2, updateMember.getNickname());
			pstmt.setInt(3, updateMember.getUserId());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBConnectionUtil.close(con, pstmt, null);
		}
		
		return result > 0 ? true : false;
	}
	
	public boolean deleteMember(int userId) {
		String sql = "delete from member where user_id = ?";
		int result = 0;
		
		try {
			con = DBConnectionUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, userId);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBConnectionUtil.close(con, pstmt, null);
		}
		
		return result > 0 ? true : false;
	}
	
}
