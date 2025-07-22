package service.impl;

import java.util.List;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import model.User;
import service.UserService;
import util.PasswordHash;

public class UserServiceImpl implements UserService {
	
	private UserDao userDao = new UserDaoImpl();
	
	@Override
	public List<User> findAllUsers() {
		return userDao.findAllUsers();
	}

	@Override
	public User getUserById(Integer id) {
		return userDao.getUserById(id);
	}

	@Override
	public User getUserByUsername(String username) {
		return userDao.getUserByUsername(username);
	}

	@Override
	public void addUser(String username, String password) {
		// 產生 salt
		String salt = PasswordHash.generateSalt();
		// 產生 hash
		String hash = PasswordHash.getHashPassword(password, salt);
		// 新增 user
		userDao.addUser(username, hash, salt);
	}

	@Override
	public void changePasswordById(Integer id, String oldPassword, String newPassword) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUserById(Integer id) {
		// TODO Auto-generated method stub
		
	}
	
}
