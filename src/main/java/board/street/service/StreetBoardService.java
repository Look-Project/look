package board.street.service;

import java.util.List;
import board.street.dao.StreetDAO;
import board.street.dto.request.StreetWriteRequest;
import board.street.dto.response.StreetBoardListResponse;

public class StreetBoardService {
   
   StreetDAO sdao = new StreetDAO();
   
   /***
    * @param   StreetWriteRequest     Street 게시글을 저장하는 Request객체
    * @return
    */
//   public void post(VintageWriteRequest swr){
//      vdao.insertBoard(vwr);
//   }
   
   /***
    * @param   
    * @return List                  Street 게시글에 관한 목록 
    */   
   public List<StreetBoardListResponse> getAllBoard() {
      return sdao.getAllBoard();
   }

public void post(StreetWriteRequest vwr) {
	// TODO Auto-generated method stub
	
}

public Object getDetailBoard(int boardId) {
	// TODO Auto-generated method stub
	return null;
}
}