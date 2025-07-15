package dao;

import java.util.List;

import model.User;

public interface UserDao {
	
	List<User> findAllUsers();
	User getUserById(Integer id);
	User getUserByUsername(String username);
	void addUser(String username, String hash, String salt);
	void changePasswordById(Integer id, String newPassword);
	void deleteUserById(Integer id);
	
}
