package board.freecycling.service;

import board.freecycling.dao.freecyclingBoardDAO;
import board.freecycling.dto.request.FreecyclingBoardDTO;

public class FreecyclingBoardService {
	
	freecyclingBoardDAO bdao = new freecyclingBoardDAO();
	
	public void freecyclingServicerequest(FreecyclingBoardDTO bdto) {
		bdao.insertBoard(bdto);
	}
}
