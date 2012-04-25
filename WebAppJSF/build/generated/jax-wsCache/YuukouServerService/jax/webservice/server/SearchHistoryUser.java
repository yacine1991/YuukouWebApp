
package jax.webservice.server;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for searchHistoryUser complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="searchHistoryUser">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idUser" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="who" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="last" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "searchHistoryUser", propOrder = {
    "idUser",
    "who",
    "last"
})
public class SearchHistoryUser {

    protected String idUser;
    protected boolean who;
    protected boolean last;

    /**
     * Gets the value of the idUser property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdUser() {
        return idUser;
    }

    /**
     * Sets the value of the idUser property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdUser(String value) {
        this.idUser = value;
    }

    /**
     * Gets the value of the who property.
     * 
     */
    public boolean isWho() {
        return who;
    }

    /**
     * Sets the value of the who property.
     * 
     */
    public void setWho(boolean value) {
        this.who = value;
    }

    /**
     * Gets the value of the last property.
     * 
     */
    public boolean isLast() {
        return last;
    }

    /**
     * Sets the value of the last property.
     * 
     */
    public void setLast(boolean value) {
        this.last = value;
    }

}
