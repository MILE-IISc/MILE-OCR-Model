//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.08.16 at 11:59:31 AM GMT+05:30 
//


package org.iisc.mile.ocr.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for rectangleType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="rectangleType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="rowStart" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *       &lt;attribute name="rowEnd" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *       &lt;attribute name="colStart" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *       &lt;attribute name="colEnd" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "rectangleType", namespace = "http://mile.ee.iisc.ernet.in/schemas/ocr_output")
@XmlSeeAlso({
    OcrLine.class,
    OcrWord.class,
    OcrBlock.class,
    OcrSymbol.class
})
public class OcrRectangle {

    @XmlAttribute
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "positiveInteger")
    protected Integer rowStart;
    @XmlAttribute
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "positiveInteger")
    protected Integer rowEnd;
    @XmlAttribute
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "positiveInteger")
    protected Integer colStart;
    @XmlAttribute
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "positiveInteger")
    protected Integer colEnd;

	public OcrRectangle() {
	}

	public OcrRectangle(int colStart, int rowStart, int colEnd, int rowEnd) {
		this.colStart = colStart;
		this.rowStart = rowStart;
		this.colEnd = colEnd;
		this.rowEnd = rowEnd;
	}

    /**
     * Gets the value of the rowStart property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getRowStart() {
        return rowStart;
    }

    /**
     * Sets the value of the rowStart property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRowStart(Integer value) {
        this.rowStart = value;
    }

    public boolean isSetRowStart() {
        return (this.rowStart!= null);
    }

    /**
     * Gets the value of the rowEnd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getRowEnd() {
        return rowEnd;
    }

    /**
     * Sets the value of the rowEnd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRowEnd(Integer value) {
        this.rowEnd = value;
    }

    public boolean isSetRowEnd() {
        return (this.rowEnd!= null);
    }

    /**
     * Gets the value of the colStart property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getColStart() {
        return colStart;
    }

    /**
     * Sets the value of the colStart property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setColStart(Integer value) {
        this.colStart = value;
    }

    public boolean isSetColStart() {
        return (this.colStart!= null);
    }

    /**
     * Gets the value of the colEnd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getColEnd() {
        return colEnd;
    }

    /**
     * Sets the value of the colEnd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setColEnd(Integer value) {
        this.colEnd = value;
    }

    public boolean isSetColEnd() {
        return (this.colEnd!= null);
    }
}
