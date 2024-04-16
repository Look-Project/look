package board.workwear.service;

import board.workwear.dao.WorkwearDAO;
import board.workwear.dto.request.WorkwearWriteRequest;

public class WorkwearWriteService {
    private WorkwearDAO WorkwearDAO;

    public WorkwearWriteService() {
        this.WorkwearDAO = new WorkwearDAO();
    }

    // 게시물을 작성하는 메서드
    public boolean writeWorkwear(WorkwearWriteRequest request) {
        // 파일을 업로드하고 실제 파일 경로를 가져오는 작업 등을 수행할 수 있음
        // 여기서는 파일 경로를 그대로 전달하고 있다고 가정함
        return WorkwearDAO.writeWorkwear(request);
    }
}
