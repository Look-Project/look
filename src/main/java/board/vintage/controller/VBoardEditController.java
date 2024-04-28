package board.vintage.controller;

import java.io.IOException;
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

import board.vintage.dto.request.VintageEditRequest;
import board.vintage.service.VintageBoardService;
import common.FileUploadUtil;
import common.SessionUtil;
import member.dto.response.MemberResponse;

@MultipartConfig
@WebServlet("/controller/edit")
public class VBoardEditController extends HttpServlet {

	private final String LOGIN = "/views/member/login.jsp";
	private final String VINTAGE_BOARD = "/vintage/detail";
	
	private final String EDIT = "/views/board/vintage/editform.jsp";
	private final String IMAGE_UPLOAD_PATH = "\\Users\\pi\\Look\\imgs\\vintage\\";

	VintageBoardService vbs = new VintageBoardService();

	

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		//수정할 게시물의 번호를 받아서 
		int boardId = boardId =Integer.parseInt(request.getParameter("boardId"));
		//System.out.println("boardId="+boardId);
		 
		MemberResponse loginMember = SessionUtil.getSessionMember(request);// session for user info

		request.setAttribute("boarddetail", vbs.getDetailBoard(boardId));

		if (loginMember == null) {
			// 로그인 되지 않은 경우 처리
			request.getRequestDispatcher(LOGIN).forward(request, response);
		} else {
			// 로그인 된 경우에는 글쓰기 폼으로 포워딩
			request.getRequestDispatcher(EDIT).forward(request, response);
		}

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		VintageEditRequest dto = new VintageEditRequest();
		String contentType = request.getContentType();
		
		//수정할 게시물의 번호를 받아서 
		int boardId =Integer.parseInt(request.getParameter("boardId"));
		//System.out.println("edit boardId="+boardId);
		
		Map<String, String> requestValues = new HashMap<String, String>();

		if (contentType != null && contentType.toLowerCase().startsWith("multipart/")) {

			// getParts()를 통해 Body에 넘어온 데이터들을 각각의 Part로 쪼개어 리턴
			Collection<Part> parts = request.getParts();

			for (Part part : parts) {

				if(part.getHeader("Content-Disposition").contains("filename=")) {
					String todayDate = FileUploadUtil.getTodayDateString();
					
					String uploadPath = IMAGE_UPLOAD_PATH + todayDate;
					
					FileUploadUtil.createUploadDirectory(uploadPath);
				
				if (part.getSubmittedFileName() != null && !part.getSubmittedFileName().isBlank()) {
					
					String newFileName = FileUploadUtil.generateUniqueFileName(part.getSubmittedFileName()); 
					
					if (part.getSize() > 0) { 
						part.write("C:" + uploadPath + "\\" + newFileName);
						part.delete();
						dto.setImgSrc(uploadPath); 
						dto.setImgName(newFileName);
						}
					}
				
				} else {

					String formValue = request.getParameter(part.getName());
					requestValues.put(part.getName(), formValue);
					
				}

			}
		}

		// 수정 내용을 매개변수에서 얻어옴
		MemberResponse loginMember = SessionUtil.getSessionMember(request);// session for user info
		
		dto.setBoardId(boardId);
		dto.setTitle(requestValues.get("title"));
		dto.setContents(requestValues.get("contents"));
		
		vbs.setEditBoard(dto);
		response.sendRedirect(request.getContextPath() + VINTAGE_BOARD + "?boardId=" + boardId);

	}

}
