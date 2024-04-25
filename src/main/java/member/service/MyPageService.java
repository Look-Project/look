package member.service;

import member.dao.MyPageDAO;
import member.dto.response.MemberResponse;

public class MyPageService {
	
	private final MyPageDAO myPageDao = new MyPageDAO();

	/**
	 * 마이페이지 프로필 업데이트
	 * @param 로그인한 사용자 정보
	 * @return true -> 업데이트 성공, false -> 업데이트 실패
	 */
	public boolean updateProfile(MemberResponse loginMember) {
		return myPageDao.updateMemberImgae(loginMember);
	}
	
	/**
	 * 마이페이지 닉네임 업데이트
	 * @param loginMember 로그인한 사용자 정보
	 * @param nickname 변경하고자 하는 닉네임
	 * @return true -> 업데이트 성공, false -> 업데이트 실패
	 */
	public boolean updateNickname(MemberResponse loginMember, String nickname) {
		return myPageDao.updateMemberNickname(loginMember, nickname);
	}
	
	/**
	 * 마이페이지 닉네임 업데이트
	 * @param loginMember 로그인한 사용자 정보
	 * @param nickname 변경하고자 하는 닉네임
	 * @return true -> 업데이트 성공, false -> 업데이트 실패
	 */
	public boolean updateIntro(MemberResponse loginMember, String intro) {
		return myPageDao.updateMemberIntro(loginMember, intro);
	}
	
	
	public boolean updateLoginPassword(int userId, String targetPassword) {
		return myPageDao.updateMemberLoginPwd(userId, targetPassword);
	}
	
}
