package kr.autowired.guardian_tales_web.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@RequiredArgsConstructor
@ConfigurationProperties("guardian-tales-web.cipher")
public class CipherSecret {

    private final String secret;
    private final String iv;

}
