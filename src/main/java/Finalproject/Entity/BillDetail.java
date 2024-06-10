package Finalproject.Entity;

public class BillDetail {
	private int 	idbillDetail;
    private int 	productid;
    private int 	idbill;
    private int 	quantity;
    private double 	total;
    public BillDetail() {
		
	}
	
	public BillDetail(int idbillDetail, int productid, int idbill, int quantity, double total) {
		super();
		this.idbillDetail = idbillDetail;
		this.productid = productid;
		this.idbill = idbill;
		this.quantity = quantity;
		this.total = total;
	}

	public int getIdbillDetail() {
		return idbillDetail;
	}
	public void setIdbillDetail(int idbillDetail) {
		this.idbillDetail = idbillDetail;
	}
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public int getIdbill() {
		return idbill;
	}
	public void setIdbill(int idbill) {
		this.idbill = idbill;
	}

    

    
}
