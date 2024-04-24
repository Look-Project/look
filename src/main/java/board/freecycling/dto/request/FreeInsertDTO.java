package board.freecycling.dto.request;


public class FreeInsertDTO {

			
		private int memberId;
		
		private String title;
		private String contents;
		
		private String imgSrc;
		private String imgName;
		
		
		


		public int getMemberId() {
			return memberId;
		}
		public void setMemberId(int memberId) {
			this.memberId = memberId;
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
		
		
	}

