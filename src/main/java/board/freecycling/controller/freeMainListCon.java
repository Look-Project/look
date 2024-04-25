package board.freecycling.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.freecycling.dto.response.FreeMainListDTO;
import board.freecycling.service.FreecyclingBoardService;




@WebServlet("/controller/freecyclingListCon")
public class freeMainListCon extends HttpServlet {
	
	private final String FREECYCLING_LIST_VIEW_NAME = "/views/board/freecycling/freecyclingMain.jsp";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.파라미터받기
		//2.비즈니스로직처리<->service->dao<->database
		//서비스 메소드로 bdao 리턴 받아주기
		FreecyclingBoardService bservice = new FreecyclingBoardService();
		List<FreeMainListDTO> listdto = bservice.freeMainListService();
		//3.model
		request.setAttribute("listdto", listdto);
		
		//메인으로 보내주기
		RequestDispatcher dis = request.getRequestDispatcher(FREECYCLING_LIST_VIEW_NAME);
		dis.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
		/*
		 * //화면에 보여질 게시글의 개수를 지정 int pageSize=8; //현재 보여지고 있는 페이지의 넘버값을 읽어드림 String
		 * pageNum=request.getParameter("pageNum"); //null처리 if(pageNum==null) {
		 * pageNum="1"; } //전체 게시글의 개수 int count=0; //jsp페이지 내에서 보여질 넘버링 숫자값을 저장하는 변수
		 * int number=0;
		 * 
		 * //현재 보여지고 있는 페이지 문자를 수자로 형변환 int currentPage = Integer.parseInt(pageNum);
		 * //전체 게시글의 개수를 가져와야 하기에 데이터 베이스 객체 생성 FreecyclingBoardService bservice = new
		 * FreecyclingBoardService(); count = bservice.boardPage();
		 * 
		 * //현재 보여질 페이지 시작 번호 설정 int startRow = (currentPage-1)*pageSize+1; int endRow =
		 * currentPage*pageSize;
		 * 
		 * //최신글 10개를 기준으로 게시글을 리턴 받아주는 메서드 호출 List<FreeMainListDTO> ldto =
		 * bservice.getAllBoard(startRow,endRow); number =
		 * count-(currentPage-1)*pageSize;
		 * 
		 * //////////////////////수정 삭제시, 비밀번호가 틀렸다면 String msg =
		 * (String)request.getAttribute("msg");
		 * 
		 * ///////////////BoardList.jsp쪽으로 request객체에 담아서 넘겨줌 request.setAttribute("v",
		 * v); request.setAttribute("number", number); request.setAttribute("pageSize",
		 * pageSize); request.setAttribute("count", count);
		 * request.setAttribute("currentPage", currentPage); request.setAttribute("msg",
		 * msg);
		 * 
		 * RequestDispatcher dis = request.getRequestDispatcher("BoardList.jsp");
		 * dis.forward(request, response);
		 * 
		 * }
		 */
	}
}


