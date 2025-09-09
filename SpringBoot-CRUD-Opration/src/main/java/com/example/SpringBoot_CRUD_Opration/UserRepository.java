package com.example.SpringBoot_CRUD_Opration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
	
	
	
}
