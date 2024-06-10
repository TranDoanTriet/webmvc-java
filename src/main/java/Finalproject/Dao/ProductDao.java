package Finalproject.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import Finalproject.Dto.ProductDto;
import Finalproject.Dto.ProductDtoMapper;
import Finalproject.Entity.Product;
import Finalproject.Entity.ProductMapper;

@Repository
public class ProductDao extends BaseDao{
	
	private String buildBaseProductQuery() {
        StringBuilder sb = new StringBuilder();
        
        sb.append("SELECT ");
        sb.append("p.idP AS id_product, ");
        sb.append("p.name, ");
        sb.append("p.price, ");
        sb.append("p.id_tag, ");
        sb.append("p.sale, ");
        sb.append("p.best_selling, ");
        sb.append("p.gaming, ");
        sb.append("p.producer, ");
        sb.append("p.title, ");
        sb.append("p.description, ");
        sb.append("p.created_at, ");
        sb.append("p.updated_at, ");
        sb.append("p.quantity, ");
        sb.append("c.idC AS id_color, ");
        sb.append("c.name AS name_color, ");
        sb.append("c.code AS code_color, ");
        sb.append("c.img ");
        sb.append("FROM keyboard_shops.product p ");
        sb.append("INNER JOIN keyboard_shops.color c ON p.idP = c.id_product ");
        return sb.toString();
    }

    private String buildProductQuery() {
        StringBuilder sb = new StringBuilder(buildBaseProductQuery());
        sb.append("GROUP BY p.idP, c.idC ");
        return sb.toString();
    }

    private String buildProductIdQuery(int id) {
        StringBuilder sb = new StringBuilder(buildBaseProductQuery());
        sb.append("WHERE p.id_tag = " + id + " ");
        sb.append("GROUP BY p.idP, c.idC ");
        return sb.toString();
    }
    
    private String buildProductSearch(String keyword) {
        StringBuilder sb = new StringBuilder(buildBaseProductQuery());
        sb.append("WHERE p.name LIKE " +"\"%"+ keyword +"%\""+ " ");
        sb.append("GROUP BY p.idP, c.idC ");
        return sb.toString();
    }

    private String buildProductPaginateQuery(int start, int end, int id) {
    	StringBuilder sb = new StringBuilder(buildBaseProductQuery());
    	sb.append("WHERE p.id_tag = " + id + " ");
        sb.append("GROUP BY p.idP, c.idC ");
        sb.append("LIMIT ").append(start).append(", ").append(end);
        return sb.toString();
    }
    //lấy tất cả sản phẩm
    public List<ProductDto> getAllDataProduct() {
        String sql = buildProductQuery();
        List<ProductDto> listProduct = _jdbcTemplate.query(sql, new ProductDtoMapper());
        return listProduct;
    }
    //lấy sản phẩm theo id tag tương ứng
    public List<ProductDto> getDataProductByIdTag(int id) {
        String sql = buildProductIdQuery(id);
        List<ProductDto> listProduct = _jdbcTemplate.query(sql, new ProductDtoMapper());
        return listProduct;
    }
    //lấy sản phẩm theo phan trang
    public List<ProductDto> getDataProductPaginate(int start, int end, int id) {
        String sql = buildProductPaginateQuery(start, end, id);
        List<ProductDto> listProduct = _jdbcTemplate.query(sql, new ProductDtoMapper());
        return listProduct;
    }
    
    
    private String buildViewProductByIdQuery(int id) {
        StringBuilder sb = new StringBuilder(buildBaseProductQuery());
        sb.append("WHERE p.idP = " + id + " ");
        sb.append("GROUP BY p.idP, c.idC ");
        sb.append("LIMIT 1 ");
        return sb.toString();
    }
    //lấy view thông tin sản phẩm theo id
    public List<ProductDto> getViewProductById(int id) {
        String sql = buildViewProductByIdQuery(id);
        List<ProductDto> listProduct = _jdbcTemplate.query(sql, new ProductDtoMapper());
        return listProduct;
    }
    
  //tìm thông tin sản phẩm theo id
    public ProductDto findProductById(int id) {
        String sql = buildViewProductByIdQuery(id);
        ProductDto product = _jdbcTemplate.queryForObject(sql, new ProductDtoMapper());
        return product;
    }
    
    //lưu sản phẩm mới
    private String builSavingProductSql(ProductDto productDto) {
    	 StringBuilder sb = new StringBuilder();
    	    sb.append("INSERT INTO keyboard_shops.product ");
    	    sb.append("(name, price, id_tag, sale, best_selling, gaming, producer, title, description, created_at, updated_at, quantity) ");
    	    sb.append("VALUES (");
    	    sb.append("'").append(productDto.getProductName()).append("', ");
    	    sb.append(productDto.getPrice()).append(", ");
    	    sb.append(productDto.getIdTag()).append(", ");
    	    sb.append(productDto.getSale()).append(", ");
    	    sb.append(productDto.isBestSelling() ? 1 : 0).append(", ");
    	    sb.append(productDto.isGaming() ? 1 : 0).append(", ");
    	    sb.append("'").append(productDto.getProducer()).append("', ");
    	    sb.append("'").append(productDto.getTitle()).append("', ");
    	    sb.append("'").append(productDto.getDescription()).append("', ");
    	    sb.append("'").append(new java.sql.Date(productDto.getCreatedAt().getTime())).append("', ");
    	    sb.append("'").append(new java.sql.Date(productDto.getUpdatedAt().getTime())).append("', ");
    	    sb.append(productDto.getQuantity());
    	    sb.append(");");
    	    return sb.toString();
    }
    
    //lấy ra id sản phẩm mới add vào
    private int getIdNewProduct() {
    	String sql = "SELECT idP FROM keyboard_shops.product ORDER BY idP DESC LIMIT 1";
    	
    	return  _jdbcTemplate.queryForObject(sql, Integer.class);
    }
    @Transactional
    private void saveImageNewProduct(ProductDto productDto) {
    	int idproduct = getIdNewProduct(); 
    	
    	StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO keyboard_shops.color (id_product, name, code, img) VALUES (");
        sb.append(idproduct).append(", ");
        sb.append("'").append("Gray").append("', ");
        sb.append("'").append("#333").append("', ");
        sb.append("'").append(productDto.getImg()).append("'");
        sb.append(");");
        _jdbcTemplate.execute(sb.toString());
    }
    // lưu ảnh vào bảng color
    @Transactional
	public void saveNewProduct(ProductDto product) {
		_jdbcTemplate.execute(builSavingProductSql(product));
		saveImageNewProduct(product);
	}
	@Transactional
	public List<ProductDto> getSearchProduct(String keyword) {
		String sql = buildProductSearch(keyword);
		List<ProductDto> listProduct = _jdbcTemplate.query(sql,new ProductDtoMapper());
		return listProduct;
	}
	
	@Transactional
	public boolean checkProductExistInBillDetail(int id) {
		String sql = "SELECT COUNT(*) FROM keyboard_shops.billdetail WHERE productid = ?";
		int count = _jdbcTemplate.queryForObject(sql, new Object[]{id}, Integer.class);
		return count > 0;
	}

	@Transactional
	public void deleteOneProduct(int id) {
		try {
            String sqlDeleteColor = "DELETE FROM keyboard_shops.color WHERE id_product = ?";
            _jdbcTemplate.update(sqlDeleteColor, id);
           
            String sqlDeleteProduct = "DELETE FROM keyboard_shops.product WHERE idP = ?";
            _jdbcTemplate.update(sqlDeleteProduct, id);
           
        } catch (Exception e) {
            throw e; // Re-throw the exception to ensure the transaction rolls back
        }
	}

	public void updateProductById(Product product) {
		StringBuilder sql = new StringBuilder();
	    sql.append("UPDATE product SET ");
	    sql.append("name = '").append(product.getName()).append("', ");
	    sql.append("price = ").append(product.getPrice()).append(", ");
	    sql.append("title = '").append(product.getTitle()).append("', ");  // Add comma here
	    sql.append("updated_at = '").append(new java.sql.Timestamp(product.getUpdatedAt().getTime())).append("' ");
	    sql.append("WHERE idP = ").append(product.getIdP()).append(";");
		 
		_jdbcTemplate.execute(sql.toString());
	}
    
}
