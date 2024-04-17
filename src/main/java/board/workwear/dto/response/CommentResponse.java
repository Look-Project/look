package board.workwear.dto.response;

public class CommentResponse {
    private String id;
    private String comment;

    public CommentResponse(String USER_ID, String CONTENTS) {
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
