package com.rgb;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashSet;
import java.util.Set;

import javax.imageio.ImageIO;

public class rgb {
	static int width;
	static int height;
	static String filePath = "D:\\data\\123\\1094ui_tpose\\新建文件夹\\1094ui_tpose #894597\\body01_Mask.png";

	public static void main(String[] args) throws Exception {
		File file = new File(filePath);
		BufferedImage image = ImageIO.read(file);
		width = image.getWidth();
		height = image.getHeight();
		int[] rgb_value = new int[3];
		// 定义用来存放RGB图像分量图的image对象（下面用到的image是已经预读取来的RGB原图像）
		BufferedImage image_R = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		BufferedImage image_G = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		BufferedImage image_B = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

		//Set<Integer> a=new HashSet<>();
		
		// 单色通道提取
		for (int height = 0; height < rgb.height; height++) {
			for (int width = 0; width < rgb.width; width++) {
				int RGB_value = image.getRGB(width, height);// 获取方式
				rgb_value[0] = (RGB_value & 0xff0000) >> 16;// 红色波段
				rgb_value[1] = (RGB_value & 0xff00) >> 8;// 绿色波段
				rgb_value[2] = (RGB_value & 0xff);// 蓝色波段
				for (int j = 0; j < rgb_value.length; j++) {
				//	a.add(rgb_value[j]);
					if(rgb_value[j]>0) {
						rgb_value[j]=255;
					}
					//System.out.print(i + " ");
				}
				//System.out.println();
				image_R.setRGB(width, height, rgb_value[0] << 16);
				image_G.setRGB(width, height, rgb_value[1] << 8);
				image_B.setRGB(width, height, rgb_value[2]);
			}
		}
		String newFilePath = file.getAbsolutePath();
		String type = "png";
		//type = "jpg";
		// 图像输出
		ImageIO.write(image_R, type, new File(newFilePath + ".image_R." + type));
		ImageIO.write(image_G, type, new File(newFilePath + ".image_G." + type));
		ImageIO.write(image_B, type, new File(newFilePath + ".image_B." + type));
		/*for (Integer integer : a) {
			System.out.println(integer);
		}*/
	}
}
