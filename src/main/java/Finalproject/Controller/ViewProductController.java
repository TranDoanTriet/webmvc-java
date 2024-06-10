package Finalproject.Controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import Finalproject.Service.User.ViewProductServiceImpl;

@Controller
public class ViewProductController extends BaseController{
	@Autowired
	private ViewProductServiceImpl _viewProductService;
	
    @RequestMapping("/user/view-product/{id}")
    public ModelAndView viewProduct(@PathVariable("id") int id) {
    	_mvSharePage.setViewName("user/viewProduct");
    	_mvSharePage.addObject("viewProduct", _viewProductService.getViewProductData(id));
    	
        return _mvSharePage;
    }
	
}
