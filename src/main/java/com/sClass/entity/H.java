package com.sClass.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@Accessors(chain = true)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "BorderTransportMeans")
public class H {
    private String JourneyID;
    private String TypeCode;
    private String ID;
    private String Name;
    private String FirstArrivalLocationID;
    private String ArrivalDateTime;
    private String DepartureDateTime;
}
