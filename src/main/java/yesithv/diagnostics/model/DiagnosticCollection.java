package yesithv.diagnostics.model;

import lombok.Data;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Document("diagnostics")
public class DiagnosticCollection implements Serializable {

    @MongoId
    private UUID idDiagnostic;

    private DiagnosticType diagnosticType;

    private boolean enable;

    @Indexed(unique = true)
    private String code;

    private String description;

    private Gender gender;

    private LocalDateTime lastModified;

    public DiagnosticCollection(DiagnosticType diagnosticType, String code, String description, Gender gender) {
        this.idDiagnostic = UUID.randomUUID();
        this.diagnosticType = diagnosticType;
        this.enable = Boolean.TRUE;
        this.code = code;
        this.description = description;
        this.gender = gender;
        this.lastModified = LocalDateTime.now();
    }
}
