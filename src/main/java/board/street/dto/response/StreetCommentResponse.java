package board.street.dto.response;

import java.sql.Date;

public class StreetCommentResponse {

    private String nickName;
    private String comment;

	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
}
    