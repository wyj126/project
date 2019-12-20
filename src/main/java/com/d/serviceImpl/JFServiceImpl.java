package com.d.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.d.entity.Jf;
import com.d.entity.Person;
import com.d.mapper.JfMapper;
import com.d.service.JFService;

@Service("jfservice")
public class JFServiceImpl implements JFService {

	@Autowired
	private JfMapper jfMapper;
	
	@Override
	public int addPersonJf(Jf jf) {
		return jfMapper.addPersonJf(jf);
	}

	@Override
	public List<Jf> queryAllDataFromTable(int page, int limit, String keyWord) {
		page=(page-1)*limit;
		return jfMapper.queryAllDataFromTable(page,limit,keyWord);
	}

	@Override
	public int queryAllCount(String keyWord) {
		// TODO Auto-generated method stub
		return jfMapper.queryAllCount(keyWord);
	}
	
	/**
     * 查询数据
     */
    public List<Jf> findAllPage(int before,int after){
        return jfMapper.findAllPage(before, after);
    }
    /**
     * 查询条数
     */
    public int count(){
        return jfMapper.count();
    }
    

	public void updateJf(Jf jf) {
		jfMapper.updateJf(jf);	
	}

	public void deleteJf(String jfid) {
		jfMapper.deleteJf(jfid);	
	}
	public Jf findByID(String jfid) {
	    return jfMapper.findByID(jfid);
	}


}