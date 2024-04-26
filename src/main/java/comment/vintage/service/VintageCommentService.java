package comment.vintage.service;

import java.util.List;

import board.workwear.dto.response.CommentResponse;
import comment.vintage.dao.VintageCommentDAO;
import comment.vintage.dto.request.VintageCommentRequest;
import comment.vintage.dto.response.VintageCommentResponse;

public class VintageCommentService {

    private VintageCommentDAO cDAO;

    public VintageCommentService() {
        this.cDAO = new VintageCommentDAO();
    }

    public void addComment(VintageCommentRequest vcr) {
        cDAO.addComment(vcr);
    }
    
    public List<VintageCommentResponse> getAllComments(int boardId) {
        return cDAO.getAllComments(boardId);
    }
    
    public int setDeleteComment(int commentId) {
    	return cDAO.setDeleteComment(commentId);
    }
}
