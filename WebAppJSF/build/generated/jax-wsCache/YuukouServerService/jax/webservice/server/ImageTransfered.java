
package jax.webservice.server;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for imageTransfered complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="imageTransfered">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="contents" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *         &lt;element name="dates" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="hasData" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="typeContents" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="values" type="{http://www.w3.org/2001/XMLSchema}int" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "imageTransfered", propOrder = {
    "contents",
    "dates",
    "hasData",
    "typeContents",
    "values"
})
public class ImageTransfered {

    protected byte[] contents;
    @XmlElement(nillable = true)
    protected List<String> dates;
    protected boolean hasData;
    protected String typeContents;
    @XmlElement(nillable = true)
    protected List<Integer> values;

    /**
     * Gets the value of the contents property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getContents() {
        return contents;
    }

    /**
     * Sets the value of the contents property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setContents(byte[] value) {
        this.contents = value;
    }

    /**
     * Gets the value of the dates property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dates property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDates().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getDates() {
        if (dates == null) {
            dates = new ArrayList<String>();
        }
        return this.dates;
    }

    /**
     * Gets the value of the hasData property.
     * 
     */
    public boolean isHasData() {
        return hasData;
    }

    /**
     * Sets the value of the hasData property.
     * 
     */
    public void setHasData(boolean value) {
        this.hasData = value;
    }

    /**
     * Gets the value of the typeContents property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTypeContents() {
        return typeContents;
    }

    /**
     * Sets the value of the typeContents property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTypeContents(String value) {
        this.typeContents = value;
    }

    /**
     * Gets the value of the values property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the values property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getValues().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Integer }
     * 
     * 
     */
    public List<Integer> getValues() {
        if (values == null) {
            values = new ArrayList<Integer>();
        }
        return this.values;
    }

}
