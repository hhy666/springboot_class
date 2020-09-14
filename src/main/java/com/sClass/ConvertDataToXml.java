package com.sClass;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings({"rawtypes","unchecked"})
public class ConvertDataToXml {

	private final static DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
	private final static TransformerFactory transformerFactory = TransformerFactory.newInstance();
	private static DocumentBuilder  documentBuilder;
	
	public static void main(String[] args) {
		try {
			ConvertDataToXml.convertDbDataToXml("E:\\erlOrRabbitmq\\OutBox");
//			System.out.println( (int)(Math.random()*200) );
//			XmlStaticData xsd = new XmlStaticData();
//			System.out.println(xsd.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	 
	/**
	 *  将数据库中的数据转换为xml文件，提供给单一窗口客户端进行传递 
	 * @param dest 目标文件夹地址 
	 * @throws Exception
	 */
	public static void convertDbDataToXml(String dest) throws Exception{
		// 先获取数据库中的数据
		List<Map> res = findDbData();
		// 将数据进行转换，封装到xml中
		doConvert(res, dest);
	}
	
	private static boolean doConvert(List<Map> res, String dest) throws Exception {
		// 判断数据是否为空
		if(res == null || res.size() == 0) {
			return false;
		}
		
		// 循环进行封装，一条数据封装一个xml
		for (int i = 0; i < res.size(); i++) {
			writeDataToXml(res.get(i), dest);
		}
		
		return true;
	}

	private static void writeDataToXml(Map map, String dest) throws Exception {
		// 创建document
		Document document = getDocument();
		
		// Manifest
		Map manifest = (Map) map.get("xmlData");
		Element mf = getElementByName(manifest.get("name").toString(), document);
		// attr 
		Map attr = (Map) manifest.get("attr");
		mf.setAttribute(attr.get("name").toString(), attr.get("value").toString());
		addElementToDocument(mf, document);
		
		// 从Manifest 的 childData 开始 循环
		List<Map> childData = (List<Map>) manifest.get("childData");
		
		if(childData != null && childData.size() > 0) {
			for (int i = 0; i < childData.size(); i++) {
				addElementToElement(addChildDataToDocument(childData.get(i), document), mf);
			}
		}

		saveDocumentToLoaclFile(dest+File.separator+map.get("fileName").toString(), document);
	}

	private static Element addChildDataToDocument(Map code, Document document) throws Exception {
		// 判断是否有子节点数据
		boolean hasChild = (boolean) code.get("hasChild"); 
		Element el = getElementByName(code.get("name").toString(), document);
		
		if(!hasChild) {
			el.setTextContent(code.get("value").toString());
		}
		
		// 判断 是否有属性
		boolean hasAttr = (boolean) code.get("hasAttr"); 
		
		if(hasAttr) {
			List<Map> fattrMap = (List<Map>) code.get("attrData");
			
			for (int i = 0; i < fattrMap.size(); i++) {
				el.setAttribute(fattrMap.get(i).get("name").toString(), fattrMap.get(i).get("value").toString());
			}
		}
		
		if(hasChild) {
			// code 的 childData 
			List<Map> childData = (List<Map>) code.get("childData");
			
			if(childData != null && childData.size() > 0) {
				for (int i = 0; i < childData.size(); i++) {
					addElementToElement(addChildDataToDocument(childData.get(i), document), el);
				}
			}
		}
		
		return el;
	}

	/**
	 * 将element添加到element中
	 * @param head
	 * @param mf
	 */
	private static void addElementToElement(Element head, Element mf) {
		mf.appendChild(head);
	}

	// 获取数据库数据
	private static List<Map> findDbData() throws Exception {
		List<Map> result = new ArrayList<Map>();
		
		// xml 文件对应的格式map 
		XmlStaticData xsd = new XmlStaticData();
		
		// 查询出数据库中需要转换的数据
		for (int i = 0; i < 1; i++) {
			Map map = new HashMap();
			
			// xml 文件名
			map.put("fileName", "海运数据文件_"+System.currentTimeMillis()+".xml");
			
			// 数据库查出来的一条数据
			List<Object> rut = new ArrayList<Object>();
			
			// 测试数据
			
			rut.add("CN_MT2101_1p1_4201101115245_20180903113640022");
			rut.add("9");
			rut.add("MT2101");
			rut.add("4201101115245_SWS0000000002_SW61000020170331_@");
			rut.add("EPORT");
			rut.add("20180519113649890");
			rut.add("1.0");
			rut.add("4201101115245");
			rut.add("AAE/0000");
			rut.add("4201101115245");
			rut.add("MM");
			rut.add("CL12");
			rut.add("4");
			rut.add("CL12");
			rut.add("OOOO");
			rut.add("GUGU");
			rut.add("20180521000000");
			rut.add("20180516000000");
			rut.add("201805");
			rut.add("10");
			rut.add("4201100004245");
			rut.add("05181");
			rut.add("9");
			rut.add("999");
			rut.add("AAE/4201");
			rut.add("20180518000000");
			rut.add("AAE");
			rut.add("20180519");
			rut.add("AAE");
			rut.add("MM");
			rut.add("AAE");
			rut.add("AAE");
			rut.add("AAE");
			rut.add("FF");
			rut.add("999");
			rut.add("AE");
			rut.add("9");
			rut.add("111111111");
			rut.add("mmm");
			rut.add("M4");
			rut.add("M4");
			rut.add("CN12");
			rut.add("M4");
			rut.add("010000");
			rut.add("AD");
			rut.add("1234567890");
			rut.add("A1+M1");
			rut.add("M1");
			rut.add("M1");
			rut.add("M1");
			rut.add("CN12");
			rut.add("M1");
			rut.add("010000");
			rut.add("AD");
			rut.add("M1");
			rut.add("M1");
			rut.add("A2+M2");
			rut.add("M2");
			rut.add("M2");
			rut.add("M2");
			rut.add("CN12");
			rut.add("M2");
			rut.add("010000");
			rut.add("AD");
			rut.add("MM");
			rut.add("ZZZ+M3");
			rut.add("M3");
			rut.add("M3");
			rut.add("M3");
			rut.add("CN12");
			rut.add("M3");
			rut.add("010000");
			rut.add("AD");
			rut.add("M5");
			rut.add("BBBBBB");
			
			// 生成xml格式及数据
			// 数据库中查询到的数据转换为map
			Map res = xsd.convertDataToMap(rut);
			map.put("xmlData", xsd.setXmlCodeValue(res));
			
			result.add(map);
		}
				
		return result;
	}
	
	/**
	 * 将 element 添加到document
	 * @param element
	 * @param document
	 * @return
	 * @throws Exception
	 */
	private static boolean addElementToDocument(Element element, Document document) throws Exception{
		try {
			document.appendChild(element);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	/**
	 * 返回 element
	 * @param elementName
	 * @param document
	 * @return
	 * @throws Exception
	 */
	private static Element getElementByName(String elementName, Document document) throws Exception{
		return document.createElement(elementName);
	}
	
	/**
	 * 根据目标地址和document 将doucment转换为xml文件
	 * @param dest
	 * @param document
	 * @return
	 * @throws Exception
	 */
	private static boolean saveDocumentToLoaclFile(String dest, Document document) throws Exception{
		Transformer transformer = getTransformer();
		
		try {
			// ** 设置xml version**
			transformer.setOutputProperty(OutputKeys.VERSION, "1.0");
			// ** 设置xml编码 格式**
			transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
			// ** 设置xml standalone **
			transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");
			// ** 设置自动换行 **
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			// ** 设置缩进 **
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
			DOMSource source = new DOMSource(document);
			//设置本地保存路径
			File file = new File(dest);
			
			if(!file.exists()) {
				file.createNewFile();
			}
			
			StreamResult result = new StreamResult(file.toURI().getPath());
			transformer.transform(source, result);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	/**
	 * 返回 Transformer 对象
	 * @return
	 * @throws Exception
	 */
	private static Transformer getTransformer() throws Exception{
		return ConvertDataToXml.transformerFactory.newTransformer();
	}
	
	/**
	 * 返回 Document 对象
	 * @return
	 * @throws Exception
	 */
	private static Document getDocument() throws Exception {
		return documentBuilderFactory.newDocumentBuilder().newDocument();
	}
	
	/**
	 * 返回 DocumentBuilder
	 * @return
	 */
	public static DocumentBuilder getDocumentBuilder() {
		return documentBuilder;
	}

	public static void setDocumentBuilder(DocumentBuilder documentBuilder) {
		try {
			ConvertDataToXml.documentBuilder = ConvertDataToXml.documentBuilderFactory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
	}

	public static DocumentBuilderFactory getDocumentbuilderfactory() {
		return documentBuilderFactory;
	}

	@SuppressWarnings("static-access")
	public ConvertDataToXml() {
		super();
		this.documentBuilder = getDocumentBuilder();
	}
	
}
