package board.freecycling.service;

import javax.servlet.http.HttpServletRequest;

import board.freecycling.dao.freecyclingBoardDAO;
import board.freecycling.dto.response.FreeOneContentDTO;
import common.SessionUtil;
import member.dto.response.MemberResponse;

public class authMember {
	
	public boolean equalMem(HttpServletRequest request) {
	SessionUtil session = new SessionUtil();
	freecyclingBoardDAO dao = new freecyclingBoardDAO();
	 //세션에서 로그인 회원 정보 가져오기
    MemberResponse loginMember = SessionUtil.getSessionMember(request);

    // 게시글 ID를 파라미터에서 추출합니다.
    String nickname = request.getParameter("nickname");

    // 4. 게시글 작성자 정보를 DB에서 가져옵니다.
    FreeOneContentDTO dto = dao.getoneBoard(0)
    MemberResponse postWriter = getPostWriterInfo(postDTO.getWriterId()); // 실제 구현 필요

    // 5. 로그인 회원의 닉네임과 게시글 작성자의 닉네임이 일치하는지 확인합니다.
    if (!loginMember.getNickname().equals(postWriter.getNickname())) {
        // 닉네임이 일치하지 않으면 에러 처리
        return;
    }
  
}
	
}
