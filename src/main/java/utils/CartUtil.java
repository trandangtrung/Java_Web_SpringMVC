package utils;

import entity.SanPham;

public class CartUtil {
	private int quanty;
	private double totalPrice;
	private SanPham sanpham;
	
	public CartUtil() {
		
	}
	public CartUtil(int quanty, double totalPrice, SanPham sanpham) {

		this.quanty = quanty;
		this.totalPrice = totalPrice;
		this.sanpham = sanpham;
	}
	public int getQuanty() {
		return quanty;
	}
	public void setQuanty(int quanty) {
		this.quanty = quanty;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public SanPham getSanpham() {
		return sanpham;
	}
	public void setSanpham(SanPham sanpham) {
		this.sanpham = sanpham;
	}
	
	
}
