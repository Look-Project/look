package board.vintage.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.vintage.dto.response.VintageBoardResponse;
import board.vintage.service.VintageBoardService;
import comment.vintage.service.VintageCommentService;
import common.SessionUtil;
import member.dto.response.MemberResponse;

@WebServlet(urlPatterns = "/vintage/detail")
public class VintageBoardController extends HttpServlet{

	private final String VINTAGE_BOARD = "/views/board/vintage/vintageboard.jsp";
	
	VintageBoardService vbs = new VintageBoardService();
	VintageCommentService vcs = new VintageCommentService();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int boardId = Integer.parseInt(request.getParameter("boardId").trim()); //board_id 
		
		MemberResponse loginMember = SessionUtil.getSessionMember(request); //session for user info
		VintageBoardResponse vbr = vbs.getDetailBoard(boardId);
		
		request.setAttribute("boarddetail", vbr); //상세게시글
		
		request.setAttribute("commentslist", vcs.getAllComments(boardId)); //댓글 리스트
		
		//글쓴이와 동일한 회원인지 검증 후 수정, 삭제하기 버튼 보여줌	
		
		  if(loginMember != null) {
			  if(loginMember.getMemberId()== vbr.getMemberId()) {
				  request.setAttribute("authMember",true); 
			  }else {
				  request.setAttribute("authMember",false); 
			  } 
		  }
		 
	 
		//메인으로 보내주기
		request.getRequestDispatcher(VINTAGE_BOARD).forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


}
