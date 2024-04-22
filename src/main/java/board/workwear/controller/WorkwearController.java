package board.workwear.controller;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.workwear.dto.request.WorkwearRequest;
import board.workwear.dto.response.WorkwearResponse;
import board.workwear.service.WorkwearService;

@WebServlet("/workwear/workwear")
public class WorkwearController extends HttpServlet {

    private WorkwearService workwearService;

    public WorkwearController() {
        this.workwearService = new WorkwearService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // GET 요청 처리 로직은 여기에 작성합니다.
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // POST 요청 처리 로직을 여기에 작성합니다.
        // 예시로 POST 요청에서 받은 데이터를 가공하여 응답으로 반환하는 코드를 작성하겠습니다.

        // 요청 파라미터에서 필요한 데이터 추출
        int boardId = Integer.parseInt(request.getParameter("boardId"));
        String imgId = request.getParameter("imgId");
        String nickname = request.getParameter("nickname");

        // WorkwearRequest 객체 생성
        WorkwearRequest workwearRequest = new WorkwearRequest(boardId, imgId, nickname);

        // WorkwearService를 사용하여 요청 처리
        WorkwearResponse workwearResponse = workwearService.processWorkwearRequest(workwearRequest);

        // 클라이언트로 응답 데이터 전송
        // 여기서는 간단히 콘솔에 출력하는 예시를 작성하겠습니다.
        System.out.println("Image Info: " + workwearResponse.toString());
    }
}
