package org.example.projectspringfalling._core.enums;

public enum GenreEnum {
    BALLAD("Ballad"),
    DANCE("Dance"),
    R_AND_B("R&B"),
    HIPHOP("HipHop"),
    TROT("Trot"),
    OST_BGM("OST/BGM"),
    INDIE("Indie"),
    ROCK_METAL("Rock/Metal"),
    ELECTRONIC("Electronic"),
    POP("POP");

    private final String genreName;

    GenreEnum(String genreName) {
        this.genreName = genreName;
    }

    public String getGenreName() {
        return genreName;
    }
}
