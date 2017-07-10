package com.hanbit.member.domain;

public class MemberBean {
	private String id, password, name, ssn;
	
	public void setId(String id){
		this.id = id;
	}
	public String getId(){
		return id;
	}

	public void setPassword(String password){
		this.password = password;
	}
	public String getPassword(){
		return password;
	}
	
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}
	
	public void setSNN(String ssn){
		this.ssn = ssn;
	}
	public String getSSN(){
		return ssn;
	}
	
	public String toString(){
		 return " name=" +name+" id="+id+" pw=" +password+ " ssn="+ssn;
	}
}
