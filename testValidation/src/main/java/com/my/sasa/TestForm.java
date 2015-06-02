package com.my.sasa;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class TestForm {
	@NotBlank
	String str;
	
	@NotNull
	@Min(1)
	Integer int_class;
	
	@NotNull
	int int_type;
	
	@NotBlank
	@Email
	String email;
	
	

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getStr() {
		return str;
	}
	public void setStr(String str) {
		this.str = str;
	}
	public Integer getInt_class() {
		return int_class;
	}
	public void setInt_class(Integer int_class) {
		this.int_class = int_class;
	}
	public int getInt_type() {
		return int_type;
	}
	public void setInt_type(int int_type) {
		this.int_type = int_type;
	}
	@Override
	public String toString() {
		return "TestForm [str=" + str + ", int_class=" + int_class
				+ ", int_type=" + int_type + ", email=" + email + "]";
	}

}
