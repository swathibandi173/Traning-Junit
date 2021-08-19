package com.swathi.training.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.swathi.training.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>{
	
	public List<User> findByAddress(String address);

}
