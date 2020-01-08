package com.d.entity;

import java.util.UUID;

public class UUIDTools {

	 public static String getUUID(){
	        return UUID.randomUUID().toString().replace("-","");
	    }

	    public static Integer getUUIDInOrderId(){
	        Integer orderId=UUID.randomUUID().toString().hashCode();
	        orderId = orderId < 0 ? -orderId : orderId; //String.hashCode() 值会为空
	        return orderId;
	    }
}
