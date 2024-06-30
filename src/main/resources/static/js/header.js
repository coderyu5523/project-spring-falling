$(document).ready(function () {
    $('#search-keyword').autocomplete({
        source: function (request, response) {
            $.ajax({
                url: '/search/auto',
                type: 'GET',
                data: { keyword: request.term },
                dataType: 'json',
                success: function (data) {
                    console.log('통신 확인:', data);
                    response($.map(data.body, function (item) {
                        return {
                            label: item.songTitle,
                            value: item.songTitle,
                            songTitle: item.songTitle,
                            albumTitle: item.albumTitle,
                            artistName: item.artistName,
                        };
                    }));
                },
                error: function (xhr, status, error) {
                    console.error('Error:', error);
                    console.error('Status:', status);
                    console.error('Response:', xhr.responseText);
                }
            });
        },
        minLength: 1,
        select: function (event, ui) {
            console.log('Selected ID:', ui.item.id);
        }
    });
});

var stompClient = null;

function connect() {
    var socket = new SockJS('/chat-websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function(frame) {
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/messages', function(response) {
            showMessage(JSON.parse(response.body));
        });
    });
}

function sendMessage() {
    var messageContent = $('#message').val();
    var chatMessage = {
        content: messageContent,
    };
    stompClient.send('/app/chat.sendMessage', {}, JSON.stringify(chatMessage));
    $('#message').val('');
    showUserMessage(chatMessage); // 사용자의 메시지를 바로 표시
}

function showMessage(message) {
    var messageElement = $('<div class="message ai-message"></div>');
    messageElement.html(message.content); // HTML로 처리
    $('#chatArea').append(messageElement);
    $('#chatArea').scrollTop($('#chatArea')[0].scrollHeight); // 스크롤을 아래로
}

function showUserMessage(message) {
    var messageElement = $('<div class="message user-message"></div>');
    messageElement.text(message.content); // 텍스트로 처리
    $('#chatArea').append(messageElement);
    $('#chatArea').scrollTop($('#chatArea')[0].scrollHeight); // 스크롤을 아래로
}

$(function () {
    $('#connectBtn').click(function() {
        connect();
    });
    $('#sendBtn').click(function() {
        sendMessage();
    });
});