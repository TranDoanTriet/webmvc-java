package Finalproject.Service.Admin;

import org.springframework.stereotype.Service;

import Finalproject.Dto.ProductDto;
import Finalproject.Entity.Product;

@Service
public interface IMangeProductService {
	public void saveNewProduct(ProductDto product);
	public boolean checkProductExistInBillDetail(int id);
	public void deleteOneProduct(int id);
	public void updateProductById(Product product);
}
