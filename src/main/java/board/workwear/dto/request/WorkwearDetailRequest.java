package board.workwear.dto.request;

public class WorkwearDetailRequest {
    private int boardId;

    public WorkwearDetailRequest(int boardId) {
        this.boardId = boardId;
    }

    public int getBoardId() {
        return boardId;
    }

    public void setBoardId(int boardId) {
        this.boardId = boardId;
    }
}
