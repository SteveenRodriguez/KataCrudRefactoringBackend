package co.com.sofka.crud;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * programa entry point
 * @author Steveen Rodriguez
 */
@SpringBootApplication
public class CrudApplication {
	/**
	 * function Main
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
	}

	/**
	 * Bean to use our ModelMapper
	 * @return ModelMapper
	 */
	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

	/**
	 *  Cors configuration
	 * @return
	 */
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry){
				registry.addMapping("/api/todos").allowedOrigins("http://localhost:3000");
			}
		};
	}

}