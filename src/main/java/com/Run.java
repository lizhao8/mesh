package com;

import com.mesh.MeshReader;

public class Run {

	public static void main(String[] args) throws Exception {

		// String meshFilePath = "D:\\data\\123\\body_Mesh_s.txt";
		String meshFilePath = "D:\\data\\123\\body_Mesh.txt";
		// String meshFilePath = "D:\\data\\123\\Run\\123.txt";
		MeshReader reader = new MeshReader(meshFilePath);
		reader.saveText("D:\\data\\123\\saveText.txt");
		reader.saveData("D:\\data\\123\\saveData.txt");
		reader.toMesh();
	}

}
