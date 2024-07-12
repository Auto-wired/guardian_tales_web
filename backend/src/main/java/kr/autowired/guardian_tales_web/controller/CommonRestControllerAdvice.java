package kr.autowired.guardian_tales_web.controller;

import kr.autowired.guardian_tales_web.exception.ErrorMessageException;
import kr.autowired.guardian_tales_web.message.ErrorMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class CommonRestControllerAdvice {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> exceptionHandler (final RuntimeException runtimeException) {
        log.error(runtimeException.getMessage());

        return new ResponseEntity<String>("An unknown error has occurred.", HttpStatus.INTERNAL_SERVER_ERROR);
    }

//    @ExceptionHandler(IllegalStateException.class)
//    public ResponseEntity<String> exceptionHandler (final IllegalStateException illegalStateException) {
//        final String message = illegalStateException.getMessage();
//
//        log.error(message);
//
//        return new ResponseEntity<String>(message, HttpStatus.BAD_REQUEST);
//    }
//
//    @ExceptionHandler(IllegalArgumentException.class)
//    public ResponseEntity<String> exceptionHandler (final IllegalArgumentException illegalArgumentException) {
//        final String message = illegalArgumentException.getMessage();
//
//        log.error(message);
//
//        return new ResponseEntity<String>(message, HttpStatus.BAD_REQUEST);
//    }

    @ExceptionHandler(ErrorMessageException.class)
    public ResponseEntity<String> exceptionHandler (final ErrorMessageException errorMessageException) {
        final ErrorMessage errorMessage = errorMessageException.getErrorMessage();
        final String message = errorMessage.getMessage();
        final HttpStatus httpStatus = errorMessage.getHttpStatus();

        log.error(message);

        return new ResponseEntity<String>(message, httpStatus);
    }

}
