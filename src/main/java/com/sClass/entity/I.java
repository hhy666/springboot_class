package com.sClass.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.xml.bind.annotation.*;

@Data
@Accessors(chain = true)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Consignment")
public class I {
    @XmlElement(name = "TransportContractDocument")
    private K k;
    @XmlElement(name = "AssociatedTransportDocument")
    private L l;
    private String GrossVolumeMeasure;
    @XmlElement(name = "ValueAmount")
    private String ValueAmount;
    @XmlElement(name = "LoadingLocation")
    private M m;
    @XmlElement(name = "UnloadingLocation")
    private N n;
    @XmlElement(name = "GoodsReceiptPlace")
    private O o;
    @XmlElement(name = "TranshipmentLocation")
    private P p;
    @XmlElement(name = "TransitDestination")
    private Q q;
    @XmlElement(name = "GoodsConsignedPlace")
    private R r;
    @XmlElement(name = "FreightPayment")
    private S s;
    @XmlElement(name = "ConsignmentPackaging")
    private T t;
    private String TotalGrossMassMeasure;
    @XmlElement(name = "PreviousCustomsDocument")
    private U u;
    @XmlElement(name = "DeliveryDestination")
    private V v;
    @XmlElement(name = "IntermediateCarrier")
    private W w;
    @XmlElement(name = "Consignee")
    private X x;
    @XmlElement(name = "Consignor")
    private Y y;
    @XmlElement(name = "NotifyParty")
    private Z z;
    @XmlElement(name = "UNDGContact")
    private IA ia;
}
