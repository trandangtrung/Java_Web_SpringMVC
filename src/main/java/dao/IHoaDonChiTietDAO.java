package dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import entity.HoaDon;
import entity.HoaDonChiTiet;
import utils.CartUtil;

@Service
public interface IHoaDonChiTietDAO {
	public List<HoaDonChiTiet> selectAll();
	public boolean insert(HoaDonChiTiet hdct);
	
	public HoaDonChiTiet selectById(Integer ma_hd);
	
	
	public int AddChiTietHD(HoaDonChiTiet hdct);
	
//	public void AddHoaDonDetail(HashMap<Long, CartUtil> carts);
//	
////	public int AddHoaDon(HoaDon hd);
////	
//	public int GetIDHoaDon();

		
	
}
