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
@Table(name = "TBL_loaisanpham")
public class LoaiSanPham {
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ma_lsp")
	private int ma_lsp;
	@Column(name = "ten_loai")
	private String ten_loai;
	@Column(name = "trang_thai")
	private Short trang_thai;
	

	@OneToMany(mappedBy = "loaiSanPham", fetch = FetchType.EAGER)
	private List<SanPham> lstSanPham;

	public LoaiSanPham() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LoaiSanPham(int ma_lsp, String ten_loai, Short trang_thai) {
		super();
		this.ma_lsp = ma_lsp;
		this.ten_loai = ten_loai;
		this.trang_thai = trang_thai;
	}

	public int getMa_lsp() {
		return ma_lsp;
	}

	public void setMa_lsp(int ma_lsp) {
		this.ma_lsp = ma_lsp;
	}

	public String getTen_loai() {
		return ten_loai;
	}

	public void setTen_loai(String ten_loai) {
		this.ten_loai = ten_loai;
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
