document.addEventListener('DOMContentLoaded', function() {
    let activeRow = null;
    // 질문 클릭 시 답변 토글
    document.querySelectorAll('.question').forEach(question => {
        question.addEventListener('click', () => {
            const answerRow = question.closest('tr').nextElementSibling;
            // 다른 답변 숨기기
            if (activeRow && activeRow !== answerRow) {
                activeRow.style.display = 'none';
            }
            // 현재 답변 토글
            if (answerRow.style.display === 'none' || answerRow.style.display === '') {
                answerRow.style.display = 'table-row';
                activeRow = answerRow;
            } else {
                answerRow.style.display = 'none';
                activeRow = null;
            }
        });
    });

    // 검색 기능
    document.getElementById('searchBar').addEventListener('input', function() {
        const filter = this.value.toLowerCase();
        document.querySelectorAll('.faq-table tbody tr').forEach(row => {
            if (row.querySelector('.question')) {
                const question = row.querySelector('.question').textContent.toLowerCase();
                const answer = row.nextElementSibling.textContent.toLowerCase();
                if (question.includes(filter) || answer.includes(filter)) {
                    row.style.display = '';
                    if (row.nextElementSibling) {
                        row.nextElementSibling.style.display = '';
                    }
                } else {
                    row.style.display = 'none';
                    if (row.nextElementSibling) {
                        row.nextElementSibling.style.display = 'none';
                    }
                }
            }
        });
    });
});
