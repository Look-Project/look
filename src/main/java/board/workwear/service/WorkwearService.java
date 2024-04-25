package board.workwear.service;

import java.util.List;

import board.vintage.dto.response.VintageBoardResponse;
import board.workwear.dao.WorkwearDAO;
import board.workwear.dto.request.WorkwearWriteRequest;
import board.workwear.dto.response.WorkwearBoardResponse;
import board.workwear.dto.response.WorkwearResponse;

public class WorkwearService {

	WorkwearDAO wdao = new WorkwearDAO();
	
	public void post(WorkwearWriteRequest wwr){
		wdao.insertBoard(wwr);
	}
	public List<WorkwearResponse> getAllBoard() {
		return wdao.getAllBoard();
	}
	public WorkwearBoardResponse getDetailBoard(int boardId) {
		return wdao.getDetailBoard(boardId);
	}
}
