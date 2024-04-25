package board.workwear.service;

import java.util.List;

import board.workwear.dao.WorkwearDAO;
import board.workwear.dto.request.WorkwearWriteRequest;
import board.workwear.dto.response.WorkwearResponse;

public class WorkwearService {

	WorkwearDAO wdao = new WorkwearDAO();
	
	public void post(WorkwearWriteRequest wwr){
		wdao.insertBoard(wwr);
	}
	public List<WorkwearResponse> getAllBoard() {
		return wdao.getAllBoard();
	}
}
