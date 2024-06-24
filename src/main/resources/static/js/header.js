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