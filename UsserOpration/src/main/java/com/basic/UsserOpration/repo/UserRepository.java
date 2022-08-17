package com.basic.UsserOpration.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.basic.UsserOpration.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

	List<User> findByUserName(String userName);

	String deleteByUserName(String userName);

	//Optional<User> toString(User updateUser);

	//Optional<User> ok(User updateUser);



	

}
