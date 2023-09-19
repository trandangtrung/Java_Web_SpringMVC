package entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "TBL_hoadon")
public class HoaDon {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ma_hd")
	private Integer ma_hd;
	@Column(name = "ten")
	private String ten;
	@Column(name = "phone")
	private String phone;
	@Column(name = "display_name")
	private String display_name;
	@Column(name = "address")
	private String address;
	@Column(name = "total")
	private double total;
	@Column(name = "quanty")
	private int quanty;
	@Column(name = "note")
	private String note;
	
	@OneToMany(mappedBy = "hoaDon", fetch = FetchType.LAZY)
	@Fetch(FetchMode.SUBSELECT)
	private List<HoaDonChiTiet> lsthdct;
	
	public HoaDon() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HoaDon(Integer ma_hd, String ten, String phone, String display_name, String address, double total,
			int quanty, String note) {
		super();
		this.ma_hd = ma_hd;
		this.ten = ten;
		this.phone = phone;
		this.display_name = display_name;
		this.address = address;
		this.total = total;
		this.quanty = quanty;
		this.note = note;
	}

	public Integer getMa_hd() {
		return ma_hd;
	}

	public void setMa_hd(Integer ma_hd) {
		this.ma_hd = ma_hd;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public int getQuanty() {
		return quanty;
	}

	public void setQuanty(int quanty) {
		this.quanty = quanty;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public List<HoaDonChiTiet> getLsthdct() {
		return lsthdct;
	}

	public void setLsthdct(List<HoaDonChiTiet> lsthdct) {
		this.lsthdct = lsthdct;
	}

	

}
