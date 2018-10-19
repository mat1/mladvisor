package ch.fhnw.mladvisor;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import java.io.IOException;
import java.util.Map;

public class SurveyStore {

    private final JdbcTemplate jdbcTemplate;
    private final ObjectMapper objectMapper = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    public SurveyStore(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void saveSurvey(Survey survey) {
        new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("Survey")
                .execute(Map.of(
                        "id", survey.getId(),
                        "json", toJson(survey)
                ));
    }

    public void updateSurvey(Survey survey) {
        jdbcTemplate.update("UPDATE Survey SET json = ? WHERE id = ?", toJson(survey), survey.getId());
    }

    public Survey getSurveyById(String id) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM Survey WHERE id = ?", surveyMapper(), id);
        } catch (EmptyResultDataAccessException e) {
            throw new SurveyNotFoundException(id);
        }
    }

    private RowMapper<Survey> surveyMapper() {
        return (resultSet, i) -> {
            String json = resultSet.getString("json");
            return fromJson(json);
        };
    }

    private String toJson(Survey survey) {
        try {
            return objectMapper.writeValueAsString(survey);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "";
        }
    }

    private Survey fromJson(String json) {
        try {
            return objectMapper.readValue(json, Survey.class);
        } catch (IOException e) {
            e.printStackTrace();
            return new Survey();
        }
    }
}
