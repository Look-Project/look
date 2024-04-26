package board.street.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.street.service.StreetBoardService;
import board.street.service.StreetCommentService;
import board.vintage.service.VintageBoardService;
import comment.vintage.service.VintageCommentService;
import common.SessionUtil;

@WebServlet(urlPatterns = "/street/detail")
public class StreetBoardController extends HttpServlet{

	private final String STREET_BOARD = "/views/board/street/street.jsp";
	StreetBoardService sbs = new StreetBoardService();
	StreetCommentService scs = new StreetCommentService();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int boardId = Integer.parseInt(request.getParameter("boardId").trim());
		//SessionUtil.getSessionMember(request).getMemberId();
		request.setAttribute("boarddetail", sbs.getDetailBoard(boardId));
		request.setAttribute("commentslist", scs.getAllComments(boardId));
		request.getRequestDispatcher(STREET_BOARD).forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


}
