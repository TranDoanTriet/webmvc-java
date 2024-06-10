package Finalproject.Service.User;

import java.util.List;

import org.springframework.stereotype.Service;

import Finalproject.Dto.ProductDto;
import Finalproject.Entity.Tag;

@Service
public interface IHomeService {
	public List<Tag> getDataTags();
	public List<ProductDto> getDataProduct();
	public List<ProductDto> getSearchProduct(String keyword);
}
