package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TBL_Users")
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id ;
	@Column(name="ten")
	private String ten ;
	@Column(name="pass_word")
	private String pass_word ;
	@Column(name="display_name")
	private String display_name ;
	@Column(name="address")
	private String address ;
	
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Users(int id, String ten, String pass_word, String display_name, String address) {
		super();
		this.id = id;
		this.ten = ten;
		this.pass_word = pass_word;
		this.display_name = display_name;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getPass_word() {
		return pass_word;
	}

	public void setPass_word(String pass_word) {
		this.pass_word = pass_word;
	}

	public String getDisplay_name() {
		return display_name;
	}

	public void setDisplay_name(String display_name) {
		this.display_name = display_name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
