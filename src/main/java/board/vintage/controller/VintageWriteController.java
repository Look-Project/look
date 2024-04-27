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

import board.vintage.dto.request.VintageWriteRequest;
import board.vintage.service.VintageBoardService;
import common.FileUploadUtil;
import common.SessionUtil;

@MultipartConfig
@WebServlet(urlPatterns = "/vintage/write")
public class VintageWriteController extends HttpServlet {
	private final String VINTAGE_BOARD_WRITE = "/views/board/vintage/vintagewriteform.jsp";
	private final String LOGIN = "/views/member/login.jsp";
	private final String VINTAGE_BOARD_LIST = "/vintage/boardlist";
	private final String IMAGE_UPLOAD_PATH = "\\Users\\pi\\Look\\imgs\\vintage\\";
	VintageBoardService vbs = new VintageBoardService();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(SessionUtil.getSessionMember(request) != null) {
		request.getRequestDispatcher(VINTAGE_BOARD_WRITE).forward(request, response);
		}else {
			request.getRequestDispatcher(LOGIN).forward(request, response);
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		VintageWriteRequest vwr = new VintageWriteRequest();
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
						response.sendRedirect(request.getContextPath() + VINTAGE_BOARD_WRITE);
						return;
					}
					
					String newFileName = FileUploadUtil.generateUniqueFileName(part.getSubmittedFileName());
					
					if(part.getSize() > 0) {
						part.write("C:" + uploadPath + "\\" + newFileName);
						part.delete();
						vwr.setImgSrc(uploadPath);
						vwr.setImgName(newFileName);
						
					}
					
				}else {
					String formValue = request.getParameter(part.getName());
					requestValues.put(part.getName(), formValue);
				}

			}
		}
		vwr.setTitle(requestValues.get("title"));
		vwr.setContents(requestValues.get("contents"));
		vwr.setMemberId(SessionUtil.getSessionMember(request).getMemberId());
		
		vbs.post(vwr);
		response.sendRedirect(request.getContextPath() + VINTAGE_BOARD_LIST);
	}
	
}
