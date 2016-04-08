
package edu.ucla.grad.commservices.gd;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for vwProQuestFiler complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="vwProQuestFiler">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Degree" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FileDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="MajorCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ProQuestID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Student_Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ThesisDiss" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "vwProQuestFiler", namespace = "http://schemas.datacontract.org/2004/07/GD.CommServices.Model", propOrder = {
    "degree",
    "fileDate",
    "majorCode",
    "proQuestID",
    "studentName",
    "thesisDiss",
    "uid"
})
public class VwProQuestFiler {

    @XmlElementRef(name = "Degree", namespace = "http://schemas.datacontract.org/2004/07/GD.CommServices.Model", type = JAXBElement.class)
    protected JAXBElement<String> degree;
    @XmlElementRef(name = "FileDate", namespace = "http://schemas.datacontract.org/2004/07/GD.CommServices.Model", type = JAXBElement.class)
    protected JAXBElement<XMLGregorianCalendar> fileDate;
    @XmlElementRef(name = "MajorCode", namespace = "http://schemas.datacontract.org/2004/07/GD.CommServices.Model", type = JAXBElement.class)
    protected JAXBElement<String> majorCode;
    @XmlElementRef(name = "ProQuestID", namespace = "http://schemas.datacontract.org/2004/07/GD.CommServices.Model", type = JAXBElement.class)
    protected JAXBElement<String> proQuestID;
    @XmlElementRef(name = "Student_Name", namespace = "http://schemas.datacontract.org/2004/07/GD.CommServices.Model", type = JAXBElement.class)
    protected JAXBElement<String> studentName;
    @XmlElementRef(name = "ThesisDiss", namespace = "http://schemas.datacontract.org/2004/07/GD.CommServices.Model", type = JAXBElement.class)
    protected JAXBElement<String> thesisDiss;
    @XmlElementRef(name = "UID", namespace = "http://schemas.datacontract.org/2004/07/GD.CommServices.Model", type = JAXBElement.class)
    protected JAXBElement<String> uid;

    /**
     * Gets the value of the degree property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDegree() {
        return degree;
    }

    /**
     * Sets the value of the degree property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDegree(JAXBElement<String> value) {
        this.degree = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the fileDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getFileDate() {
        return fileDate;
    }

    /**
     * Sets the value of the fileDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setFileDate(JAXBElement<XMLGregorianCalendar> value) {
        this.fileDate = ((JAXBElement<XMLGregorianCalendar> ) value);
    }

    /**
     * Gets the value of the majorCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getMajorCode() {
        return majorCode;
    }

    /**
     * Sets the value of the majorCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setMajorCode(JAXBElement<String> value) {
        this.majorCode = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the proQuestID property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getProQuestID() {
        return proQuestID;
    }

    /**
     * Sets the value of the proQuestID property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setProQuestID(JAXBElement<String> value) {
        this.proQuestID = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the studentName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getStudentName() {
        return studentName;
    }

    /**
     * Sets the value of the studentName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setStudentName(JAXBElement<String> value) {
        this.studentName = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the thesisDiss property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getThesisDiss() {
        return thesisDiss;
    }

    /**
     * Sets the value of the thesisDiss property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setThesisDiss(JAXBElement<String> value) {
        this.thesisDiss = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the uid property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getUID() {
        return uid;
    }

    /**
     * Sets the value of the uid property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setUID(JAXBElement<String> value) {
        this.uid = ((JAXBElement<String> ) value);
    }

}
