package com;

import com.draw.Draw;
import com.mesh.MeshReader;
import com.mesh.MeshWriter;
import com.mesh.object.Mesh;

public class Run {

	public static void main(String[] args) throws Exception {

		// String meshFilePath = "D:\\data\\123\\body_Mesh_s.txt";
		String meshFilePath = "D:\\data\\123\\body_Mesh.txt";
		// String meshFilePath = "D:\\data\\123\\Run\\123.txt";
		MeshReader reader = new MeshReader(meshFilePath);
		reader.saveText("D:\\data\\123\\saveText.txt");
		reader.saveData("D:\\data\\123\\saveData.txt");
		Mesh mesh = reader.toMesh();
		MeshWriter writer=new MeshWriter(mesh);
		writer.saveMesh("D:\\data\\123\\saveMesh.txt");

		// Draw draw=new Draw(mesh);
		// draw.run();
	}

}
