package board.workwear.dto.response;

public class CommentResponse {
    private String nickname;
    private String comment;
    
    public CommentResponse() {
    }

    public CommentResponse(String nickname, String contents) {
        this.nickname = nickname;
        this.comment = contents;
    }

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
