//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.12.20 at 10:32:02 PM CAT 
//


package com.google.earth.kml._2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for altitudeModeEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="altitudeModeEnum">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="clampToGround"/>
 *     &lt;enumeration value="relativeToGround"/>
 *     &lt;enumeration value="absolute"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "altitudeModeEnum")
@XmlEnum
public enum AltitudeModeEnum {

    @XmlEnumValue("clampToGround")
    CLAMP_TO_GROUND("clampToGround"),
    @XmlEnumValue("relativeToGround")
    RELATIVE_TO_GROUND("relativeToGround"),
    @XmlEnumValue("absolute")
    ABSOLUTE("absolute");
    private final String value;

    AltitudeModeEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AltitudeModeEnum fromValue(String v) {
        for (AltitudeModeEnum c: AltitudeModeEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
