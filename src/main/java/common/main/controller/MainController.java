package common.main.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/main")
public class MainController extends HttpServlet {
	
	private final String MAIN_VIEW_NAME = "/views/common/Mainpage.jsp";

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher(MAIN_VIEW_NAME).forward(request, response);
	}
	
}
