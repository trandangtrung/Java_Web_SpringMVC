package entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_nhanhieu")
public class NhanHieu {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ma_nh")
	private int ma_nh ;
	@Column(name = "ten_nhan_hieu")
    private String ten_nhan_hieu;
	@Column(name = "trang_thai")
    private Short trang_thai ;
	
	@OneToMany(mappedBy = "nhanHieu", fetch = FetchType.EAGER)
	private List<SanPham> lstSanPham;
	
	public NhanHieu() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NhanHieu(int ma_nh, String ten_nhan_hieu, Short trang_thai) {
		super();
		this.ma_nh = ma_nh;
		this.ten_nhan_hieu = ten_nhan_hieu;
		this.trang_thai = trang_thai;
	}
	public int getMa_nh() {
		return ma_nh;
	}
	public void setMa_nh(int ma_nh) {
		this.ma_nh = ma_nh;
	}
	public String getTen_nhan_hieu() {
		return ten_nhan_hieu;
	}
	public void setTen_nhan_hieu(String ten_nhan_hieu) {
		this.ten_nhan_hieu = ten_nhan_hieu;
	}
	public Short getTrang_thai() {
		return trang_thai;
	}
	public void setTrang_thai(Short trang_thai) {
		this.trang_thai = trang_thai;
	}
	public List<SanPham> getLstSanPham() {
		return lstSanPham;
	}
	public void setLstSanPham(List<SanPham> lstSanPham) {
		this.lstSanPham = lstSanPham;
	}
	
	
}
