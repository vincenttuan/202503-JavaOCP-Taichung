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
		// 判斷 oldPassword 是否有效 ?
		User user = getUserById(id);
		if(user == null) {
			throw new RuntimeException("查無使用者");
		}
		String oldSalt = user.getSalt(); // 原始的鹽(目前存放在資料表中的鹽)
		String oldHash = user.getHash(); // 原始哈希(目前存放在資料表中的哈希)
		// oldPassword + oldSalt != oldHash 表示 oldPassword 輸入錯誤
		if(!PasswordHash.getHashPassword(oldPassword, oldSalt).equals(oldHash)) {
			throw new RuntimeException("舊密碼輸入錯誤");
		}
		// 進行新密碼更改
		String newSalt = PasswordHash.generateSalt(); // 取得新鹽
		String newHash = PasswordHash.getHashPassword(newPassword, newSalt); // 取得新哈希
		userDao.changePasswordById(id, newHash, newSalt);
	}

	@Override
	public void deleteUserById(Integer id) {
		userDao.deleteUserById(id);
	}
	
}
