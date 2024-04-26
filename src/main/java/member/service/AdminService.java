package member.service;

import java.util.List;
import java.util.Map;

import member.dao.AdminDAO;
import member.dto.request.AdminMemberUpdateRequest;
import member.dto.response.AdminMemberResponse;

public class AdminService {
	
	private final AdminDAO adminDao = new AdminDAO();
	
	public int selectMemberCount(Map<String, Object> map) {
		return adminDao.selectCount(map);
	}
	
	public List<AdminMemberResponse> selectListPage(Map<String,Object> map) {
		return adminDao.selectListPage(map);
	}
	
	public List<AdminMemberResponse> getAllMember() {
		return adminDao.selectAllMember();
	}
	
	public boolean updateMemberDetails(AdminMemberUpdateRequest updateMember) {
		return adminDao.updateMember(updateMember);
	}
	
	public boolean deleteMember(int userId) {
		return adminDao.deleteMember(userId);
	}
	
	public static String pagingStr(int totalCount, int pageSize, int blockPage, int pageNum, String reqUrl) {
		String pagingStr="";
		//전체 페이주 수 계산
		//올림처리를 하지 않으면 마지막 페이지의 게시물 5개가 조회가 안되므로 계산된 결과는 올림처리한다.
		//계산식: Math.ceil(전체 게시물수/POSTS_PER_PAGE)
		int totalPages=(int)(Math.ceil((double) totalCount/pageSize));
		
		//이전 페이지 블록 바로가기 출력
		int pageTemp = (((pageNum-1)/blockPage)*blockPage)+1;
		//페이지가 1이 아닐 때에만 첫 페이지와 이전 블록 링크를 출력한다.
		if(pageTemp!=1) {
			pagingStr+="<a href='"+reqUrl+"?pageNum=1'>[첫 페이지]</a>";
			pagingStr+="&nbsp;";
			pagingStr+="<a href='"+reqUrl+"?pageNum="+(pageTemp-1)+"'>[이전블록]</a>";
		}
		//각 페이지 번호 출력
        int blockCount = 1;
        while (blockCount <= blockPage && pageTemp <= totalPages) {
            if (pageTemp == pageNum) {
                //현재 페이지는 링크를 걸지 않음
                pagingStr += "&nbsp;" + pageTemp + "&nbsp;";
            } else {
                pagingStr += "&nbsp;<a href='" + reqUrl + "?pageNum=" + pageTemp
                             + "'>" + pageTemp + "</a>&nbsp;";
            }
            //pageTemp를 1씩 증가 시키면서 페이지 바로가기를 출력한다.
            pageTemp++;
            blockCount++;
        }

        //pageTemp가 전체 페이지 수 이하일 때 다음 블록과 마지막 페이지 링크를 출력한다. 
        //[마지막 페이지]가 포함된 블록으로 이동하면 이 영역은 출력되지 않는다.
        //마지막 페이지로 바로가기 링크는 PageNum값으로 전체 페이지수를 사용한다.
        //다음 페이지 블록 바로가기 출력
        if (pageTemp <= totalPages) {
            pagingStr += "<a href='" + reqUrl + "?pageNum=" + pageTemp
                         + "'>[다음 블록]</a>";
            pagingStr += "&nbsp;";
            pagingStr += "<a href='" + reqUrl + "?pageNum=" + totalPages
                         + "'>[마지막 페이지]</a>";
        }

        return pagingStr;
    }
	
	public static String pagingStr(int totalCount, int pageSize, int blockPage, int pageNum, String reqUrl, String searchWord) {
		String pagingStr="";
		//전체 페이주 수 계산
		//올림처리를 하지 않으면 마지막 페이지의 게시물 5개가 조회가 안되므로 계산된 결과는 올림처리한다.
		//계산식: Math.ceil(전체 게시물수/POSTS_PER_PAGE)
		int totalPages=(int)(Math.ceil((double) totalCount/pageSize));
		
		//이전 페이지 블록 바로가기 출력
		int pageTemp = (((pageNum-1)/blockPage)*blockPage)+1;
		//페이지가 1이 아닐 때에만 첫 페이지와 이전 블록 링크를 출력한다.
		if(pageTemp!=1) {
			pagingStr+="<a href='"+reqUrl+"?pageNum=1" + "&searchWord=" + searchWord + "'>[첫 페이지]</a>";
			pagingStr+="&nbsp;";
			pagingStr+="<a href='"+reqUrl+"?pageNum="+(pageTemp-1) + "&searchWord="+ searchWord + "'>[이전블록]</a>";
		}
		//각 페이지 번호 출력
        int blockCount = 1;
        while (blockCount <= blockPage && pageTemp <= totalPages) {
            if (pageTemp == pageNum) {
                //현재 페이지는 링크를 걸지 않음
                pagingStr += "&nbsp;" + pageTemp + "&nbsp;";
            } else {
                pagingStr += "&nbsp;<a href='" + reqUrl + "?pageNum=" + pageTemp  + "&searchWord="+ searchWord
                             + "'>" + pageTemp + "</a>&nbsp;";
            }
            //pageTemp를 1씩 증가 시키면서 페이지 바로가기를 출력한다.
            pageTemp++;
            blockCount++;
        }

        //pageTemp가 전체 페이지 수 이하일 때 다음 블록과 마지막 페이지 링크를 출력한다. 
        //[마지막 페이지]가 포함된 블록으로 이동하면 이 영역은 출력되지 않는다.
        //마지막 페이지로 바로가기 링크는 PageNum값으로 전체 페이지수를 사용한다.
        //다음 페이지 블록 바로가기 출력
        if (pageTemp <= totalPages) {
            pagingStr += "<a href='" + reqUrl + "?pageNum=" + pageTemp  + "&searchWord="+ searchWord
                         + "'>[다음 블록]</a>";
            pagingStr += "&nbsp;";
            pagingStr += "<a href='" + reqUrl + "?pageNum=" + totalPages  + "&searchWord="+ searchWord
                         + "'>[마지막 페이지]</a>";
        }

        return pagingStr;
    }
	
}
