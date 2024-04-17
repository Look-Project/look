package board.workwear.dto.request;

public class WorkwearDetailRequest {
    private int boardId;

    public WorkwearDetailRequest(int BOARD_ID) {
        this.boardId = BOARD_ID;
    }

    public int getBoardId() {
        return boardId;
    }

    public void setBoardId(int BOARD_ID) {
        this.boardId = BOARD_ID;
    }
}
