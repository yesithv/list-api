package yesithv.occupations.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Document("occupations")
public class OccupationCollection implements Serializable {

    @MongoId
    private UUID idOccupation;

    private boolean enable;

    private String name;

    private LocalDate anniversary;

    private LocalDateTime lastModified;

    public OccupationCollection(String name, LocalDate anniversary) {
        this.idOccupation = UUID.randomUUID();
        this.enable = Boolean.TRUE;
        this.name = name;
        this.anniversary = anniversary;
        this.lastModified = LocalDateTime.now();
    }
}
