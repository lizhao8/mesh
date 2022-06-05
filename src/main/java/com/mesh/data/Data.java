package com.mesh.data;

import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.List;

public class Data {

	protected int deep;
	protected String start;
	protected Type type;
	protected String name;
	protected String value;
	protected Data parent;
	protected List<Data> childList = new ArrayList<Data>();

	public Data(Data parent) {
		super();
		this.parent = parent;
		if (parent != null) {
			deep = parent.deep + 1;
			parent.add(this);
		}
	}

	public void remove(Data data) {
		childList.remove(data);
	}

	public void add(Data data) {
		childList.add(data);
	}

	public Data get(int index) {
		return childList.get(index);
	}

	public int getDeep() {
		return deep;
	}

	public void setDeep(int deep) {
		this.deep = deep;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Data getParent() {
		return parent;
	}

	public void setParent(Data parent) {
		this.parent = parent;
	}

	public List<Data> getChildList() {
		return childList;
	}

	public void setChildList(List<Data> childList) {
		this.childList = childList;
	}

	////////////////

	public byte byteValue() {
		return (byte)intValue();
	}

	public int intValue() {
		return Integer.valueOf(value);
	}

	public int longValue() {
		return Integer.valueOf(value);
	}

	public float floatValue() {
		return Float.valueOf(value);
		// return BitConverter.toFloat(longToBytes(Integer.valueOf(value), 4));
	}

	@Override
	public String toString() {
		return value + "";
	}

	public Data getByType(Type type) {
		return childList.stream().filter(x -> x.type == type).findFirst().get();
	}

	public Data getByName(String name) {
		return childList.stream().filter(x -> name.equals(x.name)).findFirst().get();
	}

	public void save(BufferedWriter writer) throws Exception {
		save(writer, null, 0);
	}

	public void save(BufferedWriter writer, Data parent, int deepAdd) throws Exception {
		if (deep == 0 && parent != null) {
			deep = parent.deep + 1;
		}
		if (this instanceof Array) {
			((Array) this).save(writer);
			return;
		}
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < deep + deepAdd; i++) {
			stringBuilder.append(" ");
		}
		stringBuilder.append(start);
		stringBuilder.append(" ");
		stringBuilder.append(type.getValue());
		stringBuilder.append(" ");
		stringBuilder.append(name);

		if (value != null && !"".equals(value)) {
			if (value.startsWith("-") && type == Type.UINT8) {
				try {
					byte b = Byte.valueOf(value);
					if (((int) b) < 0) {
						value = (b & 0xff) + "";
					}
				} catch (Exception e) {
					// System.out.println(value);
				}
			}
			stringBuilder.append(" = ");
			stringBuilder.append(value);
		}

		writer.append(stringBuilder);
		writer.newLine();
		for (Data data : childList) {
			data.save(writer, this, deepAdd);
		}
	}

}
