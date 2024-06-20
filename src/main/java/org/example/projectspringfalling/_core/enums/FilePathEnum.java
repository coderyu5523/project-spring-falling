package org.example.projectspringfalling._core.enums;

public enum FilePathEnum {
    IMAGE("upload/imageFile/"), // 이미지 저장경로
    VIDEO("upload/videoFile/"), // 동영상 저장경로
    MUSIC("upload/musicFile/"); // 음악 저장경로

    private final String path;

    FilePathEnum(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
