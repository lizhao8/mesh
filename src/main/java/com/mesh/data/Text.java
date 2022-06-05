package com.mesh.data;

import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.List;

public class Text {
	private int deep;
	private String text;
	private Text parent;
	private List<Text> childList = new ArrayList<Text>();

	public Text(Text parentText) {
		super();
		this.parent = parentText;
		this.parent.addChild(this);
		this.deep = parentText.deep + 1;
	}

	public Text(int deep) {
		super();
		this.deep = deep;
	}

	public int getDeep() {
		return deep;
	}

	public void setDeep(int deep) {
		this.deep = deep;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Text getParent() {
		return parent;
	}

	public void setParent(Text parent) {
		this.parent = parent;
	}

	public List<Text> getChildList() {
		return childList;
	}

	public void setChildList(List<Text> childList) {
		this.childList = childList;
	}

	public void addChild(Text text) {
		childList.add(text);
	}

	public void save(BufferedWriter writer) throws Exception {
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < deep; i++) {
			stringBuilder.append(" ");
		}
		stringBuilder.append(text);
		writer.append(stringBuilder);
		writer.newLine();

		for (Text text : childList) {
			text.save(writer);
		}
	}

	@Override
	public String toString() {
		return "Text [deep=" + deep + ", text=" + text + ", childList=" + childList + "]";
	}

}
