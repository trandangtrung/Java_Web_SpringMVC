package dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import entity.HoaDon;
import utils.CartUtil;

@Service
public interface IHoaDonDAO {
	public List<HoaDon> selectAll();
	
	public boolean insert (HoaDon hoadon);

	public boolean update(HoaDon hd);

	public boolean delete(int ma_hd);
	
	public List<HoaDon> search3(String title);
	
	public int AddHoaDon(HoaDon hd);
	
	public void AddHoaDonDetail(HashMap<Long, CartUtil> carts);
	
	public int GetIDHoaDon();
}
