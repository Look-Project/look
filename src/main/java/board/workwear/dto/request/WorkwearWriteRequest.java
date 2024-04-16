package board.workwear.dto.request;

public class WorkwearWriteRequest {
    private String title;
    private String content;

    // 생성자
    public WorkwearWriteRequest(String title, String content) {
        this.title = title;
        this.content = content;
    }

    // Getter 및 Setter 메서드
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
