package member.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.service.AdminService;

@WebServlet(urlPatterns = "/mypage/admin/member-delete")
public class AdminMemberDeleteController extends HttpServlet {
	
	private final String ADMIN_MEMBER_VIEW_NAME = "/views/member/adminpage/Member_manage.jsp";
	private final AdminService adminService = new AdminService();
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int userId = Integer.parseInt(request.getParameter("userId"));
		
		if(!adminService.deleteMember(userId)) {
			response.sendError(response.SC_INTERNAL_SERVER_ERROR, "서버 에러가 발생했습니다.");
		}
		
		
		response.sendRedirect(request.getContextPath() + "/mypage/admin-member");
		
	}

	
	
}
