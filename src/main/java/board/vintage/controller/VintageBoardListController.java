package board.vintage.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.vintage.service.VintageBoardService;

@WebServlet(urlPatterns = "/vintage/boardlist")
public class VintageBoardListController extends HttpServlet{

	private final String VINTAGE_BOARD_LIST = "/views/board/vintage/vintageboardlist.jsp";
	VintageBoardService vbs = new VintageBoardService();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("boardlist", vbs.getAllBoard());
		request.getRequestDispatcher(VINTAGE_BOARD_LIST).forward(request, response);
	
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
}
