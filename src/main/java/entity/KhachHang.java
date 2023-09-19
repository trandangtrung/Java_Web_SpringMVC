package entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "TBL_KHACHHANG")
public class KhachHang {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ma_kh")
	private int ma_kh;
	@Column(name = "ho_ten")
	private String ho_ten;
	@Column(name = "tai_khoan")
	private String tai_khoan;
	@Column(name = "mat_khau")
	private String mat_khau;
	@Column(name = "dia_chi")
	private String dia_chi;
	@Column(name = "dien_thoai")
	private String dien_thoai;
	@Column(name = "email")
	private String email;
	@Column(name = "ngay_sinh")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date ngay_sinh;
	@Column(name = "ngay_cap_nhat")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date ngay_cap_nhat;
	@Column(name = "gioi_tinh")
	private String gioi_tinh;
	@Column(name = "tich_diem")
	private int tich_diem;
	@Column(name = "trang_thai")
	private Short trang_thai;

	public KhachHang() {
		super();
		// TODO Auto-generated constructor stub
	}

	public KhachHang(int ma_kh, String ho_ten, String tai_khoan, String mat_khau, String dia_chi, String dien_thoai,
			String email, Date ngay_sinh, Date ngay_cap_nhat, String gioi_tinh, int tich_diem, Short trang_thai) {
		super();
		this.ma_kh = ma_kh;
		this.ho_ten = ho_ten;
		this.tai_khoan = tai_khoan;
		this.mat_khau = mat_khau;
		this.dia_chi = dia_chi;
		this.dien_thoai = dien_thoai;
		this.email = email;
		this.ngay_sinh = ngay_sinh;
		this.ngay_cap_nhat = ngay_cap_nhat;
		this.gioi_tinh = gioi_tinh;
		this.tich_diem = tich_diem;
		this.trang_thai = trang_thai;
	}

	public int getMa_kh() {
		return ma_kh;
	}

	public void setMa_kh(int ma_kh) {
		this.ma_kh = ma_kh;
	}

	public String getHo_ten() {
		return ho_ten;
	}

	public void setHo_ten(String ho_ten) {
		this.ho_ten = ho_ten;
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

	public String getDia_chi() {
		return dia_chi;
	}

	public void setDia_chi(String dia_chi) {
		this.dia_chi = dia_chi;
	}

	public String getDien_thoai() {
		return dien_thoai;
	}

	public void setDien_thoai(String dien_thoai) {
		this.dien_thoai = dien_thoai;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getNgay_sinh() {
		return ngay_sinh;
	}

	public void setNgay_sinh(Date ngay_sinh) {
		this.ngay_sinh = ngay_sinh;
	}

	public Date getNgay_cap_nhat() {
		return ngay_cap_nhat;
	}

	public void setNgay_cap_nhat(Date ngay_cap_nhat) {
		this.ngay_cap_nhat = ngay_cap_nhat;
	}

	public String getGioi_tinh() {
		return gioi_tinh;
	}

	public void setGioi_tinh(String gioi_tinh) {
		this.gioi_tinh = gioi_tinh;
	}

	public int getTich_diem() {
		return tich_diem;
	}

	public void setTich_diem(int tich_diem) {
		this.tich_diem = tich_diem;
	}

	public Short getTrang_thai() {
		return trang_thai;
	}

	public void setTrang_thai(Short trang_thai) {
		this.trang_thai = trang_thai;
	}

}
