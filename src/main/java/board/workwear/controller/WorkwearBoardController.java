package board.workwear.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.workwear.service.CommentService;
import board.workwear.service.WorkwearService;

@WebServlet(urlPatterns = "/workwear/detail")
public class WorkwearBoardController extends HttpServlet{

		private final String WORKWEAR_BOARD = "/views/board/workwear/workwearBoard.jsp";
		WorkwearService wbs = new WorkwearService();
		CommentService cbs = new CommentService();
		
		@Override
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			int boardId = Integer.parseInt(request.getParameter("boardId").trim());
			request.setAttribute("boarddetail", wbs.getDetailBoard(boardId));
			request.setAttribute("commentlist", cbs.getAllComments(boardId));
			request.getRequestDispatcher(WORKWEAR_BOARD).forward(request, response);
		}

		@Override
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		}


	}
