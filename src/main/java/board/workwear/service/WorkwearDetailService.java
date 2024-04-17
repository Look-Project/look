package board.workwear.service;

import board.workwear.dao.WorkwearDAO;
import board.workwear.dto.request.WorkwearDetailRequest;
import board.workwear.dto.response.WorkwearDetailResponse;

public class WorkwearDetailService {

    private final WorkwearDAO workwearDAO;

    public WorkwearDetailService() {
        this.workwearDAO = new WorkwearDAO();
    }

    public WorkwearDetailResponse getWorkwearDetail(WorkwearDetailRequest request) {
        return workwearDAO.getWorkwearDetail(request);
    }
}
