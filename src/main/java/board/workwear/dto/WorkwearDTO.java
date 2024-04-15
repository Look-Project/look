package board.workwear.dto;

public class WorkwearDTO {
	private int boradId;
    private String imageName;
    private String userNickname;

    // 생성자
    public WorkwearDTO(int boradId, String imageName, String userNickname) {
        this.boradId = boradId;
        this.imageName = imageName;
        this.userNickname = userNickname;
    }

    // id 속성의 Getter 및 Setter
    public int getId() {
        return boradId;
    }

    public void setId(int boradId) {
        this.boradId = boradId;
    }

    // imagePath 속성의 Getter 및 Setter
    public String getImagePath() {
        return imageName;
    }

    public void setImagePath(String imagePath) {
        this.imageName = imagePath;
    }

    // additionalText 속성의 Getter 및 Setter
    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }
}
