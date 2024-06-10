package Finalproject.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Finalproject.Dao.OrderDao;
import Finalproject.Entity.Bill;
import Finalproject.Entity.BillDetail;

@Service
public class OrderServiceImpl implements IOrderService{
	
	@Autowired
	private OrderDao orderDao;
	//admin
	@Override
	public List<Bill> getAllBill() {
		return orderDao.getAllBill();
	}
	@Override
	public List<BillDetail> getAllBillDetail(){
		return orderDao.getAllBillDetail();
	}
	//user
	@Override
	public List<Bill> getAllBillByIdUser(int id) {
		
		return orderDao.getAllBillByIdUser(id);
	}
	@Override
	public List<BillDetail> getBillDetailByIdBill(int id) {
		
		return orderDao.getAllBillDetailByIdBill(id);
	}
	@Override
	public void cancelOrderById(int id) {
		orderDao.DeleteOrder(id);
	}
	@Override
	public void receivedOrderById(int id) {
		orderDao.receivedOrder(id);
	}
	

}
