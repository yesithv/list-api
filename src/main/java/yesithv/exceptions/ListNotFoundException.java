package yesithv.exceptions;

import lombok.EqualsAndHashCode;
import yesithv.utils.ListType;
import lombok.Data;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Data
public class ListNotFoundException extends RuntimeException {

    private String code;
    private ListType listType;

    public ListNotFoundException(String message, String code, ListType listType) {
        super(message);
        this.code = code;
        this.listType = listType;
    }
}
