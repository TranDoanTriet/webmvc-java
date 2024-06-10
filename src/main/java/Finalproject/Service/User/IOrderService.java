package Finalproject.Service.User;

import java.util.List;

import org.springframework.stereotype.Service;

import Finalproject.Entity.Bill;
import Finalproject.Entity.BillDetail;

@Service
public interface IOrderService {
	public List<Bill> getAllBillByIdUser(int id);
	
	public List<BillDetail> getBillDetailByIdBill(int id);
	public void cancelOrderById(int id);
	public void receivedOrderById(int id);
	
	
	//admin
	public List<Bill> getAllBill();
	public List<BillDetail> getAllBillDetail();
}
