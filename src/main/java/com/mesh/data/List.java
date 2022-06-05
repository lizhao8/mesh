package com.mesh.data;

public class List<T> extends java.util.ArrayList<T> {

	private static final long serialVersionUID = -5934421127506509344L;

	private String name;
	private Type type;
	public List() {
		super();
	}
	public List(String name, Type type) {
		super();
		this.name = name;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

}
