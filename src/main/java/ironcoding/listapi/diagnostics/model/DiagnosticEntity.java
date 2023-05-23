package ironcoding.listapi.diagnostics.model;

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

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "diagnostics")
public class DiagnosticEntity implements Serializable {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "uuid", updatable = false)
    private UUID idDiagnostic;

    @Column
    private DiagnosticType diagnosticType;

    @Column
    private boolean enable;

    @Column
    private String code;

    @Column
    private String Description;

    @Column
    private Gender gender;

}
