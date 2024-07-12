package kr.autowired.guardian_tales_web.exception;

import kr.autowired.guardian_tales_web.message.ErrorMessage;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ErrorMessageException extends RuntimeException {

    private final ErrorMessage errorMessage;

}
