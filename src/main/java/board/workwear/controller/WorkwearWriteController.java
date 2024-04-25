package board.workwear.controller;

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

import board.workwear.dto.request.WorkwearWriteRequest;
import board.workwear.service.WorkwearService;
import common.FileUploadUtil;
import common.SessionUtil;


@MultipartConfig
@WebServlet(urlPatterns = "/workwear/write")
public class WorkwearWriteController extends HttpServlet {
	private final String WORKWEAR_BOARD_WRITE = "/views/board/workwear/workwearWrite.jsp";
	private final String LOGIN = "/views/member/login.jsp";
	private final String WORKWEAR_BOARD_LIST = "/workwear/boardlist";
	private final String IMAGE_UPLOAD_PATH = "/Users/sukchoi/git/image/workwear/";
	WorkwearService wbs = new WorkwearService();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(SessionUtil.getSessionMember(request) != null) {
		request.getRequestDispatcher(WORKWEAR_BOARD_WRITE).forward(request, response);
		}else {
			request.getRequestDispatcher(LOGIN).forward(request, response);
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		WorkwearWriteRequest wwr = new WorkwearWriteRequest();
		String contentType = request.getContentType();
		
		Map<String, String> requestValues = new HashMap<String, String>();
		
		if(contentType != null && contentType.toLowerCase().startsWith("multipart/")){
			Collection<Part> parts = request.getParts();
			
			for(Part part : parts) {
				
				if(part.getHeader("Content-Disposition").contains("filename=")) {
					String todayDate = FileUploadUtil.getTodayDateString();
					
					String uploadPath = IMAGE_UPLOAD_PATH + todayDate;
					
					FileUploadUtil.createUploadDirectory(uploadPath);
					
					if(part.getSubmittedFileName() == null || part.getSubmittedFileName().isBlank()) {
						response.sendRedirect(request.getContextPath() + WORKWEAR_BOARD_WRITE);
					}
					
					String newFileName = FileUploadUtil.generateUniqueFileName(part.getSubmittedFileName());
					
					if(part.getSize() > 0) {
						part.write(uploadPath + "/" + newFileName);
						part.delete();
						wwr.setImgSrc(uploadPath);
						wwr.setImgName(newFileName);
						
					}
					
				}else {
					String formValue = request.getParameter(part.getName());
					requestValues.put(part.getName(), formValue);
				}

			}
		}
		wwr.setTitle(requestValues.get("title"));
		wwr.setContents(requestValues.get("contents"));
		wwr.setMemberId(SessionUtil.getSessionMember(request).getMemberId());
		
		wbs.post(wwr);
		response.sendRedirect(request.getContextPath() + WORKWEAR_BOARD_LIST);
	}
	
}