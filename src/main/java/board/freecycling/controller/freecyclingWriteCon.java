package board.freecycling.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.freecycling.dto.request.FreecyclingBoardDTO;
import board.freecycling.service.FreecyclingBoardService;


@WebServlet("/controller/freecyclingWriteCon")
public class freecyclingWriteCon extends HttpServlet {

	private final String FREECYCLING_WRITE_VIEW_NAME = "/views/board/freecycling/freecyclingWriteForm.jsp";
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		RequestDispatcher dis = request.getRequestDispatcher("/views/board/freecycling/freecyclingWriteForm.jsp");
		dis.forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		FreecyclingBoardDTO bdto = new FreecyclingBoardDTO();

			bdto.setContents(request.getParameter("contents"));
			bdto.setTitle(request.getParameter("title"));
			
/*    		freecyclingBoardDAO bdao = new freecyclingBoardDAO();
    	    bdao.insertBoard(bdto);
*/			
			FreecyclingBoardService bservice = new FreecyclingBoardService();
			bservice.freecyclingServicerequest(bdto);
		
			RequestDispatcher dis = request.getRequestDispatcher("/views/board/freecycling/freecyclingMain.jsp");
		    dis.forward(request, response);
		 	
	}
	

}
