$("#plan-button1").on("click", function () {
    var merchant_uid = "0" + new Date().getTime(); // 고유한 주문번호 생성
    var name = $("#plan-button1").data("name");
    var amount = $("#plan-button1").data("amount");
    var subscription_pk = $("#plan-button1").data("subscriptionPk");
    console.log(merchant_uid + " " + name + " " + amount + " " + subscription_pk);

    // preparePayment 호출
    preparePayment(merchant_uid, amount).then(function () { // preparePayment가 성공했을 때 결제 요청 진행
        // 초기화 (필수)
        var IMP = window.IMP;
        IMP.init("imp86167246");

        // IMP 결제 요청
        IMP.request_pay(
            {
                pg: "html5_inicis",
                pay_method: "card",
                merchant_uid: merchant_uid, // 주문 고유 번호
                subscription_pk: subscription_pk, // 이용권의 id
                name: "[falling] " + name,
                amount: amount,
            },
            function (response) { // 결제 요청이 성공하면
                if (response.success) {
                    $.ajax({
                        url: "/pay",
                        method: "POST",
                        contentType: "application/json",
                        data: JSON.stringify({ // 값을 JSON 문자열로 변환하는 역할
                            impUid: response.imp_uid, // 결제 고유번호
                            merchantUid: response.merchant_uid, // 주문번호
                            name: response.name, // 상품 이름
                            amount: amount, // 결제 금액
                            subscriptionPk: subscription_pk,
                            payMethod: response.pay_method, // 결제 방법 추가
                        }),
                    }).done(function (data) {
                        alert("결제가 완료되었습니다.(" + merchant_uid + ")");
                        window.location.href = data; // 성공 페이지로 리다이렉트
                    }).fail(function (xhr) {
                        alert("결제에 실패하였습니다. 에러 내용: " + xhr.responseText);
                        // window.location.href = xhr.responseText; // 실패 페이지로 리다이렉트
                    });
                } else {
                    alert("결제에 실패하였습니다. 에러 내용: " + response.error_msg);
                }
            }
        );
    }).catch(function (error) {
        alert("결제 준비 중 오류가 발생했습니다: " + error);
    });
});

function preparePayment(merchant_uid, amount) {
    return new Promise(function (resolve, reject) { // Promsie가 비동기 작업의 완료 또는 실패 처리를 도와주며 콜백 지옥 문제를 피할 수 있다.
        $.ajax({
            url: "/prepare-payment",
            method: "POST",
            contentType: "application/json",
            data: JSON.stringify({
                merchant_uid: merchant_uid, // 고객사 주문번호
                amount: amount, // 결제 예정금액
            }),
            success: function (data) {
                console.log("preparePayment 성공:", data);
                resolve(data);
            },
            error: function (jqXHR, textStatus, errorThrown) {
                console.error("preparePayment 실패:", jqXHR, textStatus, errorThrown);
                reject(textStatus + ": " + errorThrown);
            }
        });
    });
}