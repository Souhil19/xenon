package dev.somari.xenon;

import dev.somari.xenon.movie.Movie;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class XenonApplication {

	public static void main(String[] args) {

		SpringApplication.run(XenonApplication.class, args);
	}
	@Bean
	CommandLineRunner runner(){
		return args ->{
			Movie movie= new Movie(1, "Titanic", LocalDateTime.now(), LocalDateTime.now().plusHours(1),3);
			System.out.println(movie);
		};
	}

}
