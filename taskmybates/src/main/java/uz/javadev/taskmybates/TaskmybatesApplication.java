package uz.javadev.taskmybates;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import uz.javadev.taskmybates.repository.UserRepository;
import uz.javadev.taskmybates.model.Users;

import java.util.Random;

@SpringBootApplication
public class TaskmybatesApplication implements CommandLineRunner{

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String...args) throws Exception {
		Random random = new Random();

		logger.info("Inserting -> {}", userRepository.insert(new Users(random.nextInt(10000), "Ramesh", "Fadatare", "Kanada")));
		logger.info("Inserting -> {}", userRepository.insert(new Users(random.nextInt(10000), "John", "Cena", "London")));
		logger.info("Inserting -> {}", userRepository.insert(new Users(random.nextInt(10000), "Anvar", "Olimov", "Uzbekistan")));
	}

	public static void main(String[] args) {
		SpringApplication.run(TaskmybatesApplication.class, args);
	}

}
