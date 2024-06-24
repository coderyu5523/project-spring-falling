$(document).ready(function () {
    let btn = $("#myBtn");
    let modal = $("#myModal");
    let modalList = $("#modal-list");

    // 닫기 버튼
    let closeButton = $(".close");

    // 모달 켜는 기능
    btn.click(function () {
        $.ajax({
            url: '/storage/my-list',
            method: 'GET',
            dataType: 'json',
            success: function (data) {
                // 받은 데이터를 기반으로 리스트 아이템 추가
                modalList.find('.default-item').siblings().remove();
                data.body.forEach(function (item) {
                    let listItem = `
                            <li class="modal-list-item">
                                <img src="${item.albumImg}" alt="default" width="50" height="50">
                                <div>
                                    <div>${item.playlistName}</div>
                                    <div>${item.playlistSongCount}곡</div>
                                    <input type="hidden" class="playlist-id" value="${item.playlistId}">
                                    <!-- songId를 전역적으로 가진 input -->
                                </div>
                            </li>`;
                    modalList.append(listItem);
                });

                modal.css("display", "block");
            },
            error: function (xhr, status, error) {
                console.error("AJAX 오류:", error);
            }
        });
    });

    // 닫기 버튼 기능
    closeButton.click(function () {
        modal.css("display", "none");
    });

    // 모달 밖 어딜 눌러도 모달이 꺼지게 하는 설정
    $(window).click(function (event) {
        if (event.target === modal[0]) {
            modal.css("display", "none");
        }
    });

    // modal-list-item 클릭 이벤트
    modalList.on('click', '.modal-list-item', function () {
        let playlistId = $(this).find('.playlist-id').val();
        let songId = $("#songIdInput").val(); // 전역적으로 존재하는 songId 값을 가져옴

        addSongToPlaylist(playlistId, songId);
    });

    function addSongToPlaylist(playlistId, songId) {
        let formData = new FormData();
        formData.append('playlistId', playlistId);
        formData.append('songId', songId);

        $.ajax({
            url: "/add-song",
            method: "POST",
            processData: false,
            contentType: false,
            data: formData,
            cache: false,
            success: function (data) {
                console.log("status : " + data.status)
                if (data.status === 200) {
                    modal.css("display", "none");
                    alert("플레이리스트에 곡이 추가 되었습니다.");
                } else if (data.status === 400) {
                    alert(data.msg);
                }
            },
            error: function () {
                alert("서버 요청 중 오류가 발생했습니다.");
            }
        });
    }
});
