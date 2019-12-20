package com.d.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.d.entity.Person;
import com.d.mapper.AdminMapper;
import com.d.service.adminService;

@Service
public class adminServiceImpl implements adminService {

	@Autowired
	private AdminMapper adm;
	
	@Override
	public String queryAdmin(String aname, String apassword) {
		System.out.println("adminService");
		return adm.queryAdmin(aname, apassword);
	}

}
