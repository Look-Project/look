package board.workwear.controller;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.workwear.service.WorkwearService;

@WebServlet(urlPatterns = "/workwear/boardlist")
public class WorkwearController extends HttpServlet {

    private final String WORKWEAR_BOARD_LIST = "/views/board/workwear/workwear.jsp";
    WorkwearService wbs = new WorkwearService();
    
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("boardlist", wbs.getAllBoard());
		request.getRequestDispatcher(WORKWEAR_BOARD_LIST).forward(request, response);
	
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

}
