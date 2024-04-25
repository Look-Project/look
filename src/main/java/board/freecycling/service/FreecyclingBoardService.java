package board.freecycling.service;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import board.freecycling.dao.freecyclingBoardDAO;
import board.freecycling.dto.request.FreeEditDTO;
import board.freecycling.dto.request.FreeInsertDTO;
import board.freecycling.dto.response.FreeMainListDTO;
import board.freecycling.dto.response.FreeOneContentDTO;
import common.SessionUtil;
import member.dto.response.MemberResponse;

public class FreecyclingBoardService {
	
	freecyclingBoardDAO bdao = new freecyclingBoardDAO();
	
	//게시글 입력 메소드
	public void freeInsertService(FreeInsertDTO dto) {
		bdao.insertBoard(dto);
	}
	
	
	//게시글 리스트 출력 메소드
	public List<FreeMainListDTO> freeMainListService() { 
		return bdao.mainListBoard();
	}
	
	
	//상세게시글 리스트 출력 메소드
	public FreeOneContentDTO freeOneContentService(int num) throws SQLException { 
		return bdao.getoneBoard(num);
	}
	
	
	//게시글 수정 메소드 서비스
	public int freeEditService(FreeEditDTO dto) {
		return bdao.updateBoard(dto);
	}
	
	
	//게시글 삭제 메소드 서비스
		public int freeDelService(int num) throws SQLException {
			return bdao.deleteBoard(num);
		}

	//로그인 멤버 본인검증
	
		    public static boolean isMemberValid(HttpServletRequest request, String nickname) {
		    	SessionUtil session = new SessionUtil();
		        MemberResponse sessionMember = SessionUtil.getSessionMember(request);
		        
		        // 세션에서 회원 정보를 가져와서 닉네임과 비교하여 검증
		        if (sessionMember != null && nickname != null && nickname.equals(sessionMember.getNickname())) {
		            return true; // 회원이 유효한 경우
		        } else {
		            return false; // 회원이 유효하지 않은 경우
		        }
		    
		    }
		    }
