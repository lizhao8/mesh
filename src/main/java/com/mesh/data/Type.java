package com.mesh.data;

public enum Type {
	MESH("Mesh", "0"),
	STRING("string", "1"),
	VECTOR("vector", "0"),
	ARRAY("Array", "1", true),
	INT("int", "0"),
	SUB_MESH("SubMesh", "0"),
	UNSIGNED_INT("unsigned int", "0"),
	TYPELESS_DATA("TypelessData", "1", true),
	AABB("AABB", "0"),
	VECTOR3F("Vector3f", "0"),
	FLOAT("float", "0"),
	BLEND_SHAPE_DATA("BlendShapeData", "0"),
	MATRIX4X4F("Matrix4x4f", "0"),
	UINT8("UInt8", "0"),
	BOOL("bool", "0"),
	VERTEX_DATA("VertexData", "1"),
	CHANNEL_INFO("ChannelInfo", "0"),
	COMPRESSED_MESH("CompressedMesh", "0"),
	PACKED_BIT_VECTOR("PackedBitVector", "0"),
	STREAMING_INFO("StreamingInfo", "0");

	private String value;
	private String start;

	private boolean isArray = false;

	private Type(String value, String start) {
		this.value = value;
		this.start = start;

	}

	private Type(String value, String start, boolean isArray) {
		this.value = value;
		this.start = start;
		this.isArray = isArray;
	}

	public String getValue() {
		return value;
	}

	public String getStart() {
		return start;
	}

	public boolean isArray() {
		return isArray;
	}

	public static Type getByValue(String value) {
		for (Type type : Type.values()) {
			if (type.getValue().equals(value)) {
				return type;
			}
		}
		throw new RuntimeException("Type【" + value + "】,不存在");
	}

	@Override
	public String toString() {
		return start + " " + value;
	}
}
