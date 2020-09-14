package com.sClass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings({ "rawtypes", "unchecked", "static-access" })
public class XmlStaticData {

	// Consignment 对应 String 数组 节点信息
	// 以$$$$$ 符号作为第一级子节点分隔符
	// 以$$$$ 符号作为第二级子节点分隔符
	// 以$$$ 符号作为第三级子节点分隔符
	// 以$$ 符号作为第四级子节点分隔符
	// 以$ 符号作为第五级子节点分隔符
	// 以,分割属性与标签名称
	// 以@分割标签属性名称与标签属性值
	private final static String FIRSTCODESTRING = "Head$$$$$Declaration";
	private final static String SECONDCODESTRING = 
			"MessageID$$$$FunctionCode$$$$MessageType$$$$SenderID$$$$ReceiverID$$$$SendTime$$$$Version"
		+ "$$$$$"
		+ "RepresentativePerson$$$$ExitCustomsOffice$$$$Agent$$$$Carrier$$$$BorderTransportMeans$$$$Consignment$$$$AdditionalInformation";
	private final static String THIRDCODESTRING = 
			"null$$$$null$$$$null$$$$null$$$$null$$$$null$$$$null"
		+ "$$$$$"
			+ "Name"
			+ "$$$$"
			+ "ID"
			+ "$$$$"
			+ "ID"
			+ "$$$$"
			+ "ID"
			+ "$$$$"
			+ "JourneyID$$$TypeCode$$$ID$$$Name$$$FirstArrivalLocationID$$$ArrivalDateTime$$$DepartureDateTime"
			+ "$$$$"
			+ "TransportContractDocument$$$AssociatedTransportDocument$$$GrossVolumeMeasure$$$ValueAmount,CurrencyTypeCode@AED"
				+ "$$$LoadingLocation$$$UnloadingLocation$$$GoodsReceiptPlace$$$TranshipmentLocation$$$TransitDestination$$$GoodsConsignedPlace"
				+ "$$$FreightPayment$$$ConsignmentPackaging$$$TotalGrossMassMeasure$$$PreviousCustomsDocument$$$DeliveryDestination"
				+ "$$$IntermediateCarrier$$$Consignee$$$Consignor$$$NotifyParty$$$UNDGContact"
			+ "$$$$"
			+ "Content";
	private final static String FOURCODESTRING = 
			"null$$$$null$$$$null$$$$null$$$$null$$$$null$$$$null"
		+ "$$$$$"
			+ "null"
			+ "$$$$"
			+ "null"
			+ "$$$$"
			+ "null"
			+ "$$$$"
			+ "null"
			+ "$$$$"
				+ "null"
				+ "$$$"
				+ "null"
				+ "$$$"
				+ "null"
				+ "$$$"
				+ "null"
				+ "$$$"
				+ "null"
				+ "$$$"
				+ "null"
				+ "$$$"
				+ "null"
			+ "$$$$"
					+ "ID$$ConditionCode$$Consolidator"
				+ "$$$"
					+ "ID"
				+ "$$$"
					+ "null"
				+ "$$$"
					+ "null"
				+ "$$$"
					+ "ID$$LoadingDate"
				+ "$$$"
					+ "ID$$ArrivalDate"
				+ "$$$"
					+ "ID$$Name"
				+ "$$$"
					+ "ID"
				+ "$$$"
					+ "ID"
				+ "$$$"
					+ "ID"
				+ "$$$"
					+ "MethodCode"
				+ "$$$"
					+ "QuantityQuantity$$TypeCode"
				+ "$$$"
					+ "null"
				+ "$$$"
					+ "ID$$TypeCode"
				+ "$$$"
					+ "Line$$CityName$$CountrySubEntityID$$CountrySubEntityName$$PostcodeID$$CountryCode"
				+ "$$$"
					+ "ID"
				+ "$$$"
					+ "ID$$Name$$Address$$Contact$$AEO"
				+ "$$$"
					+ "ID$$Name$$Address$$AEO"
				+ "$$$"
					+ "ID$$Name$$Address"
				+ "$$$"
					+ "Name"
			+ "$$$$"
				+ "null";
	private final static String FIVECODESTRING = 
			"null$$$$null$$$$null$$$$null$$$$null$$$$null$$$$null"
		+ "$$$$$"
			+ "null"
			+ "$$$$"
			+ "null"
			+ "$$$$"
			+ "null"
			+ "$$$$"
			+ "null"
			+ "$$$$"
				+ "null"
				+ "$$$"
				+ "null"
				+ "$$$"
				+ "null"
				+ "$$$"
				+ "null"
				+ "$$$"
				+ "null"
				+ "$$$"
				+ "null"
				+ "$$$"
				+ "null"
			+ "$$$$"
						+ "null"
					+ "$$"
						+ "null"
					+ "$$"
						+ "ID"
				+ "$$$"
					+ "null"
				+ "$$$"
					+ "null"
				+ "$$$"
					+ "null"
				+ "$$$"
					+ "null$$null"
				+ "$$$"
					+ "null$$null"
				+ "$$$"
					+ "null$$null"
				+ "$$$"
					+ "null"
				+ "$$$"
					+ "null"
				+ "$$$"
					+ "null"
				+ "$$$"
					+ "null"
				+ "$$$"
					+ "null$$null"
				+ "$$$"
					+ "null"
				+ "$$$"
					+ "null$$null"
				+ "$$$"
					+ "null$$null$$null$$null$$null$$null"
				+ "$$$"
					+ "null"
				+ "$$$"
					+ "null$$null"
					+ "$$"
						+ "Line$CityName$CountrySubEntityID$CountrySubEntityName$PostcodeID$CountryCode"
					+ "$$"
						+ "Name"
					+ "$$null"
				+ "$$$"
					+ "null$$null$$"
						+ "Line$CityName$CountrySubEntityID$CountrySubEntityName$PostcodeID$CountryCode"
					+ "$$null"
				+ "$$$"
					+ "null$$null$$"
						+ "Line$CityName$CountrySubEntityID$CountrySubEntityName$PostcodeID$CountryCode"
					+ "$$null"
				+ "$$$"
					+ "null"
			+ "$$$$"
				+ "null";
	private static Map codeMap;

	public XmlStaticData() throws Exception{
		super();
		// 初始化设置xml对应的map
		this.codeMap = setXmlCodeMap();
	}

	/**
	 * 根据传入的与xml格式对应的data数据 设置xml对应格式内标签的值
	 * @param data
	 * @return
	 */
	Map setXmlCodeValue(Map data) {
		// 从Manifest 的 childData开始 赋值 
		List<Map> childData = (List<Map>) this.codeMap.get("childData");
		// 查询出来的数据childData
		List<Map> rcData = (List<Map>) data.get("childData");
		
		if(childData == null || childData.size() == 0) {
			return null;
		}
		
		for (int i = 0; i < childData.size(); i++) {
			setChildDataValue(childData.get(i), rcData.get(i));
		}
		
		this.codeMap.put("childData", childData);
		
		return this.codeMap;
	}
	
	/**
	 * 循环遍历 childData
	 * @param code
	 * @param data
	 */
	private void setChildDataValue(Map code, Map data) {
		// 判断是否有子节点数据
		boolean hasChild = (boolean) code.get("hasChild"); 
		
		if(!hasChild) {
			// 没有子节点 此时设置值
			code.put("value", data.get(code.get("name")));
		}else {
			// code 的 childData 
			List<Map> childData = (List<Map>) code.get("childData");
			// 查询出来的数据childData
			List<Map> rcData = (List<Map>) data.get("childData");
			
			if(childData != null && childData.size() > 0) {
				for (int i = 0; i < childData.size(); i++) {
					setChildDataValue(childData.get(i), rcData.get(i));
				}
			}
		}
	}

	/**
	 * 根据节点string 生成对应的xml格式的map标签名信息
	 * @return
	 */
	private Map setXmlCodeMap() {
		try {
			// 存储 进行返回
			Map map = new HashMap();
			// 存储 根节点对应的子节点的map信息
			List<Map> childData = new ArrayList<Map>();

			// 先按$$$$$划分第一类节点
			String[] first = XmlStaticData.FIRSTCODESTRING.split("\\$\\$\\$\\$\\$");
			
			// 对first 进行循环
			for (int i = 0; i < first.length; i++) {
				String[] spt = new String[1];
				spt[0] = "\\$\\$\\$\\$\\$";
				int[] is = new int[1];
				is[0] = i;
				childData.add(returnChildData(first[i], 2, spt, is));			
			}
			
			// 存放根节点信息
			map.put("name", "Manifest");
			// attr
			Map attr = new HashMap();
			attr.put("name", "xmlns");
			attr.put("value", "urn:Declaration:datamodel:standard:CN:MT2101:1");
			
			map.put("attr", attr);
			// 含有子节点
			map.put("childData", childData);
			
			return map;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/*
	 * 返回第一类子节点的子节点信息
	 */
	private static Map returnChildData(String str, int strIndex, String[] spt, int[] is) throws Exception{
		// 存储 第一类节点 的map
		Map map = checkIsHaveAttr(str);
		
		if(strIndex > 5) {
			map.put("hasChild", false);
			return map;
		}
		
		// 判断节点是否含有子节点
		// 获取 secondString 中的第一类节点 i 对应的string
		String ssi = returnXmlString(strIndex, spt, is);
		// 判断ssi中是否为null
		if(ssi == null || ssi.equals("") || ssi.equals("null")) {
			// 此时 对应节点不存在 子节点 跳出当前循环
			map.put("hasChild", false);
			return map;
		}
		
		// 此时存在子节点
		map.put("hasChild", true);
		// 存储 第一类节点对应的子节点的map信息
		List<Map> childData = new ArrayList<Map>();
		// 设置下一类节点
		String[] next = ssi.split(spt[spt.length - 1].substring(0, spt[spt.length - 1].length() - 2) );
		
		// 如果next 为空 或者长度=0 跳出当前循环
		if(next == null || next.length == 0) {
			return map;
		}
		
		// 下一个循环需要查找的字符串
		int nextStrIndex = strIndex+1;
		
		for (int j = 0; j < next.length; j++) {
			String[] spt1 = Arrays.copyOf(spt, spt.length+1);
			spt1[spt.length] = spt[spt.length-1].substring(0, spt[spt.length-1].length() - 2);
			int[] is1 = Arrays.copyOf(is, is.length+1);
			is1[is.length] = j;
			
			childData.add(returnChildData(next[j], nextStrIndex, spt1, is1));			
		}
		
		// 含有子节点
		map.put("childData", childData);
		
		return map;
	}
	
	// 根据传入序号和需要进行分割的数组以及序号数组进行返回对应的字符串
	private static String returnXmlString(int strIndex, String[] spt, int[] is) throws Exception{
		String str = "";
		try {
			str = returnXmlString(strIndex);
			System.out.println(str);
			for (int i = 0; i < spt.length; i++) {
				str = str.split(spt[i])[is[i]];
				System.out.println(str.split(spt[i])[0]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return str;
	}
	// 根据传入序号返回对应的字符串
	private static String returnXmlString(int i) throws Exception{
		switch(i) {
			case 1:
				return XmlStaticData.FIRSTCODESTRING;
			case 2:
				return XmlStaticData.SECONDCODESTRING;
			case 3:
				return XmlStaticData.THIRDCODESTRING;
			case 4:
				return XmlStaticData.FOURCODESTRING;
			case 5:
				return XmlStaticData.FIVECODESTRING;
			default:
				return null;
		}
	}
	
	/**
	 *	根据 传入字符串 判断是否含有 attr 属性 如果有属性则将attr属性添加到map 并返回map
	 * @paramType map
	 * @param str
	 * @throws Exception
	 */
	private static Map checkIsHaveAttr(String str) throws Exception{
		Map map = new HashMap();
		
		// 节点名称
		map.put("name", str);
		// 判断节点是否含有属性
		if(str.indexOf(",") < 0) {
			// 不含属性
			map.put("hasAttr", false);
		}else {
			// 含有属性
			map.put("hasAttr", true);
			// 对 str 进行分割 其中 第0个元素为code的名称 之后元素为@分开的属性名称和属性值
			String[] fattr =  str.split(",");
			// 存储属性值list<Map>
			List<Map> fattrMap = new ArrayList<Map>();
			
			// 对fattr循环
			for (int j = 1; j < fattr.length; j++) {
				Map fam = new HashMap();
				
				fam.put("name", fattr[j].split("@")[0]);
				fam.put("value", fattr[j].split("@")[1]);
				
				fattrMap.add(fam);
			}
			
			map.put("attrData", fattrMap);
			// 节点有属性重新对节点的名称进行存储
			map.put("name", fattr[0]);
		}
		
		return map;
	}

	/**
	 * 将查询出来的数据 转换成与xml的map格式相近的map 供xml的map设置内容
	 * @param rut
	 * @return
	 */
	public Map convertDataToMap(List<Object> rut) {
		Map map = new HashMap();
		
		// 从Manifest 的 childData开始 赋值 
		List<Map> childData = (List<Map>) this.codeMap.get("childData");
		// 查询出来的数据childData
		List<Map> rcData = new ArrayList<Map>();
		
		if(childData == null || childData.size() == 0) {
			return null;
		}
		
		// rut 中 每个元素依次对应一个叶节点的值 从0开始计数
		int ruti = 0;
		
		for (int i = 0; i < childData.size(); i++) {
			Map res = returnChildDataValueMap(childData.get(i), rut, ruti);
			
			ruti = (int) res.get("rutj");
			System.out.println(ruti+"");
			rcData.add(res);
		}
		
		map.put("childData", rcData);
		
		return map;
	}

	/**
	 * 循环遍历 设置childData
	 * @param code
	 * @param rut
	 * @param ruti
	 * @return
	 */
	private Map returnChildDataValueMap(Map code, List<Object> rut, int ruti) {
		Map res = new HashMap();
		
		// 计数
		int rutj = ruti+1;
		
		// 判断是否有子节点数据
		boolean hasChild = (boolean) code.get("hasChild");
		
		if(!hasChild) {
			// 没有子节点 此时设置值
			res.put(code.get("name"), rut.get(ruti));
			res.put("rutj", rutj);
			System.out.println(ruti+"");
		}else {
			// code 的 childData 
			List<Map> childData = (List<Map>) code.get("childData");
			// 查询出来的数据childData
			List<Map> rcData =  new ArrayList<Map>();
			
			if(childData != null && childData.size() > 0) {
				for (int i = 0; i < childData.size(); i++) {
					Map rrr = returnChildDataValueMap(childData.get(i), rut, ruti);
					
					ruti = (int) rrr.get("rutj");
					System.out.println(ruti+"");
					rcData.add(rrr);
				}
			}
			
			res.put("rutj", ruti);
			res.put("childData", rcData);
		}
		
		return res;
	}

}
