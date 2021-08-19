package com.swathi.training;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.swathi.training.entity.User;
import com.swathi.training.repository.UserRepository;
import com.swathi.training.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
class TrainingJunitMockitoApplicationTests {

	@Autowired
	private UserService userService;
	
	@MockBean
	private UserRepository userRepository;
	
	@Test
	public void viewUsersTest() {
		when(userRepository.findAll()).thenReturn(Stream.of(new User(34,"Swathi","India","swathi@gmail.com")
				,new User(346,"Karthik","USA","karthik@gmail.com")).collect(Collectors.toList()));
		
		assertEquals(2,userService.viewUsers().size());
	}
	
	@Test
	public void getUserByAddressTest() {
		String address="Hyderabad";
		when(userRepository.findByAddress(address)).thenReturn(Stream.of(new User(34,"Swathi","India","swathi@gmail.com")
				,new User(346,"Karthik","USA","karthik@gmail.com")).collect(Collectors.toList()));
		
		assertEquals(2,userService.findUsersByAddress(address).size());
	}
	
	@Test
	public void saveUserTest() {
		User user=new User(234,"Aryan","France","aryan@gmail.com");
		when(userRepository.save(user)).thenReturn(user);
		
		assertEquals(user,userService.addUser(user));
	}
	
	@Test
	public void deleteUserTest() {
		User user=new User(234,"Aryan","France","aryan@gmail.com");
		userService.deleteUserById(user.getId());	
		//verify(userRepository,((UserService) times(1)).deleteUserById(user.getId()));
	}

}
