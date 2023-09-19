package dao;

import java.util.List;

import org.springframework.stereotype.Service;

import entity.SanPham;

@Service
public interface ISanPhamDAO {
	public List<SanPham> selectAll();
	
	public List<SanPham> getSanPham(int limit);
	
	public List<SanPham> getLoaiSanPham(int ma_lsp);
	
	public SanPham selectById(int ma_sp);
	
	public boolean insert (SanPham sp);

	public boolean update(SanPham sp);

	public boolean delete(int ma_sp);
	
	public List<SanPham> search(String title);

	public List<SanPham> selectPaginate(int ma_lsp,int start, int totalPage);
	
	public List<SanPham> selectPaginate1(int start, int totalPage);
	
//	public List<SanPham> selectPaginate(int start, int end);
}
