package board.workwear.service;

import java.util.List;
import board.workwear.dao.WorkwearDAO;
import board.workwear.dto.WorkwearDTO;

public class WorkwearService {
    private WorkwearDAO workwearDAO;

    public WorkwearService() {
        this.workwearDAO = new WorkwearDAO();
    }

    // 모든 WorkwearDTO 가져오기
    public List<WorkwearDTO> getAllWorkwear() {
        return workwearDAO.getAllWorkwear();
    }

    // 다른 필요한 서비스 메서드 추가 가능
}