package comment.vintage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comment.vintage.service.VintageCommentService;
import common.SessionUtil;
import member.dto.response.MemberResponse;

@WebServlet(urlPatterns = "/vintage/comment/delete")
public class VCommentDeleteController extends HttpServlet {
	
	private final String VINTAGE_BOARD = "/vintage/detail";

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MemberResponse loginMember = SessionUtil.getSessionMember(request);// session for user info
		VintageCommentService vcs = new VintageCommentService();
		
		int commentId =Integer.parseInt(request.getParameter("commentId"));
		int boardId =Integer.parseInt(request.getParameter("boardId"));
		vcs.setDeleteComment(commentId);
		
		response.sendRedirect(request.getContextPath() + VINTAGE_BOARD + "?boardId=" + boardId);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
}
