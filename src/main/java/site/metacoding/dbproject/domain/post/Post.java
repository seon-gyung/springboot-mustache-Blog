package site.metacoding.dbproject.domain.post;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import site.metacoding.dbproject.domain.user.User;

@AllArgsConstructor
@NoArgsConstructor
@Data // Getter, Setter, toString
@Entity // 서버 실행시 해당 클래스로 테이블을 생성해!!
@EntityListeners(AuditingEntityListener.class) // 현재 시간 입력을 위해 필요한 어노테이션
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
        @ManyToOne(fetch = FetchType.EAGER)
        private User user;
    
        @CreatedDate // INSERT
        private LocalDateTime createDate; // 언제 생성됐는지
        @LastModifiedDate // INSERT, UPDATE
        private LocalDateTime updateDate; // 언제 수정했는지
}
