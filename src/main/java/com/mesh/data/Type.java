package com.mesh.data;

public enum Type {
	MESH("Mesh"),
	STRING("string"),
	VECTOR("vector"),
	ARRAY("Array", true),
	INT("int"),
	SUB_MESH("SubMesh"),
	UNSIGNED_INT("unsigned int"),
	TYPELESS_DATA("TypelessData", true),
	AABB("AABB"),
	VECTOR3F("Vector3f"),
	FLOAT("float"),
	BLEND_SHAPE_DATA("BlendShapeData"),
	MATRIX4X4F("Matrix4x4f"),
	UINT8("UInt8"),
	BOOL("bool"),
	VERTEX_DATA("VertexData"),
	CHANNEL_INFO("ChannelInfo"),
	COMPRESSED_MESH("CompressedMesh"),
	PACKED_BIT_VECTOR("PackedBitVector"),
	STREAMING_INFO("StreamingInfo");

	private String value;
	private boolean isArray = false;

	private Type(String value) {
		this.value = value;
	}

	private Type(String value, boolean isArray) {
		this.value = value;
		this.isArray = isArray;
	}

	public String getValue() {
		return value;
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
}
