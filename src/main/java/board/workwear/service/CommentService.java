package board.workwear.service;

import java.util.List;
import board.workwear.dao.CommentDAO;
import board.workwear.dto.request.CommentRequest;
import board.workwear.dto.response.CommentResponse;

public class CommentService {

    private CommentDAO commentDAO;

    public CommentService() {
        this.commentDAO = new CommentDAO();
    }

    public List<CommentResponse> getAllComments() {
        return commentDAO.getAllComments();
    }

    public void addComment(CommentRequest request) {
        commentDAO.addComment(request);
    }
}
