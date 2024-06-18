package org.example.projectspringfalling.report;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.projectspringfalling.reply.Reply;
import org.example.projectspringfalling.user.User;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "report_tb")
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String content; // 신고 내용
    private Boolean status; // 처리 상태

    @CreationTimestamp
    private Timestamp createdAt; // 생성날짜

    @ManyToOne(fetch = FetchType.LAZY)
    private User user; // 회원

    @ManyToOne(fetch = FetchType.LAZY)
    private Reply reply; // 댓글

    @Builder
    public Report(Integer id, String content, Boolean status, Timestamp createdAt, User user, Reply reply) {
        this.id = id;
        this.content = content;
        this.status = status;
        this.createdAt = createdAt;
        this.user = user;
        this.reply = reply;
    }
}
