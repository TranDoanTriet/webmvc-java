package Finalproject.Service.User;

import org.springframework.stereotype.Service;

import Finalproject.Entity.UserEntity;

@Service
public interface IAccountService {
	public int addAccount(UserEntity user);
	public UserEntity checkAccount(UserEntity user);
}
