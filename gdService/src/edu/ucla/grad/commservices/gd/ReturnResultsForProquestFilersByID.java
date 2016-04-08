
package edu.ucla.grad.commservices.gd;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ReturnResultsForProquestFilersByID complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ReturnResultsForProquestFilersByID">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Message" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ProquestFiler" type="{http://schemas.datacontract.org/2004/07/GD.CommServices.Model}vwProQuestFiler" minOccurs="0"/>
 *         &lt;element name="Result" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReturnResultsForProquestFilersByID", namespace = "http://schemas.datacontract.org/2004/07/GD.CommServices", propOrder = {
    "message",
    "proquestFiler",
    "result"
})
public class ReturnResultsForProquestFilersByID {

    @XmlElementRef(name = "Message", namespace = "http://schemas.datacontract.org/2004/07/GD.CommServices", type = JAXBElement.class)
    protected JAXBElement<String> message;
    @XmlElementRef(name = "ProquestFiler", namespace = "http://schemas.datacontract.org/2004/07/GD.CommServices", type = JAXBElement.class)
    protected JAXBElement<VwProQuestFiler> proquestFiler;
    @XmlElement(name = "Result")
    protected Integer result;

    /**
     * Gets the value of the message property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getMessage() {
        return message;
    }

    /**
     * Sets the value of the message property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setMessage(JAXBElement<String> value) {
        this.message = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the proquestFiler property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link VwProQuestFiler }{@code >}
     *     
     */
    public JAXBElement<VwProQuestFiler> getProquestFiler() {
        return proquestFiler;
    }

    /**
     * Sets the value of the proquestFiler property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link VwProQuestFiler }{@code >}
     *     
     */
    public void setProquestFiler(JAXBElement<VwProQuestFiler> value) {
        this.proquestFiler = ((JAXBElement<VwProQuestFiler> ) value);
    }

    /**
     * Gets the value of the result property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getResult() {
        return result;
    }

    /**
     * Sets the value of the result property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setResult(Integer value) {
        this.result = value;
    }

}
