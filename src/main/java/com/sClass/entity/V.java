package com.sClass.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@Accessors(chain = true)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "DeliveryDestination")
public class V {
    private String Line;
    private String CityName;
    private String CountrySubEntityID;
    private String CountrySubEntityName;
    private String PostcodeID;
    private String CountryCode;
}
