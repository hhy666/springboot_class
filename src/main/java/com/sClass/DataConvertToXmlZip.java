package com.sClass;

import com.sClass.util.MD5Utils;
import com.sClass.util.ZipUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * 通过数据库查询出 要导出的数据
 * 将每条数据封装成一个xml文件
 * 将生成的xml打包成.zip文件 方便传输到服务器
 * @author Administrator
 *
 */
public class DataConvertToXmlZip {

	// 通过数据库查询出 要导出的数据 生成xml 并打包成zip
	public static void dataToZip(String source, String dest) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			System.out.println(" 开始时间 " + sdf.format(new Date()));
			
			// 查询数据库中需要导出的数据
			List<List<Object>> result = findDataFromDb();
			// 将查询出的数据 封装到xml中 并打包成zip
			setDataToXml(result, source, dest);
			// 将xml打包成.zip文件
			convertXmlsToZip(dest);
			// 转换成功之后将xml文件删除
			ZipUtils.delDirFiles(dest);
			
			System.out.println(" 结束时间 " + sdf.format(new Date()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 查询数据库中需要导出的数据
	public static List<List<Object>> findDataFromDb() throws Exception {
		List<List<Object>> result = new ArrayList<List<Object>>();
		
		// 此处模拟数据 因为不知道数据格式是啥样子的
		// 安装海运传输的xml格式模拟数据
		for (int i = 0; i < 500000; i++) {
			// 数据库查出来的一条数据
			List<Object> rut = new ArrayList<Object>();
			
			// 测试数据			
			rut.add("CN_MT2101_1p1_4201101115245_20180903113640022"+i);
			rut.add("9"+i);
			rut.add("MT2101"+i);
			rut.add("4201101115245_SWS0000000002_SW61000020170331_@"+i);
			rut.add("EPORT"+i);
			rut.add("20180519113649890"+i);
			rut.add("1.0"+i);
			rut.add("4201101115245"+i);
			rut.add("AAE/0000"+i);
			rut.add("4201101115245"+i);
			rut.add("MM"+i);
			rut.add("CL12"+i);
			rut.add("4"+i);
			rut.add("CL12"+i);
			rut.add("OOOO"+i);
			rut.add("GUGU"+i);
			rut.add("20180521000000"+i);
			rut.add("20180516000000"+i);
			rut.add("201805"+i);
			rut.add("10"+i);
			rut.add("4201100004245"+i);
			rut.add("05181"+i);
			rut.add("9"+i);
			rut.add("999"+i);
			rut.add("AAE/4201"+i);
			rut.add("20180518000000"+i);
			rut.add("AAE"+i);
			rut.add("20180519"+i);
			rut.add("AAE"+i);
			rut.add("MM"+i);
			rut.add("AAE"+i);
			rut.add("AAE"+i);
			rut.add("AAE"+i);
			rut.add("FF"+i);
			rut.add("999"+i);
			rut.add("AE"+i);
			rut.add("9"+i);
			rut.add("111111111"+i);
			rut.add("mmm"+i);
			rut.add("M4"+i);
			rut.add("M4"+i);
			rut.add("CN12"+i);
			rut.add("M4"+i);
			rut.add("010000"+i);
			rut.add("AD"+i);
			rut.add("1234567890"+i);
			rut.add("A1+M1"+i);
			rut.add("M1"+i);
			rut.add("M1"+i);
			rut.add("M1"+i);
			rut.add("CN12"+i);
			rut.add("M1"+i);
			rut.add("010000"+i);
			rut.add("AD"+i);
			rut.add("M1"+i);
			rut.add("M1"+i);
			rut.add("A2+M2"+i);
			rut.add("M2"+i);
			rut.add("M2"+i);
			rut.add("M2"+i);
			rut.add("CN12"+i);
			rut.add("M2"+i);
			rut.add("010000"+i);
			rut.add("AD"+i);
			rut.add("MM"+i);
			rut.add("ZZZ+M3"+i);
			rut.add("M3"+i);
			rut.add("M3"+i);
			rut.add("M3"+i);
			rut.add("CN12"+i);
			rut.add("M3"+i);
			rut.add("010000"+i);
			rut.add("AD"+i);
			rut.add("M5"+i);
			rut.add("BBBBBB"+i);
			
			result.add(rut);
		}
		
		return result;
	}
	
	// 将查询出的数据 封装到xml中
	public static boolean setDataToXml(List<List<Object>> result, String source, String dest) throws Exception{
		boolean flag = true;
		
		if(result != null && result.size() > 0) {
			for (int i = 0; i < result.size(); i++) {
				// 将source对应的document
				Document sdoc = getDocumentByFilePath(source);
				
				if(sdoc == null) {
					return false;
				}
				
				// 根据source路径下的xml格式，将result中的一条数据存入一个xml并保存到dest目录中
				if(!saveDataToXml(result.get(i), sdoc, dest, i)) {
					flag = false;
					break;
				}
			}
		}
		
		return flag;
	}
	
	// 将xml打包成.zip文件
	public static boolean convertXmlsToZip(String dest) {
		boolean flag = true;
		
		try {
			// zip名称
			String fileName = dest.substring(0, dest.lastIndexOf("/")) + File.separator + System.currentTimeMillis() + ".zip";
			
			// 创建文件
			File file = new File(fileName);
			file.createNewFile();
			// 文件夹
			File dir = new File(dest);
			
			// 输出流
			FileOutputStream fos1 = new FileOutputStream(file);
			ZipUtils.toZip(dir, fos1, true);
		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		
		return flag;
	}
	
	/**
	 * 将每条数据根据document的格式保存到新的xml中
	 * @param list
	 * @param sdoc
	 * @param dest
	 * @param i
	 * @return
	 */
	private static boolean saveDataToXml(List<Object> list, Document sdoc, String dest, int i) {
		boolean flag = true;
		
		if(list == null || list.size() == 0) {
			return false;
		}
		
		if(!setDataToDocument(list, sdoc, 0)) {
			return false;
		}
		
		if(!saveDocumentToXml(sdoc, dest, i)) {
			flag = false;
		}
		
		return flag;
	}

	/**
	 * 将document保存到xml中
	 * @param sdoc
	 * @param dest
	 * @param i 
	 */
	private static boolean saveDocumentToXml(Document sdoc, String dest, int i) {
		try {
			OutputFormat format = OutputFormat.createPrettyPrint();
			// ** 设置xml编码 格式**
            format.setEncoding("UTF-8");
            // ** 设置自动换行 **
            format.setNewlines(true);
            // ** 设置缩进 **
            format.setIndent(true);
            // 保留空格
            format.setTrimText(false);
            // xml 名称
            String flieName = dest + File.separator + MD5Utils.getPassword(Thread.currentThread().getName())+i+".xml";
            //设置本地保存路径
			File file = new File(flieName);
			
			if(!file.exists()) {
				file.createNewFile();
			}
            
            StandaloneWriter writer = new StandaloneWriter (new FileWriter(flieName),format);
            writer.write(sdoc);
            writer.close();            
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

	/**
	 * 将一条数据设置到document中
	 * @param list 数据list
	 * @param sdoc document对象
	 * @param idx 序号 记录list已经设置到哪个位置
	 * @return
	 */
	private static boolean setDataToDocument(List<Object> list, Document sdoc, int idx) {
		boolean flag = true;
		
		// document 的子节点 进行循环 
		// 如果子节点有children 继续循环
		Element root = sdoc.getRootElement();
		Iterator<Element> firstIterator = root.elementIterator();
		
		try {
			setDataToEveryLeaf(root, firstIterator, list, 0);
		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		
		return flag;
	}
	
	/**
	 * 将数据设置到每个子节点
	 * @param firstIterator 子节点数据对象
	 * @param list 数据list
	 * @param i 序号 记录list已经设置到哪个位置
	 */
	@SuppressWarnings("unchecked")
	private static int setDataToEveryLeaf(Element r, Iterator<Element> firstIterator, List<Object> list, int i) {		
		boolean flag = true;
		
		while(firstIterator.hasNext()) {
			flag = false;
			Element e= firstIterator.next();
			Iterator<Element> siet = e.elementIterator();
			
			i = setDataToEveryLeaf(e, siet, list, i);
		}
		
		if(flag) {
			r.setText(list.get(i) == null ? "" : list.get(i).toString());
			i++;
		}
		
		return i;
	}

	/**
	 * 根据文件路径 返回 对应的document对象
	 * @param source 文件路径
	 * @return
	 */
	private static Document getDocumentByFilePath(String source) {
		Document doc = null;
		try {
			File file = new File(source);
			SAXReader reader = new SAXReader();
			doc = reader.read(file);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return doc;
	}

	public static void main(String[] args) {
		DataConvertToXmlZip.dataToZip("F:/工作内容/海关数据对接/测试报文样例/海运预配主要报文.xml", "F:/hgcsbw/OutBox");
//		ZipUtils.delDirFiles("F:/hgcsbw/OutBox");
	}
}
