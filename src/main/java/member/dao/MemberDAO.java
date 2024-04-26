 package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import common.DBConnectionUtil;
import member.dto.request.MemberLoginRequest;
import member.dto.request.MemberSignupRequest;
import member.dto.response.MemberResponse;

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
	
    public Optional<MemberResponse> findMemberByLoginIdAndPassword(MemberLoginRequest memberRequest) {
		String sql = "select user_id, login_pwd, nickname, profile_src, profile_name, admin_yn, intro, create_at from member where login_id = ? and login_pwd = ?";
		
		try {
			con = DBConnectionUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memberRequest.getLoginId());
			pstmt.setString(2, memberRequest.getPassword());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				MemberResponse findMember = new MemberResponse();
				findMember.setMemberId(rs.getInt("user_id"));
				findMember.setPassword(rs.getString("login_pwd"));
				findMember.setNickname(rs.getString("nickname"));
				findMember.setProfileSrc(rs.getNString("profilE_src"));
				findMember.setProfileName(rs.getNString("profile_name"));
				findMember.setAdminYn(rs.getString("admin_yn"));
				findMember.setIntro(rs.getString("intro"));
				findMember.setCreateAt(rs.getTimestamp("create_at").toLocalDateTime());
				
				return Optional.ofNullable(findMember);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBConnectionUtil.close(con, pstmt, rs);
		}
		
		return Optional.empty();
		
    }
    
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
}
