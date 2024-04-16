package board.workwear.dto.response;

public class WorkwearWriteResponse {
    private String filePath;

    // 생성자
    public WorkwearWriteResponse(String filePath) {
        this.filePath = filePath;
    }

    // Getter 및 Setter 메서드
    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
