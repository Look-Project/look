package board.workwear.service;

import board.workwear.dao.WorkwearDetailDAO;
import board.workwear.dto.request.WorkwearDetailRequest;
import board.workwear.dto.response.WorkwearDetailResponse;

public class WorkwearDetailService {

    private WorkwearDetailDAO workwearDetailDAO;

    public WorkwearDetailService() {
        this.workwearDetailDAO = new WorkwearDetailDAO();
    }

    public WorkwearDetailResponse getWorkwearDetail(WorkwearDetailRequest request) {
        return workwearDetailDAO.getWorkwearDetail(request);
    }
}
