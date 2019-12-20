package com.d.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.d.entity.Jf;
import com.d.entity.Person;


public interface JfMapper {

	public int addPersonJf(Jf jf);
	public List<Jf> queryAllDataFromTable(@Param("page") int page, @Param("limit") int limit, @Param("keyWord") String keyWord);
	 
	public int queryAllCount(String keyWord);
	void deleteJf(@Param("jfid")String jfid);
	void updateJf(Jf jf);
	Jf findByID(String jfid);
	public List<Jf> findAllPage(int before,int after);      
	 
	   public int count();
}
