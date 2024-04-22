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

@WebServlet(urlPatterns = "/mypage/profile-intro")
public class ProfileIntroController extends HttpServlet {

	private final MyPageService myPageService = new MyPageService();
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getParameter("intro"));
		String intro = request.getParameter("intro");
		
		MemberResponse loginMember = SessionUtil.getSessionMember(request);
		
		if(!myPageService.updateIntro(loginMember, intro)) {
			response.sendError(response.SC_INTERNAL_SERVER_ERROR, "소개글 작성에 문제가 발생했습니다.");
		}
		
		loginMember.setIntro(intro);
		
		response.sendRedirect(request.getContextPath() + "/mypage/profile");
	}

}
