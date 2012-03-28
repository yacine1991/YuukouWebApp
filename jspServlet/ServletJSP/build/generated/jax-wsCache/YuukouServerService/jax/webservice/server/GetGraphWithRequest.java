
package jax.webservice.server;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getGraphWithRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getGraphWithRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="rqt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="rqtLqbel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="label" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="startTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="endTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="factor" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getGraphWithRequest", propOrder = {
    "rqt",
    "rqtLqbel",
    "label",
    "startTime",
    "endTime",
    "factor"
})
public class GetGraphWithRequest {

    protected String rqt;
    protected String rqtLqbel;
    protected String label;
    protected String startTime;
    protected String endTime;
    protected int factor;

    /**
     * Gets the value of the rqt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRqt() {
        return rqt;
    }

    /**
     * Sets the value of the rqt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRqt(String value) {
        this.rqt = value;
    }

    /**
     * Gets the value of the rqtLqbel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRqtLqbel() {
        return rqtLqbel;
    }

    /**
     * Sets the value of the rqtLqbel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRqtLqbel(String value) {
        this.rqtLqbel = value;
    }

    /**
     * Gets the value of the label property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLabel() {
        return label;
    }

    /**
     * Sets the value of the label property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLabel(String value) {
        this.label = value;
    }

    /**
     * Gets the value of the startTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStartTime() {
        return startTime;
    }

    /**
     * Sets the value of the startTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStartTime(String value) {
        this.startTime = value;
    }

    /**
     * Gets the value of the endTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEndTime() {
        return endTime;
    }

    /**
     * Sets the value of the endTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEndTime(String value) {
        this.endTime = value;
    }

    /**
     * Gets the value of the factor property.
     * 
     */
    public int getFactor() {
        return factor;
    }

    /**
     * Sets the value of the factor property.
     * 
     */
    public void setFactor(int value) {
        this.factor = value;
    }

}
