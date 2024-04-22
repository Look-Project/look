package board.vintage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.vintage.dto.request.VintageWriteRequest;
import board.vintage.service.VintageBoardService;
import common.SessionUtil;

@WebServlet(urlPatterns = "/vintage/write")
public class VintageWriteController extends HttpServlet {
	private final String VINTAGE_BOARD_WRITE = "/views/board/vintage/vintagewriteform.jsp";
	private final String LOGIN = "/views/member/login.jsp";
	private final String VINTAGE_BOARD_LIST = "/vintage/boardlist";
	VintageBoardService vbs = new VintageBoardService();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(SessionUtil.getSessionMember(request) != null) {
		request.getRequestDispatcher(VINTAGE_BOARD_WRITE).forward(request, response);
		}else {
			request.getRequestDispatcher(LOGIN).forward(request, response);
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		VintageWriteRequest vwr = new VintageWriteRequest();
		
		vwr.setTitle(request.getParameter("title"));
		vwr.setContents(request.getParameter("contents"));
		vwr.setMemberId(SessionUtil.getSessionMember(request).getMemberId());
		vbs.post(vwr);
		response.sendRedirect(request.getContextPath() + VINTAGE_BOARD_LIST);
	}
	
}
