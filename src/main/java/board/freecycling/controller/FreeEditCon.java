package board.freecycling.controller;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;

import board.freecycling.dao.freecyclingBoardDAO;
import board.freecycling.dto.response.FreeOneContentDTO;
import common.SessionUtil;
import member.dto.response.MemberResponse;

@MultipartConfig
@WebServlet("/controller/FreeEditCon")
public class FreeEditCon extends HttpServlet {
	
	private final String LOGIN = "/views/member/login.jsp";
	public final String FREE_EDIT_VIEW = "/views/board/freecycling/freeEditForm.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//수정할 게시물의 번호를 받아서
    	int num = Integer.parseInt(request.getParameter("num"));
    	System.out.println("num="+num);
    	MemberResponse loginMember = SessionUtil.getSessionMember(request);
    	
    	//기존 게시물 내용을 담은 DTO 객체 저장한 다음 Edit.jsp로 포워드
        freecyclingBoardDAO bdao = new freecyclingBoardDAO();
        FreeOneContentDTO onecondto = null;
		try {
			onecondto = bdao.getoneBoard(num);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("onecondto", onecondto);
		
		if (loginMember == null) {
			// 로그인 되지 않은 경우 처리
			request.getRequestDispatcher(LOGIN).forward(request, response);
		} else {
			// 로그인 된 경우에는 글쓰기 폼으로 포워딩
			request.getRequestDispatcher(FREE_EDIT_VIEW).forward(request, response);
		}
    }
  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    	doGet(request,response);
    	
        // 1. 파일 업로드 처리 =============================
        // 업로드 디렉터리의 물리적 경로 확인
 /*       String saveDirectory = req.getServletContext().getRealPath("/Uploads");

        // 초기화 매개변수로 설정한 첨부 파일 최대 용량 확인
        ServletContext application = this.getServletContext();
        int maxPostSize = Integer.parseInt(application.getInitParameter("maxPostSize"));

        // 파일 업로드
        MultipartRequest mr = FileUtil.uploadFile(req, saveDirectory, maxPostSize);

        if (mr == null) {
            // 파일 업로드 실패
            JSFunction.alertBack(resp, "첨부 파일이 제한 용량을 초과합니다.");
            return;
        }

        // 2. 파일 업로드 외 처리 =============================
        // 수정 내용을 매개변수에서 얻어옴
        String idx = mr.getParameter("idx");
        String prevOfile = mr.getParameter("prevOfile");
        String prevSfile = mr.getParameter("prevSfile");

        String name = mr.getParameter("name");
        String title = mr.getParameter("title");
        String content = mr.getParameter("content");
            
        // 비밀번호는 session에서 가져옴
        HttpSession session = req.getSession();
        String pass = (String)session.getAttribute("pass");

        // DTO에 저장
        MVCBoardDTO dto = new MVCBoardDTO();
        dto.setIdx(idx);
        dto.setName(name);
        dto.setTitle(title);
        dto.setContent(content);
        dto.setPass(pass);
            
        // 원본 파일명과 저장된 파일 이름 설정
        String fileName = mr.getFilesystemName("ofile");
        if (fileName != null) {
            // 첨부 파일이 있을 경우 파일명 변경
            // 새로운 파일명 생성
            String now = new SimpleDateFormat("yyyyMMdd_HmsS").format(new Date());
            String ext = fileName.substring(fileName.lastIndexOf("."));
            String newFileName = now + ext;

            // 파일명 변경
            File oldFile = new File(saveDirectory + File.separator + fileName);
            File newFile = new File(saveDirectory + File.separator + newFileName);
            oldFile.renameTo(newFile);

            // DTO에 저장
            dto.setOfile(fileName);  // 원래 파일 이름
            dto.setSfile(newFileName);  // 서버에 저장된 파일 이름

            // 기존 파일 삭제
            FileUtil.deleteFile(req, "/Uploads", prevSfile);
        }
        else {
            // 첨부 파일이 없으면 기존 이름 유지
            dto.setOfile(prevOfile);
            dto.setSfile(prevSfile);
        }

        // DB에 수정 내용 반영
        MVCBoardDAO dao = new MVCBoardDAO();
        int result = dao.updatePost(dto);
        dao.close();

        // 성공 or 실패?
        if (result == 1) {  // 수정 성공
            session.removeAttribute("pass");
            resp.sendRedirect("../mvcboard/view.do?idx=" + idx);
        }
        else {  // 수정 실패
            JSFunction.alertLocation(resp, "비밀번호 검증을 다시 진행해주세요.",
                "../mvcboard/view.do?idx=" + idx);
        }
*/    }
   
}
