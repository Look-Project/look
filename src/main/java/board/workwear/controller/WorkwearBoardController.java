package board.workwear.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.workwear.dto.response.WorkwearBoardResponse;
import board.workwear.service.CommentService;
import board.workwear.service.WorkwearService;
import common.SessionUtil;
import member.dto.response.MemberResponse;

@WebServlet(urlPatterns = "/workwear/detail")
public class WorkwearBoardController extends HttpServlet {

    private final String WORKWEAR_BOARD = "/views/board/workwear/workwearBoard.jsp";
    private final WorkwearService wbs = new WorkwearService();
    private final CommentService cbs = new CommentService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        MemberResponse loginMember = SessionUtil.getSessionMember(request);

        // boardId 파라미터를 가져옴
        String boardIdParam = request.getParameter("boardId");
        int boardId;
        if (boardIdParam != null && !boardIdParam.isEmpty()) {
            boardId = Integer.parseInt(boardIdParam.trim());
        } else {
            // boardId가 없는 경우에 대한 처리
            // 여기서는 기본값으로 0을 사용
            boardId = -1;
        }

        // 해당 boardId를 이용하여 게시글 정보와 댓글 리스트를 가져옴
        WorkwearBoardResponse viewdto = wbs.getDetailBoard(boardId);
        request.setAttribute("boarddetail", viewdto);
        request.setAttribute("commentlist", cbs.getAllComments(boardId));

        // 로그인한 멤버와 게시글 작성자를 비교하여 권한 설정
        if (loginMember != null) {
            if (loginMember.getMemberId() == viewdto.getUserId()) {
                request.setAttribute("authMember", true);
            } else {
                request.setAttribute("authMember", false);
            }
        }

        request.getRequestDispatcher(WORKWEAR_BOARD).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
