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

@WebServlet(urlPatterns = "/mypage/user-delete")
public class MemerDeleteController extends HttpServlet {
	
	private final MyPageService myPageService = new MyPageService();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberResponse loginMember = SessionUtil.getSessionMember(request);
		
		myPageService.removeMember(loginMember.getMemberId());
		
		request.getSession().invalidate();
		response.sendRedirect(request.getContextPath() + "/main");
	}

	
	
}