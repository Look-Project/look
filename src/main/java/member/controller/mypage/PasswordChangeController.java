package member.controller.mypage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import common.SessionUtil;
import member.dto.request.MemberPasswordChangeRequest;
import member.dto.request.MemberSignupRequest;
import member.dto.response.MemberResponse;
import member.service.MyPageService;

@WebServlet(urlPatterns = "/mypage/user-password")
public class PasswordChangeController extends HttpServlet {
	
	private final MyPageService myPageService = new MyPageService();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberResponse loginMember = SessionUtil.getSessionMember(request);
		
		MemberPasswordChangeRequest memberPasswordChange = new MemberPasswordChangeRequest();
		memberPasswordChange.setCurrentPassword(request.getParameter("currentPw"));
		memberPasswordChange.setNewPassword(request.getParameter("newPw"));
		memberPasswordChange.setNewPasswordCheck(request.getParameter("newPwCheck"));
		
		Map<String, String> errors = validatePasswordChange(memberPasswordChange);
		
		checkPasswordMatch(errors, loginMember.getPassword(), memberPasswordChange.getCurrentPassword());
		
		JSONObject jObj = new JSONObject();
		
		if(!errors.isEmpty()) {
	        jObj.put("errors", errors);
		}else if(myPageService.updateLoginPassword(loginMember.getMemberId(), memberPasswordChange.getNewPassword())) {
			jObj.put("success", true);
		}else {
			jObj.put("success", false);
		}
		
        response.setContentType("application/x-json; charset=utf-8");
        response.getWriter().print(jObj);
	}
	
	private Map<String, String> validatePasswordChange(MemberPasswordChangeRequest memberPasswordChange) {
		Map<String, String> errors = new HashMap<>();
		
		checkPassword(errors, memberPasswordChange.getNewPassword(), "password");
		checkPassword(errors, memberPasswordChange.getNewPasswordCheck(), "passwordCheck");
		
		if(!errors.containsKey("password") && !errors.containsKey("passwordCheck")) {
			if(!memberPasswordChange.getNewPassword().equals(memberPasswordChange.getNewPasswordCheck())) {
				errors.put("passwordCheck", "비밀번호가 일치하지 않습니다.");
			}
		}
		
		return errors;
	}
	
	private void checkPasswordMatch(Map<String, String> errors, String loginPw, String targetPw) {
		if(loginPw == null || targetPw == null) {
			errors.put("currentPw", "비밀번호를 입력해 주세요");
			return;
		}
		
		if(!loginPw.equals(targetPw)) {
			errors.put("currentPw", "비밀번호가 일치하지 않습니다.");
		}
		
	}
	
	private void checkPassword(Map<String, String> errors, String value, String fieldName) {
		checkPasswordValue(errors, value, fieldName, "비밀번호를 입력해 주세요.");
		
		if(!errors.containsKey(fieldName) && !Pattern.matches("^[A-Za-z0-9]{8,15}$", value)) {
			errors.put(fieldName, "8~15 글자 범위(알파벳, 숫자 필수)로 입력해 주세요.");
		}
	}
	
	private void checkPasswordValue(Map<String, String> errors, String value, String fieldName, String msg) {
		if(value == null || value.isEmpty()) {
			errors.put(fieldName, msg);
		}
	}
	
}
