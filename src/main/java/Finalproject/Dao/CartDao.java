package Finalproject.Dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Finalproject.Dto.CartDto;
import Finalproject.Dto.ProductDto;

@Repository
public class CartDao extends BaseDao{
	@Autowired
	ProductDao productDao = new ProductDao();
	public HashMap<Integer, CartDto> AddCart(int id, HashMap<Integer, CartDto> cart) {
		CartDto itemCart = new CartDto();
		//lấy sản phẩm từ db
		ProductDto product = productDao.findProductById(id);
		//kiểm tra sản phẩm tồn tại
		if(product != null && cart.containsKey(id)) {
			itemCart = cart.get(id);
			itemCart.setQuantity(itemCart.getQuantity() + 1);
			itemCart.setTotalPrice(itemCart.getQuantity() * itemCart.getProduct().getPrice());
		}
		else {
			itemCart.setProduct(product);
			itemCart.setQuantity(1);
			double total = product.getPrice();
			itemCart.setTotalPrice(total);
		}
		cart.put(id, itemCart);
		
		return cart;
	}
	
	public HashMap<Integer, CartDto> EditCart(int id,int quantity, HashMap<Integer, CartDto> cart) {
		if(cart == null) {
			return cart;
		}
		CartDto itemCart = new CartDto();
		//kiểm tra sản phẩm có tồn tại trong giỏ hàng
		if(cart.containsKey(id)) {
			itemCart = cart.get(id);
			itemCart.setQuantity(quantity);
			double totalPrice = quantity * itemCart.getProduct().getPrice();
			itemCart.setTotalPrice(totalPrice);
		}
		cart.put(id, itemCart);
		
		return cart;
	}
	
	public HashMap<Integer, CartDto> DeleteCart(int id, HashMap<Integer, CartDto> cart) {
		if(cart == null) {
			return cart;
		}
		if(cart.containsKey(id)) {
			cart.remove(id);
		}
		
		return cart;
	}
	
	public int TotalQuantity( HashMap<Integer, CartDto> cart) {
		int totalQuantity = 0;
		for(Map.Entry<Integer, CartDto> itemCart : cart.entrySet()) {
			totalQuantity += itemCart.getValue().getQuantity();
		}
		
		return totalQuantity;
	}
	
	public double TotalPrice( HashMap<Integer, CartDto> cart) {
		double totalPrice = 0;
		for(Map.Entry<Integer, CartDto> itemCart : cart.entrySet()) {
			totalPrice += itemCart.getValue().getTotalPrice();
		}
		
		return totalPrice;
		
	}
}
