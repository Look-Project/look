package board.vintage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.vintage.service.VintageBoardService;
import common.SessionUtil;
import member.dto.response.MemberResponse;

@MultipartConfig
@WebServlet("/controller/delete")
public class VBoardDeleteController extends HttpServlet {
	
	private final String VINTAGE_BOARD_LIST = "/vintage/boardlist";
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MemberResponse loginMember = SessionUtil.getSessionMember(request);// session for user info
		VintageBoardService vbs = new VintageBoardService();
		
		int boardId = boardId =Integer.parseInt(request.getParameter("boardId"));
		vbs.setDeleteBoard(boardId);
		System.out.println("컨트롤러 boardId = " + boardId);
		
		response.sendRedirect(request.getContextPath() + VINTAGE_BOARD_LIST);
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
	

}
