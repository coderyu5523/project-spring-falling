// 체크박스를 모두 체크/해제
function toggleAllCheckboxes(checked) {
    var checkboxes = document.querySelectorAll('.artist-main-table-body input[type="checkbox"]');
    checkboxes.forEach(function (checkbox) {
        checkbox.checked = checked;
    });
}

// 상위 체크박스 클릭 시 모든 하위 체크박스 체크/해제
var masterCheckbox = document.querySelector('.artist-main-table-header input[type="checkbox"]');
masterCheckbox.addEventListener('change', function () {
    toggleAllCheckboxes(this.checked);
});

$(document).ready(function () {
    // 초기화: 모든 옵션 초기화
    var selectedCategory = localStorage.getItem('selectedCategory') || "";
    var selectedOrderBy = localStorage.getItem('selectedOrderBy') || "";
    var artistId = $('#artist-id').val();
    let artistLike = $("#artist-like"); // 아티스트 좋아요 여부 (boolean)

    // 저장된 값을 불러와서 적용
    if (selectedCategory) {
        $('.artist-album-list-filter-album-category p[data-keyword="' + selectedCategory + '"]').addClass('active');
    }
    if (selectedOrderBy) {
        $('.artist-album-list-filter-order-by p[data-orderby="' + selectedOrderBy + '"]').addClass('active');
    }

    // 전체, 정규/싱글, 참여 중 하나만 선택되도록 처리
    $('.artist-album-list-filter-album-category p').click(function (e) {
        e.preventDefault();
        var keyword = $(this).data('keyword');

        // 기존 선택 제거
        $('.artist-album-list-filter-album-category p').removeClass('active');
        $(this).addClass('active');

        // 선택된 카테고리 저장
        selectedCategory = keyword;

        // 필터링 함수 호출
        filterAlbums(selectedCategory, selectedOrderBy);
    });

    // 최신순, 인기순, 가나다순 중 하나만 선택되도록 처리
    $('.artist-album-list-filter-order-by p').click(function (e) {
        e.preventDefault();
        var orderBy = $(this).data('orderby');

        // 기존 선택 제거
        $('.artist-album-list-filter-order-by p').removeClass('active');
        $(this).addClass('active');

        // 선택된 정렬 순서 저장
        selectedOrderBy = orderBy;

        // 필터링 함수 호출
        filterAlbums(selectedCategory, selectedOrderBy);
    });


    function filterAlbums(category, orderBy) {
        console.log("Filtering songs by:", category, "Order by:", orderBy);
        getContent('/' + artistId + '/sort-and-filter/songs', songs);
    }

    function getContent(url, pageCallback) {
        $.ajax({
            url: url,
            method: 'GET',
            dataType: 'json',
            data: {
                keyword: selectedCategory + "," + selectedOrderBy
            },
            success: function (data) {
                console.log("AJAX Success:", data); // 콘솔 로그 추가
                $("#artist-album-list-tbody").html(pageCallback(data.body))
            },
            error: function () {
                alert("데이터 가져오기 실패");
            }
        })
    }

    // 노래 리스트
    function songs(body) {
        console.log("Rendering songs:", body); // 콘솔 로그 추가
        return body.map(item => {
            return `
                <tr class="artist-main-table-body">
                    <td><input type="checkbox"></td>
                    <td class="artist-album-list-table-album-container">
                        <a href="/albums/${item.albumId}/list">
                            <img src="..${item.coverImg}" alt="Album Cover">
                        </a>
                        <div class="artist-album-list-text-container">
                            <div class="artist-album-list-title-group">
                                <div class="artist-album-list-song-title">
                                    <a href="/songs/${item.songId}">
                                        ${item.title}
                                    </a>
                                </div>
                            </div>
                            <a href="/albums/${item.albumId}/list">
                                <p class="artist-album-list-album-title" style="font-size: 12px;">${item.albumTitle}</p>
                            </a>
                        </div>
                    </td>
                    <td class="artist-album-list-table-artist">
                        <a href="/artists/${artistId}">${item.artistName}</a>
                    </td>
                    <td>
                        <a href="#" class="play-btn" data-songid="${item.songId}" data-title="${item.title}"
                           data-artist="${item.artistName}" data-cover="${item.coverImg}" data-music="${item.musicFile}"
                           data-lyrics="${item.lyrics}" >
                            <i class="artist-album-list-play-btn fa-solid fa-play"></i>
                        </a>
                    </td>
                    <td>
                        <a href="#"><i class="artist-album-list-add-playlist-btn fas fa-list icon"></i></a>
                    </td>
                    <td>
                        <a href="#"><i
                                class="artist-album-list-add-list-btn fas fa-folder-plus custom-icon"></i></a>
                    </td>
                    <td>
                        <a href="#"><i class="artist-album-list-more-btn fas fa-ellipsis-h icon"></i></a>
                    </td>
                </tr>
            `;
        }).join('');
    }

    // 좋아요 나타나게 하기(true, false)
    function likeButtonAppear(value) {
        switch (value.val()) {
            case 'true':
                $(value).siblings().remove(".like-icons");
                $(value).after("<a class='like-icons' href='#'><i id='liked-artist' class='artist-album-list-btn-add-like fas fa-heart'></i></a>");
                doLike("DELETE", "좋아요 취소 실패", "false");
                break;
            case 'false':
                $(value).siblings().remove(".like-icons");
                $(value).after("<a class='like-icons' href='#'><i id='unliked-artist' class='artist-album-list-btn-add-like fa-regular fa-heart'></i></a>");
                doLike("POST", "좋아요 실패", "true");
                break;
        }
    }

    // 좋아요, 좋아요 취소
    function doLike(method, failMsg, value) {
        $(".like-icons").click(function () {
            $.ajax({
                url: "/artists/like",
                method: method,
                contentType: "application/json",
                data: JSON.stringify(artistId),
                success: function () {
                    artistLike.val(value);
                    likeButtonAppear(artistLike);
                },
                error: function () {
                    alert(failMsg);
                }
            })
        });
    }

    // 좋아요 초기상태
    likeButtonAppear(artistLike);

    // 초기 로드 시 필터링 적용
    filterAlbums(selectedCategory, selectedOrderBy);
});