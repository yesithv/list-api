package ironcoding.listapi.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ListType {
    EMPTY("L00", "Ninguna"),
    OCCUPATIONS("L01", "Ocupaciones"),
    DIAGNOSTICS("L02", "Diagnosticos");

    private final String code;
    private final String name;
}
