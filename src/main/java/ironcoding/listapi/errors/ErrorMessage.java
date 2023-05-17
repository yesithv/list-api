package ironcoding.listapi.errors;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorMessage {

    private String errorCode;

    private String errorTittle;

    private String errorMessage;
}
