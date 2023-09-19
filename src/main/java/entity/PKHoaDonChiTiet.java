package entity;

import java.io.Serializable;
import java.util.Objects;

public class PKHoaDonChiTiet implements Serializable {
	protected Integer hoaDon;
	protected Integer sanPham;
	
	
	public PKHoaDonChiTiet() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	public Integer getHoaDon() {
		return hoaDon;
	}



	public void setHoaDon(Integer hoaDon) {
		this.hoaDon = hoaDon;
	}



	public Integer getSanPham() {
		return sanPham;
	}



	public void setSanPham(Integer sanPham) {
		this.sanPham = sanPham;
	}



	public PKHoaDonChiTiet(Integer hoaDon, Integer sanPham) {
		super();
		this.hoaDon = hoaDon;
		this.sanPham = sanPham;
	}



	public boolean equals(Object obj) {
	    if (this == obj) return true;
	    if (!(obj instanceof PKHoaDonChiTiet)) return false;
	    PKHoaDonChiTiet that = (PKHoaDonChiTiet) obj;
	    return Objects.equals(getHoaDon(), that.getHoaDon()) &&
	            Objects.equals(getSanPham(), that.getSanPham());
	}

	@Override
	public int hashCode() {
	    return Objects.hash(getHoaDon(), getSanPham());
	}
	
}
