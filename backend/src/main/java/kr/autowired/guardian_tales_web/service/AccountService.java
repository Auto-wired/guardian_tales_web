package kr.autowired.guardian_tales_web.service;

import kr.autowired.guardian_tales_web.common.CompatibilityData;
import kr.autowired.guardian_tales_web.dto.AccountDTO;
import kr.autowired.guardian_tales_web.entity.AccountEntity;
import kr.autowired.guardian_tales_web.exception.ErrorMessageException;
import kr.autowired.guardian_tales_web.message.ErrorMessage;
import kr.autowired.guardian_tales_web.repository.AccountRepository;
import kr.autowired.guardian_tales_web.util.CipherUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService extends CommonService {

    private final AccountRepository accountRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final CipherUtil cipherUtil;

    public AccountDTO getAccount (final String username) throws ErrorMessageException {
        if (username == null || username.isEmpty()) {
            throw new ErrorMessageException(ErrorMessage.NULL_DATA);
        }

        if (!this.accountRepository.existsByUsername(username)) {
            throw new ErrorMessageException(ErrorMessage.NOT_FOUND_DATA);
        }

        return this.getCompatibilityData(AccountDTO.class).toSingle(this.accountRepository.findByUsername(username));
    }

    public void addAccount (final AccountDTO accountDTO) throws ErrorMessageException {
        final AccountEntity accountEntity = this.getCompatibilityData(AccountEntity.class).toSingle(accountDTO);

        if (this.accountRepository.existsByUsername(accountDTO.getUsername())) {
            throw new ErrorMessageException(ErrorMessage.DUPLICATE_DATA);
        }

        this.accountRepository.save(accountEntity);
    }

    public void updateAccount (final AccountDTO accountDTO) throws ErrorMessageException {
        final AccountEntity accountEntity = this.getCompatibilityData(AccountEntity.class).toSingle(accountDTO);

        if (!this.accountRepository.existsByUsername(accountDTO.getUsername())) {
            throw new ErrorMessageException(ErrorMessage.NOT_FOUND_DATA);
        }

        this.accountRepository.save(accountEntity);
    }

    // validate code

    @Override
    protected <T> CompatibilityData<T> getCompatibilityData (final Class<T> clazz) {
        return new CompatibilityData<T>(clazz, this.bCryptPasswordEncoder, this.cipherUtil);
    }

}
