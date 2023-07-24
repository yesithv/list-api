package ironcoding.listapi.exceptions;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ExceptionErrorMessage {

    private String errorCode;

    private String errorTittle;

    private String errorMessage;
}
