package board.freecycling.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.freecycling.service.FreecyclingBoardService;
import common.SessionUtil;
import member.dto.response.MemberResponse;


@WebServlet("/controller/FreeDeleteCon")
public class FreeDeleteCon extends HttpServlet {
	
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//삭제할 게시물의 번호를 받아서
    	int num = Integer.parseInt(request.getParameter("num"));
    	System.out.println("num="+num);
    	MemberResponse loginMember = SessionUtil.getSessionMember(request);
    	
    	FreecyclingBoardService delService = new FreecyclingBoardService();
		
    	try {
			delService.freeDelService(num);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//수정이 완료 되었다면 전체 게시글 보기로 이동 
		request.setAttribute("msg","삭제가 완료 되었습니다");
		RequestDispatcher dis = request.getRequestDispatcher("/controller/freecyclingListCon");
		dis.forward(request ,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
