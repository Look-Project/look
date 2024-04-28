const ID_CHECK_URL = BASE_URL + "/member/id-check";
const NICKNAME_CHECK_URL = BASE_URL + "/member/nickname-check";
const LOGIN_PAGE_URL = BASE_URL +"/member/login";
const MEMBER_SIGNUP_URL = BASE_URL + "/member/signup";

let duplicateIdCheck = false;
let duplicateNicknameCheck = false;

$("#signup-form-id-duplicate-check").click(function(){
    
    $.ajax({
        url: ID_CHECK_URL,
        type: "post",
		data: {loginId: $("#signup-form-id-input").val()},
        success:function(data){
			if(!!data.errors) {
				if(data.errors.loginId) markingErrorMessage("#signup-form-id-inputlist", data.errors.loginId);
				else deleteErrorMessage("#signup-form-id-inputlist");
			}else if(data.success){
				duplicateIdCheck = true;
				deleteErrorMessage("#signup-form-id-inputlist");
				alert("사용 가능한 아이디입니다.");
			}else if(!data.success) {
				duplicateIdCheck = false;
				alert("중복된 아이디입니다.");
			}
        },
        error:function(){
            alert("error");
        }
        
    }); //ajax end

}); //click event end


$("#signup-form-nickname-duplicate-check").click(function(){
    
    $.ajax({
        url: NICKNAME_CHECK_URL,
        type: "post",
		data: {nickname: $("#signup-form-nickname-input").val()},
        success:function(data){
			if(!!data.errors) {
				if(data.errors.nickname) markingErrorMessage("#signup-form-nickname-inputlist", data.errors.nickname);
				else deleteErrorMessage("#signup-form-nickname-inputlist");
			}else if(data.success){
				duplicateNicknameCheck = true;
				deleteErrorMessage("#signup-form-nickname-inputlist");
				alert("사용 가능한 닉네임입니다.");
			}else if(!data.success) {
				duplicateNicknameCheck = false;
				alert("중복된 닉네임입니다.");
			}
        },
        error:function(){
            alert("error");
        }
        
    }); //ajax end

}); //click event end

$("#signup-button").click(function(){
	
	const member = {
		loginId: $("#signup-form-id-input").val(),
		nickname: $("#signup-form-nickname-input").val(),
		password: $("#signup-form-pw-input").val(),
		passwordCheck: $("#signup-form-pw-check-input").val()
	}
	
	if(!duplicateIdCheck) alert("아이디 중복 확인을 해주세요.");
	else if(!duplicateNicknameCheck) alert("닉네임 중복 확인을 해주세요.");
	else {
	    $.ajax({
	        url: MEMBER_SIGNUP_URL,
	        type: "POST",
			data: member,
	        success:function(data){
				
				if(!!data.errors) {
					if(data.errors.loginId) markingErrorMessage("#signup-form-id-inputlist", data.errors.loginId);
					else deleteErrorMessage("#signup-form-id-inputlist");
					if(data.errors.nickname) markingErrorMessage("#signup-form-nickname-inputlist", data.errors.nickname);
					else deleteErrorMessage("#signup-form-nickname-inputlist");
					if(data.errors.password) markingErrorMessage("#signup-form-password-inputlist", data.errors.password);
					else deleteErrorMessage("#signup-form-paassword-inputlist");
					if(data.errors.passwordCheck) markingErrorMessage("#signup-form-password-check-inputlist", data.errors.passwordCheck);
					else deleteErrorMessage("#signup-form-password-check-inputlist");
				}else if(data.duplicatedLoginId) {
					alert("아이디가 중복입니다.");
				}else if(data.duplicatedNickname) {
					alert("닉네임이 중복입니다.");
				}else if(data.success) {
					location.href = LOGIN_PAGE_URL;
				}else if(!data.success) {
					alert("서버에 문제가 발생하였습니다. 다시 시도해 주세요.");
				}
	
		},
	        error:function(){
	            alert("error");
	        }
	        
	    }); //ajax end
	} //else end

}); //click event end


const markingErrorMessage = function (targetElement, message) {
    const $targetElement = $(targetElement);
    $targetElement.siblings('.signup-errors-words').remove();
    $targetElement.after('<div class="signup-errors-words">'+message+'</div>');
};

const deleteErrorMessage = function (targetElement) {
	const $targetElement = $(targetElement);
	$targetElement.siblings('.signup-errors-words').remove();
}