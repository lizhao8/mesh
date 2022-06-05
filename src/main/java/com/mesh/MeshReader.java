package com.mesh;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import com.mesh.data.Array;
import com.mesh.data.Data;
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

public class MeshReader {
	private String meshFilePath;
	private BufferedReader reader;
	private Text text;
	private Data data;
	private Mesh mesh;

	public MeshReader(String meshFilePath) throws Exception {
		this.meshFilePath = meshFilePath;
		FileReader fileReader = new FileReader(meshFilePath);
		reader = new BufferedReader(fileReader);
		reader();
	}

	private void reader() throws Exception {
		readerText(meshFilePath);
		getData(text);
	}

	private Text readerText(String meshFilePath) throws Exception {
		text = new Text(0);
		String line = "";
		line = reader.readLine();
		text.setText(line);
		readerText(text, null);
		System.out.println("readerText over");
		return text;
	}

	private String readerText(Text parent, String string) throws Exception {
		Text text = null;
		if (string != null) {
			string = string.replaceFirst(" ", "");
			text = new Text(parent);
			text.setText(string);
		}
		do {
			int deep = parent.getDeep() + 1;
			String line = reader.readLine();
			if (line == null) {
				return "";
			}
			String regex = "\\s{" + deep + "}";
			if (line.matches(regex + ".*")) {
				line = line.replaceFirst(regex, "");
			} else {
				return line;
			}
			if (line.startsWith(" ")) {
				line = readerText(text, line);
				if (line.matches(regex + ".*")) {
					line = line.replaceFirst(regex, "");
					text = new Text(parent);
					text.setText(line);
				} else {
					return line;
				}
			} else {
				text = new Text(parent);
				text.setText(line);
			}
		} while (true);
	}

	public void saveText(String filePath) throws Exception {
		FileWriter fileWriter = new FileWriter(filePath);
		BufferedWriter writer = new BufferedWriter(fileWriter);
		text.save(writer);
		writer.flush();
		writer.close();
		System.out.println("saveText over");
	}

	public void saveData(String filePath) throws Exception {
		FileWriter fileWriter = new FileWriter(filePath);
		BufferedWriter writer = new BufferedWriter(fileWriter);
		data.save(writer);
		writer.flush();
		writer.close();
		System.out.println("saveData over");
	}

	private Data getData(Text text) {
		data = getData(null, text);
		System.out.println("getData over");
		return data;
	}

	private Data getData(Data parent, Text text) {
		String string = text.getText();
		String[] splits = string.split(" ");
		int i = 0;
		String start = splits[i++];
		String typeString = splits[i++];
		if ("unsigned".equals(typeString)) {
			typeString = typeString + " " + splits[i++];
		}
		Type type = Type.getByValue(typeString);
		String name = splits[i++];
		String value = null;
		if (i < splits.length && "=".equals(splits[i++])) {
			value = splits[i++];
		}
		Data data = new Data(parent);
		data.setStart(start);
		data.setType(type);
		data.setName(name);
		data.setValue(value);
		if (type.isArray()) {
			parent.remove(data);
			data = analyseArray(data, text);
		} else {
			for (Text child : text.getChildList()) {
				getData(data, child);
			}
		}

		return data;

	}

	private Array analyseArray(Data data, Text text) {
		Array array = new Array(data);
		int size = text.getChildList().size();
		for (int i = 1; i < size; i++) {
			Text childText = text.getChildList().get(i).getChildList().get(0);
			getData(array, childText);
		}
		return array;
	}

	public Mesh toMesh() {
		mesh = new Mesh();
		// data
		mesh.setData(data);
		// m_Name
		mesh.setM_Name(data.getByName("m_Name"));
		// m_SubMeshes
		List<Data> m_SubMeshes = data.getByName("m_SubMeshes").get(0).getChildList();
		for (int i = 0; i < m_SubMeshes.size(); i++) {
			mesh.getM_SubMeshes().add(new SubMesh(m_SubMeshes.get(i)));
		}
		mesh.setM_Shapes(data.getByName("m_Shapes"));
		mesh.setM_BindPose(data.getByName("m_BindPose"));
		mesh.setM_BoneNameHashes(data.getByName("m_BoneNameHashes"));
		mesh.setM_RootBoneNameHash(data.getByName("m_RootBoneNameHash"));
		mesh.setM_MeshCompression(data.getByName("m_MeshCompression"));
		mesh.setM_IsReadable(data.getByName("m_IsReadable"));
		mesh.setM_KeepVertices(data.getByName("m_KeepVertices"));
		mesh.setM_KeepIndices(data.getByName("m_KeepIndices"));
		mesh.setM_IndexFormat(data.getByName("m_IndexFormat"));

		List<Data> m_IndexBuffer = data.getByName("m_IndexBuffer").get(0).getChildList();

		for (Iterator<Data> iterator = m_IndexBuffer.iterator(); iterator.hasNext();) {
			byte[] bytes = new byte[2];
			bytes[0] = iterator.next().byteValue();
			bytes[1] = iterator.next().byteValue();
			mesh.getM_IndexBuffer().add(bytesToLong(bytes));
		}
		Data m_VertexData = data.getByName("m_VertexData");
		int m_VertexCount = m_VertexData.getByName("m_VertexCount").intValue();
		List<Data> m_Channels = m_VertexData.getByName("m_Channels").get(0).getChildList();
		for (int i = 0; i < m_Channels.size(); i++) {
			Channel channel = new Channel(m_Channels.get(i), i);
			mesh.getM_Channels().add(channel);

			switch (i) {
			case 0:
				channel.setFloatList(mesh.getM_Vertices());
				channel.setType(ChannelType.m_Vertices);
				break;
			case 1:
				channel.setFloatList(mesh.getM_Normals());
				channel.setType(ChannelType.m_Normals);
				break;
			case 2:
				channel.setFloatList(mesh.getM_Tangents());
				channel.setType(ChannelType.m_Tangents);
				break;
			case 3:
				channel.setFloatList(mesh.getM_Colors());
				channel.setType(ChannelType.m_Colors);
				break;
			case 4:
				channel.setFloatList(mesh.getM_UV0());
				channel.setType(ChannelType.m_UV0);
				break;
			case 5:
				channel.setFloatList(mesh.getM_UV1());
				channel.setType(ChannelType.m_UV1);
				break;
			case 6:
				channel.setFloatList(mesh.getM_UV2());
				channel.setType(ChannelType.m_UV2);
				break;
			case 7:
				channel.setFloatList(mesh.getM_UV3());
				channel.setType(ChannelType.m_UV3);
				break;
			case 8:
				channel.setFloatList(mesh.getM_UV4());
				channel.setType(ChannelType.m_UV4);
				break;
			case 9:
				channel.setFloatList(mesh.getM_UV5());
				channel.setType(ChannelType.m_UV5);
				break;
			case 10:
				channel.setFloatList(mesh.getM_UV6());
				channel.setType(ChannelType.m_UV6);
				break;
			case 11:
				channel.setFloatList(mesh.getM_UV7());
				channel.setType(ChannelType.m_UV7);
				break;
			// 2018.2 and up
			case 12:
				channel.setFloatList(mesh.getM_Skin_weight());
				channel.setType(ChannelType.m_Skin_weight);
				break;
			case 13:
				channel.setFloatList(mesh.getM_Skin_boneIndex());
				channel.setType(ChannelType.m_Skin_boneIndex);
				break;
			default:
				throw new RuntimeException("m_Channel");
			}
		}

		Map<Integer, List<Channel>> streamChannelMap = mesh.getM_Channels().stream()
				.collect(Collectors.groupingBy(Channel::getStream, TreeMap::new, Collectors.toList()));

		List<Data> m_DataSize = m_VertexData.getByName("m_DataSize").getChildList();

		int dataSizeIndex = 0;
		for (Integer stream : streamChannelMap.keySet()) {
			List<Channel> channelList = streamChannelMap.get(stream);
			for (int v = 0; v < m_VertexCount; v++) {
				for (Channel channel : channelList) {
					List<Float> floatList = channel.getFloatList();
					for (int d = 0; d < channel.getDimension(); d++) {
						byte[] bytes = new byte[4];
						for (int c = 0; c < channel.getComponentByteSize(); c++) {
							bytes[c] = m_DataSize.get(dataSizeIndex + c).byteValue();
						}
						float value = BitConverter.toFloat(bytes);
						floatList.add(value);
						dataSizeIndex += channel.getComponentByteSize();
					}
				}
			}
		}
		printChannal(mesh, "Mesh over");

		return mesh;
	}

	private void printChannal(Mesh mesh, String log) {
		System.out.println("----------" + log + " printChannal begin----------");
		System.out.println("VertexCount=" + mesh.getVertexCount());
		for (Channel channel : mesh.getM_Channels()) {
			if (channel.getDimension() == 0) {
				continue;
			}
			if (channel.getFloatList().isEmpty()) {
				continue;
			}
			System.out.println(channel.getType() + "," + channel.getFloatList().size() + "," + channel.getDimension()
					+ "," + channel.getComponentByteSize() + "," + (mesh.getVertexCount() * channel.getDimension()));
		}
		int indexCount = 0;
		for (SubMesh subMesh : mesh.getM_SubMeshes()) {
			System.out.println("subMesh," + subMesh.getIndexCount());
			indexCount += subMesh.getIndexCount().intValue();
		}
		System.out.println("subMesh,count=" + indexCount + "," + indexCount / 3);
		System.out.println("----------" + log + " printChannal end----------");

	}

	public static long bytesToLong(byte[] bytes) {
		long value = 0;
		for (int i = 0; i < bytes.length; i++) {
			value <<= 8;
			byte b = bytes[bytes.length - 1 - i];
			long a = b;
			if (a < 0) {
				a = (b & 0xff);
			}
			value |= a;
		}
		return value;
	}
}
