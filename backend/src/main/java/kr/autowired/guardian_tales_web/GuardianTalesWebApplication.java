package kr.autowired.guardian_tales_web;

import kr.autowired.guardian_tales_web.common.CipherSecret;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Slf4j
@SpringBootApplication
@EnableJpaAuditing
@EnableConfigurationProperties({ CipherSecret.class })
public class GuardianTalesWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(GuardianTalesWebApplication.class, args);

        log.info("Guardian tales web application started");
    }

}
