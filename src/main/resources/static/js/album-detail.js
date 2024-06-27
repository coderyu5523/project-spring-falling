$(document).ready(function () {
    let albumAbout = $("#album-about");
    let albumSongList = $("#album-song-list");
    let albumAboutTab = $(".album-list-album-detail");
    let albumSongs = $(".album-list-album-songs");

    function appearContent(tab) {
        tab.siblings().css("display", "none");
        tab.css("display", "block");
    }

    function selectTab(tab) {
        tab.siblings().removeClass("album-selected-tab");
        tab.addClass("album-selected-tab");
    }

    $(".album-list-tab-button").on("click", "button", function () {
        switch ($(this).data("tab")) {
            case "album-about":
                appearContent(albumAbout);
                selectTab(albumAboutTab);
                break;
            case "album-song-list":
                appearContent(albumSongList);
                selectTab(albumSongs);
                break;
        }
    });
});