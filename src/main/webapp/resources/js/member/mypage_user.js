const MYPAGE_PASSWORD_CHANGE_URL = BASE_URL + "/mypage/user-password";
const MYPAGE_USER_URL = BASE_URL + "/mypage/user";

$('#mypage-current-pw').on('keyup', function(e){
    if (e.keyCode === 13 || e.key === "Enter") {
    	$('#login-button').click();
    }
});

$('#mypage-new-pw').on('keyup', function(e){
    if (e.keyCode === 13 || e.key === "Enter") {
    	$('#login-button').click();
    }
});

$('#mypage-new-pw-change').on('keyup', function(e){
    if (e.keyCode === 13 || e.key === "Enter") {
    	$('#login-button').click();
    }
});

$("#profile-password-send-btn").click(function(){
	const memberPassword = {
		currentPw: $("#mypage-current-pw").val(),
		newPw: $("#mypage-new-pw").val(),
		newPwCheck: $("#mypage-new-pw-check").val()
	}
	
	if(memberPassword.currentPw.length == 0) alert("현재 사용하고 계시는 비밀번호를 입력해 주세요.");
	else if(memberPassword.newPw.length == 0) alert("변경할 비밀번호를 입력해 주세요.");
	else if(memberPassword.newPwCheck.length == 0) alert("변경할 비밀번호가 일치하지 않습니다."); 
	else {
	    $.ajax({
	        url: MYPAGE_PASSWORD_CHANGE_URL,
	        type: "POST",
			data: memberPassword,
	        success:function(data){
				if(!!data.errors) {
					if(data.errors.currentPw) markingErrorMessage("#mypage-current-password-inputlist", data.errors.currentPw);
					else deleteErrorMessage("#mypage-current-password-inputlist");
					if(data.errors.password) markingErrorMessage("#mypage-password-inputlist", data.errors.password);
					else deleteErrorMessage("#mypage-password-inputlist");
					if(data.errors.passwordCheck) markingErrorMessage("#mypage-password-check-inputlist", data.errors.passwordCheck);
					else deleteErrorMessage("#mypage-password-check-inputlist");
				}else if(data.success) {
					location.href = MYPAGE_USER_URL;
				}else if(!data.success) {
					alert("서버에 문제가 발생하였습니다. 다시 시도해 주세요.");
				}
			},
	        error:function(jqXHR, textStatus, errorThrown){
				alert("server error");
	        }
	        
	    }); //ajax end
	} //else end

}); //click event end


const markingErrorMessage = function (targetElement, message) {
    const $targetElement = $(targetElement);
    $targetElement.siblings('.password-change-errors-words').remove();
    $targetElement.after('<div class="password-change-errors-words">'+message+'</div>');
};

const deleteErrorMessage = function (targetElement) {
	const $targetElement = $(targetElement);
	$targetElement.siblings('.password-change-errors-words').remove();
}