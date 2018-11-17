package com.suyun.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;
import javax.xml.transform.sax.TransformerHandler;
import org.xml.sax.ContentHandler;
import org.xml.sax.helpers.DefaultHandler;
import org.kabeja.dxf.DXFDocument;
import org.kabeja.parser.Parser;
import org.kabeja.parser.ParserBuilder;
import org.kabeja.svg.SVGGenerator;
import org.kabeja.xml.SAXGenerator;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.stream.StreamResult;


public class DxfHelp {

	public static void main(String[] args) {
		parseFile("D:/dxf_to_svg/hl1.dxf");

		/*
		 * String direc = ""; direc = "E:/项目备份_勿删/信息技术服务项目/PCB阅读控件/svg"; File f
		 * = new File(direc); parseDirec(f);
		 */
	}

	/**
	 * 将文件夹中的dxf文件转换为svg文件
	 * 
	 * @param f
	 */
	public static void parseDirec(File f) {
		File[] fs = f.listFiles();
		for (int i = 0; i < fs.length; i++) {
			if (fs[i].isDirectory()) {// 继续处理文件夹
				parseDirec(fs[i]);
			}
			if (!fs[i].getName().toLowerCase().endsWith(".dxf")) {// 只处理DXF文件
				continue;
			}
			System.out.println("处理路径：" + fs[i].getPath());
			parseFile(fs[i].getPath());
		}
	}

	/**
	 * 将dxf文件解析为svg文件
	 * 
	 * @param sourceFile
	 */
	public static void parseFile(String sourceFile) {
		Map map = new HashMap();
		Parser parser = ParserBuilder.createDefaultParser();
		String xml_name;
		int index = sourceFile.lastIndexOf(".");

		xml_name = sourceFile.substring(0, index) + ".svg";

		try {

			Result resultXml = new StreamResult(new FileOutputStream(xml_name)); // 输出到person.xml
			SAXTransformerFactory sff = (SAXTransformerFactory) SAXTransformerFactory
					.newInstance();
			TransformerHandler th = sff.newTransformerHandler();
			th.setResult(resultXml);

			Transformer transformer = th.getTransformer();
			transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8"); // 编码格式是UTF-8
			transformer.setOutputProperty(OutputKeys.INDENT, "yes"); // 换行

			parser.parse(new FileInputStream(sourceFile), "GBK");
			DXFDocument doc = parser.getDocument();
			// the SVG will be emitted as SAX-Events
			// see org.xml.sax.ContentHandler for more information
			ContentHandler myhandler = new DefaultHandler();
			// the output - create first a SAXGenerator (SVG here)
			SAXGenerator generator = new SVGGenerator();
			// setup properties
			generator.setProperties(new HashMap());
			// start the output
			generator.generate(doc, th, map);

			System.out.println("OK");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
