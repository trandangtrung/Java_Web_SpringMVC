//package utils;
//
//import org.mindrot.jbcrypt.BCrypt;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Repository;
//import org.springframework.stereotype.Service;
//
//import dao.ImplAccountDAO;
//import entity.Users;
//
//@Repository
//@Configuration
//@Service
//public class UserUtil {
//	
//	@Autowired
//	ImplAccountDAO acountDao = new ImplAccountDAO();
//	
//	public int AddAcount(Users user) {
//		user.setPass_word(BCrypt.hashpw(user.getPass_word(), BCrypt.gensalt(12)));
//		return acountDao.SaveAccount(user);
//	
//}
//}

