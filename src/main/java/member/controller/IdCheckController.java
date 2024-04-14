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


@WebServlet(urlPatterns = "/member/id-check")
public class IdCheckController extends HttpServlet {

	private final MemberService memberService = new MemberService();
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Map<String, String> errors = new HashMap<>();
		String loginId = request.getParameter("loginId");
		
		checkLoginId(errors, loginId);
		JSONObject jObj = new JSONObject();
		
		if(!errors.isEmpty()) {
	        jObj.put("errors", errors);
		}else if(memberService.duplicateLoginId(loginId)){
			jObj.put("success", true);
		}else {
			jObj.put("success", false);
		}
        
        response.setContentType("application/x-json; charset=utf-8");
        response.getWriter().print(jObj);
	}
	
	private void checkLoginId(Map<String, String> errors, String loginId) {
		checkloginIdValue(errors, loginId);
		
		if(!errors.containsKey("loginId") && !Pattern.matches("^[A-Za-z0-9]{6,15}$", loginId)) {
			errors.put("loginId", "6~15 글자 범위(알파벳 또는 숫자 필수)로 입력해 주세요.");
		}
	}
	
	private void checkloginIdValue(Map<String, String> errors, String loginId) {
		if(loginId == null || loginId.isEmpty()) {
			errors.put("loginId", "아이디를 입력해 주세요.");
		}
	}
	
}
