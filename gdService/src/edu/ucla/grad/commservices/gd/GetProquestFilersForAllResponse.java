
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
 *         &lt;element name="GetProquestFilersForAllResult" type="{http://schemas.datacontract.org/2004/07/GD.CommServices}ReturnResultsForProquestFilers" minOccurs="0"/>
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
    "getProquestFilersForAllResult"
})
@XmlRootElement(name = "GetProquestFilersForAllResponse")
public class GetProquestFilersForAllResponse {

    @XmlElementRef(name = "GetProquestFilersForAllResult", namespace = "http://tempuri.org/", type = JAXBElement.class)
    protected JAXBElement<ReturnResultsForProquestFilers> getProquestFilersForAllResult;

    /**
     * Gets the value of the getProquestFilersForAllResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ReturnResultsForProquestFilers }{@code >}
     *     
     */
    public JAXBElement<ReturnResultsForProquestFilers> getGetProquestFilersForAllResult() {
        return getProquestFilersForAllResult;
    }

    /**
     * Sets the value of the getProquestFilersForAllResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ReturnResultsForProquestFilers }{@code >}
     *     
     */
    public void setGetProquestFilersForAllResult(JAXBElement<ReturnResultsForProquestFilers> value) {
        this.getProquestFilersForAllResult = ((JAXBElement<ReturnResultsForProquestFilers> ) value);
    }

}
