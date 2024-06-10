package Finalproject.Dto;

import java.util.Date;

public class ProductDto {
	private int idProduct;
    private String productName;
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
    private int idColor;
    private String colorName;
    private String colorCode;
    private String img;
    private int quantity;
    
    

	public ProductDto() {
    	super();
    }

	public int getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
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

	public int getIdColor() {
		return idColor;
	}

	public void setIdColor(int idColor) {
		this.idColor = idColor;
	}

	public String getColorName() {
		return colorName;
	}

	public void setColorName(String colorName) {
		this.colorName = colorName;
	}

	public String getColorCode() {
		return colorCode;
	}

	public void setColorCode(String colorCode) {
		this.colorCode = colorCode;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
		
	}
    
	public int getQuantity() {
		return quantity;
	}
}
