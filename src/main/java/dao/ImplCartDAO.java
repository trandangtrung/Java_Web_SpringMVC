package dao;



import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import utils.CartUtil;
import utils.ICartUtil;

@Service
public class ImplCartDAO implements ICartDAO {
	
	@Autowired
	private ICartUtil cartUtil = new ICartUtil();
	
	
	@Override
	public HashMap<Integer, CartUtil> AddCart(int ma_sp, HashMap<Integer, CartUtil> cart) {
		return cartUtil.AddCart(ma_sp, cart);
	}

	@Override
	public HashMap<Integer, CartUtil> EditCart(int ma_sp, int quanty, HashMap<Integer, CartUtil> cart) {
		return cartUtil.EditCart(ma_sp, quanty, cart);
	}

	@Override
	public HashMap<Integer, CartUtil> DeleteCart(int ma_sp, HashMap<Integer, CartUtil> cart) {
		return cartUtil.DeleteCart(ma_sp, cart);
	}

	@Override
	public int TotalQuanty(HashMap<Integer, CartUtil> cart) {
		
		return cartUtil.TotalQuanty(cart);
	}

	@Override
	public double TotalPrice(HashMap<Integer, CartUtil> cart) {
		return cartUtil.TotalPrice(cart);
	}

}
