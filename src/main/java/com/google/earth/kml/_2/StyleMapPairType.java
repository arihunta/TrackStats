//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.12.20 at 10:32:02 PM CAT 
//


package com.google.earth.kml._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for StyleMapPairType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="StyleMapPairType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="key" type="{http://earth.google.com/kml/2.1}styleStateEnum"/>
 *         &lt;element ref="{http://earth.google.com/kml/2.1}styleUrl"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StyleMapPairType", propOrder = {

})
public class StyleMapPairType {

    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected StyleStateEnum key;
    @XmlElement(required = true)
    @XmlSchemaType(name = "anyURI")
    protected String styleUrl;

    /**
     * Gets the value of the key property.
     * 
     * @return
     *     possible object is
     *     {@link StyleStateEnum }
     *     
     */
    public StyleStateEnum getKey() {
        return key;
    }

    /**
     * Sets the value of the key property.
     * 
     * @param value
     *     allowed object is
     *     {@link StyleStateEnum }
     *     
     */
    public void setKey(StyleStateEnum value) {
        this.key = value;
    }

    /**
     * Gets the value of the styleUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStyleUrl() {
        return styleUrl;
    }

    /**
     * Sets the value of the styleUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStyleUrl(String value) {
        this.styleUrl = value;
    }

}
