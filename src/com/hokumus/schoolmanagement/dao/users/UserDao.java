package com.hokumus.schoolmanagement.dao.users;

import java.util.List;

import com.hokumus.schoolmanagement.dao.util.DBServices;
import com.hokumus.schoolmanagement.model.user.Users;

public class UserDao extends DBServices<Users>{
	
	@Override
	public List<Users> getir(String kolonAdi, String deger, Users temp) {
		// TODO Auto-generated method stub
		return super.getir(kolonAdi, deger, temp);
	}
	
	@Override
	public List<Users> ara(Users temp) {
		// TODO Auto-generated method stub
		return super.ara(temp);
	}

}
