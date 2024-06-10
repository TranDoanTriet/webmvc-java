package Finalproject.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Finalproject.Dao.ProductDao;
import Finalproject.Dto.ProductDto;

@Service
public class CategoryServiceImpl implements ICategoryService{
	
	@Autowired
	private ProductDao productDao;
	
	@Override
	public List<ProductDto> getAllDataProductById(int id) {
		List<ProductDto> products = productDao.getDataProductByIdTag(id);
		return products;
	}
	
	@Override
	public List<ProductDto> getDataProductPaginate(int start, int end, int id) {
		List<ProductDto> products = productDao.getDataProductPaginate(start, end, id);
		return products;
	}
}