package kr.autowired.guardian_tales_web.message;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorMessage {

    NOT_FOUND_DATA (HttpStatus.NOT_FOUND, "Data does not exist."),
    NULL_DATA (HttpStatus.BAD_REQUEST, "Data cannot be null."),
    DUPLICATE_DATA (HttpStatus.BAD_REQUEST, "Data already exists."),
    ;

    private HttpStatus httpStatus;
    private String message;

}
