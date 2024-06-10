package Finalproject.Dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import Finalproject.Entity.Bill;
import Finalproject.Entity.BillDetail;
import Finalproject.Entity.BillDetailMapper;
import Finalproject.Entity.BillMapper;

@Repository
public class OrderDao extends BaseDao{

	public List<Bill> getAllBillByIdUser(int id) {
		String sql = "SELECT * FROM keyboard_shops.bill WHERE userid = " + id;
		return _jdbcTemplate.query(sql, new BillMapper());
	}

	public List<BillDetail> getAllBillDetailByIdBill(int id) {
		String sql = "SELECT * FROM keyboard_shops.billdetail WHERE idbill = " + id;
		return _jdbcTemplate.query(sql, new BillDetailMapper());
	}

	public void DeleteOrder(int id) {
		String sql1 = "DELETE FROM keyboard_shops.billdetail WHERE idbill = " + id;
		_jdbcTemplate.execute(sql1);
		String sql2 = "DELETE FROM keyboard_shops.bill WHERE idbill = " + id;
		_jdbcTemplate.execute(sql2);
	}

	public void receivedOrder(int id) {
		String sql = "UPDATE keyboard_shops.bill SET status = 1 WHERE idbill = ?";
        _jdbcTemplate.update(sql, id);
	}
	
	//admin
	public List<Bill> getAllBill() {
		String sql = "SELECT * FROM keyboard_shops.bill";
		return _jdbcTemplate.query(sql, new BillMapper());
	}
	
	public List<BillDetail> getAllBillDetail() {
		String sql = "SELECT * FROM keyboard_shops.billdetail";
		return _jdbcTemplate.query(sql, new BillDetailMapper());
	}
	
}
