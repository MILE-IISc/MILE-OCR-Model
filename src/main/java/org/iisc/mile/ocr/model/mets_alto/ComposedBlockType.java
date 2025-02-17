//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.01.12 at 06:25:05 PM GMT+05:30 
//


package org.iisc.mile.ocr.model.mets_alto;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;


/**
 * A block that consists of other blocks
 * 
 * <p>Java class for ComposedBlockType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ComposedBlockType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.loc.gov/standards/alto/ns-v2#}BlockType">
 *       &lt;sequence maxOccurs="unbounded" minOccurs="0">
 *         &lt;group ref="{http://www.loc.gov/standards/alto/ns-v2#}BlockGroup"/>
 *       &lt;/sequence>
 *       &lt;attribute name="TYPE" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="FILEID" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ComposedBlockType", namespace = "http://www.loc.gov/standards/alto/ns-v2#", propOrder = {
    "textBlockOrIllustrationOrGraphicalElement"
})
public class ComposedBlockType
    extends BlockType
{

    @XmlElements({
        @XmlElement(name = "Illustration", namespace = "http://www.loc.gov/standards/alto/ns-v2#", type = IllustrationType.class),
        @XmlElement(name = "ComposedBlock", namespace = "http://www.loc.gov/standards/alto/ns-v2#", type = ComposedBlockType.class),
        @XmlElement(name = "TextBlock", namespace = "http://www.loc.gov/standards/alto/ns-v2#", type = TextBlockType.class),
        @XmlElement(name = "GraphicalElement", namespace = "http://www.loc.gov/standards/alto/ns-v2#", type = GraphicalElementType.class)
    })
    protected List<BlockType> textBlockOrIllustrationOrGraphicalElement;
    @XmlAttribute(name = "TYPE")
    protected String type;
    @XmlAttribute(name = "FILEID")
    protected String fileid;

    /**
     * Gets the value of the textBlockOrIllustrationOrGraphicalElement property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the textBlockOrIllustrationOrGraphicalElement property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTextBlockOrIllustrationOrGraphicalElement().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IllustrationType }
     * {@link ComposedBlockType }
     * {@link TextBlockType }
     * {@link GraphicalElementType }
     * 
     * 
     */
    public List<BlockType> getTextBlockOrIllustrationOrGraphicalElement() {
        if (textBlockOrIllustrationOrGraphicalElement == null) {
            textBlockOrIllustrationOrGraphicalElement = new ArrayList<BlockType>();
        }
        return this.textBlockOrIllustrationOrGraphicalElement;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTYPE() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTYPE(String value) {
        this.type = value;
    }

    /**
     * Gets the value of the fileid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFILEID() {
        return fileid;
    }

    /**
     * Sets the value of the fileid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFILEID(String value) {
        this.fileid = value;
    }

}
