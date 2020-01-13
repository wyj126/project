package com.d.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.d.entity.Person;

public interface IService {

	public String queryPersonByName(String name);
	
	public int addPerson(Person person);
	
	public String queryLogin(String name, String card);
	
	public List<Person> queryAllDataFromTable(@Param("page") int page, @Param("limit") int limit, @Param("keyWord") String keyWord);
	 
	public int queryAllCount(String keyWord);
	
	public void updatePerson(Person person);
	
	public void deletePerson(String id);
	
	public Person findByID(String id);
	
	public List<Person> findAllPage(int before,int after);      
	 
	public int count();
	
	public Person queryPBynameAndId(@Param("name") String name, @Param("id") String id);
	   
}
