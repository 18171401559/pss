package com.itheima.domain;

public class Student {
	private String id; //学号
	private String name;//名字
	private String age;//年龄
	private String address;//地址
	
	public Student() {
		super();
	}
	public Student(String id, String name, String age, String address) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.address = address;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Student{" +
				"id='" + id + '\'' +
				", name='" + name + '\'' +
				", age='" + age + '\'' +
				", address='" + address + '\'' +
				'}';
	}
}
