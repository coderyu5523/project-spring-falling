package org.example.projectspringfalling._core.enums;

public enum FilePathEnum {
    ALBUMIMAGE("upload/album/"), // 앨범 이미지 저장경로
    ARTISTIMAGE("upload/artist/"), // 아티스트 이미지 저장경로
    VIDEO("upload/videoFile/"), // 동영상 저장경로
    MUSIC("upload/song/"); // 음악 저장경로

    private final String path;

    FilePathEnum(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
