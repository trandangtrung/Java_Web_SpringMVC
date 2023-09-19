package entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_Color")
public class Color implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ma_ms")
	private int ma_ms;
	@Column(name = "ten_ms")
	private String ten_ms;
	@Column(name = "trang_thai")
	private Short trang_thai;
	@Column(name = "ma_sp")
	private int ma_sp;
	
	@OneToOne(mappedBy = "color",cascade = CascadeType.ALL)
	private SanPham sanPham;
	
	public Color() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Color(int ma_ms, String ten_ms, Short trang_thai, int ma_sp) {
		super();
		this.ma_ms = ma_ms;
		this.ten_ms = ten_ms;
		this.trang_thai = trang_thai;
		this.ma_sp = ma_sp;
		
	}

	public int getMa_ms() {
		return ma_ms;
	}

	public void setMa_ms(int ma_ms) {
		this.ma_ms = ma_ms;
	}

	public String getTen_ms() {
		return ten_ms;
	}

	public void setTen_ms(String ten_ms) {
		this.ten_ms = ten_ms;
	}

	public Short getTrang_thai() {
		return trang_thai;
	}

	public void setTrang_thai(Short trang_thai) {
		this.trang_thai = trang_thai;
	}

	public int getMa_sp() {
		return ma_sp;
	}

	public void setMa_sp(int ma_sp) {
		this.ma_sp = ma_sp;
	}

	public SanPham getSanPham() {
		return sanPham;
	}

	public void setSanPham(SanPham sanPham) {
		this.sanPham = sanPham;
	}
	
	
	
	
	
}
