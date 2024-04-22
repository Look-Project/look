package board.freecycling.service;

import java.sql.SQLException;
import java.util.List;

import board.freecycling.dao.freecyclingBoardDAO;
import board.freecycling.dto.request.FreecyclingBoardDTO;
import board.freecycling.dto.request.FreecyclingUpdaterequestDTO;
import board.freecycling.dto.response.FreecyclingBoardContentsViewDTO;
import board.freecycling.dto.response.FreecyclingBoardListViewDTO;
import board.freecycling.dto.response.FreecyclingUpdateresponseDTO;

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
	
	
	//상세게시글 리스트 출력 메소드
	public FreecyclingBoardContentsViewDTO freecyclingOneContentViewService(int num) throws SQLException { 
		return bdao.getoneBoard(num);
	}
	
	//Updaterequest 수정 메소드
	public FreecyclingUpdaterequestDTO freecyclingUpdaterequestService(int num) throws SQLException { 
		return bdao.getoneUpdateBoard(num);
	}
	
	//Updateresponse 수정 메소드
	public void freecyclingUpdateresponseService(int num,FreecyclingUpdateresponseDTO upresdto) {
		bdao.updateBoard(num,upresdto);
	}	
}
