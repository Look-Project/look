package board.workwear.dto.response;

public class WorkwearDetailResponse {
    private int boardId;
    private String imageName;
    private String userNickname;

    public WorkwearDetailResponse(int boardId, String imageName, String userNickname) {
        this.boardId = boardId;
        this.imageName = imageName;
        this.userNickname = userNickname;
    }

    public int getBoardId() {
        return boardId;
    }

    public void setBoardId(int boardId) {
        this.boardId = boardId;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }
}
