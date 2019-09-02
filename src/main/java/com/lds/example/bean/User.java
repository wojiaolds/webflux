package com.lds.example.bean;

import lombok.Data;

/**
 * @Author: lds
 * @Date: 2019/9/2 17:08
 */
@Data
public class User {
	
	private  String name;
	private  int age;
	
	public User() {}
	
	public User(String name, int age) {
		this.name = name;
		this.age = age;
	}
}

