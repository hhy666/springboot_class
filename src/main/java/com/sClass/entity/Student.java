package com.sClass.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Accessors(chain = true)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="Student")
@XmlType(propOrder = {
        "id",
        "name",
        "username",
        "password",
        "age",
        "bir",
        "grou",
        "clazz",
        "city",
        "tag",
})
public class Student implements Serializable {
    private String id;
    private String name;
    private String username;
    private String password;
    private Integer age;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date bir;
    @XmlElement(name = "Grou")
    private Grou grou;
    @XmlElement(name = "Clazz")
    private Clazz clazz;
    @XmlElement(name = "City")
    private City city;
    @XmlElement(name = "Tag")
    private Tag tag;

}
