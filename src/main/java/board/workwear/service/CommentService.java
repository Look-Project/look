package board.workwear.service;

import java.util.List;
import board.workwear.dao.CommentDAO;
import board.workwear.dao.WorkwearDAO;
import board.workwear.dto.request.CommentRequest;
import board.workwear.dto.request.WorkwearWriteRequest;
import board.workwear.dto.response.CommentResponse;
import board.workwear.dto.response.WorkwearResponse;

public class CommentService {

	CommentDAO cdao = new CommentDAO();
	
	public void post(CommentRequest cr){
		cdao.insertComment(cr);
	}
	public List<CommentResponse> getAllComment() {
		return cdao.getAllComment();
	}
}
