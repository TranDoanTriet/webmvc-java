package Finalproject.Entity;

public class UserEntity {
	private int idUser;
	private String username;
	private String password;
	private String fullname;
	private String phone;
	private String address;
	private int role;
	private String email;
	
	public UserEntity() {
		super();
	}
	public UserEntity(int idUser, String username, String password, String fullname, String phone, String address,
			int role, String email) {
		super();
		this.idUser = idUser;
		this.username = username;
		this.password = password;
		this.fullname = fullname;
		this.phone = phone;
		this.address = address;
		this.role = role;
		this.email = email;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
