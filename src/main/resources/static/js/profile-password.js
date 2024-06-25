let isSameCheck = false;

function passwordCheck() {
    let inputPassword = $("#inputPassword").val();

    $.ajax({
        type: "GET",
        url: "/api/password-same-check",
        data: { inputPassword:inputPassword},
        success: (res) => {
            console.log("Server response:", res);  // 서버 응답을 로그로 출력
            if (res.data === true) { // 응답 데이터가 true이면 비밀번호가 일치하는 것
                isSameCheck = true;
                $("#passwordMessage").text("현재 비밀번호가 일치합니다.").css("color", "green");
                $("#newPassword").prop('disabled', false);
                $("#newPasswordCheck").prop('disabled', false);
            } else {
                isSameCheck = false;
                $("#passwordMessage").text("현재 비밀번호가 일치하지 않습니다.").css("color", "red");
                $("#newPassword").prop('disabled', true);
                $("#newPasswordCheck").prop('disabled', true);
            }
        },
        error: (res) => {
            console.error("Error response:", res);  // 오류 응답을 로그로 출력
            $("#passwordMessage").text("비밀번호 확인 중 오류가 발생했습니다.").css("color", "red");
        }
    });
}

function passwordSameCheck() {
    let password = $("#newPassword").val();
    let newPasswordCheck = $("#newPasswordCheck").val();

    if (newPasswordCheck && password === newPasswordCheck) {
        $("#passwordMessage").text("새 비밀번호가 일치합니다.").css("color", "green");
        $("#verifyBtn").prop('disabled', false);
    } else if (newPasswordCheck) {
        $("#passwordMessage").text("새 비밀번호가 일치하지 않습니다.").css("color", "red");
        $("#verifyBtn").prop('disabled', true);
    } else {
        $("#passwordMessage").text("");
        $("#verifyBtn").prop('disabled', true);
    }
}

$(document).ready(function () {
    $("#newPasswordCheck").on('input', passwordSameCheck);
    $("#newPasswordCheck").on('focus', passwordSameCheck);
});