package board.freecycling.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.freecycling.dao.freecyclingBoardDAO;
import board.freecycling.dto.request.FreecyclingUpdateDTO;
import board.freecycling.service.FreecyclingBoardService;
import common.SessionUtil;
import member.dto.response.MemberResponse;




@WebServlet("/controller/FreecyclingUpdateresponseCon")
public class FreecyclingUpdateresponseCon extends HttpServlet {
       //게시글 수정하여 reponse해주는 controller
	public final String FREECYCLING_UPDATE_VIEW = "/views/board/freecycling/freecyclingMain.jsp";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	/*
	 * request.setCharacterEncoding("utf-8");
	 * 
	 * //폼에서 넘어온 데이터를 받아옴 int num = Integer.parseInt(request.getParameter("num"));
	 * System.out.println(request.getParameter("num"));
	 * 
	 * MemberResponse loginMember = SessionUtil.getSessionMember(request);
	 * FreecyclingUpdaterequestDTO boardupdto = new FreecyclingUpdaterequestDTO();
	 * 
	 * //String title = request.getParameter("title"); //String contents =
	 * request.getParameter("contents"); //String imgSrc =
	 * request.getParameter("imgSrc"); //String imgName =
	 * request.getParameter("imgName"); if (loginMember == null) { // 로그인 되지 않은 경우
	 * 처리 request.setAttribute("msg", "로그인이 필요한 서비스입니다.");
	 * response.sendRedirect(request.getContextPath()+"/member/login"); } else { //
	 * 제목, 내용 데이터 받기 boardupdto.setTitle(request.getParameter("title"));
	 * boardupdto.setContents(request.getParameter("contents"));
	 * 
	 * //서비스 메소드로 보내기 FreecyclingBoardService bupresservice = new
	 * FreecyclingBoardService();
	 * bupresservice.freecyclingUpdateresponseService(num, boardupdto);
	 * //boardupdto.setImgSrc(request.getParameter("imgSrc"));
	 * //boardupdto.setImgName(request.getParameter("imgName"));
	 * 
	 * System.out.println("test : " + boardupdto.getTitle()); //수정이 완료되었다면 전체 게시글보기로
	 * 이동 request.setAttribute("msg", "수정이 완료되었습니다."); RequestDispatcher dis =
	 * request.getRequestDispatcher("/controller/freecyclingListCon");
	 * dis.forward(request, response); } }
	 *
	 */	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		 MemberResponse loginMember = SessionUtil.getSessionMember(request);
		 FreecyclingUpdateDTO boardupdto = new FreecyclingUpdateDTO();
		 
         request.setCharacterEncoding("utf-8");
		
		//폼에서 넘어온 데이터를 받아옴
		//int num = Integer.parseInt(request.getParameter("num"));
		//System.out.println(request.getParameter("num"));
         boardupdto.setTitle(request.getParameter("title"));
         boardupdto.setContents(request.getParameter("contents"));
		
		//String title = request.getParameter("title");
		//String contents = request.getParameter("contents");
		System.out.println("test : " + boardupdto.getTitle()); //수정이 완료되었다면 전체 게시글보기로
		FreecyclingBoardService bservice = new FreecyclingBoardService();
		//boardupdto = bservice.freecyclingUpdateresponseService(num, boardupdto);   
		
			request.setAttribute("boardupdto",boardupdto);
			//수정이 완료되었다면 전체 게시글보기로 이동
			//request.setAttribute("msg", "수정이 완료되었습니다.");
			RequestDispatcher dis = request.getRequestDispatcher("/controller/freecyclingListCon");
			dis.forward(request, response);
			
		
	}
}
