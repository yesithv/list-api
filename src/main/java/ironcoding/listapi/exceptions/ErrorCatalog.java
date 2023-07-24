package ironcoding.listapi.exceptions;

import ironcoding.listapi.utils.ListType;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

import static ironcoding.listapi.utils.ListType.DIAGNOSTICS;
import static ironcoding.listapi.utils.ListType.EMPTY;
import static ironcoding.listapi.utils.ListType.OCCUPATIONS;

@Getter
@AllArgsConstructor
public enum ErrorCatalog {

    DONT_FIND_ERROR_CATALOG("LIS001", "No se encontró el error con dicho código", EMPTY),
    DONT_FIND_OCCUPATION("LIS002", "La ocupación con id [%s] no existe", OCCUPATIONS),
    DONT_FIND_DIAGNOSTIC("LIS003", "El diagnóstico con id [%s] no existe", DIAGNOSTICS);

    private final String code;
    private final String description;
    private final ListType listType;

    public static ErrorCatalog getErrorbyCode(String code) {
        return Arrays.stream(ErrorCatalog.values())
                .filter(errorCatalog -> code.equals(errorCatalog.getCode()))
                .findFirst()
                .orElse(DONT_FIND_ERROR_CATALOG);
    }

}
