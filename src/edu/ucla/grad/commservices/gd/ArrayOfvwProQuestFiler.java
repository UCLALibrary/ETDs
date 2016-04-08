
package edu.ucla.grad.commservices.gd;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfvwProQuestFiler complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfvwProQuestFiler">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="vwProQuestFiler" type="{http://schemas.datacontract.org/2004/07/GD.CommServices.Model}vwProQuestFiler" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfvwProQuestFiler", namespace = "http://schemas.datacontract.org/2004/07/GD.CommServices.Model", propOrder = {
    "vwProQuestFiler"
})
public class ArrayOfvwProQuestFiler {

    @XmlElement(nillable = true)
    protected List<VwProQuestFiler> vwProQuestFiler;

    /**
     * Gets the value of the vwProQuestFiler property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the vwProQuestFiler property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVwProQuestFiler().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VwProQuestFiler }
     * 
     * 
     */
    public List<VwProQuestFiler> getVwProQuestFiler() {
        if (vwProQuestFiler == null) {
            vwProQuestFiler = new ArrayList<VwProQuestFiler>();
        }
        return this.vwProQuestFiler;
    }

}
