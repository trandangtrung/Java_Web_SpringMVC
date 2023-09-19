package entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="TBL_sp")
public class SanPham  {
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ma_sp")
	private int ma_sp;
	@Size(min = 5, max = 50, message = "{msg.err.string.ranger}") // Tên sản phẩm phải có từ 5 - 50 ký tự
	@NotEmpty(message = "{msg.err.notempty}")
	@Column(name="ten_sp")
	private String ten_sp;
	@Column(name="thong_tin")
	private String thong_tin;
	@Column(name="gia_nhap")
	@Max(value = 1000000, message = "Giá tối đa là 1.000.000 vnđ")
	@PositiveOrZero(message = "Giá bằng 0 hoặc lớn")
	private double gia_nhap;
	@Column(name="gia_cu")
	@PositiveOrZero(message = "Giá bằng 0 hoặc lớn")
	private double gia_cu;
	@Column(name="gia_moi")
	@PositiveOrZero(message = "Giá bằng 0 hoặc lớn")
	private double gia_moi;
	@Column(name="luot_xem")
	private int luot_xem;
	@Column(name="ngay_cap_nhat")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "Dữ liệu ngày nhập không để trống")
	private Date ngay_cap_nhat;
	@Column(name="trang_thai")
	private Short trang_thai;
	@Column(name="img")
	private String img;
	@Column(name="ma_lsp")
	@PositiveOrZero(message = "Giá bằng 0 hoặc lớn")
	private int ma_lsp;
	@Column(name="ma_nh")
	@PositiveOrZero(message = "Giá bằng 0 hoặc lớn")
	private int ma_nh;
	
//	private MultipartFile fileImage;
	
	@ManyToOne
	@JoinColumn(name = "ma_lsp", referencedColumnName = "ma_lsp",insertable = false, updatable = false)
	private LoaiSanPham loaiSanPham;
	
	@ManyToOne
	@JoinColumn(name = "ma_nh", referencedColumnName = "ma_nh", insertable = false, updatable = false)
	private NhanHieu nhanHieu;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ma_sp",referencedColumnName = "ma_sp")
	private Color color;
	
	@OneToMany(mappedBy = "sanPham", fetch = FetchType.LAZY)
	@Fetch(FetchMode.SUBSELECT)
	private List<HoaDonChiTiet> lsthdct;
	
	public SanPham() {
		super();
		// TODO Auto-generated constructor stub
	} 
	
	

	public SanPham(int ma_sp, String ten_sp, String thong_tin, double gia_nhap, double gia_cu,
			double gia_moi, int luot_xem, Date ngay_cap_nhat, Short trang_thai, String img, int ma_lsp, int ma_nh) {
		super();
		this.ma_sp = ma_sp;
		this.ten_sp = ten_sp;
		this.thong_tin = thong_tin;
		this.gia_nhap = gia_nhap;
		this.gia_cu = gia_cu;
		this.gia_moi = gia_moi;
		this.luot_xem = luot_xem;
		this.ngay_cap_nhat = ngay_cap_nhat;
		this.trang_thai = trang_thai;
		this.img = img;
		this.ma_lsp = ma_lsp;
		this.ma_nh = ma_nh;
	}



	public int getMa_sp() {
		return ma_sp;
	}
	public void setMa_sp(int ma_sp) {
		this.ma_sp = ma_sp;
	}
	public String getTen_sp() {
		return ten_sp;
	}
	public void setTen_sp(String ten_sp) {
		this.ten_sp = ten_sp;
	}
	public String getThong_tin() {
		return thong_tin;
	}
	public void setThong_tin(String thong_tin) {
		this.thong_tin = thong_tin;
	}
	public double getGia_nhap() {
		return gia_nhap;
	}
	public void setGia_nhap(double gia_nhap) {
		this.gia_nhap = gia_nhap;
	}
	public double getGia_cu() {
		return gia_cu;
	}
	public void setGia_cu(double gia_cu) {
		this.gia_cu = gia_cu;
	}
	public double getGia_moi() {
		return gia_moi;
	}
	public void setGia_moi(double gia_moi) {
		this.gia_moi = gia_moi;
	}
	public int getLuot_xem() {
		return luot_xem;
	}
	public void setLuot_xem(int luot_xem) {
		this.luot_xem = luot_xem;
	}
	public Date getNgay_cap_nhat() {
		return ngay_cap_nhat;
	}
	public void setNgay_cap_nhat(Date ngay_cap_nhat) {
		this.ngay_cap_nhat = ngay_cap_nhat;
	}
	public Short getTrang_thai() {
		return trang_thai;
	}
	public void setTrang_thai(Short trang_thai) {
		this.trang_thai = trang_thai;		
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public int getMa_lsp() {
		return ma_lsp;
	}
	public void setMa_lsp(int ma_lsp) {
		this.ma_lsp = ma_lsp;
	}
	public int getMa_nh() {
		return ma_nh;
	}
	public void setMa_nh(int ma_nh) {
		this.ma_nh = ma_nh;
	}

	public LoaiSanPham getLoaiSanPham() {
		return loaiSanPham;
	}

	public void setLoaiSanPham(LoaiSanPham loaiSanPham) {
		this.loaiSanPham = loaiSanPham;
	}

	public NhanHieu getNhanHieu() {
		return nhanHieu;
	}

	public void setNhanHieu(NhanHieu nhanHieu) {
		this.nhanHieu = nhanHieu;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}



	public List<HoaDonChiTiet> getLsthdct() {
		return lsthdct;
	}



	public void setLsthdct(List<HoaDonChiTiet> lsthdct) {
		this.lsthdct = lsthdct;
	}



	
	
	
	

	
	
	

//	public MultipartFile getFileImage() {
//		return fileImage;
//	}
//
//	public void setFileImage(MultipartFile fileImage) {
//		this.fileImage = fileImage;
//	}
	
}
