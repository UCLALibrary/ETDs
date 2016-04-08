
package edu.ucla.grad.commservices.gd;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="gdToken" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="proquestID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "gdToken",
    "proquestID"
})
@XmlRootElement(name = "GetProquestFilerForProquestID")
public class GetProquestFilerForProquestID {

    @XmlElementRef(name = "gdToken", namespace = "http://tempuri.org/", type = JAXBElement.class)
    protected JAXBElement<String> gdToken;
    @XmlElementRef(name = "proquestID", namespace = "http://tempuri.org/", type = JAXBElement.class)
    protected JAXBElement<String> proquestID;

    /**
     * Gets the value of the gdToken property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getGdToken() {
        return gdToken;
    }

    /**
     * Sets the value of the gdToken property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setGdToken(JAXBElement<String> value) {
        this.gdToken = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the proquestID property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getProquestID() {
        return proquestID;
    }

    /**
     * Sets the value of the proquestID property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setProquestID(JAXBElement<String> value) {
        this.proquestID = ((JAXBElement<String> ) value);
    }

}
