package Finalproject.Service.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Finalproject.Dao.UserDao;
import Finalproject.Entity.UserEntity;

@Service
public class AccountServiceImpl implements IAccountService{

	@Autowired
	UserDao userDao = new UserDao();

	@Override
	public int addAccount(UserEntity user) {
		return userDao.AddAccount(user);
		
	}

	@Override
	public UserEntity checkAccount(UserEntity user) {
		user = userDao.checkAccount(user);
		if(user != null) {
			return user;
		}
		return null;
	}

}
