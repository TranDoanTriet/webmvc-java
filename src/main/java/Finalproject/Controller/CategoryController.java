package Finalproject.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import Finalproject.Dto.PaginateDto;
import Finalproject.Dto.ProductDto;
import Finalproject.Service.User.CategoryServiceImpl;
import Finalproject.Service.User.PaginateProductServiceImpl;

@Controller
public class CategoryController extends BaseController{
	@Autowired
	private CategoryServiceImpl categoryService;
	@Autowired
	private PaginateProductServiceImpl paginationService;
	
	int limit = 2;
	
    @RequestMapping(value = {"/user/product/{id}"})
    public ModelAndView Product(@PathVariable("id") int id) {
    	_mvSharePage.setViewName("user/category");
		/* int totalData = categoryService.getAllDataProductById(id).size(); */
    	
    	//lấy ra tất cả sản phẩm theo id
    	_mvSharePage.addObject("allProductById", categoryService.getAllDataProductById(id));
    	_mvSharePage.addObject("idCategory", id);
    	//lấy thông tin phân trang
		/*
		 * PaginateDto paginateInfo = paginationService.GetInfoPagination(totalData,
		 * limit, 1); _mvSharePage.addObject("paginateInfo", paginateInfo);
		 * _mvSharePage.addObject("productPaginate",
		 * categoryService.getDataProductPaginate(paginateInfo.getStart(),
		 * paginateInfo.getEnd(),id));
		 */
    	
        return _mvSharePage;
    }
    
	/*
	 * @RequestMapping(value = {"/user/product/{id}/{curentPage}"}) public
	 * ModelAndView Product(@PathVariable("id") int id,@PathVariable("curentPage")
	 * int curentPage) { _mvSharePage.setViewName("user/category"); int totalData =
	 * categoryService.getAllDataProductById(id).size();
	 * 
	 * //lấy ra tất cả sản phẩm theo id _mvSharePage.addObject("allProductById",
	 * categoryService.getAllDataProductById(id));
	 * _mvSharePage.addObject("idCategory", id); //lấy thông tin phân trang
	 * PaginateDto paginateInfo = paginationService.GetInfoPagination(totalData,
	 * limit, curentPage); _mvSharePage.addObject("paginateInfo", paginateInfo);
	 * _mvSharePage.addObject("productPaginate",
	 * categoryService.getDataProductPaginate(paginateInfo.getStart(),
	 * paginateInfo.getEnd(),id));
	 * 
	 * return _mvSharePage; }
	 */

}
