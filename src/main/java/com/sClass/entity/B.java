package com.sClass.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@Accessors(chain = true)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Head")
public class B {
    private String MessageID;
    private String FunctionCode;
    private String MessageType;
    private String SenderID;
    private String ReceiverID;
    private String SendTime;
    private String Version;


}
