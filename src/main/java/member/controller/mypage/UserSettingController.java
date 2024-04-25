package member.controller.mypage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/mypage/user")
public class UserSettingController extends HttpServlet {
	
	private final String MYPAGE_USER_VIEW_NAME = "/views/member/mypage/mypage_user.jsp";

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher(MYPAGE_USER_VIEW_NAME).forward(request, response);
	}

	
	
}
