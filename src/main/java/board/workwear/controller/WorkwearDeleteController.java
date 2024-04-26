package board.workwear.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.workwear.service.WorkwearService;
import common.SessionUtil;
import member.dto.response.MemberResponse;

@WebServlet("/controller/WorkwearDeleteController")
public class WorkwearDeleteController extends HttpServlet {
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 삭제할 게시물의 번호(boardID)를 받아서
        String boardIdParam = request.getParameter("boardId");
        int boardId = 0;
        if (boardIdParam != null && !boardIdParam.isEmpty()) {
            boardId = Integer.parseInt(boardIdParam);
        } else {
            // 예외 처리: 빈 문자열이거나 null일 때의 처리
            // 예를 들어 기본값을 설정하거나 오류 메시지를 출력할 수 있습니다.
        }
        
        MemberResponse loginMember = SessionUtil.getSessionMember(request);
        
        WorkwearService ds = new WorkwearService();
        
        try {
            ds.workwearDelService(boardId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        // 수정이 완료되었다면 전체 게시글 보기로 이동 
        request.setAttribute("msg", "삭제가 완료 되었습니다");
        RequestDispatcher dis = request.getRequestDispatcher("/workwear/boardlist");
        dis.forward(request ,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
