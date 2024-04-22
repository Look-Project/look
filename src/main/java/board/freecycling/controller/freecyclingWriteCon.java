package board.freecycling.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.freecycling.dto.request.FreecyclingBoardDTO;
import board.freecycling.service.FreecyclingBoardService;
import common.SessionUtil;
import member.dto.response.MemberResponse;


@WebServlet("/controller/freecyclingWriteCon")
public class freecyclingWriteCon extends HttpServlet {

	public final String FREECYCLING_WRITE_VIEW_NAME = "/views/board/freecycling/freecyclingWriteForm.jsp";
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	    MemberResponse loginMember = SessionUtil.getSessionMember(request);
	    
	    if (loginMember == null) {
	        // 로그인 되지 않은 경우 처리
	    	
	        response.sendRedirect(request.getContextPath()+"/member/login");
	    } else {
	        // 로그인 된 경우에는 글쓰기 폼으로 포워딩
	        RequestDispatcher dis = request.getRequestDispatcher("/views/board/freecycling/freecyclingWriteForm.jsp");
	        dis.forward(request, response);
	    }
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// 한글 인코딩
		    request.setCharacterEncoding("utf-8");
		    
		    // 제목, 내용 데이터 받기
		    FreecyclingBoardDTO bdto = new FreecyclingBoardDTO();
			bdto.setContents(request.getParameter("contents"));
			bdto.setTitle(request.getParameter("title"));
			
			//서비스 메소드로 보내기
			FreecyclingBoardService bservice = new FreecyclingBoardService();
			bservice.freecyclingInsertService(bdto);
			
			//메인으로 보내주기
			RequestDispatcher dis = request.getRequestDispatcher("/controller/freecyclingListCon");
		    dis.forward(request, response);
		 	
	}
	

}
