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

import member.service.MemberService;

@WebServlet(urlPatterns = "/member/nickname-check")
public class NicknameCheckController extends HttpServlet {
	private final MemberService memberService = new MemberService();
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Map<String, String> errors = new HashMap<>();
		String nickname = request.getParameter("nickname");
		
		checkNickname(errors, nickname);
		JSONObject jObj = new JSONObject();
		
		if(!errors.isEmpty()) {
	        jObj.put("errors", errors);
		}else if(memberService.duplicateNickname(nickname)){
			jObj.put("success", true);
		}else {
			jObj.put("success", false);
		}
        
        response.setContentType("application/x-json; charset=utf-8");
        response.getWriter().print(jObj);
	}
	
	
	private void checkNickname(Map<String, String> errors, String nickname) {
		checkSignupValue(errors, nickname);
		
		if(!errors.containsKey("nickname") && !Pattern.matches("^(?=.*[a-z0-9가-힣])[a-z0-9가-힣]{2,8}$", nickname)) {
			errors.put("nickname", "2~8 글자 범위(영어, 숫자, 한글)로 입력해 주세요.");
		}
	}
	
	private void checkSignupValue(Map<String, String> errors, String nickname) {
		if(nickname == null || nickname.isEmpty()) {
			errors.put("nickname", "닉네임을 입력해 주세요.");
		}
	}
		
}
