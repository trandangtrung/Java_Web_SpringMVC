package Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entity.LoaiSanPham;
import entity.SanPham;

@Service
public interface IHomeService {
	
	@Autowired
	public List<SanPham> selectPaginate(int start, int end);	
	
	

}
