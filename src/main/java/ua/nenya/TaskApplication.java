package ua.nenya;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ua.nenya.domain.HoverData;
import ua.nenya.parser.TableParser;

import javax.persistence.EntityManager;
import java.util.List;

@SpringBootApplication
public class TaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskApplication.class, args);
	}
}
