function activateTab(tab) {
    const tabs = document.querySelectorAll('.tab');
    tabs.forEach(t => t.classList.remove('active'));
    tab.classList.add('active');
}

$("#refund-button").on("click", function () {
    function refundPayment(transaction_id, amount) {
        return new Promise(function (resolve, reject) {
            $.ajax({
                url: "/refund-payment",
                method: "POST",
                contentType: "application/json",
                success: function (data) {
                    console.log("취소 성공:", data);
                    resolve(data);
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    console.error("취소 실패:", jqXHR, textStatus, errorThrown);
                    reject(textStatus + ": " + errorThrown);
                }
            });
        });
    }

    refundPayment()
        .then(function (data) {
            alert("결제가 성공적으로 취소되었습니다.");
        })
        .catch(function (error) {
            alert("결제 취소에 실패했습니다: " + error);
        });
});

