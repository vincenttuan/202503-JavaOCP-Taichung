package service;

import java.util.List;

import model.User;

public interface UserService {
	List<User> findAllUsers();
	User getUserById(Integer id);
	User getUserByUsername(String username);
	void addUser(String username, String password);
	void changePasswordById(Integer id, String oldPassword, String newPassword);
	void deleteUserById(Integer id);
}
