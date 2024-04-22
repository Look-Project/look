package member.controller.mypage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.SessionUtil;
import member.dto.response.MemberResponse;
import member.service.MemberService;
import member.service.MyPageService;

@WebServlet(urlPatterns = "/mypage/profile-nickname")
public class ProfileNicknameController extends HttpServlet {

	private final MemberService memberService = new MemberService();
	private final MyPageService myPageService = new MyPageService();
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("nickanme = " + request.getParameter("nickname"));
		
		String nickname = request.getParameter("nickname");
		MemberResponse loginMember = SessionUtil.getSessionMember(request);
		
		if(!memberService.duplicateNickname(nickname)) {
			response.sendError(response.SC_BAD_REQUEST, "중복된 닉네임입니다.");
			return;
		}
		
		if(!myPageService.updateNickname(loginMember, nickname)) {
			response.sendError(response.SC_INTERNAL_SERVER_ERROR, "닉네임 변경에 실패했습니다.");
			return;
		}
		
		loginMember.setNickname(nickname);
		
		response.sendRedirect(request.getContextPath() + "/mypage/profile");
	}
	
}
