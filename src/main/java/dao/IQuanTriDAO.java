package dao;

import java.util.List;

import entity.KhachHang;
import entity.QuanTri;

public interface IQuanTriDAO {
//	public QuanTri loginQuanTri(QuanTri quantri);
	public QuanTri loginQuanTri(String tai_khoan, String mat_khau);
	
	public List<QuanTri> selectAll();

	public QuanTri selectById(int id);

	public boolean insert(QuanTri kh);

	public boolean update(QuanTri qt);

	public boolean delete(int id);

	public List<QuanTri> search2(String title2);
}
