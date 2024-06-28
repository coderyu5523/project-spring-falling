$(document).ready(function () {
    let songLike = $("#song-like"); // 곡 좋아요 여부 (boolean)
    let songId = $("#song-id"); // 곡 id

    // 좋아요 나타나게 하기(true, false)
    function likeButtonAppear(value) {
        switch (value.val()) {
            case 'true':
                $(value).siblings().remove(".like-icons");
                $(value).after("<a class='like-icons' href='#'><i id='liked-song' class='song-detail-btn-add-like fas fa-heart'></i></a>");
                doLike("DELETE", "좋아요 취소 실패", "false");
                break;
            case 'false':
                $(value).siblings().remove(".like-icons");
                $(value).after("<a class='like-icons' href='#'><i id='unliked-song' class='song-detail-btn-add-like fa-regular fa-heart'></i></a>");
                doLike("POST", "좋아요 실패", "true");
                break;
        }
    }

    // 좋아요, 좋아요 취소
    function doLike(method, failMsg, value) {
        $(".like-icons").click(function () {
            $.ajax({
                url: "/songs/like",
                method: method,
                contentType: "application/json",
                data: JSON.stringify(songId.val()),
                success: function () {
                    songLike.val(value);
                    likeButtonAppear(songLike);
                },
                error: function () {
                    alert(failMsg);
                }
            })
        });
    }

    // 좋아요 초기 상태
    likeButtonAppear(songLike);
});