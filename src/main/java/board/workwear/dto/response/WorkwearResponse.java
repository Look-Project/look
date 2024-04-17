package board.workwear.dto.response;

public class WorkwearResponse {
	private int boardId;
    private String imageName;
    private String userNickname;

    // 생성자
    public WorkwearResponse(int BOARD_ID, String IMG_ID, String NICKNAME) {
        this.boardId = BOARD_ID;
        this.imageName = IMG_ID;
        this.userNickname = NICKNAME;
    }

    // 각 속성의 Getter 및 Setter
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
