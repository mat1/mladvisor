package ch.fhnw.mladvisor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.support.TransactionTemplate;

@SpringBootApplication
public class MladvisorApplication {

	public static void main(String[] args) {
		SpringApplication.run(MladvisorApplication.class, args);
	}

	@Bean
	public SurveyStore surveyStore(JdbcTemplate jdbcTemplate) {
		return new SurveyStore(jdbcTemplate);
	}
}
