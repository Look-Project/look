package board.freecycling.service;

import java.util.ArrayList;
import java.util.List;

import board.freecycling.dao.freecyclingBoardDAO;
import board.freecycling.dto.request.FreecyclingBoardDTO;
import board.freecycling.dto.response.FreecyclingBoardListViewDTO;

public class FreecyclingBoardService {
	
	freecyclingBoardDAO bdao = new freecyclingBoardDAO();
	
	//게시글 작성 후 데이터베이스 입력 메소드
	public void freecyclingInsertService(FreecyclingBoardDTO bdto) {
		bdao.insertBoard(bdto);
	}
	
	
	//게시글 리스트 출력 메소드
	public List<FreecyclingBoardListViewDTO> freecyclingListViewService() { 
		return bdao.getAllBoard();
	}
	
}
