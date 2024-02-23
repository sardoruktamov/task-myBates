package uz.javadev.taskmybates;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import uz.javadev.taskmybates.mapper.UserMapper;
import uz.javadev.taskmybates.model.User;

@SpringBootApplication
public class TaskmybatesApplication implements CommandLineRunner{

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UserMapper userMapper;

	@Override
	public void run(String...args) throws Exception {

		logger.info("Inserting -> {}", userMapper.insert(new User(10011L, "Ramesh", "Fadatare", "Kanada")));
		logger.info("Inserting -> {}", userMapper.insert(new User(10012L, "John", "Cena", "London")));
		logger.info("Inserting -> {}", userMapper.insert(new User(10013L, "Anvar", "Olimov", "Uzbekistan")));

		logger.info("Employee id 10011 -> {}", userMapper.findById(10011L));

		logger.info("Update 10003 -> {}", userMapper.update(new User(10011L, "Anvar", "Olimov", "Uzbekistan")));

		userMapper.deleteById(10013L);

		logger.info("All users -> {}", userMapper.findAll());
	}

	public static void main(String[] args) {
		SpringApplication.run(TaskmybatesApplication.class, args);
	}

}
