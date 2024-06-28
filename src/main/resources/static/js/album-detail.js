$(document).ready(function () {
    let albumAbout = $("#album-about"); // 앨범 상세정보
    let albumSongList = $("#album-song-list"); // 앨범 수록곡
    let albumAboutTab = $(".album-list-album-detail"); // 앨범 상세정보 탭
    let albumSongs = $(".album-list-album-songs"); // 앨범 수록곡 탭
    let albumLike = $("#album-like"); // 앨범 좋아요 여부 (boolean)
    let albumId = $("#album-id"); // 앨범 id

    // 탭을 바꿨을 때 선택된 탭에 따른 내용 보여지게 하기
    function appearContent(tab) {
        tab.siblings().css("display", "none");
        tab.css("display", "block");
    }

    // 선택된 탭 스타일 변경(클래스 추가, 제거)
    function selectTab(tab) {
        tab.siblings().removeClass("album-selected-tab");
        tab.addClass("album-selected-tab");
    }

    // 탭 버튼에 함수 추가
    $(".album-list-tab-button").on("click", "button", function () {
        switch ($(this).data("tab")) {
            case "album-about":
                appearContent(albumAbout);
                selectTab(albumAboutTab);
                break;
            case "album-song-list":
                appearContent(albumSongList);
                selectTab(albumSongs);
                break;
        }
    });

    // 좋아요 나타나게 하기(true, false)
    function likeButtonAppear(value) {
        switch (value.val()) {
            case 'true':
                $(value).siblings().remove(".like-icons");
                $(value).after("<a class='like-icons' href='#'><i id='liked-album' class='album-list-btn-add-like fas fa-heart'></i></a>");
                doLike("DELETE", "좋아요 취소 실패", "false");
                break;
            case 'false':
                $(value).siblings().remove(".like-icons");
                $(value).after("<a class='like-icons' href='#'><i id='unliked-album' class='album-list-btn-add-like fa-regular fa-heart'></i></a>");
                doLike("POST", "좋아요 실패", "true");
                break;
        }
    }

    // 좋아요, 좋아요 취소
    function doLike(method, failMsg, value) {
        $(".like-icons").click(function () {
            $.ajax({
                url: "/albums/like",
                method: method,
                contentType: "application/json",
                data: JSON.stringify(albumId.val()),
                success: function () {
                    albumLike.val(value);
                    likeButtonAppear(albumLike);
                },
                error: function () {
                    alert(failMsg);
                }
            })
        });
    }

    // 좋아요 초기상태
    likeButtonAppear(albumLike);
});
