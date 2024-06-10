package Finalproject.Service.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Finalproject.Dao.OrderDao;
import Finalproject.Dao.ProductDao;
import Finalproject.Dto.ProductDto;
import Finalproject.Entity.Product;

@Service
public class MangeProductServiceImpl implements IMangeProductService{
	
	@Autowired
	private ProductDao productDao;
	@Override
	public void saveNewProduct(ProductDto product) {
		productDao.saveNewProduct(product);
	}
	@Override
	public boolean checkProductExistInBillDetail(int id) {
		return productDao.checkProductExistInBillDetail(id);
	}
	@Override
	public void deleteOneProduct(int id) {
		productDao.deleteOneProduct(id);
	}
	@Override
	public void updateProductById(Product product) {
		productDao.updateProductById(product);
	}
}
