package com.jk.rentdata;

import com.jk.rentdata.UserEntity.AppUser;
import com.jk.rentdata.UserRepo.AppUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RentDataApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(RentDataApplication.class, args);
	}

	@Autowired
	private AppUserRepo repo;

	@Override
	public void run(String... args) throws Exception {
		this.repo.save(new AppUser("root", "root@gmail.com", "root"));
	}
}
