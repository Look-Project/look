package board.vintage.service;

import java.util.List;

import board.vintage.dao.VintageDAO;
import board.vintage.dto.request.VintageWriteRequest;
import board.vintage.dto.response.VintageBoardListResponse;

public class VintageBoardService {
	
	VintageDAO vdao = new VintageDAO();
	
	public void post(VintageWriteRequest vwr){
		vdao.insertBoard(vwr);
	}
	public List<VintageBoardListResponse> getAllBoard() {
		return vdao.getAllBoard();
	}
}