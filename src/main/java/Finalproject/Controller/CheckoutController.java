package Finalproject.Controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import Finalproject.Dto.CartDto;
import Finalproject.Entity.Bill;
import Finalproject.Entity.UserEntity;
import Finalproject.Service.User.BuyServiceImpl;


@Controller
public class CheckoutController extends BaseController{
	@Autowired
	private BuyServiceImpl billService = new BuyServiceImpl();
	
	@RequestMapping(value = {"/user/checkout"}, method = RequestMethod.GET)
    public ModelAndView login(HttpServletRequest request, HttpSession session) {
    	_mvSharePage.setViewName("user/checkout");
    	Bill bill = new Bill();
    	UserEntity loginInfo = (UserEntity) session.getAttribute("LoginInfo"); 
    	
    	if(loginInfo != null) {
    		bill.setAddress(loginInfo.getAddress());
    		bill.setFullname(loginInfo.getFullname());
    		bill.setEmail(loginInfo.getEmail());
    		bill.setPhone(loginInfo.getPhone());
    		bill.setUserid(loginInfo.getIdUser());
    	}
    	_mvSharePage.addObject("bill", bill);
    	
        return _mvSharePage;
    }
	
	@RequestMapping(value = {"/user/checkout"}, method = RequestMethod.POST)
    public String login(HttpServletRequest request, HttpSession session, @ModelAttribute("bill") Bill bill) {
		String totalQuantityStr = session.getAttribute("totalQuantity").toString();
	    String totalPriceStr = session.getAttribute("totalPrice").toString();
	    UserEntity loginInfo = (UserEntity) session.getAttribute("LoginInfo"); 
	    
	    int totalQuantity = Integer.parseInt(totalQuantityStr);
	    double totalPrice = Double.parseDouble(totalPriceStr);
	    

	    bill.setQuantity(totalQuantity);
	    bill.setTotal(totalPrice);
	    bill.setUserid(loginInfo.getIdUser());
	    
    	if(billService.AddBill(bill) > 0) {
    		HashMap<Integer, CartDto> carts = (HashMap<Integer, CartDto>) session.getAttribute("cart");
    		billService.AddBillDetail(carts);
    	}
    	session.removeAttribute("cart");
    	session.removeAttribute("totalQuantity");
    	session.removeAttribute("totalPrice");
        return "redirect: /final_project/user/cart";
    }
}
