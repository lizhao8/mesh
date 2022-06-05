package com.mesh.object;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.mesh.object.base.Point3D;

public class Point extends Point3D {

	private List<Face> faceList = new ArrayList<Face>();
	private Texture texture;
	private Normal normal;
	private Index index;

	public Point(float x, float y, float z) {
		super(x, y, z);
	}

	public List<Face> getFaceList() {
		return faceList;
	}

	public Texture getTexture() {
		return texture;
	}

	public void setTexture(Texture texture) {
		this.texture = texture;
	}

	public Normal getNormal() {
		return normal;
	}

	public void setNormal(Normal normal) {
		this.normal = normal;
	}

	public Index getIndex() {
		return index;
	}

	public void setIndex(Index index) {
		this.index = index;
	}

	public void addFace(Face face) {
		faceList.add(face);
	}

}
