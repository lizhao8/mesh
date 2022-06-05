package com.mesh.data;

import java.io.BufferedWriter;

public class Array extends Data {

	public Array(Data data) {
		super(data.parent);
		super.start = data.start;
		super.name = data.name;
		super.type = data.type;
		super.value = data.value;
		super.parent = data.parent;
	}

	@Override
	public void save(BufferedWriter writer) throws Exception {
		StringBuilder spaceBuilder = new StringBuilder();
		for (int i = 0; i < deep; i++) {
			spaceBuilder.append(" ");
		}
		StringBuilder stringBuilder = new StringBuilder(spaceBuilder);
		stringBuilder.append(start);
		stringBuilder.append(" ");
		stringBuilder.append(type.getValue());
		stringBuilder.append(" ");
		stringBuilder.append(name);
		if (value != null && !"".equals(value)) {
			stringBuilder.append(" = ");
			stringBuilder.append(value);
		}
		long size = childList.size();
		stringBuilder.append(" (" + size + " items)");
		writer.append(stringBuilder);
		writer.newLine();
		spaceBuilder.append(" ");
		stringBuilder = new StringBuilder(spaceBuilder);
		stringBuilder.append("0");
		stringBuilder.append(" int size = ");
		stringBuilder.append(size);
		writer.append(stringBuilder);
		writer.newLine();

		for (int i = 0; i < childList.size(); i++) {
			Data data = childList.get(i);
			stringBuilder = new StringBuilder(spaceBuilder);
			stringBuilder.append("[" + i + "]");
			writer.append(stringBuilder);
			writer.newLine();
			data.save(writer, this, 1);
		}
	}

	@Override
	public String toString() {
		return "Array [size=" + childList.size() + ", start=" + start + ", type=" + type + ", name=" + name + ", value="
				+ value + ", childList=" + childList + "]";
	}

}
