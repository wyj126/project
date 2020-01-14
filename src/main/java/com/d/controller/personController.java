package com.d.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.d.entity.Person;
import com.d.entity.UUIDTools;
import com.d.service.IService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@RestController
@RequestMapping("/personController")
public class personController {

	@Autowired
	private IService personService;
	
	@RequestMapping("/queryByname")
	public String queryByname(@RequestParam(value="name") String name) {
		String pName = personService.queryPersonByName(name) ;
		return pName;
		
	}
	
	@RequestMapping("/addPerson")
	public int addPerson(Person person ) {
		person.setId(UUIDTools.getUUIDInOrderId());
		int i = personService.addPerson(person);
		return i;
		
	}

	//查询所有人
	@RequestMapping(value="findallEmp")
	 public Map<String,Object> methodx(
	            @RequestParam(required=false,defaultValue="1") int page,
	            @RequestParam(required=false,defaultValue="15") int limit,
	            String keyWord
	    ){
	    List<Person> datas=personService.queryAllDataFromTable(page,limit,keyWord);
	        int countx=  personService.queryAllCount(keyWord);
	        Map<String,Object> map=new HashMap<String,Object>();
	        map.put("code",0);
	        map.put("msg","");
	        map.put("count",countx);
	        map.put("data",datas);
	        return map;
	    }
	       

	@RequestMapping(value="/personedit",method=RequestMethod.POST)
	public @ResponseBody String  personedit(Person person,HttpServletRequest request,
			Map<String, Object> requestMap) {
		String id = Integer.toString(person.getId());
		Person persons = personService.findByID(id);
		persons.setName(person.getName());
		persons.setSex(person.getSex());
		persons.setAge(person.getAge());
		persons.setNationame(person.getNationame());
		persons.setIdcard(person.getIdcard());
		persons.setLevel(person.getLevel());
		personService.updatePerson(persons);;
		JSONArray json = JSONArray.fromObject(persons);
	    String js = json.toString();
	    //*****转为layui需要的json格式
	    String jso = "{\"code\":200,\"msg\":\"\",\"count\":"+0+",\"data\":"+js+"}";
	    return jso;
	}

	//删除
	@RequestMapping("/personDelete")
	public @ResponseBody String personDelete(HttpServletRequest request) throws UnsupportedEncodingException {
		String id = request.getParameter("id");
		personService.deletePerson(id);
		System.out.println(id);
		JSONObject json = new JSONObject();
        return json.toString();

	}
	
	//缴费id name 检测
	@RequestMapping("/queryPBynameAndId")
	public Person queryPBynameAndId(@RequestParam(value="name")String name, @RequestParam(value="id")String id) {
		Person person = personService.queryPBynameAndId(name, id);
		return person;
	}
	
	@RequestMapping("/queryNameByID")
	public String queryNameByID (@RequestParam(value="id")String id) {
		return personService.queryNameByID(id);
	}
	
	@RequestMapping("/findByID")
	public Person personUp(String id) {
		return personService.findByID(id);
	}
	
	@RequestMapping("/updatePersonInP")
	public void updatePersonInP(Person person) {
		personService.updatePersonInP(person);
	}
	
}
