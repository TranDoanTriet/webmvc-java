package Finalproject.Service.User;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import Finalproject.Entity.UserEntity;

@Service
public class UserService {
	@Autowired
    private JdbcTemplate jdbcTemplate;
	public void createPasswordResetTokenForUser(String email, String token) {
		UserEntity user = findUserByEmail(email);
        if (user != null) {
            String sql = "INSERT INTO password_reset_token (user_id, token, expiry_date) VALUES (?, ?, ?)";
            jdbcTemplate.update(sql, user.getIdUser(), token, calculateExpiryDate(60 * 24));
        }
		
	}

	private Date calculateExpiryDate(int expiryTimeInMinutes) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.MINUTE, expiryTimeInMinutes);
        return new Date(cal.getTime().getTime());
    }
	
	
	private UserEntity findUserByEmail(String email) {
		 String sql = "SELECT * FROM user WHERE email = ?";
	        try {
	            return jdbcTemplate.queryForObject(sql, new Object[]{email}, new BeanPropertyRowMapper<>(UserEntity.class));
	        } catch (EmptyResultDataAccessException e) {
	            return null;
	        }
	}

	public UserEntity validatePasswordResetToken(String token) {
        String sql = "SELECT u.* FROM user u JOIN password_reset_token t ON u.iduser = t.user_id WHERE t.token = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new Object[]{token}, new BeanPropertyRowMapper<>(UserEntity.class));
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

	public void updatePassword(UserEntity user, String password) {
        String sql = "UPDATE user SET password = ? WHERE iduser = ?";
        jdbcTemplate.update(sql, password, user.getIdUser());
    }
	
}
