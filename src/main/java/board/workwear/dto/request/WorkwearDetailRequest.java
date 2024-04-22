package board.workwear.dto.request;

public class WorkwearDetailRequest {
    private int boardId;

    public WorkwearDetailRequest(int boradId) {
        this.boardId = boradId;
    }

    public int getBoardId() {
        return boardId;
    }

    public void setBoardId(int boradId) {
        this.boardId = boradId;
    }
}
