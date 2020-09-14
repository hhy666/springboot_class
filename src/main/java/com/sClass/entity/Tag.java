package com.sClass.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.Date;
@Data
@Accessors(chain = true)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Tag")
@XmlType(propOrder = {
        "id",
        "name",
        "creatdate",
        "tagtype",
})
public class Tag implements Serializable {
    private String id;
    private String name;
    @JsonFormat(pattern = "yyyy/MM/dd",timezone = "GMT+8")
    private Date creatdate;
    private String tagtype;
}
