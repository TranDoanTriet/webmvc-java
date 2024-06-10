package Finalproject.Entity;

import java.util.Date;

public class Bill {
    private int idbill;
    private String email;
    private String phone;
    private String fullname;
    private String address;
    private double total;
    private int quantity;
    private String note;
    private int userid;
    private boolean status;
    public Bill() {
		
	}
	
	public Bill(int idbill, String email, String phone, String fullname, String address, double total, int quantity,
			String note, int userid, boolean status) {
		super();
		this.idbill = idbill;
		this.email = email;
		this.phone = phone;
		this.fullname = fullname;
		this.address = address;
		this.total = total;
		this.quantity = quantity;
		this.note = note;
		this.userid = userid;
		this.status = status;
	}

	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getIdbill() {
		return idbill;
	}
	public void setIdbill(int idbill) {
		this.idbill = idbill;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
    
    
    
}
