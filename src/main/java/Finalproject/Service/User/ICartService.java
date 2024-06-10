package Finalproject.Service.User;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import Finalproject.Dto.CartDto;

@Service
public interface ICartService {
	public HashMap<Integer, CartDto> AddCart(int id, HashMap<Integer, CartDto> cart);
	public HashMap<Integer, CartDto> EditCart(int id,int quantity, HashMap<Integer, CartDto> cart);
	public HashMap<Integer, CartDto> DeleteCart(int id, HashMap<Integer, CartDto> cart);
	public int TotalQuantity( HashMap<Integer, CartDto> cart);
	public double TotalPrice( HashMap<Integer, CartDto> cart);
}
