package ironcoding.listapi.occupations.exception;

import ironcoding.listapi.errors.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class OccupationExceptionController {

    @ExceptionHandler(value = OccupationNotFoundException.class)
    public ResponseEntity<?> occupationNotFound(OccupationNotFoundException exception) {

        return new ResponseEntity<>(ErrorMessage.builder()
                .errorTittle("No se encontró la ocupación")
                .errorCode("OCU-001")
                .errorMessage(exception.getMessage())
                .build(),
                HttpStatus.NOT_FOUND);
    }
}
