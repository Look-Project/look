//package board.formal.controller;
//
//import java.io.IOException;
//import java.sql.Date;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import board.fromal.service.Formal_BoardService;
//
//@WebServlet(urlPatterns = "/formal/boardlist")
//public class FORMAL_BoardListController extends HttpServlet{
//
//	private final String FORMAL_BOARD_LIST = "/views/board/formal/formal_list.jsp";
//	FORMAL_BoardService vbs = new FORMAL_BoardService();
//	
//	@Override
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setAttribute("boardlist", vbs.getAllBoard());
//		request.getRequestDispatcher(FORMAL_BOARD_LIST).forward(request, response);
//	
//	}
//
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		
//	}
//	
//}
