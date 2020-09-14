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

@Data// 缩减代码，省略get/set方法，还可以实现haashCode(),toString(),equals()等方法
@Accessors(chain = true) //默认为false，当chain为true时，set方法返回的是当前对象，可以在对属性赋值时连续进行
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="City")
@XmlType(propOrder = {
        "id",
        "name",
        "creatdate",
})

public class City implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String name;
    @JsonFormat(pattern = "yyyy/MM/dd",timezone = "GMT+8")
    private Date creatdate;
}
