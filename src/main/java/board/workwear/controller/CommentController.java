package board.workwear.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.workwear.dto.request.CommentRequest;
import board.workwear.service.CommentService;
import common.SessionUtil;

@WebServlet(urlPatterns = "/workwear/board")
public class CommentController extends HttpServlet {
    private final String WORKWEAR_BOARD_COMMWNT = "/views/board/workwear/workwearBoard.jsp";
    private final String LOGIN = "/views/member/login.jsp";
    private final String WORKWEAR_COMMWNT_LIST = "/workwear/commentlist";
    CommentService cs = new CommentService();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(SessionUtil.getSessionMember(request) != null) {
            request.getRequestDispatcher(WORKWEAR_BOARD_COMMWNT).forward(request, response);
        } else {
            request.getRequestDispatcher(LOGIN).forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        CommentRequest cr = new CommentRequest();
        
        Map<String, String> requestValues = new HashMap<>();
        requestValues.put("nickname", request.getParameter("nickname"));
        requestValues.put("contents", request.getParameter("contents"));
        
        cr.setNickname(requestValues.get("nickname"));
        cr.setContents(requestValues.get("contents"));
        
        cs.post(cr);
        response.sendRedirect(request.getContextPath() + WORKWEAR_COMMWNT_LIST);
    }
}
