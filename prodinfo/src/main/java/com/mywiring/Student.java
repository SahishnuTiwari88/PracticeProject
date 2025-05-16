package com.mywiring;

import org.springframework.beans.factory.annotation.Autowired;

public class Student {
	private String sname;
	@Autowired
	private Address address;

	public Student() {
		
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String name) {
		this.sname = name;
	}
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Student [sname=" + sname + ", address=" + address + "]";
	}


}
