package kr.autowired.guardian_tales_web.dto;

import kr.autowired.guardian_tales_web.annotation.Cipher;
import kr.autowired.guardian_tales_web.annotation.Exclude;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class AccountDTO {

    private String username;

    @Exclude(type = 0)
    private String password;

    private String nickname;

    @Cipher(type = 1, mode = 1)
    private String email;

    private String profileImage;

    private LocalDateTime createDate;

    private LocalDateTime updateDate;

}
