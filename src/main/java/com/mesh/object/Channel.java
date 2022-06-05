package com.mesh.object;

import java.util.List;

import com.mesh.data.Data;
import com.mesh.object.enums.ChannelType;

public class Channel {
	private int index;
	private int stream;
	private int offset;
	private int format;
	private int dimension;
	private ChannelType type;
	private int componentByteSize;
	private List<Float> floatList;

	public Channel(Data data, int index) {
		this.index = index;
		stream = data.getByName("stream").intValue();
		offset = data.getByName("offset").intValue();
		format = data.getByName("format").intValue();
		dimension = data.getByName("dimension").intValue();
		if (dimension == 0) {
			return;
		}
		switch (format) {
		case 0:
		case 11:
			componentByteSize = 4;
			break;
		case 2:
			componentByteSize = 1;
			break;
		default:
			throw new RuntimeException("format");
		}
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getStream() {
		return stream;
	}

	public void setStream(int stream) {
		this.stream = stream;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getFormat() {
		return format;
	}

	public void setFormat(int format) {
		this.format = format;
	}

	public int getDimension() {
		return dimension;
	}

	public void setDimension(int dimension) {
		this.dimension = dimension;
	}

	public ChannelType getType() {
		return type;
	}

	public void setType(ChannelType type) {
		this.type = type;
	}

	public int getComponentByteSize() {
		return componentByteSize;
	}

	public void setComponentByteSize(int componentByteSize) {
		this.componentByteSize = componentByteSize;
	}

	public List<Float> getFloatList() {
		return floatList;
	}

	public void setFloatList(List<Float> floatList) {
		this.floatList = floatList;
	}

}