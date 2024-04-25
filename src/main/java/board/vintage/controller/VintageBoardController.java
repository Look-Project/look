package board.vintage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.vintage.service.VintageBoardService;
import comment.vintage.service.VintageCommentService;
import common.SessionUtil;

@WebServlet(urlPatterns = "/vintage/detail")
public class VintageBoardController extends HttpServlet{

	private final String VINTAGE_BOARD = "/views/board/vintage/vintageboard.jsp";
	VintageBoardService vbs = new VintageBoardService();
	VintageCommentService vcs = new VintageCommentService();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int boardId = Integer.parseInt(request.getParameter("boardId").trim());
		//SessionUtil.getSessionMember(request).getMemberId();
		request.setAttribute("boarddetail", vbs.getDetailBoard(boardId));
		request.setAttribute("commentslist", vcs.getAllComments(boardId));
		request.getRequestDispatcher(VINTAGE_BOARD).forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


}
