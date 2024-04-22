package board.street.dto.response;

import java.sql.Date;



public class StreetBoardListResponse {
   
   /*
      CREATE TABLE "MEMBER" (
      "USER_ID" number(6) NOT NULL,
      "LOGIN_ID" varchar2(50) NOT NULL,
      "LOGIN_PWD" varchar2(200) NOT NULL,
      "NICKNAME" varchar2(30) NOT NULL,
      "ADMIN_YN" varchar2(2) DEFAULT 'N' CHECK(ADMIN_YN in('Y','N')) NOT NULL,
      "PROFILE_SRC" varchar2(300) NULL,
      "PROFILE_NAME" varchar2(200) NULL,
      "CREATE_AT" TIMESTAMP(2) DEFAULT sysdate NOT NULL,
      "UPDATE_AT" TIMESTAMP(2) DEFAULT sysdate NOT NULL,
      "INTRO" varchar2(1500) NULL,
      CONSTRAINT USER_ID_PK PRIMARY KEY(USER_ID)
      );     

      CREATE TABLE "BOARD_IMG" (
      "IMG_ID" number(6) NOT NULL,
      "BOARD_ID" number(6) NOT NULL,
      "IMG_SRC" varchar2(300) NOT NULL,
      "IMG_NAME" varchar2(200) NOT NULL,
      CONSTRAINT IMG_ID_PK PRIMARY KEY(IMG_ID),
      CONSTRAINT BOARD_ID_FK FOREIGN KEY(BOARD_ID) REFERENCES BOARD(BOARD_ID)
      );
      
    * CREATE TABLE "BOARD" ( 
    *   "BOARD_ID" number(6) NOT NULL
    *   "USER_ID" number(6) NOT NULL, 
    *   "TITLE" varchar2(60) NOT NULL, 
    *   "CONTENTS" varchar2(1000) NOT NULL,
    *   "VIEWS" number(6) DEFAULT 0 NOT NULL, 
    *   "CATEGORY" varchar2(2) CHECK(CATEGORY in('F','S','W','V','C')) NOT NULL, 
    *   "DELETE_YN" varchar2(2) DEFAULT 'N'
    *   "CHECK(DELETE_YN in('Y','N')) NOT NULL, 
    *   "CREATE_AT" TIMESTAMP(2) DEFAULT sysdate NOT NULL, 
    *   "UPDATE_AT" TIMESTAMP(2) DEFAULT sysdate NOT NULL,
    *   
    *   CONSTRAINT BOARD_ID_PK PRIMARY KEY(BOARD_ID), 
    *   CONSTRAINT USER_ID_FK FOREIGN KEY(USER_ID) REFERENCES MEMBER(USER_ID) );
    */      

   // 추가 선언속성
   private String boardId;
   private String views;
   Date createAt;
   Date updateAt; 
   
   
   
   private String nickname;
   private String title;
   private String imgSrc;
   private String imgName;
   
   public String getViews() {
      return views;
   }
   public void setViews(String views) {
      this.views = views;
   }
   public Date getCreateAt() {
      return createAt;
   }
   public void setCreateAt(Date createAt) {
      this.createAt = createAt;
   }
   public Date getUpdateAt() {
      return updateAt;
   }
   public void setUpdateAt(Date updateAt) {
      this.updateAt = updateAt;
   }
   public String getBoardId() {
      return boardId;
   }
   public void setBoardId(String boardId) {
      this.boardId = boardId;
   }
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
