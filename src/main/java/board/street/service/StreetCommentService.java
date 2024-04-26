package board.street.service;

import java.util.List;
import board.street.dao.StreetDAO;
import board.street.dto.request.StreetCommentRequest;
import board.street.dto.request.StreetWriteRequest;
import board.street.dto.response.StreetBoardListResponse;
import board.workwear.dto.request.WorkwearWriteRequest;
import board.workwear.dto.response.WorkwearBoardResponse;
import board.workwear.dto.response.WorkwearResponse;
import comment.vintage.dao.VintageCommentDAO;
import comment.vintage.dto.request.VintageCommentRequest;
import comment.vintage.dto.response.VintageCommentResponse;

public class StreetCommentService<StreetCommentResponse> {
   
    private StreetCommentService sDAO;

    public StreetCommentService() {
        this.sDAO = new StreetCommentService();
    }

    public void addComment(StreetCommentRequest scr) {
        sDAO.addComment(scr);
    }
    
    public List<StreetCommentResponse> getAllComments(int boardId) {
        return sDAO.getAllComments(boardId);
    }
    
}
