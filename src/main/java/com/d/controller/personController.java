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
		System.out.println(name);
		String pName = personService.queryPersonByName(name) ;
		System.out.println(pName+"+++++++++++++++++++++++++++++++++++");
		return pName;
		
	}
	
	/*
	 * @RequestMapping("/addPerson") public int addPerson(@RequestParam
	 * Map<String,String> map ) { System.out.println(map); Person person=new
	 * Person(); person.setId(Integer.parseInt(map.get("id")));
	 * person.setName(map.get("name"));
	 * person.setAge(Integer.parseInt(map.get("age")));
	 * person.setSex(map.get("sex")); person.setNationame(map.get("nationame"));
	 * person.setIdcard(Integer.parseInt(map.get("idcard")));
	 * person.setLevel(map.get("level")); //int i = personService.addPerson(person);
	 * int i =1 ; System.out.print(i); System.out.println(person.toString()); return
	 * i;
	 * 
	 * }
	 */
	
	@RequestMapping("/addPerson")
	public int addPerson(Person person ) {
		System.out.println(person);
		person.setId(UUIDTools.getUUIDInOrderId());
		System.out.println(person);
		int i = personService.addPerson(person);
		System.out.print(i);
		return i;
		
	}

   /** @RequestMapping("/queryPerson")
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
        System.out.println(map.toString());
        return map;
    }
	**/
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
	        System.out.println(map.toString());
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
//				return "redirect:/informa/mohu";
		 			JSONObject json = new JSONObject();
			        return json.toString();

			}
			
	//查询
	
	
}
