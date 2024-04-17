package board.workwear.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.workwear.dto.request.WorkwearWriteRequest;
import board.workwear.service.WorkwearWriteService;

import java.io.IOException;

@WebServlet("/workwear/write")
public class WorkwearWriteController extends HttpServlet {

    private WorkwearWriteService workwearWriteService;

    @Override
    public void init() {
        this.workwearWriteService = new WorkwearWriteService();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 요청 파라미터에서 데이터 추출
        String title = request.getParameter("title");
        String contents = request.getParameter("contents");

        // DTO 객체 생성
        WorkwearWriteRequest workwearWriteRequest = new WorkwearWriteRequest(title, contents);

        // 서비스 호출
        boolean success = workwearWriteService.writeWorkwear(workwearWriteRequest);

        // 결과 반환
        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(String.valueOf(success));
    }
}
