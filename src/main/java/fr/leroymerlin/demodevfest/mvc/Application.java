package fr.leroymerlin.demodevfest.mvc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

/**
 * This is the main class used to start application.
 */
@Slf4j
@SpringBootApplication(scanBasePackages = "fr.leroymerlin.demodevfest.mvc")
public class Application {


	/**
	 * Main method used to start application.
	 *
	 * @param args
	 * 		startup arguments.
	 *
	 * @throws IOException
	 * 		IOException
	 */
	public static void main(String[] args) throws IOException {
		SpringApplication.run(Application.class, args);
	}
}
