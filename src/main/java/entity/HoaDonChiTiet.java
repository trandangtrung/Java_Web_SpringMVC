package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@IdClass(PKHoaDonChiTiet.class)
@Table(name = "TBL_chitiethd")
public class HoaDonChiTiet {
	@Id
	@ManyToOne
	@JoinColumn(name = "ma_hd", referencedColumnName = "ma_hd" , insertable = false , updatable = false )
	private HoaDon hoaDon;
	@Column(name="ma_hd")
	private Long ma_hd;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "ma_sp", referencedColumnName = "ma_sp", insertable = false , updatable = false )
	private SanPham sanPham;
	@Column(name="ma_sp")
	private Integer ma_sp;
	
	@Column(name = "quanty")
	private Integer quanty;
	@Column(name = "total")
	private double total;
	public HoaDonChiTiet() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public HoaDonChiTiet(HoaDon hoaDon, Long ma_hd, SanPham sanPham, int ma_sp, Integer quanty, double total) {
		super();
		this.hoaDon = hoaDon;
		this.ma_hd = ma_hd;
		this.sanPham = sanPham;
		this.ma_sp = ma_sp;
		this.quanty = quanty;
		this.total = total;
	}

	public HoaDon getHoaDon() {
		return hoaDon;
	}

	public void setHoaDon(HoaDon hoaDon) {
		this.hoaDon = hoaDon;
	}

	public Long getMa_hd() {
		return ma_hd;
	}

	public void setMa_hd(Long ma_hd) {
		this.ma_hd = ma_hd;
	}

	public SanPham getSanPham() {
		return sanPham;
	}

	public void setSanPham(SanPham sanPham) {
		this.sanPham = sanPham;
	}

	public Integer getMa_sp() {
		return ma_sp;
	}

	public void setMa_sp(int ma_sp) {
		this.ma_sp = ma_sp;
	}

	public Integer getQuanty() {
		return quanty;
	}

	public void setQuanty(Integer quanty) {
		this.quanty = quanty;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	
	
}
