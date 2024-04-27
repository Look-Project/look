package member.dto.request;

public class MemberSignupRequest {
	private String loginId;
	private String nickname;
	private String password;
	private String passwordCheck;
	private String profileSrc;
	private String profileName;
	
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPasswordCheck() {
		return passwordCheck;
	}
	public void setPasswordCheck(String passwordCheck) {
		this.passwordCheck = passwordCheck;
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
	
	
}
