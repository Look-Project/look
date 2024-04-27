package board.freecycling.dto.response;

public class FreeMainListDTO {
	
	private String nickname;
	private String title;
	private int boardId;
	private String profileSrc;
	private String profileName;
	
	
	
	private String imgSrc;
	private String imgName;
	
	
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
		
	public int getBoardId() {
		return boardId;
	}
	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}
	
	
	public String getProfileSrc() {
		return profileSrc;
	}
	public void setProfileSrc(String profileSrc) {
		this.profileSrc = profileSrc;
	}
	public String getProfileName() {
		return profileName;
	}
	public void setProfileName(String profileName) {
		this.profileName = profileName;
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
	
	
	
}
