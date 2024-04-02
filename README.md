## 폴더 구조

### ***java 이하 폴더 구조***

```
src/main 
       ├─java
          ├─ member (회원관련)
          │      ├─ controller (url에 따라 요청을 제일 먼저 받아서 처리하는 Servlet 파일 보관)
          │      ├─ service (controller와 dao 사이에서 비즈니스 로직(데이터를 가져와서 2차적으로 가공)을 작성하는 클래스 파일 보관)
          │      ├─ dao (DB와 통신하여 데이터를 가져오고 DTO 객체로 저장하여 서비스 클래스로 전달)
          │      ├─ dto
          │           ├─ request (request 즉, 요청 객체로 사용자가 서버쪽으로 데이터를 전달할 때 받을 DTO 선언)
          │           ├─ response (response 즉, 응답 객체로 DB의 데이터를 해당 DTO로 받아서 최종적으로 사용자에게 반환할 DTO 선언)
          │
          │
          ├─ board (게시판 관련)
          │      ├─ formal
          │      │      ├─ controller
          │      │      ├─ service
          │      │      ├─ dao
          │      │      ├─ dto
          │      │           ├─ request
          │      │           ├─ response
          │      ├─ streat
          │      │      ├─ controller
          │      │      ├─ service
          │      │      ├─ dao
          │      │      ├─ dto
          │      │           ├─ request
          │      │           ├─ response
          │      ├─ workwear
          │      │      ├─ controller
          │      │      ├─ service
          │      │      ├─ dao
          │      │      ├─ dto
          │      │           ├─ request
          │      │           ├─ response
          │      ├─ activewear
          │      │      ├─ controller
          │      │      ├─ service
          │      │      ├─ dao
          │      │      ├─ dto
          │      │           ├─ request
          │      │           ├─ response
          │      ├─ freecycling
          │             ├─ controller
          │             ├─ service
          │             ├─ dao
          │             ├─ dto
          │                  ├─ request
          │                  ├─ response
          │
          │
          ├─ comment (댓글 관련)
          │      ├─ formal
          │      │      ├─ controller
          │      │      ├─ service
          │      │      ├─ dao
          │      │      ├─ dto
          │      │           ├─ request
          │      │           ├─ response
          │      ├─ streat
          │      │      ├─ controller
          │      │      ├─ service
          │      │      ├─ dao
          │      │      ├─ dto
          │      │           ├─ request
          │      │           ├─ response
          │      ├─ workwear
          │      │      ├─ controller
          │      │      ├─ service
          │      │      ├─ dao
          │      │      ├─ dto
          │      │           ├─ request
          │      │           ├─ response
          │      ├─ activewear
          │      │      ├─ controller
          │      │      ├─ service
          │      │      ├─ dao
          │      │      ├─ dto
          │      │           ├─ request
          │      │           ├─ response
          │      ├─ freecycling
          │             ├─ controller
          │             ├─ service
          │             ├─ dao
          │             ├─ dto
          │                  ├─ request
          │                  ├─ response
          │
          │
          ├─ common (프로젝트 전체에서 공통으로 쓸 파일 보관)
          │
          ├─ config (각종 설정파일 보관)

```

</br>

### ***webapp 이하 폴더 구조***


```
src/main 
       ├─webapp 
          ├─ resources (css,image,js 파일 보관)
          │          ├─ css (css 파일 보관)
          │          │    ├─ member
          │          │    ├─ board
          │          │    ├─ comment
          │          │    ├─ common
          │          │
          │          │
          │          ├─ image (image 파일 보관)
          │          │    ├─ member
          │          │    ├─ board
          │          │    ├─ comment
          │          │    ├─ common
          │          │
          │          │
          │          ├─ js (js 파일 보관)
          │               ├─ member
          │               ├─ board
          │               ├─ comment
          │               ├─ common
          │
          │
          │
          ├─ views (jsp 파일 보관)
          │      ├─ member
          │      ├─ board
          │      ├─ comment
          │      ├─ common
          │
          │
          │
          ├─ WEB-INF
          │      ├─ lib
          │      ├─ web.xml
          │
          │
          │
          ├─ META-INF
```