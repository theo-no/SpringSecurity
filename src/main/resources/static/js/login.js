//ajax 호출 공통 함수
function sendAjaxRequest(url, type, requestData, responseType, params,
	successCallback, errorCallback){
	var options = {
	    url: url ,
	    type: type,
	    contentType: "application/json",
	    headers: {
	      "Authorization": "Bearer " + localStorage.getItem('accessToken')
	    },
	    success: successCallback,
	    error: errorCallback
	  };
    // responseType이 null이 아닌 경우에만 dataType을 "json"으로 설정
    if (responseType !== null) {
      options.dataType = responseType;
    }
    // data가 null이 아닌 경우에만 options에 data 추가
    if (requestData !== null) {
    	options.data = JSON.stringify(requestData);
    }
    // params가 null이 아닌 경우에만 URL의 쿼리 파라미터로 추가
	if (params !== null && typeof params === 'object' && Object.keys(params).length > 0) {
	    var queryParams = new URLSearchParams(params);
	    options.url += '?' + queryParams.toString();
	}
    // Ajax 요청 보내기
    $.ajax(options);
}


let id = $('#id');
let pw = $('#pw');
let btn = $('#btn');

$(btn).on('click', function(){
    //여기서 id pw로 db에 있는지 확인해보자.
    // id와 pw를 가지는 UserDto 객체 생성
    console.log("버튼 클릭");
    var loginRequest = {
        userId: $(id).val(),
        password: $(pw).val()
    };
    sendAjaxRequest(
        "/login",
        "POST",
        loginRequest,
        "json",
        null,
        function(response){
            if (Object.keys(response).length === 0) {
                // response가 비어 있는 경우 처리할 로직 작성
                alert("로그인 실패");
            }else{
                console.log(response);
                alert("로그인 성공");
                //accessToken을 local Storage에 저장
                localStorage.setItem('userId', response.userId);
                console.log("userId 저장");
                //window.location.href = "/sample/grid?lang="+sessionStorage.getItem('locale');
                window.location.replace("/home");
            }
        },
        function(xhr,status,error){
            console.log("xhr: "+xhr.responseJSON+" status: "+status+"error: "+error);
            //alert(xhr.responseJSON.errorMsg);
        }
    )
});
