package comment.vintage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.vintage.service.VintageBoardService;
import comment.vintage.dto.request.VintageCommentRequest;
import comment.vintage.service.VintageCommentService;
import common.SessionUtil;

@WebServlet(urlPatterns = "/vintage/comment/write")
public class VintageCommentController extends HttpServlet{

	private final String LOGIN = "/views/member/login.jsp";
	private final String VINTAGE_BOARD = "/vintage/detail";
	
	VintageCommentService vcs = new VintageCommentService();
	VintageBoardService vbs = new VintageBoardService();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		VintageCommentRequest vcr = new VintageCommentRequest();
		int boardId = Integer.parseInt(request.getParameter("boardId").trim());
		
		
		if(SessionUtil.getSessionMember(request) != null) {
			vcr.setBoardId(boardId);
			vcr.setMemberId(SessionUtil.getSessionMember(request).getMemberId());
			vcr.setComment(request.getParameter("comment"));
			vcs.addComment(vcr);
			request.setAttribute("boardlist", vbs.getAllBoard());
			response.sendRedirect(request.getContextPath() + VINTAGE_BOARD + "?boardId=" + boardId);
		}else {
			request.getRequestDispatcher(LOGIN).forward(request, response);	
		}
	}
	
}
