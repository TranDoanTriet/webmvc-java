package Finalproject.Service.User;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Finalproject.Dao.BuyDao;
import Finalproject.Dto.CartDto;
import Finalproject.Entity.Bill;
import Finalproject.Entity.BillDetail;

@Service
public class BuyServiceImpl implements IBuyService{
	@Autowired
	private BuyDao buyDao;
	
	@Override
	public int AddBill(Bill bill) {
		
		return buyDao.AddBill(bill);
	}
	@Override
	public void AddBillDetail(HashMap<Integer, CartDto> carts) {
		int idBill =  buyDao.GetIdLastBill();
		for(Map.Entry<Integer, CartDto> itemCart : carts.entrySet()) {
			BillDetail billDetail = new BillDetail();
			billDetail.setIdbill(idBill);
			billDetail.setProductid(itemCart.getValue().getProduct().getIdProduct());
			billDetail.setQuantity(itemCart.getValue().getQuantity());
			billDetail.setTotal(itemCart.getValue().getTotalPrice());
			buyDao.AddBillDetail(billDetail);
		}
	}

}
