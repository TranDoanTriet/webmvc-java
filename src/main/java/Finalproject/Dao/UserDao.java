package Finalproject.Dao;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

import Finalproject.Entity.MapperUser;
import Finalproject.Entity.UserEntity;

@Repository
public class UserDao extends BaseDao{
	
	public int AddAccount(UserEntity user) {
		
		StringBuilder sql = new StringBuilder();
	    sql.append("INSERT INTO user (username, password, fullname, phone, address, role, email) VALUES ('");
	    sql.append(user.getUsername()).append("', '");
	    sql.append(user.getPassword()).append("', '");
	    sql.append(user.getFullname()).append("', '");
	    sql.append(user.getPhone()).append("', '");
	    sql.append(user.getAddress()).append("', ");
	    sql.append(1).append(", '");
	    sql.append(user.getEmail()).append("');");
	    
	    int insert = _jdbcTemplate.update(sql.toString());
	    return insert;
	}
	
	public UserEntity checkAccount(UserEntity user) {
		
		String sql = "SELECT * FROM keyboard_shops.user WHERE username = ?";
        try {
            return _jdbcTemplate.queryForObject(sql, new Object[]{user.getUsername()}, new MapperUser());
        } catch (EmptyResultDataAccessException e) {
            return null; // Trả về null nếu không tìm thấy người dùng
        }
	}
}
