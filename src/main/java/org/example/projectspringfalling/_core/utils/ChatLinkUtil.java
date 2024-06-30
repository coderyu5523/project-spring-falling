package org.example.projectspringfalling._core.utils;

import org.example.projectspringfalling.song.Song;

import java.util.List;
import java.util.regex.Pattern;

// 챗봇 노래제목 링크
public class ChatLinkUtil {

    public static String addSongLinks(String response, List<Song> songs) {
        for (Song song : songs) {
            String title = Pattern.quote(song.getTitle());
            String link = "<a href='/songs/" + song.getId() + "' class='a-link'>" + song.getTitle() + "</a>";
//            response = response.replaceAll("(?iu)\\b" + title + "\\b", link);
            response = response.replaceAll("(?iu)(?<!\\p{L})" + title + "(?!\\p{L})", link);
        }
        return response;
    }

}


