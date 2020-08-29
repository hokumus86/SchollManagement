package com.hokumus.schoolmanagement.ui.main;

import java.util.Date;

import com.hokumus.schoolmanagement.dao.users.UserDao;
import com.hokumus.schoolmanagement.model.user.UserRole;
import com.hokumus.schoolmanagement.model.user.Users;
import com.hokumus.schoolmanagement.ui.user.GirisEkrani;

public class Runner {
	
	public static void main(String[] args) {
		new GirisEkrani().setVisible(true);
		
//		UserDao dao=new UserDao();
//		Users temp=new Users();
//		temp.setUsername("hokumus");
//		temp.setPassword("123");
//		temp.setAdress("test");
//		temp.setPhone("55555");
//		temp.setCreatedBy("admin");
//		temp.setCreatedDate(new Date());
//		temp.setRole(UserRole.ADMIN);
//		temp.setSurname("okumus");
//		temp.setName("huseyin");
//		dao.kaydet(temp);
		
	}

}
