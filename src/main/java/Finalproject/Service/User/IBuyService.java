package Finalproject.Service.User;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import Finalproject.Dto.CartDto;
import Finalproject.Entity.Bill;

@Service
public interface IBuyService {
	public int AddBill(Bill bill);
	public void AddBillDetail(HashMap<Integer, CartDto> carts);
}
