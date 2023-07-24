package ironcoding.listapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ListExceptionController {

    @ExceptionHandler(value = ListNotFoundException.class)
    public ResponseEntity<?> occupationNotFound(ListNotFoundException exception) {

        return new ResponseEntity<>(ExceptionErrorMessage.builder()
                .errorTittle("En el listado de [" + exception.getListType() + "]")
                .errorCode(exception.getCode())
                .errorMessage(exception.getMessage())
                .build(),
                HttpStatus.NOT_FOUND);
    }
}
