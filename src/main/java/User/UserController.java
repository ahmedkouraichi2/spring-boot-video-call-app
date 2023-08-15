package User;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/users")
@CrossOrigin(origins = "*")

@Slf4j
public class UserController {

	
	private final UserService userService;
	
	
	public UserController(UserService userService) {
		this.userService = userService ;
		
	}
	@PostMapping
	public void register(@RequestBody User user) {
		
		userService.register(user);
	}
	
	@PostMapping("/login")
	public User login(@RequestBody User user) {
		return userService.login(user);
	}
	
	@PostMapping("/logout")
	public void logout(@RequestBody User email) {
		userService.logout(email.getEmail());
	}
	
	@GetMapping
	public List<User> findAll(){
		return userService.findAll();
		
	}
	
	
	
}
