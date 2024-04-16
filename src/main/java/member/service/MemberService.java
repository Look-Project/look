package member.service;

import member.dao.MemberDAO;
import member.dto.request.MemberLoginRequest;
import member.dto.request.MemberSignupRequest;
import member.dto.response.MemberResponse;

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
	
	public MemberResponse login(MemberLoginRequest member) {
		MemberResponse findMember = memberDao.findMemberByLoginIdAndPassword(member)
				.orElseThrow(() -> new RuntimeException("아이디 또는 비밀번호가 존재하지 않거나 틀렸습니다."));
		return findMember;
	}
	
}
