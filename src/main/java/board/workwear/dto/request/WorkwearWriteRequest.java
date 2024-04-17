package board.workwear.dto.request;

public class WorkwearWriteRequest {
    private String title;
    private String content;

    // 생성자
    public WorkwearWriteRequest(String TITLE, String CONTENTS) {
        this.title = TITLE;
        this.content = CONTENTS;
    }

    // Getter 및 Setter 메서드
    public String getTitle() {
        return title;
    }

    public void setTitle(String TITLE) {
        this.title = TITLE;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String CONTENTS) {
        this.content = CONTENTS;
    }
}
