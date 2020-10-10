//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.12.20 at 10:32:02 PM CAT 
//


package com.garmin.xmlschemas.gpxextensions.v3;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 				This type contains data fields available in Garmin GDB waypoints that
 * 				cannot
 * 				be represented in waypoints in GPX 1.1 instances.
 * 			
 * 
 * <p>Java class for WaypointExtension_t complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WaypointExtension_t">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Proximity" type="{http://www.garmin.com/xmlschemas/GpxExtensions/v3}Meters_t" minOccurs="0"/>
 *         &lt;element name="Temperature" type="{http://www.garmin.com/xmlschemas/GpxExtensions/v3}DegreesCelsius_t" minOccurs="0"/>
 *         &lt;element name="Depth" type="{http://www.garmin.com/xmlschemas/GpxExtensions/v3}Meters_t" minOccurs="0"/>
 *         &lt;element name="DisplayMode" type="{http://www.garmin.com/xmlschemas/GpxExtensions/v3}DisplayMode_t" minOccurs="0"/>
 *         &lt;element name="Categories" type="{http://www.garmin.com/xmlschemas/GpxExtensions/v3}Categories_t" minOccurs="0"/>
 *         &lt;element name="Address" type="{http://www.garmin.com/xmlschemas/GpxExtensions/v3}Address_t" minOccurs="0"/>
 *         &lt;element name="PhoneNumber" type="{http://www.garmin.com/xmlschemas/GpxExtensions/v3}PhoneNumber_t" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Extensions" type="{http://www.garmin.com/xmlschemas/GpxExtensions/v3}Extensions_t" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WaypointExtension_t", propOrder = {
    "proximity",
    "temperature",
    "depth",
    "displayMode",
    "categories",
    "address",
    "phoneNumber",
    "extensions"
})
public class WaypointExtensionT {

    @XmlElement(name = "Proximity")
    protected Double proximity;
    @XmlElement(name = "Temperature")
    protected Double temperature;
    @XmlElement(name = "Depth")
    protected Double depth;
    @XmlElement(name = "DisplayMode")
    @XmlSchemaType(name = "token")
    protected DisplayModeT displayMode;
    @XmlElement(name = "Categories")
    protected CategoriesT categories;
    @XmlElement(name = "Address")
    protected AddressT address;
    @XmlElement(name = "PhoneNumber")
    protected List<PhoneNumberT> phoneNumber;
    @XmlElement(name = "Extensions")
    protected ExtensionsT extensions;

    /**
     * Gets the value of the proximity property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getProximity() {
        return proximity;
    }

    /**
     * Sets the value of the proximity property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setProximity(Double value) {
        this.proximity = value;
    }

    /**
     * Gets the value of the temperature property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getTemperature() {
        return temperature;
    }

    /**
     * Sets the value of the temperature property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setTemperature(Double value) {
        this.temperature = value;
    }

    /**
     * Gets the value of the depth property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getDepth() {
        return depth;
    }

    /**
     * Sets the value of the depth property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setDepth(Double value) {
        this.depth = value;
    }

    /**
     * Gets the value of the displayMode property.
     * 
     * @return
     *     possible object is
     *     {@link DisplayModeT }
     *     
     */
    public DisplayModeT getDisplayMode() {
        return displayMode;
    }

    /**
     * Sets the value of the displayMode property.
     * 
     * @param value
     *     allowed object is
     *     {@link DisplayModeT }
     *     
     */
    public void setDisplayMode(DisplayModeT value) {
        this.displayMode = value;
    }

    /**
     * Gets the value of the categories property.
     * 
     * @return
     *     possible object is
     *     {@link CategoriesT }
     *     
     */
    public CategoriesT getCategories() {
        return categories;
    }

    /**
     * Sets the value of the categories property.
     * 
     * @param value
     *     allowed object is
     *     {@link CategoriesT }
     *     
     */
    public void setCategories(CategoriesT value) {
        this.categories = value;
    }

    /**
     * Gets the value of the address property.
     * 
     * @return
     *     possible object is
     *     {@link AddressT }
     *     
     */
    public AddressT getAddress() {
        return address;
    }

    /**
     * Sets the value of the address property.
     * 
     * @param value
     *     allowed object is
     *     {@link AddressT }
     *     
     */
    public void setAddress(AddressT value) {
        this.address = value;
    }

    /**
     * Gets the value of the phoneNumber property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the phoneNumber property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPhoneNumber().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PhoneNumberT }
     * 
     * 
     */
    public List<PhoneNumberT> getPhoneNumber() {
        if (phoneNumber == null) {
            phoneNumber = new ArrayList<PhoneNumberT>();
        }
        return this.phoneNumber;
    }

    /**
     * Gets the value of the extensions property.
     * 
     * @return
     *     possible object is
     *     {@link ExtensionsT }
     *     
     */
    public ExtensionsT getExtensions() {
        return extensions;
    }

    /**
     * Sets the value of the extensions property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExtensionsT }
     *     
     */
    public void setExtensions(ExtensionsT value) {
        this.extensions = value;
    }

}
