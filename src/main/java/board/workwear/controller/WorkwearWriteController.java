package board.workwear.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.workwear.dto.request.WorkwearWriteRequest;
import board.workwear.service.WorkwearWriteService;
import common.SessionUtil;

import java.io.IOException;

@WebServlet("/workwear/write")
public class WorkwearWriteController extends HttpServlet {

    private final String WORKWEAR_WRITE_FORM = "/views/board/workwear/workwearwrite.jsp";
    private final String LOGIN = "/views/member/login.jsp";
    private final String WORKWEAR_BOARD_LIST = "/workwear/boardlist";

    private WorkwearWriteService workwearWriteService;

    @Override
    public void init() {
        this.workwearWriteService = new WorkwearWriteService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(SessionUtil.getSessionMember(request) != null) {
            request.getRequestDispatcher(WORKWEAR_WRITE_FORM).forward(request, response);
        } else {
            request.getRequestDispatcher(LOGIN).forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // Extract data from request parameters
        String title = request.getParameter("title");
        String contents = request.getParameter("contents");

        // Create DTO object
        WorkwearWriteRequest workwearWriteRequest = new WorkwearWriteRequest(title, contents);

        // Set member ID from session
        workwearWriteRequest.setMemberId(SessionUtil.getSessionMember(request).getMemberId());

        // Call the service
        boolean success = workwearWriteService.writeWorkwear(workwearWriteRequest);

        // Redirect to board list page
        response.sendRedirect(request.getContextPath() + WORKWEAR_BOARD_LIST);
    }
}
