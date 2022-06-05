package com.mesh;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import com.mesh.data.Array;
import com.mesh.data.Data;
import com.mesh.data.List;
import com.mesh.data.Text;
import com.mesh.data.Type;
import com.mesh.object.Channel;
import com.mesh.object.Face;
import com.mesh.object.Index;
import com.mesh.object.Mesh;
import com.mesh.object.Normal;
import com.mesh.object.Point;
import com.mesh.object.SubMesh;
import com.mesh.object.Texture;
import com.mesh.object.enums.ChannelType;
import com.utils.BitConverter;

public class MeshWriter {
	private Mesh mesh;

	public MeshWriter(Mesh mesh) {
		super();
		this.mesh = mesh;
	}

	private BufferedWriter writer;

	private String getDeepString(int deep) {
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < deep; i++) {
			stringBuilder.append(" ");
		}
		return stringBuilder.toString();
	}

	private void writeLine(String line) throws Exception {
		writer.write(line);
		writer.newLine();
	}

	private void writeLine(Data data) throws Exception {
		writer.write(data.toString());
		writer.newLine();
	}

	private void writeLine(Data data, boolean withChild) throws Exception {
		writer.write(data.toString());
		writer.newLine();
		if (withChild) {
			for (Data data2 : data.getChildList()) {
				writeLine(data2, withChild);
			}
		}
	}

	private String writeLine(List<?> list, int deep) throws Exception {
		int size = list.size();
		String deepString = getDeepString(deep);
		writer.write(deepString + list.getType() + " " + list.getName());
		writer.newLine();
		deepString += " ";
		writer.write(deepString + "1 Array Array (" + size + " items)");
		writer.newLine();
		deepString += " ";
		writer.write(deepString + "0 int size = " + size);
		writer.newLine();
		return deepString;
	}

	public void saveMesh(String filePath) throws Exception {
		FileWriter fileWriter = new FileWriter(filePath);
		writer = new BufferedWriter(fileWriter);
		writeLine(mesh.getData());
		writeLine(mesh.getM_Name());
		saveM_SubMeshes();
		writer.flush();
		writer.close();
		System.out.println("saveMesh over");
	}

	private void saveM_SubMeshes() throws Exception {
		// m_SubMeshes
		List<SubMesh> m_SubMeshes = mesh.getM_SubMeshes();
		String deepString = writeLine(m_SubMeshes, 1);
		for (int i = 0; i < m_SubMeshes.size(); i++) {
			SubMesh subMesh = m_SubMeshes.get(i);
			writeLine(deepString + "[" + i + "]");
			writeLine(deepString + " " + subMesh.getType() + " data");
			writeLine(subMesh.getFirstByte());
			writeLine(subMesh.getIndexCount());
			writeLine(subMesh.getTopology());
			writeLine(subMesh.getBaseVertex());
			writeLine(subMesh.getFirstVertex());
			writeLine(subMesh.getVertexCount());
			writeLine(subMesh.getLocalAABB(), true);

		}
	}

}
