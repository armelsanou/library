package com.library;

import com.library.entities.Effectuerabonnement;
import com.library.implementations.EffectuerAbonnementImpl;
import com.library.property.FileStorageProperties;
import com.library.repositories.EffectuerAbonnementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({
		FileStorageProperties.class
})
public class LibraryApplication{

	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
		System.out.println("les images sont sauvegardées dans le repertoire: "+System.getProperty("user.dir")+"/src/main/resources/uploaded-images");
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/api/**")
						.allowedOrigins("*")
						.allowedHeaders("*")
						.allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS")
						.exposedHeaders("Authorization");
			}
		};
	}

}
