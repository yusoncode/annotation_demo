package com.xy.lee.domain;

import com.xy.lee.annotation.Init;

public class Persion {
	private String name;
	private int age;

	@Init(name="李曉宇")
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Init(age=25)
	public void setAge(int age) {
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	@Override
	public String toString() {
		return "Persion [name=" + name + ", age=" + age + "]";
	}
	

}
