package Finalproject.Controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import java.text.DecimalFormat;
import Finalproject.Dto.CartDto;
import Finalproject.Service.User.CartServiceImpl;

@Controller
public class CartController extends BaseController{
	
	@Autowired
	private CartServiceImpl cartService = new CartServiceImpl();
	
	@RequestMapping(value = {"/user/cart"})
    public ModelAndView Product(HttpSession session) {
		if(session.getAttribute("LoginInfo") == null) {
			_mvSharePage.setViewName("redirect:/authen/login");
			return _mvSharePage;
		}
    	_mvSharePage.setViewName("user/cart");
        return _mvSharePage;
    }
	
	@RequestMapping(value = {"/addCart/{id}"})
	public String addCart(HttpServletRequest request,HttpSession session, @PathVariable int id) {
		
		HashMap<Integer, CartDto> cart = (HashMap<Integer, CartDto>) session.getAttribute("cart");
		if(cart == null ) {
			cart = new HashMap<Integer, CartDto>();
		}
		cart = cartService.AddCart(id, cart);
		session.setAttribute("cart", cart);
		session.setAttribute("totalQuantity", cartService.TotalQuantity(cart));
		
		double totalPrice = cartService.TotalPrice(cart);
		DecimalFormat decimalFormat = new DecimalFormat("#.00");
		String formattedPrice = decimalFormat.format(totalPrice);
		
		session.setAttribute("totalPrice", formattedPrice);
		return "redirect:"+ request.getHeader("Referer");
	}
	
	@RequestMapping(value = {"/deleteCart/{id}"})
	public String deleteCart(HttpServletRequest request,HttpSession session, @PathVariable int id) {
		HashMap<Integer, CartDto> cart = (HashMap<Integer, CartDto>) session.getAttribute("cart");
		if(cart == null ) {
			cart = new HashMap<Integer, CartDto>();
		}
		cart = cartService.DeleteCart(id, cart);
		session.setAttribute("cart", cart);
		session.setAttribute("totalQuantity", cartService.TotalQuantity(cart));
		
		double totalPrice = cartService.TotalPrice(cart);
		DecimalFormat decimalFormat = new DecimalFormat("#.00");
		String formattedPrice = decimalFormat.format(totalPrice);
		
		session.setAttribute("totalPrice", formattedPrice);
		return "redirect:"+ request.getHeader("Referer");
	}
	
	@RequestMapping(value = {"/editCart/{id}/{quantity}"})
	public String editCart(HttpServletRequest request,HttpSession session, @PathVariable int id, @PathVariable int quantity) {
		HashMap<Integer, CartDto> cart = (HashMap<Integer, CartDto>) session.getAttribute("cart");
		if(cart == null ) {
			cart = new HashMap<Integer, CartDto>();
		}
		cart = cartService.EditCart(id,quantity, cart);
		session.setAttribute("cart", cart);
		session.setAttribute("totalQuantity", cartService.TotalQuantity(cart));
		
		double totalPrice = cartService.TotalPrice(cart);
		DecimalFormat decimalFormat = new DecimalFormat("#.00");
		String formattedPrice = decimalFormat.format(totalPrice);
		
		session.setAttribute("totalPrice", formattedPrice);
		return "redirect:"+ request.getHeader("Referer");
	}
}
