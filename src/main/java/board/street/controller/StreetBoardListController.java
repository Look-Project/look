package board.street.controller;

import java.io.IOException;

import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.street.service.StreetBoardService;

@WebServlet(urlPatterns = "/street/boardlist")
public class StreetBoardListController extends HttpServlet{

   private final String STREET_BOARD_LIST = "/views/street/board/streetboardlist.jsp";
   StreetBoardService sbs = new StreetBoardService();
   
   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   
	   // http://localhost:8081/project_1/street/boardlist
	   System.out.println("-------------------boardlist!!!!!!!!!!! 호출이되나요?? ");
	   
	   
      request.setAttribute("boardlist", sbs.getAllBoard());
      request.getRequestDispatcher(STREET_BOARD_LIST).forward(request, response);
   
   }

   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      // POST요청은 사용X
   }
   
}
