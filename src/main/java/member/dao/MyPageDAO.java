package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.DBConnectionUtil;
import member.dto.response.MemberResponse;

public class MyPageDAO {
	
	Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

	public boolean updateMemberImgae(MemberResponse loginMember) {
		String sql = "update member set profile_src = ?, profile_name = ? where user_id = ?";
		int result = 0;
		
		try {
			con = DBConnectionUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, loginMember.getProfileSrc());
			pstmt.setString(2, loginMember.getProfileName());
			pstmt.setInt(3, loginMember.getMemberId());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBConnectionUtil.close(con, pstmt, null);
		}
		
		return result > 0 ? true : false;
	}
	
	public boolean updateMemberNickname(MemberResponse loginMember, String nickname) {
		String sql = "update member set nickname = ? where user_id = ?";
		int result = 0;
		
		try {
			con = DBConnectionUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, nickname);
			pstmt.setInt(2, loginMember.getMemberId());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBConnectionUtil.close(con, pstmt, null);
		}
		
		return result > 0 ? true : false;
	}
	
	public boolean updateMemberIntro(MemberResponse loginMember, String intro) {
		String sql = "update member set intro = ? where user_id = ?";
		int result = 0;
		
		try {
			con = DBConnectionUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, intro);
			pstmt.setInt(2, loginMember.getMemberId());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBConnectionUtil.close(con, pstmt, null);
		}
		
		return result > 0 ? true : false;
	}
	
	
}