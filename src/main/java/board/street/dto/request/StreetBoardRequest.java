package board.street.dto.request;

public class StreetBoardRequest {
   
   /*** 글 상세조회 */
   private String boardId;   //글 번호(PK)
   
   /*** 글쓰기 저장 */
   private String title;     //글 제목
   private String contents;  //글 내용
   private String imgName;   //이미지 이름
   
   public String getBoardId() {
      return boardId;
   }
   public void setBoardId(String boardId) {
      this.boardId = boardId;
   }
   public String getTitle() {
      return title;
   }
   public void setTitle(String title) {
      this.title = title;
   }
   public String getContents() {
      return contents;
   }
   public void setContents(String contents) {
      this.contents = contents;
   }
   public String getImgName() {
      return imgName;
   }
   public void setImgName(String imgName) {
      this.imgName = imgName;
   }
   
}
