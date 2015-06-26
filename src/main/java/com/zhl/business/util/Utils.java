package com.zhl.business.util;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGEncodeParam;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

public class Utils {
	/**
	 * 等比例压缩图片文件<br>
	 * 先保存原文件，再压缩、上传
	 * 
	 * @param oldFile
	 *            要进行压缩的文件
	 * @param newFile
	 *            新文件
	 * @param width
	 *            宽度 //设置宽度时（高度传入0，等比例缩放）
	 * @param height
	 *            高度 //设置高度时（宽度传入0，等比例缩放）
	 * @param quality
	 *            质量
	 * @return 返回压缩后的文件的全路径
	 */
	public static String zipImageFile(File oldFile, File newFile, int width, int height, float quality) {
		if (oldFile == null) {
			return null;
		}
		try {
			/** 对服务器上的临时文件进行处理 */
			Image srcFile = ImageIO.read(oldFile);
			int w = srcFile.getWidth(null);
			// System.out.println(w);
			int h = srcFile.getHeight(null);
			// System.out.println(h);
			double bili;
			if (width > 0) {
				bili = width / (double) w;
				height = (int) (h * bili);
			} else {
				if (height > 0) {
					bili = height / (double) h;
					width = (int) (w * bili);
				}
			}
			/** 宽,高设定 */
			BufferedImage tag = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			tag.getGraphics().drawImage(srcFile, 0, 0, width, height, null);
			// String filePrex = oldFile.getName().substring(0,
			// oldFile.getName().indexOf('.'));
			/** 压缩后的文件名 */
			// newImage = filePrex + smallIcon+
			// oldFile.getName().substring(filePrex.length());

			/** 压缩之后临时存放位置 */
			FileOutputStream out = new FileOutputStream(newFile);

			JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
			JPEGEncodeParam jep = JPEGCodec.getDefaultJPEGEncodeParam(tag);
			/** 压缩质量 */
			jep.setQuality(quality, true);
			encoder.encode(tag, jep);
			out.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return newFile.getAbsolutePath();
	}

	/**
	 * 上传文件
	 * 
	 * @param request
	 * @return path 文件路径
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	public static String uploadFile(HttpServletRequest request) throws IllegalStateException, IOException {
		String fileName = "";
		String path = "";
		String picPath = "";
		// 将当前上下文初始化给 CommonsMutipartResolver （多部分解析器）
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
		// 检查form中是否有enctype="multipart/form-data"
		if (multipartResolver.isMultipart(request)) {
			// 将request变成多部分request
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			// 获取multiRequest 中所有的文件名
			Iterator iter = multiRequest.getFileNames();

			while (iter.hasNext()) {
				// 一次遍历所有文件
				MultipartFile file = multiRequest.getFile(iter.next().toString());
				if (file != null) {
					// 创建上传路径
					SimpleDateFormat dateformat = new SimpleDateFormat("yyyy/MM/ddHHmmss");
					String webRoot = request.getSession().getServletContext().getRealPath("");
					String pagePath = "/files/" + dateformat.format(new Date()); // 用于返回显示图片
					String logoPathDir = webRoot + pagePath;
					File logoSaveFile = new File(logoPathDir);
					if (!logoSaveFile.exists()) {
						logoSaveFile.mkdirs();
					}
					fileName = file.getOriginalFilename();
					path = logoPathDir + "/" + fileName;
					picPath = pagePath + "/" + fileName;
					// 上传
					file.transferTo(new File(path));
				}

			}

		}
		return picPath;
	}
}
