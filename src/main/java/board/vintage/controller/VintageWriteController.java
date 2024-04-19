package board.vintage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.vintage.dto.request.VintageWriteRequest;
import board.vintage.service.VintageBoardService;

@WebServlet(urlPatterns = "/vintage/write")
public class VintageWriteController extends HttpServlet {
	
	VintageBoardService vbs = new VintageBoardService();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		VintageWriteRequest vwr = new VintageWriteRequest();
		
		vwr.setTitle(request.getParameter("title"));;
		vwr.setContents(request.getParameter("contents"));
		
		vbs.post(vwr);
	}
	
}