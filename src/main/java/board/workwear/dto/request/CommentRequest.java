package board.workwear.dto.request;

public class CommentRequest {
    private String id;
    private String comment;

    public CommentRequest(String USER_ID, String CONTENTS) {
        this.id = USER_ID;
        this.comment = CONTENTS;
    }

    public String getId() {
        return id;
    }

    public void setId(String USER_ID) {
        this.id = USER_ID;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String CONTENTS) {
        this.comment = CONTENTS;
    }
}
