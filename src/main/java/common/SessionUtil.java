package common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import member.dto.response.MemberResponse;

public class SessionUtil {
	private static final String SESSION_ID = "LOGIN_USER";
	
	public static void setSessionMember(HttpServletRequest request, MemberResponse member) {
		HttpSession session = request.getSession();
		session.setAttribute(SESSION_ID, member);
	}
	
	public static MemberResponse getSessionMember(HttpServletRequest request) {
		HttpSession session = request.getSession();
		MemberResponse loginMember = (MemberResponse) session.getAttribute(SESSION_ID);
		
		return loginMember;
	}
}
