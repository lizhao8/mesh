package com.mesh.object;

import java.util.ArrayList;
import java.util.List;

public class Element {

	public List<Face> faceList = new ArrayList<Face>();
	public List<Point> pointList = new ArrayList<Point>();


	public void addFace(Face face) {
		List<Face> needAddFaceList = new ArrayList<Face>();
		needAddFaceList.add(face);
		while (needAddFaceList.size() > 0) {
			List<Face> _needAddFaceList = new ArrayList<Face>();
			for (Face needAddFace : needAddFaceList) {
				if (!faceList.contains(needAddFace)) {
					faceList.add(needAddFace);
					for (Point point : needAddFace.pointList) {
						if (!pointList.contains(point)) {
							pointList.add(point);
							_needAddFaceList.addAll(point.faceList);
						}
					}

				}
			}
			needAddFaceList = _needAddFaceList;
		}
	}

}
