package board.workwear.controller;

import board.workwear.dto.request.WorkwearDetailRequest;
import board.workwear.dto.response.WorkwearDetailResponse;
import board.workwear.service.WorkwearDetailService;

public class WorkwearDetailController {

    private final WorkwearDetailService workwearDetailService;

    public WorkwearDetailController() {
        this.workwearDetailService = new WorkwearDetailService();
    }

    // 특정 boardId에 해당하는 작업복 상세 정보를 가져오는 컨트롤러 메서드
    public WorkwearDetailResponse getWorkwearDetail(int boardID) {
        WorkwearDetailRequest request = new WorkwearDetailRequest(boardID);
        return workwearDetailService.getWorkwearDetail(request);
    }
}
