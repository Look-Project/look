package board.workwear.service;

import java.sql.SQLException;
import java.util.List;

import board.workwear.dao.WorkwearDAO;
import board.workwear.dto.request.WorkwearEditRequest;
import board.workwear.dto.request.WorkwearWriteRequest;
import board.workwear.dto.response.WorkwearBoardResponse;
import board.workwear.dto.response.WorkwearResponse;

public class WorkwearService {

	WorkwearDAO wdao = new WorkwearDAO();
	
	//게시글 입력 
	public void post(WorkwearWriteRequest wwr){
		wdao.insertBoard(wwr);
	}
	//게시글 리스트 출력
	public List<WorkwearResponse> getAllBoard() {
		return wdao.getAllBoard();
	}
	//상세 게시글로 이동
	public WorkwearBoardResponse getDetailBoard(int boardId) {
		return wdao.getDetailBoard(boardId);
	}
	//게시글 수정 메소드 서비스
	public int workwearEditService(WorkwearEditRequest ws) {
		return wdao.updateBoard(ws);
	}
	//게시글 삭제 메소드 서비스
	public int workwearDelService(int boardId) throws SQLException {
			return wdao.deleteBoard(boardId);
		}
}

