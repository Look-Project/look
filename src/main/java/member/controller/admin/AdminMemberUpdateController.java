package member.controller.admin;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import member.dao.AdminDAO;
import member.dto.request.AdminMemberUpdateRequest;
import member.service.AdminService;
import member.service.MemberService;

@WebServlet(urlPatterns = "/mypage/admin/member-update")
public class AdminMemberUpdateController extends HttpServlet {
	
	private final MemberService memberService = new MemberService();
	private final AdminService adminService = new AdminService();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		AdminMemberUpdateRequest updateMember = new AdminMemberUpdateRequest();
		updateMember.setUserId(Integer.parseInt(request.getParameter("userId")));
		updateMember.setAdminYn(request.getParameter("adminYn"));
		updateMember.setNickname(request.getParameter("nickname"));

		JSONObject jObj = new JSONObject();
		Map<String, String> errors = new HashMap<>();
		checkNickname(errors, updateMember.getNickname(), "nickname");
		
		if(!errors.isEmpty()) {
	        jObj.put("errors", errors);
		}else if(!memberService.duplicateNickname(updateMember.getNickname())) {
			//닉네임 중복이라면
			jObj.put("duplicatedNickname", true);
		}else if(adminService.updateMemberDetails(updateMember)){
			jObj.put("success", true);
		}else {
			jObj.put("success", false);
		}
		
        response.setContentType("application/x-json; charset=utf-8");
        response.getWriter().print(jObj);
	}
	
	private void checkNickname(Map<String, String> errors, String value, String fieldName) {
		checkSignupValue(errors, value, fieldName, "닉네임을 입력해 주세요.");
		
		if(!errors.containsKey(fieldName) && !Pattern.matches("^(?=.*[a-z0-9가-힣])[a-z0-9가-힣]{2,8}$", value)) {
			errors.put(fieldName, "2~8 글자 범위(영어, 숫자, 한글)로 입력해 주세요.");
		}
	}
	
	private void checkSignupValue(Map<String, String> errors, String value, String fieldName, String msg) {
		if(value == null || value.isEmpty()) {
			errors.put(fieldName, msg);
		}
	}
	
}
