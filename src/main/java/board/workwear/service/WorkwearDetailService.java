package board.workwear.service;

import board.workwear.dao.WorkwearDAO;
import board.workwear.dto.request.WorkwearDetailRequest;
import board.workwear.dto.response.WorkwearDetailResponse;

public class WorkwearDetailService {

    private WorkwearDAO WorkwearDAO;

    public WorkwearDetailService() {
        this.WorkwearDAO = new WorkwearDAO();
    }

    public WorkwearDetailResponse getWorkwearDetail(WorkwearDetailRequest request) {
        return WorkwearDAO.getWorkwearDetail(request);
    }
}
