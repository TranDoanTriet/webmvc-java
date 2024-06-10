package Finalproject.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperUser implements RowMapper<UserEntity>{
	@Override
    public UserEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        UserEntity user = new UserEntity();
        user.setIdUser(rs.getInt("iduser"));
        user.setUsername(rs.getString("username"));
        user.setPassword(rs.getString("password"));
        user.setFullname(rs.getString("fullname"));
        user.setPhone(rs.getString("phone"));
        user.setAddress(rs.getString("address"));
        user.setRole(rs.getInt("role"));
        user.setEmail(rs.getString("email"));
        return user;
    }
}
