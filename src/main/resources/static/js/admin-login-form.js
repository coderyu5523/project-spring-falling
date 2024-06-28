$(document).ready(function () {
    // 페이지 로드 시 저장된 이메일이 있다면 이메일 입력란에 자동으로 설정
    let rememberedAdminEmail = localStorage.getItem("rememberedAdminEmail");
    if (rememberedAdminEmail) {
        $("#email").val(rememberedAdminEmail);
        $("#remember-id").prop("checked", true);
    }

    // 아이디 기억하기 체크박스 클릭 시 동작
    $("#remember-id").change(function () {
        // 체크박스 상태 확인
        var isChecked = $(this).prop("checked");

        // 이메일 입력란의 값 가져오기
        var adminEmail = $("#email").val();

        if (isChecked) {
            // 체크되었을 때 이메일을 로컬 스토리지에 저장
            localStorage.setItem("rememberedAdminEmail", adminEmail);
        } else {
            // 체크 해제되었을 때 로컬 스토리지에서 이메일 삭제
            localStorage.removeItem("rememberedAdminEmail");
        }
    });
});
