package Finalproject.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Finalproject.Dao.ProductDao;
import Finalproject.Dao.TagDao;
import Finalproject.Dto.ProductDto;
import Finalproject.Entity.Tag;

@Service
public class HomeServiceImpl implements IHomeService{
	@Autowired
	private TagDao tagDao;
	
	@Autowired
	private ProductDao productDao;
	
	@Override
	public List<Tag> getDataTags() {
		return tagDao.getDataTags();
	}
	
	@Override
	public List<ProductDto> getDataProduct(){
		List<ProductDto> lisProduct = productDao.getAllDataProduct();
		return lisProduct;
	}

	@Override
	public List<ProductDto> getSearchProduct(String keyword) {
		List<ProductDto> lisProduct = productDao.getSearchProduct(keyword);
		return lisProduct;
	}
	
}
