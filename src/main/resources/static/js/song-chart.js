// 더보기 버튼 기능
document.addEventListener("DOMContentLoaded", function () {
    const loadButton = document.getElementById("load");
    const chartTableBody = document.querySelector(".chart-main-table tbody");
    let currentIndex = 5;  // 처음에 5개만 보여줌

    // 초기 5개 항목만 보이도록 설정
    const chartItems = document.querySelectorAll(".chart-main-table-body");
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
});

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