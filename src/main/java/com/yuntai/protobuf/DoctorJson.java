package com.yuntai.protobuf;

import java.io.Serializable;

public class DoctorJson implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1801018324613753054L;

	private String id;
	
	private String name;
	
	private String hosName;

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

	public String getHosName() {
		return hosName;
	}

	public void setHosName(String hosName) {
		this.hosName = hosName;
	}
	
	
}
