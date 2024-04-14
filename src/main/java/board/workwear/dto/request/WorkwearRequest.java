package board.workwear.dto.request;

public class WorkwearRequest {
	private int boardId;
    private String imageName;
    private String userNickname;

    // 생성자
    public WorkwearRequest(int boardId, String imageName, String userNickname) {
        this.boardId = boardId;
        this.imageName = imageName;
        this.userNickname = userNickname;
    }

    // 각 속성의 Getter 및 Setter
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
