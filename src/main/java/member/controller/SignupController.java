package member.controller;

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
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import common.DBConnectionUtil;
import common.SessionUtil;
import member.dto.request.MemberSignupRequest;
import member.dto.response.MemberResponse;
import member.service.MemberService;

@WebServlet(urlPatterns = "/member/signup")
public class SignupController extends HttpServlet {

	private final String SIGN_UP_VIEW_NAME = "/views/member/signup.jsp";
	private final MemberService memberService = new MemberService();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberResponse loginMember = SessionUtil.getSessionMember(request);
		
		if(loginMember != null) {
			response.sendRedirect(request.getContextPath() + "/main");
		}else {
			request.getRequestDispatcher(SIGN_UP_VIEW_NAME).forward(request, response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberSignupRequest member = new MemberSignupRequest();
		member.setLoginId(request.getParameter("loginId"));
		member.setNickname(request.getParameter("nickname"));
		member.setPassword(request.getParameter("password"));
		member.setPasswordCheck(request.getParameter("passwordCheck"));
        
        Map<String, String> errors = validateSignup(member);
        JSONObject jObj = new JSONObject();
        
		if(!errors.isEmpty()) {
	        jObj.put("errors", errors);
		}else if(!memberService.duplicateLoginId(member.getLoginId())) {
			jObj.put("duplicatedLoginId", true);
		}else if(!memberService.duplicateNickname(member.getNickname())) {
			jObj.put("duplicatedNickname", true);
		}else if(memberService.signup(member)){
			jObj.put("success", true);
		}else {
			jObj.put("success", false);
		}

        response.setContentType("application/x-json; charset=utf-8");
        response.getWriter().print(jObj);
	}
	
	private Map<String, String> validateSignup(MemberSignupRequest member) {
		Map<String, String> errors = new HashMap<>();
		
		checkLoginId(errors, member.getLoginId(), "loginId");
		checkNickname(errors, member.getNickname(), "nickname");
		checkPassword(errors, member.getPassword(), "password");
		checkPassword(errors, member.getPasswordCheck(), "passwordCheck");
		
		if(!errors.containsKey("password") && !errors.containsKey("passwordCheck")) {
			if(!member.getPassword().equals(member.getPasswordCheck())) {
				errors.put("passwordCheck", "비밀번호가 일치하지 않습니다.");
			}
		}
		
		return errors;
	}
	
	private void checkLoginId(Map<String, String> errors, String value, String fieldName) {
		checkSignupValue(errors, value, fieldName, "아이디를 입력해 주세요.");
		
		if(!errors.containsKey(fieldName) && !Pattern.matches("^[A-Za-z0-9]{6,15}$", value)) {
			errors.put(fieldName, "6~15 글자 범위(알파벳 또는 숫자 필수)로 입력해 주세요.");
		}
	}
	
	private void checkPassword(Map<String, String> errors, String value, String fieldName) {
		checkSignupValue(errors, value, fieldName, "비밀번호를 입력해 주세요.");
		
		if(!errors.containsKey(fieldName) && !Pattern.matches("^[A-Za-z0-9]{8,15}$", value)) {
			errors.put(fieldName, "8~15 글자 범위(알파벳, 숫자 필수)로 입력해 주세요.");
		}
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
