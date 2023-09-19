package dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import entity.Users;

@Service
@Repository
@Transactional
public interface IAccountDAO {
	public Users AddAccount(String ten, String pass_word);

	public  int SaveAccount(Users user);
	
	public int CheckAccount(Users user);
	
//	public List<Users> selectAll();

	
}
