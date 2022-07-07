package service;

import java.util.UUID;

import domain.User;
import repository.UserManager;

public class UserServiceImpl implements UserService {

	private UserManager userManager;
	
	public UserServiceImpl(UserManager userManager) {
		this.userManager = userManager;
	}

	@Override
	public void add_user(String name, char gender, int age) {
		UUID id = UUID.randomUUID();
		try {
			User user = new User(name, gender, age, id);
			userManager.addUser(user);
			System.out.println("User " + name + " added");
		} catch (RuntimeException e) {
			System.out.println(e);
		}

	}

}
