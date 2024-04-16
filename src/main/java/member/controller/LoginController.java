package member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import common.SessionUtil;
import member.dto.request.MemberLoginRequest;
import member.dto.response.MemberResponse;
import member.service.MemberService;

@WebServlet(urlPatterns = "/member/login")
public class LoginController extends HttpServlet {
	
	private final String LOGIN_VIEW_NAME = "/views/member/login.jsp";
	private final MemberService memberService = new MemberService();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher(LOGIN_VIEW_NAME).forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberLoginRequest member = new MemberLoginRequest();
		member.setLoginId(request.getParameter("loginId"));
		member.setPassword(request.getParameter("password"));
		
		JSONObject jObj = new JSONObject();
		try {
			MemberResponse findMember = memberService.login(member);
			SessionUtil.setSessionMember(request, findMember);
		}catch(RuntimeException e) {
			jObj.put("error", e.getMessage());
		}
		
        response.setContentType("application/x-json; charset=utf-8");
        response.getWriter().print(jObj);
	}

	
	
}
