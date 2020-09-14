package com.sClass.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.xml.bind.annotation.*;

@Data
@Accessors(chain = true)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Manifest")
public class A {
    @XmlAttribute(name = "xmlns")
    private String xmlns;
    @XmlElement(name = "Head")
    private B b;
    @XmlElement(name = "Declaration")
    private C c;
}
