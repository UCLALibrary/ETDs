
package edu.ucla.grad.commservices.gd;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.datatype.Duration;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the edu.ucla.grad.commservices.gd package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _VwProQuestFilerDegree_QNAME = new QName("http://schemas.datacontract.org/2004/07/GD.CommServices.Model", "Degree");
    private final static QName _VwProQuestFilerProQuestID_QNAME = new QName("http://schemas.datacontract.org/2004/07/GD.CommServices.Model", "ProQuestID");
    private final static QName _VwProQuestFilerMajorCode_QNAME = new QName("http://schemas.datacontract.org/2004/07/GD.CommServices.Model", "MajorCode");
    private final static QName _VwProQuestFilerFileDate_QNAME = new QName("http://schemas.datacontract.org/2004/07/GD.CommServices.Model", "FileDate");
    private final static QName _VwProQuestFilerThesisDiss_QNAME = new QName("http://schemas.datacontract.org/2004/07/GD.CommServices.Model", "ThesisDiss");
    private final static QName _VwProQuestFilerUID_QNAME = new QName("http://schemas.datacontract.org/2004/07/GD.CommServices.Model", "UID");
    private final static QName _VwProQuestFilerStudentName_QNAME = new QName("http://schemas.datacontract.org/2004/07/GD.CommServices.Model", "Student_Name");
    private final static QName _GetProquestFilerForProquestIDResponseGetProquestFilerForProquestIDResult_QNAME = new QName("http://tempuri.org/", "GetProquestFilerForProquestIDResult");
    private final static QName _AnyURI_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "anyURI");
    private final static QName _DateTime_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "dateTime");
    private final static QName _Char_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "char");
    private final static QName _QName_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "QName");
    private final static QName _UnsignedShort_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "unsignedShort");
    private final static QName _Float_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "float");
    private final static QName _Long_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "long");
    private final static QName _Short_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "short");
    private final static QName _Base64Binary_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "base64Binary");
    private final static QName _Byte_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "byte");
    private final static QName _ReturnResultsForProquestFilers_QNAME = new QName("http://schemas.datacontract.org/2004/07/GD.CommServices", "ReturnResultsForProquestFilers");
    private final static QName _Boolean_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "boolean");
    private final static QName _VwProQuestFiler_QNAME = new QName("http://schemas.datacontract.org/2004/07/GD.CommServices.Model", "vwProQuestFiler");
    private final static QName _UnsignedByte_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "unsignedByte");
    private final static QName _AnyType_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "anyType");
    private final static QName _UnsignedInt_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "unsignedInt");
    private final static QName _Int_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "int");
    private final static QName _Decimal_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "decimal");
    private final static QName _Double_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "double");
    private final static QName _Guid_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "guid");
    private final static QName _ReturnResultsForProquestFilersByID_QNAME = new QName("http://schemas.datacontract.org/2004/07/GD.CommServices", "ReturnResultsForProquestFilersByID");
    private final static QName _Duration_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "duration");
    private final static QName _String_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "string");
    private final static QName _UnsignedLong_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "unsignedLong");
    private final static QName _ArrayOfvwProQuestFiler_QNAME = new QName("http://schemas.datacontract.org/2004/07/GD.CommServices.Model", "ArrayOfvwProQuestFiler");
    private final static QName _GetProquestFilerForProquestIDProquestID_QNAME = new QName("http://tempuri.org/", "proquestID");
    private final static QName _GetProquestFilerForProquestIDGdToken_QNAME = new QName("http://tempuri.org/", "gdToken");
    private final static QName _ReturnResultsForProquestFilersByIDProquestFiler_QNAME = new QName("http://schemas.datacontract.org/2004/07/GD.CommServices", "ProquestFiler");
    private final static QName _ReturnResultsForProquestFilersByIDMessage_QNAME = new QName("http://schemas.datacontract.org/2004/07/GD.CommServices", "Message");
    private final static QName _GetProquestFilersForAllResponseGetProquestFilersForAllResult_QNAME = new QName("http://tempuri.org/", "GetProquestFilersForAllResult");
    private final static QName _ReturnResultsForProquestFilersProquestFilers_QNAME = new QName("http://schemas.datacontract.org/2004/07/GD.CommServices", "ProquestFilers");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: edu.ucla.grad.commservices.gd
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetProquestFilersForAllResponse }
     * 
     */
    public GetProquestFilersForAllResponse createGetProquestFilersForAllResponse() {
        return new GetProquestFilersForAllResponse();
    }

    /**
     * Create an instance of {@link ReturnResultsForProquestFilers }
     * 
     */
    public ReturnResultsForProquestFilers createReturnResultsForProquestFilers() {
        return new ReturnResultsForProquestFilers();
    }

    /**
     * Create an instance of {@link GetProquestFilersForAll }
     * 
     */
    public GetProquestFilersForAll createGetProquestFilersForAll() {
        return new GetProquestFilersForAll();
    }

    /**
     * Create an instance of {@link GetProquestFilerForProquestID }
     * 
     */
    public GetProquestFilerForProquestID createGetProquestFilerForProquestID() {
        return new GetProquestFilerForProquestID();
    }

    /**
     * Create an instance of {@link GetProquestFilerForProquestIDResponse }
     * 
     */
    public GetProquestFilerForProquestIDResponse createGetProquestFilerForProquestIDResponse() {
        return new GetProquestFilerForProquestIDResponse();
    }

    /**
     * Create an instance of {@link ReturnResultsForProquestFilersByID }
     * 
     */
    public ReturnResultsForProquestFilersByID createReturnResultsForProquestFilersByID() {
        return new ReturnResultsForProquestFilersByID();
    }

    /**
     * Create an instance of {@link ArrayOfvwProQuestFiler }
     * 
     */
    public ArrayOfvwProQuestFiler createArrayOfvwProQuestFiler() {
        return new ArrayOfvwProQuestFiler();
    }

    /**
     * Create an instance of {@link VwProQuestFiler }
     * 
     */
    public VwProQuestFiler createVwProQuestFiler() {
        return new VwProQuestFiler();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/GD.CommServices.Model", name = "Degree", scope = VwProQuestFiler.class)
    public JAXBElement<String> createVwProQuestFilerDegree(String value) {
        return new JAXBElement<String>(_VwProQuestFilerDegree_QNAME, String.class, VwProQuestFiler.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/GD.CommServices.Model", name = "ProQuestID", scope = VwProQuestFiler.class)
    public JAXBElement<String> createVwProQuestFilerProQuestID(String value) {
        return new JAXBElement<String>(_VwProQuestFilerProQuestID_QNAME, String.class, VwProQuestFiler.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/GD.CommServices.Model", name = "MajorCode", scope = VwProQuestFiler.class)
    public JAXBElement<String> createVwProQuestFilerMajorCode(String value) {
        return new JAXBElement<String>(_VwProQuestFilerMajorCode_QNAME, String.class, VwProQuestFiler.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/GD.CommServices.Model", name = "FileDate", scope = VwProQuestFiler.class)
    public JAXBElement<XMLGregorianCalendar> createVwProQuestFilerFileDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_VwProQuestFilerFileDate_QNAME, XMLGregorianCalendar.class, VwProQuestFiler.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/GD.CommServices.Model", name = "ThesisDiss", scope = VwProQuestFiler.class)
    public JAXBElement<String> createVwProQuestFilerThesisDiss(String value) {
        return new JAXBElement<String>(_VwProQuestFilerThesisDiss_QNAME, String.class, VwProQuestFiler.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/GD.CommServices.Model", name = "UID", scope = VwProQuestFiler.class)
    public JAXBElement<String> createVwProQuestFilerUID(String value) {
        return new JAXBElement<String>(_VwProQuestFilerUID_QNAME, String.class, VwProQuestFiler.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/GD.CommServices.Model", name = "Student_Name", scope = VwProQuestFiler.class)
    public JAXBElement<String> createVwProQuestFilerStudentName(String value) {
        return new JAXBElement<String>(_VwProQuestFilerStudentName_QNAME, String.class, VwProQuestFiler.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReturnResultsForProquestFilersByID }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetProquestFilerForProquestIDResult", scope = GetProquestFilerForProquestIDResponse.class)
    public JAXBElement<ReturnResultsForProquestFilersByID> createGetProquestFilerForProquestIDResponseGetProquestFilerForProquestIDResult(ReturnResultsForProquestFilersByID value) {
        return new JAXBElement<ReturnResultsForProquestFilersByID>(_GetProquestFilerForProquestIDResponseGetProquestFilerForProquestIDResult_QNAME, ReturnResultsForProquestFilersByID.class, GetProquestFilerForProquestIDResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "anyURI")
    public JAXBElement<String> createAnyURI(String value) {
        return new JAXBElement<String>(_AnyURI_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "dateTime")
    public JAXBElement<XMLGregorianCalendar> createDateTime(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_DateTime_QNAME, XMLGregorianCalendar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "char")
    public JAXBElement<Integer> createChar(Integer value) {
        return new JAXBElement<Integer>(_Char_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QName }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "QName")
    public JAXBElement<QName> createQName(QName value) {
        return new JAXBElement<QName>(_QName_QNAME, QName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "unsignedShort")
    public JAXBElement<Integer> createUnsignedShort(Integer value) {
        return new JAXBElement<Integer>(_UnsignedShort_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Float }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "float")
    public JAXBElement<Float> createFloat(Float value) {
        return new JAXBElement<Float>(_Float_QNAME, Float.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "long")
    public JAXBElement<Long> createLong(Long value) {
        return new JAXBElement<Long>(_Long_QNAME, Long.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Short }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "short")
    public JAXBElement<Short> createShort(Short value) {
        return new JAXBElement<Short>(_Short_QNAME, Short.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "base64Binary")
    public JAXBElement<byte[]> createBase64Binary(byte[] value) {
        return new JAXBElement<byte[]>(_Base64Binary_QNAME, byte[].class, null, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Byte }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "byte")
    public JAXBElement<Byte> createByte(Byte value) {
        return new JAXBElement<Byte>(_Byte_QNAME, Byte.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReturnResultsForProquestFilers }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/GD.CommServices", name = "ReturnResultsForProquestFilers")
    public JAXBElement<ReturnResultsForProquestFilers> createReturnResultsForProquestFilers(ReturnResultsForProquestFilers value) {
        return new JAXBElement<ReturnResultsForProquestFilers>(_ReturnResultsForProquestFilers_QNAME, ReturnResultsForProquestFilers.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "boolean")
    public JAXBElement<Boolean> createBoolean(Boolean value) {
        return new JAXBElement<Boolean>(_Boolean_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VwProQuestFiler }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/GD.CommServices.Model", name = "vwProQuestFiler")
    public JAXBElement<VwProQuestFiler> createVwProQuestFiler(VwProQuestFiler value) {
        return new JAXBElement<VwProQuestFiler>(_VwProQuestFiler_QNAME, VwProQuestFiler.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Short }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "unsignedByte")
    public JAXBElement<Short> createUnsignedByte(Short value) {
        return new JAXBElement<Short>(_UnsignedByte_QNAME, Short.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "anyType")
    public JAXBElement<Object> createAnyType(Object value) {
        return new JAXBElement<Object>(_AnyType_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "unsignedInt")
    public JAXBElement<Long> createUnsignedInt(Long value) {
        return new JAXBElement<Long>(_UnsignedInt_QNAME, Long.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "int")
    public JAXBElement<Integer> createInt(Integer value) {
        return new JAXBElement<Integer>(_Int_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "decimal")
    public JAXBElement<BigDecimal> createDecimal(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_Decimal_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Double }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "double")
    public JAXBElement<Double> createDouble(Double value) {
        return new JAXBElement<Double>(_Double_QNAME, Double.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "guid")
    public JAXBElement<String> createGuid(String value) {
        return new JAXBElement<String>(_Guid_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReturnResultsForProquestFilersByID }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/GD.CommServices", name = "ReturnResultsForProquestFilersByID")
    public JAXBElement<ReturnResultsForProquestFilersByID> createReturnResultsForProquestFilersByID(ReturnResultsForProquestFilersByID value) {
        return new JAXBElement<ReturnResultsForProquestFilersByID>(_ReturnResultsForProquestFilersByID_QNAME, ReturnResultsForProquestFilersByID.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Duration }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "duration")
    public JAXBElement<Duration> createDuration(Duration value) {
        return new JAXBElement<Duration>(_Duration_QNAME, Duration.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "string")
    public JAXBElement<String> createString(String value) {
        return new JAXBElement<String>(_String_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "unsignedLong")
    public JAXBElement<BigInteger> createUnsignedLong(BigInteger value) {
        return new JAXBElement<BigInteger>(_UnsignedLong_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfvwProQuestFiler }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/GD.CommServices.Model", name = "ArrayOfvwProQuestFiler")
    public JAXBElement<ArrayOfvwProQuestFiler> createArrayOfvwProQuestFiler(ArrayOfvwProQuestFiler value) {
        return new JAXBElement<ArrayOfvwProQuestFiler>(_ArrayOfvwProQuestFiler_QNAME, ArrayOfvwProQuestFiler.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "proquestID", scope = GetProquestFilerForProquestID.class)
    public JAXBElement<String> createGetProquestFilerForProquestIDProquestID(String value) {
        return new JAXBElement<String>(_GetProquestFilerForProquestIDProquestID_QNAME, String.class, GetProquestFilerForProquestID.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "gdToken", scope = GetProquestFilerForProquestID.class)
    public JAXBElement<String> createGetProquestFilerForProquestIDGdToken(String value) {
        return new JAXBElement<String>(_GetProquestFilerForProquestIDGdToken_QNAME, String.class, GetProquestFilerForProquestID.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VwProQuestFiler }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/GD.CommServices", name = "ProquestFiler", scope = ReturnResultsForProquestFilersByID.class)
    public JAXBElement<VwProQuestFiler> createReturnResultsForProquestFilersByIDProquestFiler(VwProQuestFiler value) {
        return new JAXBElement<VwProQuestFiler>(_ReturnResultsForProquestFilersByIDProquestFiler_QNAME, VwProQuestFiler.class, ReturnResultsForProquestFilersByID.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/GD.CommServices", name = "Message", scope = ReturnResultsForProquestFilersByID.class)
    public JAXBElement<String> createReturnResultsForProquestFilersByIDMessage(String value) {
        return new JAXBElement<String>(_ReturnResultsForProquestFilersByIDMessage_QNAME, String.class, ReturnResultsForProquestFilersByID.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReturnResultsForProquestFilers }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetProquestFilersForAllResult", scope = GetProquestFilersForAllResponse.class)
    public JAXBElement<ReturnResultsForProquestFilers> createGetProquestFilersForAllResponseGetProquestFilersForAllResult(ReturnResultsForProquestFilers value) {
        return new JAXBElement<ReturnResultsForProquestFilers>(_GetProquestFilersForAllResponseGetProquestFilersForAllResult_QNAME, ReturnResultsForProquestFilers.class, GetProquestFilersForAllResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/GD.CommServices", name = "Message", scope = ReturnResultsForProquestFilers.class)
    public JAXBElement<String> createReturnResultsForProquestFilersMessage(String value) {
        return new JAXBElement<String>(_ReturnResultsForProquestFilersByIDMessage_QNAME, String.class, ReturnResultsForProquestFilers.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfvwProQuestFiler }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/GD.CommServices", name = "ProquestFilers", scope = ReturnResultsForProquestFilers.class)
    public JAXBElement<ArrayOfvwProQuestFiler> createReturnResultsForProquestFilersProquestFilers(ArrayOfvwProQuestFiler value) {
        return new JAXBElement<ArrayOfvwProQuestFiler>(_ReturnResultsForProquestFilersProquestFilers_QNAME, ArrayOfvwProQuestFiler.class, ReturnResultsForProquestFilers.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "gdToken", scope = GetProquestFilersForAll.class)
    public JAXBElement<String> createGetProquestFilersForAllGdToken(String value) {
        return new JAXBElement<String>(_GetProquestFilerForProquestIDGdToken_QNAME, String.class, GetProquestFilersForAll.class, value);
    }

}
