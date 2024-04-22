package board.workwear.controller;

import javax.servlet.annotation.WebServlet;

import board.workwear.dto.request.WorkwearRequest;
import board.workwear.dto.response.WorkwearResponse;
import board.workwear.service.WorkwearService;

@WebServlet("/workwear/workwear")
// 이 부분에 컨트롤러에 필요한 어노테이션을 추가해주세요 (예를 들어, Spring Framework를 사용한다면 @Controller 어노테이션 등)
public class WorkwearController {

    private WorkwearService workwearService;

    public WorkwearController() {
        this.workwearService = new WorkwearService();
    }

    // 특정 boardId에 해당하는 이미지 정보를 가져오는 컨트롤러 메서드
    public WorkwearResponse getImageInfo(int boardId, String imgId, String nickname) {
        WorkwearRequest request = new WorkwearRequest(boardId, imgId, nickname);
        return workwearService.processWorkwearRequest(request);
    }
}
