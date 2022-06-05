package com.mesh.object;

import com.mesh.data.Data;
import com.mesh.data.List;
import com.mesh.data.Type;

public class Mesh {
	private Data data;
	private Data m_Name;
	private List<SubMesh> m_SubMeshes = new List<SubMesh>("m_SubMeshes",Type.VECTOR);
	private Data m_Shapes;
	private Data m_BindPose;
	private Data m_BoneNameHashes;
	private Data m_RootBoneNameHash;

	private Data m_MeshCompression;
	private Data m_IsReadable;
	private Data m_KeepVertices;
	private Data m_KeepIndices;
	private Data m_IndexFormat;

	private List<Long> m_IndexBuffer = new List<Long>("m_IndexBuffer",Type.VECTOR);

	private List<Float> m_Vertices = new List<Float>();
	private List<Float> m_Normals = new List<Float>();
	private List<Float> m_Colors = new List<Float>();
	private List<Float> m_UV0 = new List<Float>();
	private List<Float> m_UV1 = new List<Float>();
	private List<Float> m_UV2 = new List<Float>();
	private List<Float> m_UV3 = new List<Float>();
	private List<Float> m_UV4 = new List<Float>();
	private List<Float> m_UV5 = new List<Float>();
	private List<Float> m_UV6 = new List<Float>();
	private List<Float> m_UV7 = new List<Float>();
	private List<Float> m_Tangents = new List<Float>();
	private List<Float> m_Skin_weight = new List<Float>();
	private List<Float> m_Skin_boneIndex = new List<Float>();
	private List<Channel> m_Channels = new List<Channel>("m_Channels",Type.VECTOR);

	private Data m_CompressedMesh;
	private Data m_LocalAABB;
	private Data m_BakedConvexCollisionMesh;
	private Data m_BakedTriangleCollisionMesh;
	private Data m_MeshMetrics0;
	private Data m_MeshMetrics1;
	private Data m_StreamData;

	public int getVertexCount() {
		return m_Vertices.size() / 3;
	}

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

	public Data getM_Name() {
		return m_Name;
	}

	public void setM_Name(Data m_Name) {
		this.m_Name = m_Name;
	}

	public List<SubMesh> getM_SubMeshes() {
		return m_SubMeshes;
	}

	public void setM_SubMeshes(List<SubMesh> m_SubMeshes) {
		this.m_SubMeshes = m_SubMeshes;
	}

	public Data getM_Shapes() {
		return m_Shapes;
	}

	public void setM_Shapes(Data m_Shapes) {
		this.m_Shapes = m_Shapes;
	}

	public Data getM_BindPose() {
		return m_BindPose;
	}

	public void setM_BindPose(Data m_BindPose) {
		this.m_BindPose = m_BindPose;
	}

	public Data getM_BoneNameHashes() {
		return m_BoneNameHashes;
	}

	public void setM_BoneNameHashes(Data m_BoneNameHashes) {
		this.m_BoneNameHashes = m_BoneNameHashes;
	}

	public Data getM_RootBoneNameHash() {
		return m_RootBoneNameHash;
	}

	public void setM_RootBoneNameHash(Data m_RootBoneNameHash) {
		this.m_RootBoneNameHash = m_RootBoneNameHash;
	}

	public Data getM_MeshCompression() {
		return m_MeshCompression;
	}

	public void setM_MeshCompression(Data m_MeshCompression) {
		this.m_MeshCompression = m_MeshCompression;
	}

	public Data getM_IsReadable() {
		return m_IsReadable;
	}

	public void setM_IsReadable(Data m_IsReadable) {
		this.m_IsReadable = m_IsReadable;
	}

	public Data getM_KeepVertices() {
		return m_KeepVertices;
	}

	public void setM_KeepVertices(Data m_KeepVertices) {
		this.m_KeepVertices = m_KeepVertices;
	}

	public Data getM_KeepIndices() {
		return m_KeepIndices;
	}

	public void setM_KeepIndices(Data m_KeepIndices) {
		this.m_KeepIndices = m_KeepIndices;
	}

	public Data getM_IndexFormat() {
		return m_IndexFormat;
	}

	public void setM_IndexFormat(Data m_IndexFormat) {
		this.m_IndexFormat = m_IndexFormat;
	}

	public List<Long> getM_IndexBuffer() {
		return m_IndexBuffer;
	}

	public void setM_IndexBuffer(List<Long> m_IndexBuffer) {
		this.m_IndexBuffer = m_IndexBuffer;
	}

	public List<Float> getM_Vertices() {
		return m_Vertices;
	}

	public void setM_Vertices(List<Float> m_Vertices) {
		this.m_Vertices = m_Vertices;
	}

	public List<Float> getM_Normals() {
		return m_Normals;
	}

	public void setM_Normals(List<Float> m_Normals) {
		this.m_Normals = m_Normals;
	}

	public List<Float> getM_Colors() {
		return m_Colors;
	}

	public void setM_Colors(List<Float> m_Colors) {
		this.m_Colors = m_Colors;
	}

	public List<Float> getM_UV0() {
		return m_UV0;
	}

	public void setM_UV0(List<Float> m_UV0) {
		this.m_UV0 = m_UV0;
	}

	public List<Float> getM_UV1() {
		return m_UV1;
	}

	public void setM_UV1(List<Float> m_UV1) {
		this.m_UV1 = m_UV1;
	}

	public List<Float> getM_UV2() {
		return m_UV2;
	}

	public void setM_UV2(List<Float> m_UV2) {
		this.m_UV2 = m_UV2;
	}

	public List<Float> getM_UV3() {
		return m_UV3;
	}

	public void setM_UV3(List<Float> m_UV3) {
		this.m_UV3 = m_UV3;
	}

	public List<Float> getM_UV4() {
		return m_UV4;
	}

	public void setM_UV4(List<Float> m_UV4) {
		this.m_UV4 = m_UV4;
	}

	public List<Float> getM_UV5() {
		return m_UV5;
	}

	public void setM_UV5(List<Float> m_UV5) {
		this.m_UV5 = m_UV5;
	}

	public List<Float> getM_UV6() {
		return m_UV6;
	}

	public void setM_UV6(List<Float> m_UV6) {
		this.m_UV6 = m_UV6;
	}

	public List<Float> getM_UV7() {
		return m_UV7;
	}

	public void setM_UV7(List<Float> m_UV7) {
		this.m_UV7 = m_UV7;
	}

	public List<Float> getM_Tangents() {
		return m_Tangents;
	}

	public void setM_Tangents(List<Float> m_Tangents) {
		this.m_Tangents = m_Tangents;
	}

	public List<Float> getM_Skin_weight() {
		return m_Skin_weight;
	}

	public void setM_Skin_weight(List<Float> m_Skin_weight) {
		this.m_Skin_weight = m_Skin_weight;
	}

	public List<Float> getM_Skin_boneIndex() {
		return m_Skin_boneIndex;
	}

	public void setM_Skin_boneIndex(List<Float> m_Skin_boneIndex) {
		this.m_Skin_boneIndex = m_Skin_boneIndex;
	}

	public List<Channel> getM_Channels() {
		return m_Channels;
	}

	public void setM_Channels(List<Channel> m_Channels) {
		this.m_Channels = m_Channels;
	}

	public Data getM_CompressedMesh() {
		return m_CompressedMesh;
	}

	public void setM_CompressedMesh(Data m_CompressedMesh) {
		this.m_CompressedMesh = m_CompressedMesh;
	}

	public Data getM_LocalAABB() {
		return m_LocalAABB;
	}

	public void setM_LocalAABB(Data m_LocalAABB) {
		this.m_LocalAABB = m_LocalAABB;
	}

	public Data getM_BakedConvexCollisionMesh() {
		return m_BakedConvexCollisionMesh;
	}

	public void setM_BakedConvexCollisionMesh(Data m_BakedConvexCollisionMesh) {
		this.m_BakedConvexCollisionMesh = m_BakedConvexCollisionMesh;
	}

	public Data getM_BakedTriangleCollisionMesh() {
		return m_BakedTriangleCollisionMesh;
	}

	public void setM_BakedTriangleCollisionMesh(Data m_BakedTriangleCollisionMesh) {
		this.m_BakedTriangleCollisionMesh = m_BakedTriangleCollisionMesh;
	}

	public Data getM_MeshMetrics0() {
		return m_MeshMetrics0;
	}

	public void setM_MeshMetrics0(Data m_MeshMetrics0) {
		this.m_MeshMetrics0 = m_MeshMetrics0;
	}

	public Data getM_MeshMetrics1() {
		return m_MeshMetrics1;
	}

	public void setM_MeshMetrics1(Data m_MeshMetrics1) {
		this.m_MeshMetrics1 = m_MeshMetrics1;
	}

	public Data getM_StreamData() {
		return m_StreamData;
	}

	public void setM_StreamData(Data m_StreamData) {
		this.m_StreamData = m_StreamData;
	}

}
