package dao;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import utils.CartUtil;

@Service
public interface ICartDAO {
	public HashMap<Integer, CartUtil> AddCart(int ma_sp, HashMap<Integer,CartUtil> cart );
	
	public HashMap<Integer, CartUtil> EditCart(int ma_sp,int quanty, HashMap<Integer,CartUtil> cart );
	
	public HashMap<Integer, CartUtil> DeleteCart(int ma_sp, HashMap<Integer,CartUtil> cart );
	
	public int TotalQuanty(HashMap<Integer, CartUtil> cart);
	
	public double TotalPrice(HashMap<Integer, CartUtil> cart);
}
