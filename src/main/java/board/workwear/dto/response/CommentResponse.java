package board.workwear.dto.response;

public class CommentResponse {
    private String id;
    private String comment;

    public CommentResponse(String userId, String contents) {
        this.id = userId;
        this.comment = contents;
    }

    public String getId() {
        return id;
    }

    public void setId(String userId) {
        this.id = userId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String contents) {
        this.comment = contents;
    }
}
