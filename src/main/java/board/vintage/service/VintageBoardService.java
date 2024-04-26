package board.vintage.service;

import java.util.List;

import board.vintage.dao.VintageDAO;
import board.vintage.dto.request.VintageEditRequest;
import board.vintage.dto.request.VintageWriteRequest;
import board.vintage.dto.response.VintageBoardListResponse;
import board.vintage.dto.response.VintageBoardResponse;

public class VintageBoardService {
	
	VintageDAO vdao = new VintageDAO();
	
	public void post(VintageWriteRequest vwr){
		vdao.insertBoard(vwr);
	}
	public List<VintageBoardListResponse> getAllBoard() {
		return vdao.getAllBoard();
	}
	public VintageBoardResponse getDetailBoard(int boardId) {
		return vdao.getDetailBoard(boardId);
	}
	public int setEditBoard(VintageEditRequest dto) {
		return vdao.setEditBoard(dto);
	}
}
