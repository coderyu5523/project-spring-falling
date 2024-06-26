$(document).ready(function () {
    function getContent(url, pageCallback) {
        $.ajax({
            url: url,
            method: 'GET',
            dataType: 'json',
            success: function (data) {
                $("#storage-tab-content").html(pageCallback(data.body))
            },
            error: function () {
                alert("데이터 가져오기 실패");
            }
        })
    }

    function updateTabHighlight() {
        const $selectedTab = $('.storage-tab.selected-tab');
        const left = $selectedTab.position().left;
        const width = $selectedTab.outerWidth();
        $('.highlight').css({left: left, width: width});
    }

    $('.storage-tab').click(function () {
        $('.storage-tab').removeClass('selected-tab');
        $(this).addClass('selected-tab');
        updateTabHighlight();

        const tab = $(this).data('tab');
        switch (tab) {
            case 'tab1':
                getContent('/storage/my-list', myList);
                break;
            case 'tab2':
                getContent('/storage/like', likeList);
                break;
            case 'tab3':
                getContent('/storage/latest', latestList);
                break;
        }
    });

    // 내 리스트
    function myList(body) {
        return "<div class=\"storage-tabs-mylist-items\">" + body.map(item => {
            return `
            <div class="storage-tabs-mylist-item">
                <a href="#">
                    <img src="..${item.albumImg}" onerror="this.src='/images/logo_2.png'" alt="Playlist">
                </a>
                <div class="storage-tabs-mylist-item-info">
                    <a href="#">
                        <h3 style="font-weight: 600;">${item.playlistName}</h3>
                    </a>
                    <a href="#">
                        <p>총 ${item.playlistSongCount}곡</p>
                    </a>
                    <a href="#">
                        <p>${item.createdAt}</p>
                    </a>
                    <br>
                    <div class="storage-tabs-mylist-item-icons">
                        <a href="#"><i class="album-icon fas fa-list icon"></i></a>
                        <a href="#"><i class="album-icon fas fa-folder-plus custom-icon"></i></a>
                    </div>
                </div>
            </div>
            `;
        }).join('') + "</div>";
    }

    getContent('/storage/my-list', myList);
    updateTabHighlight();

});