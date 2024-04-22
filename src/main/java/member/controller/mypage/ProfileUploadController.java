package member.controller.mypage;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import common.FileUploadUtil;
import common.SessionUtil;
import member.dto.response.MemberResponse;
import member.service.MyPageService;

@MultipartConfig
@WebServlet(urlPatterns = "/mypage/profile-upload")
public class ProfileUploadController extends HttpServlet {
	
	private final String PROFILE_UPLOAD_PATH = "\\look-images\\profile\\";
	private final MyPageService myPageService = new MyPageService();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String contentType = request.getContentType();
		MemberResponse loginMember = SessionUtil.getSessionMember(request);

		if(contentType != null && contentType.toLowerCase().startsWith("multipart/")) {

			Collection<Part> parts = request.getParts();
			
			for(Part part : parts) {
				if(part.getHeader("Content-Disposition").contains("filename=")) {
					String todayDate = FileUploadUtil.getTodayDateString();
					String uploadPath = PROFILE_UPLOAD_PATH + todayDate;
					
					FileUploadUtil.createUploadDirectory(uploadPath);
					
					if(part.getSubmittedFileName() == null || part.getSubmittedFileName().isBlank()) {
						response.sendRedirect(request.getContextPath() + "/mypage/profile");
						return;
					}
					
					System.out.println("hello!");
		            String newFileName = FileUploadUtil.generateUniqueFileName(part.getSubmittedFileName());
					
					if(part.getSize() > 0 && loginMember != null) {
						part.write("C:" + uploadPath + "\\" + newFileName);
						part.delete();
						loginMember.setProfileSrc(uploadPath);
						loginMember.setProfileName(newFileName);
						if(!myPageService.updateProfile(loginMember)) {
							response.sendError(response.SC_UNAUTHORIZED);
							return;
						}
					}
						
				}

			}//for end
		}//if end
		
		response.sendRedirect(request.getContextPath() + "/mypage/profile");

	}//doPost end

}
