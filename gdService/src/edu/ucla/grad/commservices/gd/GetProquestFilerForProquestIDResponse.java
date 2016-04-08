
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
 *         &lt;element name="GetProquestFilerForProquestIDResult" type="{http://schemas.datacontract.org/2004/07/GD.CommServices}ReturnResultsForProquestFilersByID" minOccurs="0"/>
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
    "getProquestFilerForProquestIDResult"
})
@XmlRootElement(name = "GetProquestFilerForProquestIDResponse")
public class GetProquestFilerForProquestIDResponse {

    @XmlElementRef(name = "GetProquestFilerForProquestIDResult", namespace = "http://tempuri.org/", type = JAXBElement.class)
    protected JAXBElement<ReturnResultsForProquestFilersByID> getProquestFilerForProquestIDResult;

    /**
     * Gets the value of the getProquestFilerForProquestIDResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ReturnResultsForProquestFilersByID }{@code >}
     *     
     */
    public JAXBElement<ReturnResultsForProquestFilersByID> getGetProquestFilerForProquestIDResult() {
        return getProquestFilerForProquestIDResult;
    }

    /**
     * Sets the value of the getProquestFilerForProquestIDResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ReturnResultsForProquestFilersByID }{@code >}
     *     
     */
    public void setGetProquestFilerForProquestIDResult(JAXBElement<ReturnResultsForProquestFilersByID> value) {
        this.getProquestFilerForProquestIDResult = ((JAXBElement<ReturnResultsForProquestFilersByID> ) value);
    }

}
