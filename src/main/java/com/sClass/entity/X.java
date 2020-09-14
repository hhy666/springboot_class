package com.sClass.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@Accessors(chain = true)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Consignee")
public class X {
    private String ID;
    private String Name;
    @XmlElement(name = "Address")
    private IC ic;
    @XmlElement(name = "Contact")
    private IE ie;
    private String AEO;

}
