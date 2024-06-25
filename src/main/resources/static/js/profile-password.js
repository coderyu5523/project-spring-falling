let isSameCheck = false;

function passwordCheck() {
    let inputPassword = $("#inputPassword").val();

    $.ajax({
        type: "get",
        url: "/api/password-same-check",
        data: {inputPassword: inputPassword}
    }).done((res) => {
        if (res.body === true) {
            isSameCheck = true;
            $("#passwordMessage1").text("현재 비밀번호가 일치합니다.").css("color", "green");
        } else {
            isSameCheck = false;
            $("#passwordMessage1").text("현재 비밀번호가 일치하지 않습니다.").css("color", "red");
        }
    }).fail((res) => {
        $("#passwordMessage1").text(res.responseJSON.msg).css("color", "red");
    });
}

function passwordSameCheck() {
    let password = $("#password").val();
    let passwordCheck = $("#passwordCheck").val();

    if (password === passwordCheck) {
        $("#passwordMessage2").text("비밀번호가 일치합니다.").css("color", "green");
        $("#verifyBtn").prop('disabled', false);
    } else {
        $("#passwordMessage2").text("비밀번호가 일치하지 않습니다.").css("color", "red");
        $("#verifyBtn").prop('disabled', true);
    }
}

function changePassword() {
    if (isSameCheck) {
        let password = $("#password").val();
        $.ajax({
            type: "put",
            url: "/users",
            data: {password: password}
        }).done((res) => {
            $("#passwordMessage2").text("비밀번호가 성공적으로 변경되었습니다.").css("color", "green");
        }).fail((res) => {
            $("#passwordMessage2").text("비밀번호 변경 중 오류가 발생했습니다.").css("color", "red");
        });
    } else {
        $("#passwordMessage2").text("현재 비밀번호가 일치하지 않습니다.").css("color", "red");
    }
}

$(document).ready(function () {
    $("#passwordCheck").on('input', passwordSameCheck);
    $("#passwordCheck").on('focus', passwordSameCheck);
});
