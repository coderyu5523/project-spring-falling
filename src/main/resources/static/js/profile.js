$(document).ready(function () {
    function activateTab(tabId) {
        // 모든 탭과 콘텐츠를 비활성화
        $('.tab').removeClass('active');
        $('.content').hide();

        // 선택된 탭과 콘텐츠를 활성화
        $(`.tab[data-tab="${tabId}"]`).addClass('active');
        $(`#${tabId}`).show();
    }

    // 탭 클릭 이벤트 리스너 설정
    $('.tab').click(function () {
        var tabId = $(this).data('tab');
        activateTab(tabId);
    });

    // 페이지 로드 시 첫 번째 탭 활성화
    activateTab('tab1');

    // 비밀번호 확인 함수
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

    // 비밀번호 일치 확인 함수
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

    // 전화번호 변경
    function changePhone() {
        let phone = $("#Phone").val();
        $.ajax({
            type: "put",
            url: "/users",
            data: {phone: phone}
        }).done((res) => {
            alert("전화번호가 변경 완료되었습니다.")
        }).fail((res) => {
            alert("전화번호가 변경 중 오류가 발생했습니다.")

        });
    }


    // 비밀번호 변경
    function changePassword() {
        if (isSameCheck) {
            let password = $("#password").val();
            $.ajax({
                type: "put",
                url: "/users",
                data: {password: password}
            }).done((res) => {
                alert("비밀번호가 변경 완료되었습니다.")
            }).fail((res) => {
                alert("비밀번호 변경 중 오류가 발생했습니다.")
            });
        } else {
            alert("현재 비밀번호가 일치하지 않습니다.")
        }
    }

    // 이벤트 리스너 설정
    $("#passwordCheck").on('input', passwordSameCheck);
    $("#passwordCheck").on('focus', passwordSameCheck);
    $("#inputPassword").on('change', passwordCheck);
    $("#verifyBtn").on('click', changePassword);
    $("#phoneVerifyBtn").on('click',changePhone)
});
