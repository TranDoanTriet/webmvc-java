package Finalproject.Service.User;

import java.util.List;

import org.springframework.stereotype.Service;

import Finalproject.Dto.ProductDto;

@Service
public interface IViewProductService {
	public List<ProductDto> getViewProductData(int id); 
}
