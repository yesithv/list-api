package yesithv.config;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;
import yesithv.occupations.model.OccupationCollection;

import java.io.InputStream;
import java.time.LocalDate;
import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void run(String... args) throws Exception {
        if (mongoTemplate.getCollection("occupations").countDocuments() < 10) {
            List<OccupationCollection> occupationList = buildDefaultOccupations();
            mongoTemplate.insertAll(occupationList);
            System.out.println("Occupation list Loaded success ");
        } else {
            System.out.println("Occupation already have enough data");
        }
    }

    private List<OccupationCollection> buildDefaultOccupations() {
        return List.of(
                new OccupationCollection("Ingeniero de Software", LocalDate.of(2025, 10, 25)),
                new OccupationCollection("Médico General", LocalDate.of(2025, 12, 03)),
                new OccupationCollection("Arquitecto", LocalDate.of(2025, 10, 01)),
                new OccupationCollection("Abogado", LocalDate.of(2025, 07, 23)),
                new OccupationCollection("Profesor de Matemáticas", LocalDate.of(2025, 05, 12)),
                new OccupationCollection("Chef", LocalDate.of(2025, 10, 20)),
                new OccupationCollection("Psicólogo Clínico", LocalDate.of(2025, 10, 13)),
                new OccupationCollection("Contador Público", LocalDate.of(2025, 3, 1)),
                new OccupationCollection("Ingeniero Civil", LocalDate.of(2025, 06, 14)),
                new OccupationCollection("Diseñador Gráfico", LocalDate.of(2025, 4, 27)),
                new OccupationCollection("Desarrollador Frontend", LocalDate.of(2025, 10, 25)),
                new OccupationCollection("Técnico en Electrónica", LocalDate.of(2025, 2, 21)),
                new OccupationCollection("Periodista", LocalDate.of(2025, 9, 8)),
                new OccupationCollection("Biólogo", LocalDate.of(2025, 9, 25)),
                new OccupationCollection("Fotógrafo Profesional", LocalDate.of(2025, 8, 19)),
                new OccupationCollection("Piloto de Aviación", LocalDate.of(2025, 8, 23)),
                new OccupationCollection("Veterinario", LocalDate.of(2025, 10, 6)),
                new OccupationCollection("Mecánico Automotriz", LocalDate.of(2025, 8, 24)),
                new OccupationCollection("Ingeniero Ambiental", LocalDate.of(2025, 11, 26)),
                new OccupationCollection("Sociólogo", LocalDate.of(2025, 7, 5)),
                new OccupationCollection("Actor de Teatro", LocalDate.of(2025, 1, 19)),
                new OccupationCollection("Astrónomo", LocalDate.of(2025, 10, 30)),
                new OccupationCollection("Traductor", LocalDate.of(2025, 6, 21)),
                new OccupationCollection("Antropólogo", LocalDate.of(2025, 9, 14))
        );
    }
}
