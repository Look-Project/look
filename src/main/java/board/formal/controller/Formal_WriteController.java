package board.formal.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.fromal.dto.request.Formal_WriteRequest;
import board.fromal.service.Formal_BoardService;
import common.SessionUtil;

@WebServlet(urlPatterns = "/formal/write")
public class Formal_WriteController extends HttpServlet {
	private final String FORMAL_BOARD_WRITE = "/views/board/formal/Formal_writeform.jsp";
	private final String LOGIN = "/views/member/login.jsp";
	private final String FORMAL_BOARD_LIST = "/formal/boardlist";
	Formal_BoardService vbs = new Formal_BoardService();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(SessionUtil.getSessionMember(request) != null) {
		request.getRequestDispatcher(FORMAL_BOARD_WRITE).forward(request, response);
		}else {
			request.getRequestDispatcher(LOGIN).forward(request, response);
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Formal_WriteRequest vwr = new Formal_WriteRequest();
		
		vwr.setTitle(request.getParameter("title"));
		vwr.setContents(request.getParameter("contents"));
		vwr.setMemberId(SessionUtil.getSessionMember(request).getMemberId());
		vbs.post(vwr);
		response.sendRedirect(request.getContextPath() + FORMAL_BOARD_LIST);
	}
	
}
