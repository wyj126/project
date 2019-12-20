package com.d.mapper;

import org.apache.ibatis.annotations.Param;

import com.d.entity.Person;

public interface AdminMapper {

	public String queryAdmin(@Param("aname") String aname, @Param("apassword") String apassword);
}
