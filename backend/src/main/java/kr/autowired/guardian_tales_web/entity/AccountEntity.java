package kr.autowired.guardian_tales_web.entity;

import jakarta.persistence.*;
import kr.autowired.guardian_tales_web.annotation.Cipher;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.Persistable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Table(name = "account")
@Getter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class AccountEntity implements Persistable<String> {

    @Id
    @Column(name = "username")
    private String username;

    @Cipher(type = 0, mode = 0)
    @Column(name = "password")
    private String password;

    @Column(name = "nickname")
    private String nickname;

    @Cipher(type = 1, mode = 0)
    @Column(name = "email")
    private String email;

    @Column(name = "profile_image")
    private String profileImage;

    @CreatedDate
    @Column(name = "create_date")
    private LocalDateTime createDate;

    @LastModifiedDate
    @Column(name = "update_date")
    private LocalDateTime updateDate;

    @Override
    public String getId () {
        return this.username;
    }

    @Override
    public boolean isNew () {
        return this.createDate == null;
    }

}
