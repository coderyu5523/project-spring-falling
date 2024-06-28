$(document).ready(function () {
    // 초기화: 모든 옵션 초기화
    var selectedCategory = localStorage.getItem('selectedCategory') || "";
    var selectedOrderBy = localStorage.getItem('selectedOrderBy') || "";
    var artistId = $('#artist-id').val();

    // 저장된 값을 불러와서 적용
    if (selectedCategory) {
        $('.artist-song-list-filter-album-category p[data-keyword="' + selectedCategory + '"]').addClass('active');
    }
    if (selectedOrderBy) {
        $('.artist-song-list-filter-order-by p[data-orderby="' + selectedOrderBy + '"]').addClass('active');
    }

    // 전체, 정규/싱글, 참여 중 하나만 선택되도록 처리
    $('.artist-song-list-filter-album-category p').click(function (e) {
        e.preventDefault();
        var keyword = $(this).data('keyword');

        // 기존 선택 제거
        $('.artist-song-list-filter-album-category p').removeClass('active');
        $(this).addClass('active');

        // 선택된 카테고리 저장
        selectedCategory = keyword;

        // 필터링 함수 호출
        filterAlbums(selectedCategory, selectedOrderBy);
    });

    // 최신순, 인기순, 가나다순 중 하나만 선택되도록 처리
    $('.artist-song-list-filter-order-by p').click(function (e) {
        e.preventDefault();
        var orderBy = $(this).data('orderby');

        // 기존 선택 제거
        $('.artist-song-list-filter-order-by p').removeClass('active');
        $(this).addClass('active');

        // 선택된 정렬 순서 저장
        selectedOrderBy = orderBy;

        // 필터링 함수 호출
        filterAlbums(selectedCategory, selectedOrderBy);
    });


    function filterAlbums(category, orderBy) {
        console.log("Filtering songs by:", category, "Order by:", orderBy);
        getContent('/' + artistId + '/sort-and-filter/albums', albums);
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
                $("#artist-song-list-album-list").html(pageCallback(data.body))
            },
            error: function () {
                alert("데이터 가져오기 실패");
            }
        })
    }

    // 노래 리스트
    function albums(body) {
        console.log("Rendering albums:", body); // 콘솔 로그 추가
        return body.map(item => {
            return `
                <li>
                    <div class="artist-song-list-badge-area">
                        <div class="artist-song-list-album-cover">
                            <img src="..${item.coverImg}" alt="Album Cover">
                            <a href="#"><i class="artist-song-list-play-btn fa fa-play"></i></a>
                        </div>
                        <div class="artist-song-list-album-info">
                            <div class="artist-song-list-info-area">
                                <a href="#"></a>
                                <p class="artist-song-list-album-title">${item.albumTitle}</p>
                                <a href="#"></a>
                                <p class="artist-song-list-album-artist">${item.artistName}</p>
                            </div>
                            <div class="artist-song-list-explain_area">
                                <div class="artist-song-list-album-category">
                                    <p>${item.category}</p>
                                </div>
                                <div class="artist-song-list-album-date">
                                    <p>${item.albumCreatedAt}</p>
                                </div>
                            </div>
                            <div class="artist-song-list-icons">
                                <a href="#"><i class="artist-song-list-btn-add-list fas fa-list icon"></i></a>
                                <a href="#"><i class="artist-song-list-btn-add-playlist fas fa-folder-plus custom-icon"></i></a>
                                <a href="#"><i class="artist-song-list-btn-add-like fas fa-heart"></i></a>
                                <a href="#"><i class="artist-song-list-btn-add-like fa-regular fa-heart"></i></a>
                            </div>
                        </div>
                    </div>
                </li>
            `;
        }).join('');
    }

    // 초기 로드 시 필터링 적용
    filterAlbums(selectedCategory, selectedOrderBy);
});