const btnComfirm = document.querySelector(".btn_comfirm");

btnComfirm.onclick = () => {
    const accountInpus = document.querySelectorAll(".account_inputs");

    let user = {
        userName: accountInpus[0].value,
        password: accountInpus[1].value,
        passwordChk: accountInpus[2].value,
        name: accountInpus[3].value,
        email: accountInpus[4].value,
        phoneNum: accountInpus[5].value,
        number: accountInpus[6].value,
        address: accountInpus[7].value
    }

    $.ajax({
        async: false,
        type: "post",
        url: "/api/account/join",
        contentType: "application/json",
        data: JSON.stringify(user),
        dataType: "json",
        success: (response, textStatus, request) => {
            alert("회원가입 요청 성공");
            console.log(response);
            const successURI = request.getResponseHeader("Location");
            location.replace(successURI + "?username=" + response.data)
        },
        error: (error) => {
            alert("회원가입 요청 실패");
            console.log(error.responseJSON.data);
            loadErrorMassage(error.responseJSON.data);
        }
    });
}

function loadErrorMassage(errors) {
    const errorList = document.querySelector(".errors")
    const errorMsgs = document.querySelector(".error-msgs")
    const errorArray = Object.values(errors)
    
    errorMsgs.innerHTML = "";

    errorArray.forEach(error => {
        errorMsgs.innerHTML += `
        <li>${error}</li>
        `;
    });

    errorList.classList.remove("errors-invisible");

}