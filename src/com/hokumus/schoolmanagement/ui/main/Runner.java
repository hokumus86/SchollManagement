package com.hokumus.schoolmanagement.ui.main;

import com.hokumus.schoolmanagement.dao.student.StudentDao;
import com.hokumus.schoolmanagement.dao.users.UserDao;
import com.hokumus.schoolmanagement.model.student.Student;
import com.hokumus.schoolmanagement.model.user.Users;
import com.hokumus.schoolmanagement.model.util.Operations;
import com.hokumus.schoolmanagement.ui.user.GirisEkrani;

public class Runner {
	
	public static void main(String[] args) {
		GirisEkrani frame =new GirisEkrani();
		Operations.callFrame = frame;
		StudentDao dao = new StudentDao();
		Student temp =new Student();
		temp.setName("a");
		dao.ara(temp);
		frame.setVisible(true);
		
		
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
