package board.freecycling.service;

import java.sql.SQLException;
import java.util.List;

import board.freecycling.dao.freecyclingBoardDAO;
import board.freecycling.dto.request.FreeInsertDTO;
import board.freecycling.dto.request.FreecyclingUpdateDTO;
import board.freecycling.dto.response.FreeOneContentDTO;
import board.freecycling.dto.response.FreeMainListDTO;
import board.freecycling.dto.response.FreecyclingUpdateresponseDTO;

public class FreecyclingBoardService {
	
	freecyclingBoardDAO bdao = new freecyclingBoardDAO();
	
	//게시글 작성 후 데이터베이스 입력 메소드
	public void freeInsertService(FreeInsertDTO dto) {
		bdao.insertBoard(dto);
	}
	
	
	//게시글 리스트 출력 메소드
	public List<FreeMainListDTO> freeMainListService() { 
		return bdao.mainListBoard();
	}
	
	
	//상세게시글 리스트 출력 메소드
	public FreeOneContentDTO freecyclingOneContentViewService(int num) throws SQLException { 
		return bdao.getoneBoard(num);
	}
	
	/*
	 * //Updaterequest 수정 메소드 public FreecyclingUpdaterequestDTO
	 * freecyclingUpdaterequestService(int num) throws SQLException { return
	 * bdao.getoneUpdateBoard(num); }
	 * 
	 * //Updateresponse 수정 메소드 public void freecyclingUpdateresponseService(int
	 * num,FreecyclingUpdaterequestDTO boardupdto) {
	 * bdao.updateBoard(num,boardupdto); }
	 */	
	
	//게시글 수정 메소드 서비스
	
}
