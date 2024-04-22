package board.freecycling.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.freecycling.dto.response.FreecyclingBoardListViewDTO;
import board.freecycling.service.FreecyclingBoardService;




@WebServlet("/controller/freecyclingListCon")
public class freecyclingListCon extends HttpServlet {
	
	private final String FREECYCLING_LIST_VIEW_NAME = "/views/board/freecycling/freecyclingMain.jsp";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1.파라미터받기
		//2.비즈니스로직처리<->service->dao<->database
		
		
		//서비스 메소드로 bdao 리턴 받아주기
		FreecyclingBoardService bservice = new FreecyclingBoardService();
		List<FreecyclingBoardListViewDTO> listdto = bservice.freecyclingListViewService();
		
		//3.model
		request.setAttribute("listdto", listdto);
		
		
		//메인으로 보내주기
		RequestDispatcher dis = request.getRequestDispatcher(FREECYCLING_LIST_VIEW_NAME);
		dis.forward(request, response);
			
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}


