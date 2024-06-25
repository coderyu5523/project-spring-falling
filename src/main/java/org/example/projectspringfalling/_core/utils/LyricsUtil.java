package org.example.projectspringfalling._core.utils;

import org.example.projectspringfalling.RestAPI.RestResponse;

import java.util.ArrayList;
import java.util.List;

public class LyricsUtil {

    public static List<RestResponse.PlaylistDTO.LyricLineDTO> parseLyrics(String lyricsText) {
        List<RestResponse.PlaylistDTO.LyricLineDTO> lyrics = new ArrayList<>();
        String[] lines = lyricsText.split("\n");

        for (String line : lines) {
            String[] parts = line.split(" ", 2);
            int time = parseTime(parts[0]);
            String text = parts.length > 1 ? parts[1] : "";
            lyrics.add(new RestResponse.PlaylistDTO.LyricLineDTO(time, text));
        }

        return lyrics;
    }

    private static int parseTime(String timeString) {
        String[] parts = timeString.split(":");
        int minutes = Integer.parseInt(parts[0]);
        int seconds = Integer.parseInt(parts[1]);
        return minutes * 60 + seconds;
    }

}
