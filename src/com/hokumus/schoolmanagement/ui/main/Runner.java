package com.hokumus.schoolmanagement.ui.main;

import java.util.Date;

import com.hokumus.schoolmanagement.dao.users.UserDao;
import com.hokumus.schoolmanagement.model.user.UserRole;
import com.hokumus.schoolmanagement.model.user.Users;

public class Runner {
	
	public static void main(String[] args) {
		UserDao dao = new UserDao();
		Users temp = new Users();
		temp.setUsername("hokumus");
		temp.setPassword("123");
		temp.setAdress("test");
		temp.setPhone("55555");
		temp.setCreatedBy("admin");
		temp.setCreatedDate(new Date());
		temp.setRole(UserRole.ADMIN);
		temp.setSurname("okumuþ");
		temp.setName("hüseyin");
		dao.kaydet(temp);
	}

}
