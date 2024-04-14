package member.service;

import member.dao.MemberDAO;
import member.dto.request.MemberSignupRequest;

public class MemberService {
	
	private final MemberDAO memberDao = new MemberDAO();
	
	/**
	 * 아이디 중복 검증 메서드
	 * @param loginId
	 * @return true -> 사용 가능한 아이디, false -> 중복된 아이디
	 */
	public boolean duplicateLoginId(String loginId) {
		return memberDao.selectLoginId(loginId);
	}
	
	/**
	 * 닉네임 중복 검증 메서드
	 * @param nickname
	 * @return true -> 사용 가능한 닉네임, false -> 중복된 닉네임
	 */
	public boolean duplicateNickname(String nickname) {
		return memberDao.selectNickname(nickname);
	}
	
	public boolean signup(MemberSignupRequest member) {
		return memberDao.insertMember(member);
	}
	
}
