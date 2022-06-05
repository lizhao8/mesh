package com.mesh.object;

import com.mesh.data.Data;
import com.mesh.data.Type;

public class SubMesh {
	private Data firstByte;
	private Data indexCount;
	private Data topology;// GfxPrimitiveType
	private Data baseVertex;
	private Data firstVertex;
	private Data vertexCount;
	// private AABB localAABB;
	private Data localAABB;
	private Data data;
	private Type type;

	public SubMesh(Data data) {
		this.data = data;
		this.type = data.getType();
		firstByte = data.getByName("firstByte");
		indexCount = data.getByName("indexCount");
		topology = data.getByName("topology");
		baseVertex = data.getByName("baseVertex");
		firstVertex = data.getByName("firstVertex");
		vertexCount = data.getByName("vertexCount");
		// localAABB = new AABB(data.getByName("localAABB"));
		localAABB = data.getByName("localAABB");
	}

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

	public Data getFirstByte() {
		return firstByte;
	}

	public void setFirstByte(Data firstByte) {
		this.firstByte = firstByte;
	}

	public Data getIndexCount() {
		return indexCount;
	}

	public void setIndexCount(Data indexCount) {
		this.indexCount = indexCount;
	}

	public Data getTopology() {
		return topology;
	}

	public void setTopology(Data topology) {
		this.topology = topology;
	}

	public Data getBaseVertex() {
		return baseVertex;
	}

	public void setBaseVertex(Data baseVertex) {
		this.baseVertex = baseVertex;
	}

	public Data getFirstVertex() {
		return firstVertex;
	}

	public void setFirstVertex(Data firstVertex) {
		this.firstVertex = firstVertex;
	}

	public Data getVertexCount() {
		return vertexCount;
	}

	public void setVertexCount(Data vertexCount) {
		this.vertexCount = vertexCount;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	/*
	 * public AABB getLocalAABB() { return localAABB; }
	 * 
	 * public void setLocalAABB(AABB localAABB) { this.localAABB = localAABB; }
	 */
	public Data getLocalAABB() {
		return localAABB;
	}

	public void setLocalAABB(Data localAABB) {
		this.localAABB = localAABB;
	}

	public class AABB {
		private Vector3 m_Center;
		private Vector3 m_Extent;

		public AABB(Data data) {
			m_Center = new Vector3(data.getByName("m_Center"));
			m_Extent = new Vector3(data.getByName("m_Extent"));

		}

		public Vector3 getM_Center() {
			return m_Center;
		}

		public void setM_Center(Vector3 m_Center) {
			this.m_Center = m_Center;
		}

		public Vector3 getM_Extent() {
			return m_Extent;
		}

		public void setM_Extent(Vector3 m_Extent) {
			this.m_Extent = m_Extent;
		}

	}

	public static class Vector3 {
		private float x;
		private float y;
		private float z;

		public Vector3(Data data) {
			x = data.getByName("x").floatValue();
			y = data.getByName("y").floatValue();
			z = data.getByName("z").floatValue();
		}

		public Vector3(float x, float y, float z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}

		public float getX() {
			return x;
		}

		public void setX(float x) {
			this.x = x;
		}

		public float getY() {
			return y;
		}

		public void setY(float y) {
			this.y = y;
		}

		public float getZ() {
			return z;
		}

		public void setZ(float z) {
			this.z = z;
		}

	}
}
