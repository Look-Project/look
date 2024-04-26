const MEMBER_UPDATE_URL = BASE_URL + "/mypage/admin/member-update";

function modifyMember(userId, rowNo) {
    let adminYn = document.getElementById('adminYn_' + rowNo).value;
    let nickname = document.getElementById('nickname_' + rowNo).value;

	const memberUpdate = {
		userId : userId,
		adminYn: adminYn,
		nickname: nickname
	}
	
    $.ajax({
        url: MEMBER_UPDATE_URL,
        type: "POST",
		data: memberUpdate,
        success:function(data){
				if(!!data.errors) {
					if(data.errors.nickname) {
						alert(data.errors.nickname);
					}
				}else if(data.duplicatedNickname) {
					alert("닉네임이 중복입니다.");
				}else if(data.success) {
					alert("수정이 완료되었습니다.");
				}else if(!data.success) {
					alert("서버에 문제가 발생하였습니다. 다시 시도해 주세요.");
				}
		},
        error:function(jqXHR, textStatus, errorThrown){
			alert("server error");
        }
        
    }); //ajax end
}
