package Finalproject.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import Finalproject.Dto.ProductDto;

public class ProductMapper implements RowMapper<ProductDto>{

	@Override
	public ProductDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		Product product = new Product();
		product.setIdP(rs.getInt("idP"));
		product.setName(rs.getString("name"));
		product.setPrice(rs.getDouble("price"));
		product.setIdTag(rs.getInt("id_tag"));
		product.setSale(rs.getInt("sale"));
		product.setBestSelling(rs.getBoolean("best_selling"));
		product.setGaming(rs.getBoolean("gaming"));
		product.setProducer(rs.getString("producer"));
		product.setTitle(rs.getString("title"));
		product.setDescription(rs.getString("description"));
		product.setCreatedAt(rs.getDate("created_at"));
		product.setUpdatedAt(rs.getDate("updated_at"));
        product.setQuantity(rs.getInt("quantity"));
		return null;
	}
	
}
