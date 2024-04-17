package board.workwear.dto.response;

public class WorkwearDetailResponse {
    private int boardId;
    private String imageName;
    private String userNickname;

    public WorkwearDetailResponse(int BOARD_ID, String IMG_ID, String NICKNAME) {
        this.boardId = BOARD_ID;
        this.imageName = IMG_ID;
        this.userNickname = NICKNAME;
    }

    public int getBoardId() {
        return boardId;
    }

    public void setBoardId(int BOARD_ID) {
        this.boardId = BOARD_ID;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String IMG_ID) {
        this.imageName = IMG_ID;
    }

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String NICKNAME) {
        this.userNickname = NICKNAME;
    }
}
