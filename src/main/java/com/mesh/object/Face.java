package com.mesh.object;

import java.util.ArrayList;
import java.util.List;

public class Face {

	public List<Point> pointList = new ArrayList<Point>();

	public void addPoint(Point point) {
		point.addFace(this);
		pointList.add(point);
	}

	public Point getPoint(int index) {
		return pointList.get(index);
	}

}
