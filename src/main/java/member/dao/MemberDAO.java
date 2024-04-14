package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.DBConnectionUtil;
import member.dto.request.MemberSignupRequest;

public class MemberDAO {
	
	Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    
    public boolean selectLoginId(String loginId) {
		String sql = "select count(*) from member where login_id = ?";
		int result = 0;
		
		try {
			con = DBConnectionUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, loginId);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBConnectionUtil.close(con, pstmt, rs);
		}
		
		return result == 0 ? true : false;
    }
    
    public boolean selectNickname(String nickname) {
		String sql = "select count(*) from member where nickname = ?";
		int result = 0;
		
		try {
			con = DBConnectionUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, nickname);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBConnectionUtil.close(con, pstmt, rs);
		}
		
		return result == 0 ? true : false;
    }
	
	
	public boolean insertMember(MemberSignupRequest member) {
		String sql = "insert into member(login_id, login_pwd, nickname) values(?, ?, ?)";
		int result = 0;
		
		try {
			con = DBConnectionUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getLoginId());
			pstmt.setString(2, member.getPassword());
			pstmt.setString(3, member.getNickname());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBConnectionUtil.close(con, pstmt, null);
		}
		
		return result > 0 ? true : false;
	}
}
