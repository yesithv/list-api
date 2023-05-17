package ironcoding.listapi.occupations.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class OccupationNotFoundException extends RuntimeException {

    public OccupationNotFoundException(String message) {
        super(message);
    }
}
