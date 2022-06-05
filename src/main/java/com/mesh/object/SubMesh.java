package com.mesh.object;

import java.util.ArrayList;
import java.util.List;

import com.mesh.data.Data;

public class SubMesh {
	public long firstByte;
	public long indexCount;
	public long topology;// GfxPrimitiveType
	public long baseVertex;
	public long firstVertex;
	public long vertexCount;
	public AABB localAABB;

	public List<Face> faceList = new ArrayList<Face>();

	public SubMesh(Data data) {
		firstByte = data.getByName("firstByte").intValue();
		indexCount = data.getByName("indexCount").intValue();
		topology = data.getByName("topology").intValue();
		baseVertex = data.getByName("baseVertex").intValue();
		firstVertex = data.getByName("firstVertex").intValue();
		vertexCount = data.getByName("vertexCount").intValue();
		localAABB = new AABB(data.getByName("localAABB"));
	}

	public long getFirstByte() {
		return firstByte;
	}

	public void setFirstByte(long firstByte) {
		this.firstByte = firstByte;
	}

	public long getIndexCount() {
		return indexCount;
	}

	public void setIndexCount(long indexCount) {
		this.indexCount = indexCount;
	}

	public long getTopology() {
		return topology;
	}

	public void setTopology(long topology) {
		this.topology = topology;
	}

	public long getBaseVertex() {
		return baseVertex;
	}

	public void setBaseVertex(long baseVertex) {
		this.baseVertex = baseVertex;
	}

	public long getFirstVertex() {
		return firstVertex;
	}

	public void setFirstVertex(long firstVertex) {
		this.firstVertex = firstVertex;
	}

	public long getVertexCount() {
		return vertexCount;
	}

	public void setVertexCount(long vertexCount) {
		this.vertexCount = vertexCount;
	}

	public AABB getLocalAABB() {
		return localAABB;
	}

	public void setLocalAABB(AABB localAABB) {
		this.localAABB = localAABB;
	}

	public List<Face> getFaceList() {
		return faceList;
	}

	public void setFaceList(List<Face> faceList) {
		this.faceList = faceList;
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
