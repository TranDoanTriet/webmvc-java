package Finalproject.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Finalproject.Dao.ProductDao;
import Finalproject.Dto.ProductDto;

@Service
public class ViewProductServiceImpl implements IViewProductService{
	@Autowired
	ProductDao productDao = new ProductDao();
	
	@Override
	public List<ProductDto> getViewProductData(int id) {
		return productDao.getViewProductById(id);
	}

}
