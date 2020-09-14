package com.sClass.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Accessors(chain = true)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="City")
@XmlType(propOrder = {
        "id",
        "name",
        "nickname",
        "creatdate",
        "clazz",
})

public class Grou implements Serializable {
    private String id;
    private String name;
    private String nickname;
    @JsonFormat(pattern = "yyyy/MM/dd",timezone = "GMT+8")
    private Date creatdate;
    @XmlElement(name = "Clazz")
    private Clazz clazz;
}
