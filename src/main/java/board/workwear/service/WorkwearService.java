package board.workwear.service;

import board.workwear.dto.request.WorkwearRequest;
import board.workwear.dto.response.WorkwearResponse;

public class WorkwearService {

    // 실제로는 데이터베이스나 외부 API 등을 이용하여 비즈니스 로직을 처리할 것입니다.
    // 여기서는 간단히 입력된 데이터를 가공하여 리턴하는 예시를 작성하겠습니다.

    public WorkwearResponse processWorkwearRequest(WorkwearRequest request) {
        // 여기서는 요청된 데이터를 가공하여 응답 데이터를 생성합니다.
        // 실제 비즈니스 로직에 따라 데이터베이스 조회, 외부 API 호출 등을 수행할 수 있습니다.
        // 이 예시에서는 요청 데이터를 그대로 응답으로 사용합니다.

        // WorkwearRequest로부터 필요한 데이터를 추출하여 응답 생성
        int boardId = request.getBoardId();
        String imageName = request.getImageName();
        String userNickname = request.getUserNickname();

        // WorkwearResponse로 변환하여 반환
        return new WorkwearResponse(boardId, imageName, userNickname);
    }
}