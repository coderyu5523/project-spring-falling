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