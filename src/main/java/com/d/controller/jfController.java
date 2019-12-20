package com.d.controller;

import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.d.entity.Jf;
import com.d.entity.Person;
import com.d.entity.UUIDTools;
import com.d.service.JFService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@RestController
@RequestMapping("/jfController")
public class jfController {

	@Autowired
	private JFService jfService;
	
	@RequestMapping("/addPersonJf")
	public int addPersonJf(Jf jf) {
		if (jf.getIsjf() == null || jf.getIsjf() == "") {
			jf.setIsjf("否");
		}
		if (jf.getIsjf().equals("on")) {
			jf.setIsjf("是");
		}
		System.out.println(jf);
		jf.setJfid(UUIDTools.getUUIDInOrderId());
		int i = jfService.addPersonJf(jf);
		System.out.print(i);
		return i;
		
	}
	
	
	//查询所有人
		@RequestMapping(value="findallEmp")
		 public Map<String,Object> methodx(
		            @RequestParam(required=false,defaultValue="1") int page,
		            @RequestParam(required=false,defaultValue="15") int limit,
		            String keyWord
		    ){
		    List<Jf> datas=jfService.queryAllDataFromTable(page,limit,keyWord);
		        int countx=  jfService.queryAllCount(keyWord);
		        Map<String,Object> map=new HashMap<String,Object>();
		        map.put("code",0);
		        map.put("msg","");
		        map.put("count",countx);
		        map.put("data",datas);
		        System.out.println(map.toString());
		        return map;
		    }
		       

		@RequestMapping(value="/jfedit",method=RequestMethod.POST)
		public @ResponseBody String  jfedit(Jf jf,HttpServletRequest request,
				Map<String, Object> requestMap) {
			String jfid = Integer.toString(jf.getJfid());
			Jf personjf = jfService.findByID(jfid);
			personjf.setJfid(jf.getJfid());
			personjf.setName(jf.getName());
			personjf.setTime(jf.getTime());
			personjf.setIsjf(jf.getIsjf());
			jfService.updateJf(personjf);
			JSONArray json = JSONArray.fromObject(personjf);
		    String js = json.toString();
		    //*****转为layui需要的json格式
		    String jso = "{\"code\":200,\"msg\":\"\",\"count\":"+0+",\"data\":"+js+"}";
		    return jso;
		}

		//删除
				@RequestMapping("/jfDelete")
				public @ResponseBody String jfDelete(HttpServletRequest request) throws UnsupportedEncodingException {
					String jfid = request.getParameter("jfid");
					jfService.deleteJf(jfid);
					System.out.println(jfid);
//					return "redirect:/informa/mohu";
			 			JSONObject json = new JSONObject();
				        return json.toString();

				}
				
	
}
