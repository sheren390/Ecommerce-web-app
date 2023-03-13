package gov.iti.jets.ecommiti.Config;

// import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration

public class DisableCors {

	@Bean
	public WebMvcConfigurer cors() {
		return new WebMvcConfigurer() {

			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("http://localhost:4200/").allowedHeaders("*")
						.allowedMethods("GET", "POST", "PUT", "DELETE");

			}
		};
	}

}
