package member.controller.admin;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.SessionUtil;
import member.dto.response.AdminMemberResponse;
import member.dto.response.MemberResponse;
import member.service.AdminService;

@WebServlet(urlPatterns = "/mypage/admin-member")
public class AdminMemberController extends HttpServlet {
	
	private final String ADMIN_MEMBER_VIEW_NAME = "/views/member/adminpage/Member_manage.jsp";
	private final AdminService adminService = new AdminService();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberResponse loginMember = SessionUtil.getSessionMember(request);
		
		if(loginMember.getAdminYn().equals("N")) {
			response.sendError(response.SC_UNAUTHORIZED, "관리자만 접근이 가능합니다.");
			return;
		}
		
		request.setCharacterEncoding("UTF-8");
		
		Map<String, Object> map = new HashMap<String, Object>();
		String searchWord = request.getParameter("searchWord");
		if(searchWord != null) {
			//쿼리스트림으로 전달 받은 매개변수 중 검색어가 있다면 맵에 저장
			map.put("searchField", "nickname");
			map.put("searchWord", searchWord);
		}
		
		int totalCount = adminService.selectMemberCount(map);
		
		/*페이지 처리 start*/
		//getServletContext() 메서드는 현재 서블릿 객체를 통해 ServletContext 객체를 가져온다.
		//이후 application 변수에 저장하여 이후 활용할 수 있도록 한다.
		ServletContext application =getServletContext();
		//페이징 설정값 상수를 가져와 페이지당 게시물수와 블록당 페이지 수를 구한다.
		int pageSize=Integer.parseInt(application.getInitParameter("POSTS_PER_PAGE"));
		int blockPage=Integer.parseInt(application.getInitParameter("PAGES_PER_BLOCK"));
		
		//현재 페이지 확인
		int pageNum=1;//기본값
		String pageTemp=request.getParameter("pageNum");
		if(pageTemp!=null&&!pageTemp.equals("")) {
			//요청받은 페이지수로 수정
			pageNum=Integer.parseInt(pageTemp);
		}
		
		//목록에 출력할 게시물 범위 계산해 매개변수 컬렉션(map)에 추가
		//첫 게시물 번호
		int start = (pageNum-1)*pageSize+1;
		//마지막 게시물 번호
		int end=pageNum*pageSize;
		map.put("start", start);
		map.put("end", end);
		/*페이지 처리 end*/
		
		//게시물 목록 받기
		List<AdminMemberResponse> memberList = adminService.selectListPage(map);
		
		//뷰에 전달할 매개변수 추가
		String pagingImg= null;
		
		if(searchWord != null && !searchWord.isBlank()) {
			pagingImg = adminService.pagingStr(totalCount, pageSize, blockPage, pageNum, request.getContextPath() + "/mypage/admin-member", searchWord);
		}else {
			pagingImg = adminService.pagingStr(totalCount, pageSize, blockPage, pageNum, request.getContextPath() + "/mypage/admin-member");
		}
		
		//바로가기 영역 HTML 문자열
		map.put("pagingImg", pagingImg);
		map.put("totalCount", totalCount);
		map.put("pageSize", pageSize);
		map.put("pageNum", pageNum);
		
		request.setAttribute("memberList", memberList);
		request.setAttribute("map", map);
		request.getRequestDispatcher(ADMIN_MEMBER_VIEW_NAME).forward(request, response);
	}
	
}
