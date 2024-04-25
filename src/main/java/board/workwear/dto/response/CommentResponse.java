package board.workwear.dto.response;

import java.util.List;

public class CommentResponse {
    private String nickname;
    private String comment;
    private int commentId;
    
    
    public CommentResponse() {
    }

    public CommentResponse(String nickname, String contents, int commentId) {
        this.nickname = nickname;
        this.comment = contents;
        this.commentId = commentId;
        
    }
    
    
	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
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
