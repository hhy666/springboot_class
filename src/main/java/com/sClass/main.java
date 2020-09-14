package com.sClass;

import com.sClass.entity.*;
import com.sClass.util.XMLUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.ResourceLoader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.ByteArrayOutputStream;

public class main {
    @Bean
    public static ResourceLoader resourceLoader() {
        return new DefaultResourceLoader();
    }

    private static ResourceLoader resourceLoader = resourceLoader();

    public static void main(String[] args) throws Exception {
        JAXBContext context = JAXBContext.newInstance(A.class, B.class, C.class);    // 获取上下文对象
        Marshaller marshaller = context.createMarshaller(); // 根据上下文获取marshaller对象

        marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");  // 设置编码字符集
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true); // 格式化XML输出，有分行和缩进

        //marshaller.marshal(getSimpleDepartment(), System.out);   // 打印到控制台

        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        marshaller.marshal(getSimpleDepartment(), baos);
        String path = "E:\\erlOrRabbitmq\\2\\city.xml";
        XMLUtil.convertToXml(getSimpleDepartment(), path);
        String xmlObj = new String(baos.toByteArray());         // 生成XML字符串
        System.out.println(xmlObj);
    }

    /**
     * 生成一个简单的Department对象
     *
     * @return
     */
//    private static Citys getSimpleDepartment() {
//        List<City> cities = new ArrayList<City>();
//
//        City stf = new City();
//        stf.setId("1");
//        stf.setName("周杰伦");
//        cities.add(stf);
//
//        City stf1 = new City();
//        stf1.setId("2");
//        stf1.setName("周笔畅");
//        cities.add(stf);
//
//        City stf2 = new City();
//        stf2.setId("3");
//        stf2.setName("周星驰");
//        cities.add(stf2);
//
//        Citys dept = new Citys();
//          dept.setCities(cities);
//        return dept;
//    }
    private static A getSimpleDepartment() {
        A a = new A();
        B b = new B();
        b.setMessageID("CN_MT2101_1p1_4201101115245_20180903113640022");
        b.setFunctionCode("9");
        b.setMessageType("MT2101");
        b.setSenderID("4201101115245_SWS0000000002_SW61000020170331_@");
        b.setReceiverID("EPORT");
        b.setSendTime("20180519113649890");
        b.setVersion("1.0");
        C c = new C();
        D d = new D();
        d.setName("4201101115245");
        E e = new E();
        e.setID("AAE/0000");
        F f = new F();
        f.setID("4201101115245");
        G g = new G();
        g.setID("MM");
        H h = new H();
        h.setJourneyID("CL12");
        h.setTypeCode("4");
        h.setID("CL12");
        h.setName("OOOO");
        h.setFirstArrivalLocationID("GUGU");
        h.setArrivalDateTime("20180521000000");
        h.setDepartureDateTime("20180516000000");
        I i = new I();
        K k = new K();
        L l = new L();
        M m = new M();
        N n = new N();
        O o = new O();
        P p = new P();
        Q q = new Q();
        R r = new R();
        S s = new S();
        T t = new T();
        U u = new U();
        V v = new V();
        W w = new W();
        X x = new X();
        Y y = new Y();
        Z z = new Z();
        IA ia = new IA();
        ia.setName("M5");
        IB ib = new IB();
        ib.setID("4201100004245");
        IC ic = new IC();
        ic.setLine("M1");
        ic.setCityName("M1");
        ic.setCountrySubEntityID("CN12");
        ic.setCountrySubEntityName("M1");
        ic.setPostcodeID("010000");
        ic.setCountryCode("AD");
        IC ic2 = new IC();
        ic2.setLine("M2");
        ic2.setCityName("M2");
        ic2.setCountrySubEntityID("CN12");
        ic2.setCountrySubEntityName("M2");
        ic2.setPostcodeID("010000");
        ic2.setCountryCode("AD");
        IC ic3 = new IC();
        ic3.setLine("M3");
        ic3.setCityName("M3");
        ic3.setCountrySubEntityID("CN12");
        ic3.setCountrySubEntityName("M3");
        ic3.setPostcodeID("010000");
        ic3.setCountryCode("AD");
        IE ie = new IE();
        ie.setName("M1");
        J j = new J();
        j.setContent("BBBBBB101");
        k.setID("201805");
        k.setConditionCode("10");
        k.setIb(ib);
        l.setID("05181");
        m.setID("AAE/4201");
        m.setLoadingDate("20180518000000");
        n.setID("AAE");
        n.setArrivalDate("20180509");
        o.setID("AAE");
        o.setName("MM");
        p.setID("AAE");
        q.setID("AAE");
        r.setID("AAE");
        s.setMethodCode("FF");
        t.setQuantityQuantity("999");
        t.setTypeCode("AE");
        u.setID("111111111");
        u.setTypeCode("mmm");
        v.setLine("M4");
        v.setCityName("M4");
        v.setCountrySubEntityID("CN12");
        v.setCountrySubEntityName("M4");
        v.setPostcodeID("010000");
        v.setCountryCode("AD");
        w.setID("1234567890");
        x.setID("A1+M1");
        x.setName("M1");
        x.setIc(ic);
        x.setIe(ie);
        x.setAEO("M1");
        y.setID("A2+M2");
        y.setName("M2");
        y.setIc(ic2);
        y.setAEO("MM");
        z.setID("ZZZ+M3");
        z.setName("M3");
        z.setIc(ic3);
        i.setK(k);
        i.setL(l);
        i.setGrossVolumeMeasure("9");
        i.setValueAmount("999");
        i.setM(m);
        i.setN(n);
        i.setO(o);
        i.setP(p);
        i.setQ(q);
        i.setR(r);
        i.setS(s);
        i.setT(t);
        i.setTotalGrossMassMeasure("9");
        i.setU(u);
        i.setV(v);
        i.setW(w);
        i.setX(x);
        i.setY(y);
        i.setZ(z);
        i.setIa(ia);
        c.setD(d);
        c.setE(e);
        c.setF(f);
        c.setG(g);
        c.setH(h);
        c.setI(i);
        c.setJ(j);

        a.setXmlns("urn:Declaration:datamodel:standard:CN:MT2101:1");
        a.setB(b);
        a.setC(c);
        return a;
    }
}
