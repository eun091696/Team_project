const loginButton = document.querySelector(".login-button");

loginButton.onclick = () => {
    const logId = document.querySelector(".loginId");
    const logPwd = document.querySelector(".loginPwd");

    let user = {
        userName: logId.value,
        password: logPwd.value 
    }

    let ajaxOption = {
        async: false, //동기, 비동기 처리
        type: "post",
        url: "/api/account/login",
        data: user,
        dataType: "json",
        success: (response) => {
            alert("로그인 요청 성공");
        },
        error: (error) => {
            alert("로그인 요청 실패");
        }
    }

    $.ajax(ajaxOption);
}