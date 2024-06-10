package Finalproject.Dto;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductDtoMapper implements RowMapper<ProductDto>{
	@Override
    public ProductDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        ProductDto productDto = new ProductDto();
        productDto.setIdProduct(rs.getInt("id_product"));
        productDto.setProductName(rs.getString("name"));
        productDto.setPrice(rs.getDouble("price"));
        productDto.setIdTag(rs.getInt("id_tag"));
        productDto.setSale(rs.getInt("sale"));
        productDto.setBestSelling(rs.getBoolean("best_selling"));
        productDto.setGaming(rs.getBoolean("gaming"));
        productDto.setProducer(rs.getString("producer"));
        productDto.setTitle(rs.getString("title"));
        productDto.setDescription(rs.getString("description"));
        productDto.setCreatedAt(rs.getDate("created_at"));
        productDto.setUpdatedAt(rs.getDate("updated_at"));
        productDto.setIdColor(rs.getInt("id_color"));
        productDto.setColorName(rs.getString("name_color"));
        productDto.setColorCode(rs.getString("code_color"));
        productDto.setImg(rs.getString("img"));
        productDto.setQuantity(rs.getInt("quantity"));
        return productDto;
    }
}
