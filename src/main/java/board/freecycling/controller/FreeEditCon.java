package board.freecycling.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import board.freecycling.dao.freecyclingBoardDAO;
import board.freecycling.dto.request.FreeEditDTO;
import board.freecycling.dto.request.FreeInsertDTO;
import board.freecycling.dto.response.FreeOneContentDTO;
import board.freecycling.service.FreecyclingBoardService;
import common.FileUploadUtil;
import common.SessionUtil;
import member.dto.response.MemberResponse;

@MultipartConfig
@WebServlet("/controller/FreeEditCon")
public class FreeEditCon extends HttpServlet {
	
	private final String LOGIN = "/views/member/login.jsp";
	public final String FREE_EDIT_VIEW = "/views/board/freecycling/Update.jsp";
//	private final String FREECYCLING_UPLOAD_PATH = "\\webStudy\\lookIMG\\";
	private final String FREECYCLING_UPLOAD_PATH = "\\look-images\\freecycling\\";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//수정할 게시물의 번호를 받아서
    	int num = Integer.parseInt(request.getParameter("num"));
    	System.out.println("num="+num);
    	MemberResponse loginMember = SessionUtil.getSessionMember(request);
    	//기존 게시물 내용을 담은 DTO 객체 저장한 다음 Edit.jsp로 포워드
        freecyclingBoardDAO bdao = new freecyclingBoardDAO();
        FreeOneContentDTO onecondto = null;
       
		onecondto = bdao.getoneBoard(num);
		request.setAttribute("onecondto", onecondto);
		
		if (loginMember == null) {
			// 로그인 되지 않은 경우 처리
			request.getRequestDispatcher(LOGIN).forward(request, response);
		} else {
			// 로그인 된 경우에는 글쓰기 폼으로 포워딩
			request.getRequestDispatcher(FREE_EDIT_VIEW).forward(request, response);
		}
    }
  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	String contentType = request.getContentType();
		FreeEditDTO dto = new FreeEditDTO();
		Map<String,String> insmap= new HashMap<String,String>();
		
		if(contentType != null && contentType.toLowerCase().startsWith("multipart/")) {
			
			// getParts()를 통해 Body에 넘어온 데이터들을 각각의  Part로 쪼개어 리턴
			Collection<Part> parts = request.getParts();
			
			for(Part part : parts) {
				//System.out.println();
				//System.out.printf("파라미터 명 : %s, contentType :  %s,  size : %d bytes \n", part.getName(), part.getContentType(), part.getSize());
				/**
				 * input 태그의 type속성이 file일 경우 if문을 실행
				 * 그 외의 type일 경우 else문을 실행
				 */
			
				if(part.getHeader("Content-Disposition").contains("filename=")) {
					String todayDate = FileUploadUtil.getTodayDateString();
					
					String uploadPath = FREECYCLING_UPLOAD_PATH + todayDate;
					//System.out.println("저장하고자 하는 파일의 경로 => " + uploadPath);
					
					FileUploadUtil.createUploadDirectory(uploadPath);
					//System.out.println("사용자가 전달한 파일명 => " + part.getSubmittedFileName());
					
					if(part.getSubmittedFileName() == null || part.getSubmittedFileName().isBlank()) {
		                  response.sendRedirect(request.getContextPath() + FREE_EDIT_VIEW);
		                  return;
		               }
					
		            String newFileName = FileUploadUtil.generateUniqueFileName(part.getSubmittedFileName());
					//System.out.printf("업로드 파일 명 : %s \n", newFileName);
					//System.out.println("최종적으로 저장되는 파일의 경로 + 파일명 => " + uploadPath + "\\" + newFileName);
					
					if(part.getSize() > 0) {
						part.write("C:"+uploadPath + "\\" + newFileName);
						part.delete();
						dto.setImgSrc(uploadPath);
						dto.setImgName(newFileName);
						
					}
				}else {
					//게시글의 제목 및 내용과 같은 input태그의 경우 실행되는 로직으로, 해당 데이터들을 저장하고자 한다면 여기에 작성하면 됩니다.
					
					String formValue = request.getParameter(part.getName());
					insmap.put(part.getName(), formValue);
					//System.out.printf("name : %s, value : %s  \n", part.getName(), formValue); //콘솔확인용
				}//else end

			}//for end
		}//if end
    	
        // 수정 내용을 매개변수에서 얻어옴
    	MemberResponse loginMember = SessionUtil.getSessionMember(request);
    	//int memberId = request.getParameter("memberId") ;
    	FreecyclingBoardService freeservice = new FreecyclingBoardService();

        String title = request.getParameter("title");
        System.out.println("title="+title);
        
        int boardId = Integer.parseInt(request.getParameter("boardId"));
        String contents = request.getParameter("contents");
    	
        // DTO에 저장
    	dto.setBoardId(boardId);
    	dto.setTitle(title);
    	dto.setContents(contents);

        // DB에 수정 내용 반영
        freeservice.freeEditService(dto);
		response.sendRedirect(request.getContextPath() + "/controller/freecyclingListCon");
    }
}
