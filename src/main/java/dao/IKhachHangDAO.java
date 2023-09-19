package dao;

import java.util.List;

import entity.KhachHang;

public interface IKhachHangDAO {
	public List<KhachHang> selectAll();

	public KhachHang selectById(int ma_kh);

	public boolean insert(KhachHang kh);

	public boolean update(KhachHang kh);

	public boolean delete(int ma_kh);

	public List<KhachHang> search1(String title1);
}
