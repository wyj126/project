package com.d.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.d.entity.Jf;
import com.d.entity.Person;

public interface JFService {

	public int addPersonJf(Jf jf);
	
	public List<Jf> queryAllDataFromTable(@Param("page") int page, @Param("limit") int limit, @Param("keyWord") String keyWord);
	 
	public List<Jf> queryAllDataFromTable2(@Param("page") int page, @Param("limit") int limit, @Param("keyWord") String keyWord,@Param("name") String name);
	
	public int queryAllCount(String keyWord);
	
	public int queryAllCount2(String name);
	
	public void updateJf(Jf jf);
	
	public void deleteJf(String jfid);
	
	public Jf findByID(String jfid);
	
	public List<Jf> findAllPage(int before,int after);      
	 
	public int count();
	
}
