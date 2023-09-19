package dao;

import java.util.List;

import org.springframework.stereotype.Service;

import entity.LoaiSanPham;
@Service
public interface ILoaiSanPhamDAO {
	public List<LoaiSanPham> GetLoaiSanPham();
	
	public LoaiSanPham GetLoaiSanPhamId(int ma_lsp);
}
