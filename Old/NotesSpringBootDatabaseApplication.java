package ru.monya.firstWebSB.notesSpringBootDatabase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableJpaAuditing
//@EntityScan(basePackages = "ru.monya.notesSpringBootDatabase")
public class NotesSpringBootDatabaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotesSpringBootDatabaseApplication.class, args);
	}

}
