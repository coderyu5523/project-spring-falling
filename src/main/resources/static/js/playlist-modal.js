// 모달 켜는 버튼
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
                console.log("AJAX 응답 데이터:", data);

                // 받은 데이터를 기반으로 리스트 아이템 추가
                modalList.find('.default-item').siblings().remove();
                data.body.forEach(function (item) {
                    let listItem = `
                            <li class="modal-list-item">
                                <img src="${item.albumImg}" alt="default" width="50" height="50">
                                <div>
                                    <div>${item.playlistName}</div>
                                    <div>${item.playlistSongCount}곡</div>
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
});