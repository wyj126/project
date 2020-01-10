package com.d.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.d.entity.Person;

public interface Mapper {
	public String queryPersonByName(String name);
	
	public int addPerson(Person person);
	
	public String queryLogin(@Param("name") String name, @Param("password") String password);
	
	public List<Person> queryAllDataFromTable(@Param("page") int page, @Param("limit") int limit, @Param("keyWord") String keyWord);
	 
	public int queryAllCount(String keyWord);
	
	void deletePerson(@Param("id")String id);
	
	void updatePerson(Person person);
	
	Person findByID(String id);
	
	public List<Person> findAllPage(int before,int after);      
	 
	public int count();
	
}
