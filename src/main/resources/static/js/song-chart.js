document.addEventListener("DOMContentLoaded", function () {
    const tabs = document.querySelectorAll(".chart-tags li");
    const contents = document.querySelectorAll(".tab-content");

    function setLoadMoreButton(contentIndex) {
        const loadButton = contents[contentIndex].querySelector(".chart-more-button");
        const chartTableBody = contents[contentIndex].querySelector(".chart-main-table tbody");
        let currentIndex = 5;  // 처음에 5개만 보여줌

        // 초기 5개 항목만 보이도록 설정
        const chartItems = contents[contentIndex].querySelectorAll(".chart-main-table .chart-main-table-body");
        for (let i = currentIndex; i < chartItems.length; i++) {
            chartItems[i].style.display = "none";
        }

        loadButton.addEventListener("click", function () {
            let itemsToShow = currentIndex + 10;
            for (let i = currentIndex; i < itemsToShow && i < chartItems.length; i++) {
                chartItems[i].style.display = "";
            }
            currentIndex = itemsToShow;

            // 만약 모든 항목이 다 로드되었으면 더보기 버튼 숨김
            if (currentIndex >= chartItems.length) {
                loadButton.style.display = "none";
            }
        });
    }

    function activateTab(index) {
        // 모든 탭과 콘텐츠 비활성화
        tabs.forEach(t => t.classList.remove("active-tab"));
        contents.forEach(c => c.classList.remove("active-content"));

        // 클릭한 탭과 해당하는 콘텐츠 활성화
        tabs[index].classList.add("active-tab");
        contents[index].classList.add("active-content");

        // 더보기 버튼 로직 설정
        setLoadMoreButton(index);
    }

    tabs.forEach((tab, index) => {
        tab.addEventListener("click", function (event) {
            event.preventDefault();
            // URL 해시 업데이트
            window.history.replaceState(null, null, `#tab${index + 1}`);
            // 탭 활성화
            activateTab(index);
        });
    });

    // 초기 설정
    if (window.location.hash) {
        const hash = window.location.hash;
        const tabIndex = parseInt(hash.replace('#tab', '')) - 1;
        if (tabIndex >= 0 && tabIndex < tabs.length) {
            activateTab(tabIndex);
        } else {
            activateTab(0);
        }
    } else {
        activateTab(0);
    }

    // 체크박스를 모두 체크/해제
    function toggleAllCheckboxes(checked) {
        var checkboxes = document.querySelectorAll('.chart-main-table-body input[type="checkbox"]');
        checkboxes.forEach(function (checkbox) {
            checkbox.checked = checked;
        });
    }

    // 상위 체크박스 클릭 시 모든 하위 체크박스 체크/해제
    var masterCheckbox = document.querySelector('.chart-main-table-header input[type="checkbox"]');
    masterCheckbox.addEventListener('change', function () {
        toggleAllCheckboxes(this.checked);
    });
});
