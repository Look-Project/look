package board.vintage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.vintage.service.VintageBoardService;

@WebServlet(urlPatterns = "/vintage/detail")
public class VintageBoardController extends HttpServlet{

	private final String VINTAGE_BOARD = "/views/board/vintage/vintageboard.jsp";
	VintageBoardService vbs = new VintageBoardService();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int boardId = Integer.parseInt(request.getParameter("boardId").trim());
		request.setAttribute("boarddetail", vbs.getDetailBoard(boardId));
		request.getRequestDispatcher(VINTAGE_BOARD).forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


}
