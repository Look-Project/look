package board.workwear.controller;

import board.workwear.dto.request.WorkwearWriteRequest;
import board.workwear.service.WorkwearWriteService;

// 이 부분에 컨트롤러에 필요한 어노테이션을 추가해주세요 (예를 들어, Spring Framework를 사용한다면 @Controller 어노테이션 등)
public class WorkwearWriteController {

    private WorkwearWriteService workwearWriteService;

    public WorkwearWriteController() {
        this.workwearWriteService = new WorkwearWriteService();
    }

    // 작업복 글을 작성하는 컨트롤러 메서드
    public boolean writeWorkwear(String title, String contents) {
        // 작업복 글 작성 시 파일 경로는 request에 의해 자동 생성되므로 제외합니다.
        WorkwearWriteRequest request = new WorkwearWriteRequest(title, contents);
        return workwearWriteService.writeWorkwear(request);
    }
}
