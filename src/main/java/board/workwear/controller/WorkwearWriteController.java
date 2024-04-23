package board.workwear.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.workwear.dto.request.WorkwearWriteRequest;
import board.workwear.service.WorkwearService;
import common.SessionUtil;

import java.io.IOException;

@WebServlet("/workwear/write")
public class WorkwearWriteController extends HttpServlet {
	private final String WORKWEAR_BOARD_WRITE = "/views/board/workwear/workwerWrite.jsp";
	private final String LOGIN = "/views/member/login.jsp";
	private final String VINTAGE_BOARD_LIST = "/vintage/boardlist";
	WorkwearService wbs = new WorkwearService();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(SessionUtil.getSessionMember(request) != null) {
		request.getRequestDispatcher(WORKWEAR_BOARD_WRITE).forward(request, response);
		}else {
			request.getRequestDispatcher(LOGIN).forward(request, response);
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		WorkwearWriteRequest wwr = new WorkwearWriteRequest();
		
		wwr.setTitle(request.getParameter("title"));
		wwr.setContents(request.getParameter("contents"));
		wwr.setMemberId(SessionUtil.getSessionMember(request).getMemberId());
		wbs.post(wwr);
		response.sendRedirect(request.getContextPath() + VINTAGE_BOARD_LIST);
	}
	
}
