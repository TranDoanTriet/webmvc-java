package Finalproject.Entity;

import java.util.Date;

public class Product {
	private int idP;
    private String name;
    private double price;
    private int idTag;
    private int sale;
    private boolean bestSelling;
    private boolean gaming;
    private String producer;
    private String title;
    private String description;
    private Date createdAt;
    private Date updatedAt;
    private int quantity;
    public Product() {
		super();
		
	}
    
	public Product(int idP, String name, double price, int idTag, int sale, boolean bestSelling, boolean gaming,
			String producer, String title, String description, Date createdAt, Date updatedAt, int quantity) {
		super();
		this.idP = idP;
		this.name = name;
		this.price = price;
		this.idTag = idTag;
		this.sale = sale;
		this.bestSelling = bestSelling;
		this.gaming = gaming;
		this.producer = producer;
		this.title = title;
		this.description = description;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.quantity = quantity;
	}
	public int getIdP() {
		return idP;
	}
	public void setIdP(int idP) {
		this.idP = idP;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getIdTag() {
		return idTag;
	}
	public void setIdTag(int idTag) {
		this.idTag = idTag;
	}
	public int getSale() {
		return sale;
	}
	public void setSale(int sale) {
		this.sale = sale;
	}
	public boolean isBestSelling() {
		return bestSelling;
	}
	public void setBestSelling(boolean bestSelling) {
		this.bestSelling = bestSelling;
	}
	public boolean isGaming() {
		return gaming;
	}
	public void setGaming(boolean gaming) {
		this.gaming = gaming;
	}
	public String getProducer() {
		return producer;
	}
	public void setProducer(String producer) {
		this.producer = producer;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
    
    

}
