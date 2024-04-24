package common.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.SessionUtil;

@WebFilter(urlPatterns = "/*")
public class LoginFilter implements Filter {
	
	private static final List<String> LOGIN_REQUITED_LIST = new ArrayList<>(Arrays.asList("/mypage/profile", "/vintage/write"));

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest servletRequest = (HttpServletRequest) request;

		String requestURI = servletRequest.getRequestURI();


		String contextPath = servletRequest.getContextPath();
		int contextPathLength = contextPath.length();

		String requestPath = requestURI.substring(contextPathLength);
		
		if(LOGIN_REQUITED_LIST.contains(requestPath) && SessionUtil.getSessionMember(servletRequest) == null) {
			System.out.println("로그인이 필요한 요청입니다.");
			String queryString = servletRequest.getQueryString();
			requestPath = (queryString == null) ? requestPath : requestPath + "?" + queryString;
			
			servletRequest.getSession().setAttribute("redirectPath", requestPath);
			HttpServletResponse servletResponse = (HttpServletResponse) response;
			servletResponse.sendRedirect(contextPath + "/member/login");
			return;
		}
		
		
		
		chain.doFilter(request, response);
	}

}
