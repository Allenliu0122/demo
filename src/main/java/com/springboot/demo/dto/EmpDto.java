package com.springboot.demo.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EmpDto implements Serializable {
     @JsonProperty(value = "Emp")
	private String emp;
	public String getEmp() {
		return emp;
	}
	public void setEmp(String emp) {
		this.emp = emp;
	}
	public EmpDto() {
	}

}
