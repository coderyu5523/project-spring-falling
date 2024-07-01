package org.example.projectspringfalling.subscription;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.projectspringfalling.song.Song;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.util.List;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "subscription_tb")
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name; // 이용권 이름
    private String description; // 이용권 설명
    private Integer price; // 가격
    private Integer duration; // 유효기간

    @CreationTimestamp
    private Timestamp createdAt; // 생성날짜


    @Builder
    public Subscription(Integer id, String name, String description, Integer price, Integer duration, Timestamp createdAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.duration = duration;
        this.createdAt = createdAt;
    }
}
