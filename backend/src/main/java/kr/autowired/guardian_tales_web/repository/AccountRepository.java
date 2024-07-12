package kr.autowired.guardian_tales_web.repository;

import kr.autowired.guardian_tales_web.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<AccountEntity, String> {

    AccountEntity findByUsername (final String username);

    boolean existsByUsername (final String username);

}
