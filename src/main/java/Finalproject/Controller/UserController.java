package Finalproject.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import Finalproject.Entity.UserEntity;
import Finalproject.Service.User.AccountServiceImpl;

@Controller
public class UserController extends BaseController{
	@Autowired
	AccountServiceImpl accountService = new AccountServiceImpl();
	@RequestMapping(value = {"/authen/logout"})
	public String logout(HttpSession session) {
		session.removeAttribute("LoginInfo");
		
		return "redirect:/user/home";
	}
	@RequestMapping(value = {"/authen/login"}, method = RequestMethod.GET)
    public ModelAndView login() {
    	_mvSharePage.setViewName("authen/login");
    	_mvSharePage.addObject("user",new UserEntity());
    	_mvSharePage.addObject("status", "");
    	
        return _mvSharePage;
    }
	@RequestMapping(value = {"/authen/login"}, method = RequestMethod.POST)
    public ModelAndView loginAccount(HttpSession session,@ModelAttribute("user") UserEntity user) {
    	UserEntity usercheck = accountService.checkAccount(user);
    	
    	if(usercheck != null && usercheck.getPassword().equals(user.getPassword()) && usercheck.getUsername().equals(user.getUsername())) {
    		
    		session.setAttribute("LoginInfo", usercheck);
    		
    		if(usercheck.getRole() == 2) {	
    			_mvSharePage.setViewName("redirect:/admin/home");
    		}else {
    			_mvSharePage.setViewName("redirect:/user/home");
    		}
        } else {
        	_mvSharePage.addObject("status", "Login failed");
        }
    	
        return _mvSharePage;
    }
	
	@RequestMapping(value = {"/authen/sign-up"}, method = RequestMethod.GET)
    public ModelAndView signUpView() {
    	_mvSharePage.setViewName("authen/signUp");
    	_mvSharePage.addObject("user",new UserEntity());
    	_mvSharePage.addObject("status", "");
        return _mvSharePage;
    }
	
	@RequestMapping(value = {"/authen/sign-up"}, method = RequestMethod.POST)
    public ModelAndView signUpAccount(@ModelAttribute("user") UserEntity user) {
    	
    	int count = accountService.addAccount(user);
    	if(count > 0) {
    		_mvSharePage.addObject("status", "create account success");
    	}else {
    		_mvSharePage.addObject("status", "create account failed");
    	}
    	_mvSharePage.setViewName("authen/signUp");
        return _mvSharePage;
    }
	
	@RequestMapping(value = {"/authen/profile"})
    public ModelAndView profile() {
    	_mvSharePage.setViewName("authen/profile");
    	
    	
        return _mvSharePage;
    }
}
