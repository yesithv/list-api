package yesithv.occupations.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("occupations")
public class OccupationEntity implements Serializable {

    @MongoId
    private UUID idOccupation;

    private boolean enable;

    private String name;

    private LocalDate anniversary;

}
