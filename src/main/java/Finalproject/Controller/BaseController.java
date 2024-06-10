package Finalproject.Controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import Finalproject.Service.User.HomeServiceImpl;

@Controller
public class BaseController {
	@Autowired
    HomeServiceImpl _homeService;
	
	public ModelAndView _mvSharePage = new ModelAndView();
	
	@PostConstruct
	public void initBase() {
		_mvSharePage.addObject("product", _homeService.getDataProduct());
		_mvSharePage.addObject("tag", _homeService.getDataTags());
	}
}
