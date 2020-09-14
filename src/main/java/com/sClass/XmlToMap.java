package com.sClass;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class XmlToMap {
    public static void main(String[] args) {
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n"+
                     "<Manifest xmlns=\"urn:Declaration:datamodel:standard:CN:MT2101:1\">\n"+
	                    "<Head>\n"+
		                   "<MessageID>CN_MT2101_1p1_4201101115245_20180903113640022</MessageID>\n"+
                           "<FunctionCode>9</FunctionCode>\n"+
		                   "<MessageType>MT2101</MessageType>\n"+
		                   "<SenderID>4201101115245_SWS0000000002_SW61000020170331_@</SenderID>\n"+
		                   "<ReceiverID>EPORT</ReceiverID>\n"+
		                   "<SendTime>20180519113649890</SendTime>\n"+
		                   "<Version>1.0</Version>\n"+
                        "</Head>\n"+
	                    "<Declaration>\n"+
		                   "<RepresentativePerson>\n"+
			                  "<Name>4201101115245</Name>\n"+
		                   "</RepresentativePerson>\n"+
		                   "<ExitCustomsOffice>\n"+
			                  "<ID>AAE/0000</ID>\n"+
		                   "</ExitCustomsOffice>\n"+
		                   "<Agent>\n"+
			                  "<ID>4201101115245</ID>\n"+
                           "</Agent>\n"+
		                   "<Carrier>\n"+
			                  "<ID>MM</ID>\n"+
		                   "</Carrier>\n"+
		                   "<BorderTransportMeans>\n"+
			                   "<JourneyID>CL12</JourneyID>\n"+
			                   "<TypeCode>4</TypeCode>\n"+
			                   "<ID>CL12</ID>\n"+
			                   "<Name>OOOO</Name>\n"+
			                   "<FirstArrivalLocationID>GUGU</FirstArrivalLocationID>\n"+
			                   "<ArrivalDateTime>20180521000000</ArrivalDateTime>\n"+
			                   "<DepartureDateTime>20180516000000</DepartureDateTime>\n"+
		                   "</BorderTransportMeans>\n"+
		                   "<Consignment>\n"+
			                  "<TransportContractDocument>\n"+
				                  "<ID>201805</ID>\n"+
				                  "<ConditionCode>10</ConditionCode>\n"+
				                  "<Consolidator>\n"+
					                 "<ID>4201100004245</ID>\n"+
				                  "</Consolidator>\n"+
			                  "</TransportContractDocument>\n"+
			                  "<AssociatedTransportDocument>\n"+
				                 "<ID>05181</ID>\n"+
			                  "</AssociatedTransportDocument>\n"+
			                  "<GrossVolumeMeasure>9</GrossVolumeMeasure>\n"+
			                  "<ValueAmount CurrencyTypeCode=\"AED\">999</ValueAmount>\n"+
			                  "<LoadingLocation>\n"+
				                 "<ID>AAE/4201</ID>\n"+
				                 "<LoadingDate>20180518000000</LoadingDate>\n"+
                              "</LoadingLocation>\n"+
			                  "<UnloadingLocation>\n"+
				                 "<ID>AAE</ID>\n"+
				                 "<ArrivalDate>20180519</ArrivalDate>\n"+
			                  "</UnloadingLocation>\n"+
			                  "<GoodsReceiptPlace>\n"+
				                 "<ID>AAE</ID>\n"+
				                 "<Name>MM</Name>\n"+
			                  "</GoodsReceiptPlace>\n"+
			                  "<TranshipmentLocation>\n"+
				                 "<ID>AAE</ID>\n"+
			                  "</TranshipmentLocation>\n"+
			                  "<TransitDestination>\n"+
				                 "<ID>AAE</ID>\n"+
			                  "</TransitDestination>\n"+
			                  "<GoodsConsignedPlace>\n"+
				                 "<ID>AAE</ID>\n"+
			                  "</GoodsConsignedPlace>\n"+
			                  "<FreightPayment>\n"+
				                 "<MethodCode>FF</MethodCode>\n"+
			                  "</FreightPayment>\n"+
			                  "<ConsignmentPackaging>\n"+
				                 "<QuantityQuantity>999</QuantityQuantity>\n"+
				                 "<TypeCode>AE</TypeCode>\n"+
			                  "</ConsignmentPackaging>\n"+
			                  "<TotalGrossMassMeasure>9</TotalGrossMassMeasure>\n"+
			                  "<PreviousCustomsDocument>\n"+
                                 "<ID>111111111</ID>\n"+
				                 "<TypeCode>mmm</TypeCode>\n"+
			                  "</PreviousCustomsDocument>\n"+
			                  "<DeliveryDestination>\n"+
				                 "<Line>M4</Line>\n"+
				                 "<CityName>M4</CityName>\n"+
				                 "<CountrySubEntityID>CN12</CountrySubEntityID>\n"+
				                 "<CountrySubEntityName>M4</CountrySubEntityName>\n"+
				                 "<PostcodeID>010000</PostcodeID>\n"+
				                 "<CountryCode>AD</CountryCode>\n"+
			                  "</DeliveryDestination>\n"+
			                  "<IntermediateCarrier>\n"+
				                 "<ID>1234567890</ID>\n"+
			                  "</IntermediateCarrier>\n"+
			                  "<Consignee>\n"+
				                 "<ID>A1+M1</ID>\n"+
				                 "<Name>M1</Name>\n"+
				                 "<Address>\n"+
					                "<Line>M1</Line>\n"+
					                "<CityName>M1</CityName>\n"+
					                "<CountrySubEntityID>CN12</CountrySubEntityID>\n"+
					                "<CountrySubEntityName>M1</CountrySubEntityName>\n"+
					                "<PostcodeID>010000</PostcodeID>\n"+
					                "<CountryCode>AD</CountryCode>\n"+
				                 "</Address>\n"+
                                 "<Contact>\n"+
					                "<Name>M1</Name>\n"+
				                 "</Contact>\n"+
				                 "<AEO>M1</AEO>\n"+
			                  "</Consignee>\n"+
			                  "<Consignor>\n"+
				                 "<ID>A2+M2</ID>\n"+
				                 "<Name>M2</Name>\n"+
				                 "<Address>\n"+
					                "<Line>M2</Line>\n"+
					                "<CityName>M2</CityName>\n"+
					                "<CountrySubEntityID>CN12</CountrySubEntityID>\n"+
					                "<CountrySubEntityName>M2</CountrySubEntityName>\n"+
					                "<PostcodeID>010000</PostcodeID>\n"+
					                "<CountryCode>AD</CountryCode>\n"+
				                 "</Address>\n"+
				                 "<AEO>MM</AEO>\n"+
			                  "</Consignor>\n"+
			                  "<NotifyParty>\n"+
				                 "<ID>ZZZ+M3</ID>\n"+
				                 "<Name>M3</Name>\n"+
				                 "<Address>\n"+
					                "<Line>M3</Line>\n"+
					                "<CityName>M3</CityName>\n"+
					                "<CountrySubEntityID>CN12</CountrySubEntityID>\n"+
					                "<CountrySubEntityName>M3</CountrySubEntityName>\n"+
					                "<PostcodeID>010000</PostcodeID>\n"+
					                "<CountryCode>AD</CountryCode>\n"+
				                 "</Address>\n"+
			                  "</NotifyParty>\n"+
			                  "<UNDGContact>\n"+
				                 "<Name>M5</Name>\n"+
			                  "</UNDGContact>\n"+
		                   "</Consignment>\n"+
		                   "<AdditionalInformation>\n"+
			                  "<Content>BBBBBB101</Content>\n"+
		                   "</AdditionalInformation>\n"+
	                    "</Declaration>\n"+
                     "</Manifest>\n";

        try {
            //xml转map
            Map map = parseXml(xml);
            System.out.println("+++++++++++++++++"+map.toString());

            //map转xml
            StringBuffer sb = new StringBuffer();
            MapToXml.parseMap(map,sb);
            //System.out.println(MapToXml.formatXML(sb.toString()));
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    /**
     * xml转为map,map中有list（节点相同时候)，list中有map
     * @param xml
     * @return
     * @throws DocumentException
     */
    public static Map<String, Object> parseXml(String xml) throws DocumentException {
        Map map = new HashMap();
        try {
            SAXReader saxReader = new SAXReader();
            Document document = saxReader.read(new ByteArrayInputStream(xml.getBytes("UTF-8")));//xml串第一行不能有空格，否则报错
            Element root = document.getRootElement();//得到xml文档根节点元素，即最上层的"<xml>"
            elementTomap(root, map);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return map;
    }

    @SuppressWarnings("unchecked")
    public static Map<String, Object> elementTomap(Element outele, Map<String, Object> outmap) {
        List<Element> list = outele.elements();
        int size = list.size();
        if (size == 0) {
            outmap.put(outele.getName(), outele.getTextTrim());
        } else {
            Map<String, Object> innermap = new HashMap<String, Object>();
            int i = 1;

            for (Element ele1 : list) {
                String eleName = ele1.getName();

                String value = ele1.getText();
                Object obj = innermap.get(eleName);
                if (obj == null) {
                    elementTomap(ele1, innermap);
                } else {
                    if (obj instanceof java.util.Map) {
                        List<Map<String, Object>> list1 = new ArrayList<Map<String, Object>>();
                        list1.add((Map<String, Object>) innermap.remove(eleName));
                        elementTomap(ele1, innermap);
                        list1.add((Map<String, Object>) innermap.remove(eleName));
                        innermap.put(eleName, list1);
                    } else if (obj instanceof String) {

                        innermap.put(eleName + i, value);
                        i++;
                    } else {
                        elementTomap(ele1, innermap);
                        Map<String, Object> listValue = (Map<String, Object>) innermap.get(eleName);
                        ((List<Map<String, Object>>) obj).add(listValue);
                        innermap.put(eleName, obj);
                    }

                }
            }
            outmap.put(outele.getName(), innermap);
        }
        return outmap;
    }
}

