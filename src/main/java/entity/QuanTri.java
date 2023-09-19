package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_QuanTri")
public class QuanTri {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name = "tai_khoan")
	private String tai_khoan ;
	@Column(name = "mat_khau")
	private String mat_khau;
	@Column(name = "trang_thai")
	private Short trang_thai;
	public QuanTri() {
		super();
		// TODO Auto-generated constructor stub
	}
	public QuanTri(String tai_khoan, String mat_khau, Short trang_thai) {
		super();
		this.tai_khoan = tai_khoan;
		this.mat_khau = mat_khau;
		this.trang_thai = trang_thai;
	}
	public String getTai_khoan() {
		return tai_khoan;
	}
	public void setTai_khoan(String tai_khoan) {
		this.tai_khoan = tai_khoan;
	}
	public String getMat_khau() {
		return mat_khau;
	}
	public void setMat_khau(String mat_khau) {
		this.mat_khau = mat_khau;
	}
	public Short getTrang_thai() {
		return trang_thai;
	}
	public void setTrang_thai(Short trang_thai) {
		this.trang_thai = trang_thai;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
