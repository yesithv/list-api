package yesithv.diagnostics.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.io.Serializable;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("diagnostics")
public class DiagnosticEntity implements Serializable {

    @MongoId
    private UUID idDiagnostic;

    private DiagnosticType diagnosticType;

    private boolean enable;

    private String code;

    private String description;

    private Gender gender;

}
