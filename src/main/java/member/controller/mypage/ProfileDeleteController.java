package member.controller.mypage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.SessionUtil;
import member.dto.response.MemberResponse;
import member.service.MyPageService;

@WebServlet("/mypage/profile-delete")
public class ProfileDeleteController extends HttpServlet {
	
	private final MyPageService myPageService = new MyPageService();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberResponse loginMember = SessionUtil.getSessionMember(request);
		loginMember.setProfileSrc(null);
		loginMember.setProfileName(null);
		
		if(!myPageService.updateProfile(loginMember)) {
			response.sendError(response.SC_UNAUTHORIZED);
		}
		
		response.sendRedirect(request.getContextPath() + "/mypage/profile");
	}
	
}
