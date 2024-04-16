const MEMBER_LOGIN_URL = BASE_URL + "/member/login";
const MAIN_PAGE_URL = BASE_URL + "/views/common/header.jsp";

$("#login-button").click(function(){
	
	const member = {
		loginId: $("#login-form-id-input").val(),
		password: $("#login-form-pw-input").val()
	}
	
	if(member.loginId.length == 0) alert("아이디를 입력해 주세요.");
	else if(member.password.length == 0) alert("비밀번호를 입력해 주세요.");
	else {
	    $.ajax({
	        url: MEMBER_LOGIN_URL,
	        type: "POST",
			data: member,
	        success:function(data){			
				if(!!data.error) {
					markingErrorMessage("#login-form-password-div", data.error);
				}else {					
					location.href = MAIN_PAGE_URL;
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
    $targetElement.siblings('.login-errors-words').remove();
    $targetElement.after('<div class="login-errors-words">'+message+'</div>');
};
