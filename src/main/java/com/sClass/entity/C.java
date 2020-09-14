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
@XmlRootElement(name = "Declaration")
public class C {
    @XmlElement(name = "RepresentativePerson")
    private D d;
    @XmlElement(name = "ExitCustomsOffice")
    private E e;
    @XmlElement(name = "Agent")
    private F f;
    @XmlElement(name = "Carrier")
    private G g;
    @XmlElement(name = "BorderTransportMeans")
    private H h;
    @XmlElement(name = "Consignment")
    private I i;
    @XmlElement(name = "AdditionalInformation")
    private J j;
}
