package board.freecycling.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.freecycling.dto.request.FreecyclingUpdaterequestDTO;
import board.freecycling.service.FreecyclingBoardService;
import common.SessionUtil;
import member.dto.response.MemberResponse;

@WebServlet("/controller/FreecyclingUpdaterequestCon")
public class FreecyclingUpdaterequestCon extends HttpServlet {
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("euc-kr");
		
		MemberResponse loginMember = SessionUtil.getSessionMember(request);
		int num = Integer.parseInt(request.getParameter("num"));
		System.out.println(request.getParameter("num"));
		FreecyclingBoardService bupservice = new FreecyclingBoardService();
		 try {
			 FreecyclingUpdaterequestDTO boardupdto = bupservice.freecyclingUpdaterequestService(num);
			request.setAttribute("boardupdto",boardupdto);
		} catch (SQLException e) {
			e.printStackTrace();
		}			  
		
		RequestDispatcher dis = request.getRequestDispatcher("/views/board/freecycling/freecyclingUpdateContents.jsp");
		dis.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
