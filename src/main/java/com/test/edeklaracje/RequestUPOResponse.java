
package com.test.edeklaracje;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="upo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="statusOpis" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "upo",
    "status",
    "statusOpis"
})
@XmlRootElement(name = "requestUPOResponse")
public class RequestUPOResponse {

    protected String upo;
    protected int status;
    @XmlElement(required = true)
    protected String statusOpis;

    /**
     * Gets the value of the upo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUpo() {
        return upo;
    }

    /**
     * Sets the value of the upo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUpo(String value) {
        this.upo = value;
    }

    /**
     * Gets the value of the status property.
     * 
     */
    public int getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     */
    public void setStatus(int value) {
        this.status = value;
    }

    /**
     * Gets the value of the statusOpis property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatusOpis() {
        return statusOpis;
    }

    /**
     * Sets the value of the statusOpis property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatusOpis(String value) {
        this.statusOpis = value;
    }

}
