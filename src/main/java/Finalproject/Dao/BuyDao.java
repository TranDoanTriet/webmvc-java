package Finalproject.Dao;

import org.springframework.stereotype.Repository;

import Finalproject.Entity.Bill;
import Finalproject.Entity.BillDetail;

@Repository
public class BuyDao extends BaseDao{

	public int AddBill(Bill bill) {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO keyboard_shops.bill (email, phone, fullname, address, total, quantity, note, userid) VALUES ('");
		sql.append(bill.getEmail()).append("', '");
		sql.append(bill.getPhone()).append("', '");
		sql.append(bill.getFullname()).append("', '");
		sql.append(bill.getAddress()).append("', ");
		sql.append(bill.getTotal()).append(", ");
		sql.append(bill.getQuantity()).append(", '");
		sql.append(bill.getNote()).append("', '");
	    sql.append(bill.getUserid()).append("');");
		int insert = _jdbcTemplate.update(sql.toString());
		return insert;
	}
	public int GetIdLastBill() {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT MAX(idbill) FROM bill");
		int id = _jdbcTemplate.queryForObject(sql.toString(), new Object[] {}, Integer.class);
		return id;
	}
	public int AddBillDetail(BillDetail billDetail) {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO keyboard_shops.billdetail (productid, idbill, quantity, total) VALUES (");
		sql.append(billDetail.getProductid()).append(", ");
		sql.append(billDetail.getIdbill()).append(", ");
		sql.append(billDetail.getQuantity()).append(", ");
		sql.append(billDetail.getTotal()).append(");");
		int insert = _jdbcTemplate.update(sql.toString());
		return insert;
	}
}
