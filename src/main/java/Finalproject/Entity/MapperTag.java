package Finalproject.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class MapperTag implements RowMapper<Tag> {

    @Override
    public Tag mapRow(ResultSet rs, int rowNum) throws SQLException {
        Tag tag = new Tag();
        tag.setId(rs.getInt("id"));
        tag.setName(rs.getString("name"));
        tag.setCode(rs.getString("code"));
        return tag;
    }
}