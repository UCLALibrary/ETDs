
package edu.ucla.grad.commservices.gd;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ReturnResultsForProquestFilers complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ReturnResultsForProquestFilers">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Count" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="Message" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ProquestFilers" type="{http://schemas.datacontract.org/2004/07/GD.CommServices.Model}ArrayOfvwProQuestFiler" minOccurs="0"/>
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
@XmlType(name = "ReturnResultsForProquestFilers", namespace = "http://schemas.datacontract.org/2004/07/GD.CommServices", propOrder = {
    "count",
    "message",
    "proquestFilers",
    "result"
})
public class ReturnResultsForProquestFilers {

    @XmlElement(name = "Count")
    protected Integer count;
    @XmlElementRef(name = "Message", namespace = "http://schemas.datacontract.org/2004/07/GD.CommServices", type = JAXBElement.class)
    protected JAXBElement<String> message;
    @XmlElementRef(name = "ProquestFilers", namespace = "http://schemas.datacontract.org/2004/07/GD.CommServices", type = JAXBElement.class)
    protected JAXBElement<ArrayOfvwProQuestFiler> proquestFilers;
    @XmlElement(name = "Result")
    protected Integer result;

    /**
     * Gets the value of the count property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCount() {
        return count;
    }

    /**
     * Sets the value of the count property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCount(Integer value) {
        this.count = value;
    }

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
     * Gets the value of the proquestFilers property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfvwProQuestFiler }{@code >}
     *     
     */
    public JAXBElement<ArrayOfvwProQuestFiler> getProquestFilers() {
        return proquestFilers;
    }

    /**
     * Sets the value of the proquestFilers property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfvwProQuestFiler }{@code >}
     *     
     */
    public void setProquestFilers(JAXBElement<ArrayOfvwProQuestFiler> value) {
        this.proquestFilers = ((JAXBElement<ArrayOfvwProQuestFiler> ) value);
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
