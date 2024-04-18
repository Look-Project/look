package board.freecycling.controller;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.freecycling.dto.request.FreecyclingBoardDTO;




@WebServlet("/controller/freecyclingListCon")
public class freecyclingListCon extends HttpServlet {
	
	private final String FREECYCLING_LIST_VIEW_NAME = "/views/board/freecycling/freecyclingMain.jsp";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}
	
	protected void reqPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dis = request.getRequestDispatcher(FREECYCLING_LIST_VIEW_NAME);
		dis.forward(request, response);
	
	}
}


