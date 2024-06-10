package Finalproject.Service.User;

import java.util.List;

import org.springframework.stereotype.Service;

import Finalproject.Dto.ProductDto;

@Service
public interface ICategoryService {
	public List<ProductDto> getDataProductPaginate(int start, int end, int id);
	public List<ProductDto> getAllDataProductById(int id);
}
