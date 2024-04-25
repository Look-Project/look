package board.freecycling.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.freecycling.dto.response.FreeOneContentDTO;
import board.freecycling.dto.response.FreeMainListDTO;
import board.freecycling.service.FreecyclingBoardService;
import common.SessionUtil;
import member.dto.response.MemberResponse;


@WebServlet("/controller/FreecyclingOneContentCon")
public class FreeOneContentCon extends HttpServlet {
	public final String FREECYCLING_ONECONTENTS_VIEW_NAME = "/views/board/freecycling/freecyclingOneContents.jsp";
       
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 MemberResponse loginMember = SessionUtil.getSessionMember(request);
		 System.out.println(request.getParameter("num"));
		 int num=Integer.parseInt(request.getParameter("num"));//상세조회하는 글번호
		 
		//서비스 메소드로 bdao 리턴 받아주기
		 FreecyclingBoardService bservice = new FreecyclingBoardService();
		 
			FreeOneContentDTO viewdto = bservice.freeOneContentService(num);
			request.setAttribute("viewdto",viewdto);
		
		
		//글쓴이와 동일한 회원인지 검증 후 수정, 삭제하기 버튼 보여줌	
		 
		
			 if(loginMember != null) {
				 if(loginMember.getMemberId()==viewdto.getUserId()) {
					request.setAttribute("authMember",true);
				 }else {
					 request.setAttribute("authMember",false); 
				 }
			 }
		 
			//메인으로 보내주기
			RequestDispatcher dis = request.getRequestDispatcher(FREECYCLING_ONECONTENTS_VIEW_NAME);
			dis.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
