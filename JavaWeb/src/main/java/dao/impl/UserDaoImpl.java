package dao.impl;

import java.util.List;

import dao.BaseDao;
import dao.UserDao;
import model.User;

public class UserDaoImpl extends BaseDao implements UserDao {

	@Override
	public List<User> findAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addUser(String username, String hash, String salt) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changePasswordById(Integer id, String newPassword) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUserById(Integer id) {
		// TODO Auto-generated method stub
		
	}
	
}
