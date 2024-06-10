package Finalproject.Controller;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import Finalproject.Dto.ProductDto;
import Finalproject.Service.User.HomeServiceImpl;

@Controller
public class DefaultController extends BaseController{
    @RequestMapping(value = {"/","/index"}, method = RequestMethod.GET)
    public ModelAndView home1() {
    	 _mvSharePage.setViewName("user/homeUser");
        return _mvSharePage;
    }
    
    @RequestMapping(value = {"/user/home"}, method = RequestMethod.GET)
    public ModelAndView homeUser() {
    	
        _mvSharePage.setViewName("user/homeUser");
        return _mvSharePage;
    }
    @RequestMapping(value = {"/admin/home"}, method = RequestMethod.GET)
    public ModelAndView homeAdmin(HttpSession session) {
    	if(session.getAttribute("LoginInfo") == null) {
    		_mvSharePage.setViewName("redirect:/authen/login");
    	}else {
    		_mvSharePage.setViewName("admin/homeAdmin");
    	}
        return _mvSharePage;
    }
    
    @RequestMapping(value = {"/search"}, method = RequestMethod.GET)
    public ModelAndView searchProduct(@RequestParam("keyword") String keyword) {
    	List<ProductDto> listSearchProduct = _homeService.getSearchProduct(keyword.trim());
    	_mvSharePage.addObject("listSearchProduct",listSearchProduct);
        _mvSharePage.setViewName("user/search");
        return _mvSharePage;
    }
    
}