package com.d.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.d.entity.Person;
import com.d.mapper.Mapper;
import com.d.service.IService;



@Service("service")
public class ServiceImpl implements IService {

	@Autowired
	private Mapper mapper;

	@Override
	public String queryPersonByName(String name) {
		return mapper.queryPersonByName(name);
	}

	@Override
	public int addPerson(Person person) {
		return mapper.addPerson(person);
		
	}

	

	@Override
	public String queryLogin(String name, String card) {
		return mapper.queryLogin(name, card);
	}

	@Override
	public List<Person> queryAllDataFromTable(int page, int limit, String keyWord) {
		page=(page-1)*limit;
		return mapper.queryAllDataFromTable(page,limit,keyWord);
	}

	@Override
	public int queryAllCount(String keyWord) {
		// TODO Auto-generated method stub
		return mapper.queryAllCount(keyWord);
	}
	
	
	/**
     * 查询数据
     */
    public List<Person> findAllPage(int before,int after){
        return mapper.findAllPage(before, after);
    }
    /**
     * 查询条数
     */
    public int count(){
        return mapper.count();
    }
    

	public void updatePerson(Person person) {
		mapper.updatePerson(person);	
	}

	public void deletePerson(String id) {
		mapper.deletePerson(id);	
	}
	public Person findByID(String id) {
	    return mapper.findByID(id);
	}

	@Override
	public Person queryPBynameAndId(String name, Integer id) {
		return mapper.queryPBynameAndId(name, id);
	}
}
