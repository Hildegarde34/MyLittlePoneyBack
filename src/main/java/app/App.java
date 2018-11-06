package app;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"app"})
@EnableJpaAuditing
@EnableJpaRepositories(basePackages = "app")
@EntityScan(basePackages = "app")
public class App {
	
	public static void main(String[] args) {
		
		SpringApplication.run(App.class, args);

	}

}
