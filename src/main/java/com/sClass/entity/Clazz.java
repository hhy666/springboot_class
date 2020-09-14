package com.sClass.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
@Data
@Accessors(chain = true)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="City")
@XmlType(propOrder = {
        "id",
        "name",
        "tag",
})

public class Clazz implements Serializable {
    private String id;
    private String name;
    @XmlElement(name = "Tag")
    private Tag tag;

    //private String tagId;
}
