package utils;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import dao.ImplSanPhamDAO;
import entity.SanPham;

@Repository
@Service
public class ICartUtil {
	
	@Autowired
	ImplSanPhamDAO sanphamDAO = new ImplSanPhamDAO();

	public HashMap<Integer, CartUtil> AddCart(int ma_sp, HashMap<Integer, CartUtil> cart) {
		CartUtil itemCart = new CartUtil();
		SanPham sanpham = sanphamDAO.selectById(ma_sp);
		if (sanpham != null && cart.containsKey(ma_sp)) {
			itemCart = cart.get(ma_sp);
			itemCart.setQuanty(itemCart.getQuanty() + 1);
			itemCart.setTotalPrice(itemCart.getQuanty() * itemCart.getSanpham().getGia_moi());
		} else {
			itemCart.setSanpham(sanpham);
			itemCart.setQuanty(1);
			itemCart.setTotalPrice(sanpham.getGia_moi());
		}
		cart.put(ma_sp, itemCart);
		return cart;
	}

	public HashMap<Integer, CartUtil> EditCart(int ma_sp, int quanty, HashMap<Integer, CartUtil> cart) {
		if (cart == null) {
			return cart;
		}
		CartUtil itemCart = new CartUtil();
		if (cart.containsKey(ma_sp)) {
			itemCart = cart.get(ma_sp);
			itemCart.setQuanty(quanty);
			double totalPrice = quanty * itemCart.getSanpham().getGia_moi();
			itemCart.setTotalPrice(totalPrice);
		}
		cart.put(ma_sp, itemCart);
		return cart;
	}

	public HashMap<Integer, CartUtil> DeleteCart(int ma_sp, HashMap<Integer, CartUtil> cart) {
		if (cart == null) {
			return cart;
		}
		if (cart.containsKey(ma_sp)) {
			cart.remove(ma_sp);
		}
		return cart;
	}

	public int TotalQuanty(HashMap<Integer, CartUtil> cart) {
		int totalQuanty = 0;
		for(Map.Entry<Integer, CartUtil> itemCart : cart.entrySet()) {
			totalQuanty += itemCart.getValue().getQuanty();
		}
		return totalQuanty;
	}

	public double TotalPrice(HashMap<Integer, CartUtil> cart) {
		double totalPrice = 0;
		for(Map.Entry<Integer, CartUtil> itemCart : cart.entrySet()) {
			totalPrice += itemCart.getValue().getTotalPrice();
		}
		return totalPrice;
	}
}
