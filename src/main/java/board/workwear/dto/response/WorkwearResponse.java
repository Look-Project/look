package board.workwear.dto.response;

public class WorkwearResponse {
	private int boardId;
    private String imageName;
    private String userNickname;

    // 생성자
    public WorkwearResponse(int boardId, String imgId, String nickname) {
        this.boardId = boardId;
        this.imageName = imgId;
        this.userNickname = nickname;
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

    public void setImageName(String imgId) {
        this.imageName = imgId;
    }

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String nickname) {
        this.userNickname = nickname;
    }
}
