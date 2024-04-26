package board.workwear.service;

import java.util.List;

import board.workwear.dao.CommentDAO;
import board.workwear.dto.request.CommentRequest;
import board.workwear.dto.response.CommentResponse;

public class CommentService {

    private CommentDAO cDAO;

    public CommentService() {
        this.cDAO = new CommentDAO();
    }

    public void addComment(CommentRequest cr) {
        cDAO.addComment(cr);
    }
    
    public List<CommentResponse> getAllComments(int boardId) {
        return cDAO.getAllComments(boardId);
    }
}
