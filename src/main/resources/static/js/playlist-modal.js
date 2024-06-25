$(document).ready(function () {
    let btn = $("#myBtn");
    let modal = $("#myModal");
    let modalList = $("#modal-list");
    let newListBtn = $(".default-item");
    let prevNewListBtn = newListBtn.html();

    // 닫기 버튼
    let closeButton = $(".close");

    // 새로운 리스트 추가 복원
    function changeToPrev() {
        newListBtn.html(prevNewListBtn);
    }

    // 새로운 리스트 추가
    function addNewPlaylist() {
        let formData = new FormData($("#playlist-save-form")[0]);
        $.ajax({
            url: "/add-playlist",
            method: "POST",
            processData: false,
            contentType: false,
            type: "json",
            data: formData,
            success: function (data) {
                newListBtn.after(
                    `<li class="modal-list-item">
                                <img class="my-playlist-img" src="/images/logo_2.png" alt="default" width="50" height="50">
                                <div>
                                    <div>${data.body.playlistName}</div>
                                    <div>0곡</div>
                                    <input type="hidden" class="playlist-id" value="${data.body.playlistId}">
                                    <!-- songId를 전역적으로 가진 input -->
                                </div>
                            </li>`
                );
                changeToPrev();
            },
            error: function () {
                alert("알수없는 플레이리스트 저장 오류");
            }
        })
    }

    $(".my-playlist-img").onerror = function () {
        this.src = "/images/logo_2.png";
    }

    // 동적으로 생성된 요소에 이벤트 위임
    modalList.on('click', '.default-item', function (event) {
        if ($(event.target).closest('#newPlaylist').length === 0 && $(event.target).closest('#save-btn').length === 0 && $(event.target).closest('#cancel-btn').length === 0) {
            $(this).html(`
                <form id="playlist-save-form">
                    <span><input id="new-playlist-name" name="playlistName" type='text' required></span>
                    <span><button type="button" id='save-btn'>저장</button></span>
                    <span><button type="button" id='cancel-btn'>취소</button></span>
                </form>
            `);
            $("#new-playlist-name").focus();
        }
    });

    // 저장 버튼에 기능 추가
    modalList.on('click', '#save-btn', function (event) {
        event.stopPropagation();
        addNewPlaylist();
    })

    // 동적으로 생성된 '취소' 버튼에 이벤트 핸들러 바인딩
    modalList.on('click', '#cancel-btn', function (event) {
        event.stopPropagation(); // 이벤트 전파 중지
        console.log("Cancel button clicked");
        changeToPrev();
    });

    // 동적으로 생성된 '저장' 버튼에 이벤트 핸들러 바인딩
    modalList.on('click', '#save-btn', function (event) {
        event.stopPropagation(); // 이벤트 전파 중지
        console.log("Save button clicked");
        // 저장 로직 추가
    });

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
                                <img class="my-playlist-img" onerror="this.src='/images/logo_2.png'" src="${item.albumImg}" alt="default" width="50" height="50">
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
        changeToPrev();
    });

    // 모달 밖 어딜 눌러도 모달이 꺼지게 하는 설정
    $(window).click(function (event) {
        if (event.target === modal[0]) {
            modal.css("display", "none");
            changeToPrev();
        }
    });

    // modal-list-item 클릭 이벤트
    modalList.on('click', '.modal-list-item', function () {
        let playlistId = $(this).find('.playlist-id').val();
        let songId = $("#songIdInput").val(); // 전역적으로 존재하는 songId 값을 가져옴

        addSongToPlaylist(playlistId, songId);
    });

    // 플레이리스트에 곡 추가하기
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
