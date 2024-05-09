package board.street.controller;

import java.io.IOException;

import java.sql.Date;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import board.street.dto.request.StreetWriteRequest;
import board.street.service.StreetBoardService;
import board.vintage.dto.request.VintageWriteRequest;
import common.FileUploadUtil;
import common.SessionUtil;

@SuppressWarnings("serial")
@MultipartConfig
@WebServlet(urlPatterns = "/street/write")
public class StreetWriteController extends HttpServlet{

	private final String STREET_BOARD_WRTIE = "/views/board/street/street_write.jsp";
	private final String LOGIN = "/views.member/login.jsp";
	private final String STREET_BOARD_LIST = "/street/write";
//	private final String IMAGE_UPLOAD_PATH = "/image/board/street";
	private final String IMAGE_UPLOAD_PATH = "\\look-images\\street\\";
	StreetBoardService sbs = new StreetBoardService();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(SessionUtil.getSessionMember(request) != null) {
		request.getRequestDispatcher(STREET_BOARD_WRTIE).forward(request, response);
		}else {
			request.getRequestDispatcher(LOGIN).forward(request, response);
		}
		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		StreetWriteRequest swr = new StreetWriteRequest();
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
						response.sendRedirect(request.getContextPath() + STREET_BOARD_WRTIE);
					}
					
					String newFileName = FileUploadUtil.generateUniqueFileName(part.getSubmittedFileName());
					
					if(part.getSize() > 0) {
						part.write("C:" + uploadPath + "\\" + newFileName);
						part.delete();
						swr.setImgSrc(uploadPath);
						swr.setImgName(newFileName);
						
					}
					
				}else {
					String formValue = request.getParameter(part.getName());
					requestValues.put(part.getName(), formValue);
				}

			}
		}
		swr.setTitle(requestValues.get("title"));
		swr.setContents(requestValues.get("contents"));
		swr.setMemberId(SessionUtil.getSessionMember(request).getMemberId());
		
		sbs.post(swr);
		response.sendRedirect(request.getContextPath() + STREET_BOARD_LIST);
	}
	
}

	