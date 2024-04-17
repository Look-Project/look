package board.workwear.controller;

import board.workwear.dto.request.WorkwearDetailRequest;
import board.workwear.dto.response.WorkwearDetailResponse;
import board.workwear.service.WorkwearDetailService;

// 이 부분에 컨트롤러에 필요한 어노테이션을 추가해주세요 (예를 들어, Spring Framework를 사용한다면 @Controller 어노테이션 등)
public class WorkwearDetailController {

    private WorkwearDetailService workwearDetailService;

    public WorkwearDetailController() {
        this.workwearDetailService = new WorkwearDetailService();
    }

    // 특정 boardId에 해당하는 작업복 상세 정보를 가져오는 컨트롤러 메서드
    public WorkwearDetailResponse getWorkwearDetail(int boardID) {
        WorkwearDetailRequest request = new WorkwearDetailRequest(boardID);
        return workwearDetailService.getWorkwearDetail(request);
    }
}
