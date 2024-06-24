function passwordSameCheck() {
    let password = $("#newPassword").val();
    let newPasswordCheck = $("#newPasswordCheck").val();

    if (newPasswordCheck && password === newPasswordCheck) {
        $("#passwordMessage").text("비밀번호가 일치합니다.").css("color", "green");
        $("#verifyBtn").prop('disabled', false);
    } else if (newPasswordCheck) {
        $("#passwordMessage").text("비밀번호가 일치하지 않습니다.").css("color", "red");
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