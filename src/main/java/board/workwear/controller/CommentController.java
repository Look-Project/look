package board.workwear.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.vintage.service.VintageBoardService;
import board.workwear.dto.request.CommentRequest;
import board.workwear.service.CommentService;
import board.workwear.service.WorkwearService;
import comment.vintage.dto.request.VintageCommentRequest;
import comment.vintage.service.VintageCommentService;
import common.SessionUtil;

@WebServlet(urlPatterns = "/workwear/comment")
public class CommentController extends HttpServlet{

	private final String LOGIN = "/views/member/login.jsp";
	private final String WORKWEAR_BOARD = "/workwear/detail";
	
	CommentService cs = new CommentService();
	WorkwearService ws = new WorkwearService();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CommentRequest cr = new CommentRequest();
		int boardId = Integer.parseInt(request.getParameter("boardId").trim());
		
		if(SessionUtil.getSessionMember(request) != null) {
			cr.setBoardId(boardId);
			cr.setMemberId(SessionUtil.getSessionMember(request).getMemberId());
			cr.setComment(request.getParameter("comment"));
			cs.addComment(cr);
			request.setAttribute("boardlist", ws.getAllBoard());
			response.sendRedirect(request.getContextPath() + WORKWEAR_BOARD + "?boardId=" + boardId);
		}else {
			request.getRequestDispatcher(LOGIN).forward(request, response);	
		}
	}
	
}
