package board.workwear.dto.request;

public class CommentRequest {
    private String nickname;
    private String comment;


    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getContents() {
        return comment;
    }

    public void setContents(String contents) {
        this.comment = contents;
    }
}
