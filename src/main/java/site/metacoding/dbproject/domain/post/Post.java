package site.metacoding.dbproject.domain.post;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import site.metacoding.dbproject.domain.user.User;

@Entity
public class Post {
        // IDENTITY 전략은 DB에게 번호 증가 전략을 위임하는 것! - 디비에 맞게 알아서 찾아줌
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id; 
    
        @Column(length = 300, nullable = false)
        private String title; 

        @Lob // CLOB 4GB 문자 타입
        @Column(nullable = false)
        private String content;

        @JoinColumn(name = "userId")
        @ManyToOne
        private User user;
    
        private LocalDateTime createDate;
}
