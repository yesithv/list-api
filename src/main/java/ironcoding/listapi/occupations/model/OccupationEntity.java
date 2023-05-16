package ironcoding.listapi.occupations.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "occupations")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OccupationEntity implements Serializable {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "uuid", updatable = false)
    private UUID idOccupation;

    @Column
    private boolean enable;

    @Column
    private String name;

}
