package board.street.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.street.dto.request.StreetCommentRequest;
import board.street.service.StreetBoardService;
import board.street.service.StreetCommentService;
import board.vintage.service.VintageBoardService;
import comment.vintage.dto.request.VintageCommentRequest;
import comment.vintage.service.VintageCommentService;
import common.SessionUtil;

@WebServlet(urlPatterns = "/street/comment")
public class StreetCommentController extends HttpServlet{

	private final String LOGIN = "/views/member/login.jsp";
	private final String STREET_BOARD = "/street/detail";
	
	StreetCommentService scs = new StreetCommentService();
	StreetBoardService sbs = new StreetBoardService();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StreetCommentRequest scr = new StreetCommentRequest();
		int boardId = Integer.parseInt(request.getParameter("boardId").trim());
		
		if(SessionUtil.getSessionMember(request) != null) {
			scr.setBoardId(boardId);
			scr.setMemberId(SessionUtil.getSessionMember(request).getMemberId());
			scr.setComment(request.getParameter("comment"));
			scs.addComment(scr);
			request.setAttribute("boardlist", sbs.getAllBoard());
			response.sendRedirect(request.getContextPath() + STREET_BOARD + "?boardId=" + boardId);
		}else {
			request.getRequestDispatcher(LOGIN).forward(request, response);	
		}
	}
	
}
