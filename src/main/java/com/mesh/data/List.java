package com.mesh.data;

public class List<T> extends java.util.ArrayList<T> {

	private static final long serialVersionUID = -5934421127506509344L;

	private String name;

	public List() {
	}

	public List(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
