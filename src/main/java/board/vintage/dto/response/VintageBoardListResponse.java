package board.vintage.dto.response;

import java.sql.Date;

public class VintageBoardListResponse {
	
	private String nickname;
	private String userImgSrc;
	private String userImgName;
	
	private String title;
	private String imgSrc;
	private String imgName;
	
	private int boardId;
	
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getUserImgSrc() {
		return userImgSrc;
	}
	public void setUserImgSrc(String userImgSrc) {
		this.userImgSrc = userImgSrc;
	}
	public String getUserImgName() {
		return userImgName;
	}
	public void setUserImgName(String userImgName) {
		this.userImgName = userImgName;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImgSrc() {
		return imgSrc;
	}
	public void setImgSrc(String imgSrc) {
		this.imgSrc = imgSrc;
	}
	public String getImgName() {
		return imgName;
	}
	public void setImgName(String imgName) {
		this.imgName = imgName;
	}
	
	public int getBoardId() {
		return boardId;
	}
	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}
	
}
