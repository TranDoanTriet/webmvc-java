package Finalproject.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import Finalproject.Entity.MapperTag;
import Finalproject.Entity.Tag;

@Repository
public class TagDao extends BaseDao{

	public List<Tag> getDataTags() {
		List<Tag> list = new ArrayList<Tag>();
        String sql = "SELECT * FROM tag";
        list = _jdbcTemplate.query(sql, new MapperTag());
        return list;
    }
}
