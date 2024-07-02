$(document).ready(function () {

    let artistSearchInput = $("#search-keyword");

    artistSearchInput.autocomplete({
        source: function (request, response) {
            $.ajax({
                url: "/search/artist",
                type: "GET",
                data: {keyword: request.term},
                dataType: 'json',
                success: function (data) {
                    response($.map(data.body, function (item) {
                        return {
                            label: item.artistName,
                            value: item.artistName,
                            id: item.artistId
                        };
                    }));
                }
            });
        },
        minLength: 1,
        select: function (event, ui) {
            $("#selected-artist").val(ui.item.id);
        }
    });


});
