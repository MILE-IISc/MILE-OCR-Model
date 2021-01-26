package org.iisc.mile.ocr;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.iisc.mile.ocr.model.OcrPage;

public class OcrXmlHandler {
	private static Logger logger = Logger.getLogger(OcrXmlHandler.class.toString());

	private Marshaller marshaller;
	private Unmarshaller unmarshaller = null;

	private static OcrXmlHandler uniqueInstance = null;

	private OcrXmlHandler() {
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance("org.iisc.mile.ocr.model");
			marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		} catch (JAXBException e) {
			logger.log(Level.SEVERE, "", e);
		}
	}

	public static synchronized OcrXmlHandler getInstance() {
		// http://www.ibm.com/developerworks/java/library/j-dcl/index.html
		if (uniqueInstance == null) {
			uniqueInstance = new OcrXmlHandler();
		}
		return uniqueInstance;
	}

	public OcrPage loadOcrOutput(String xmlFilePath) {
		try {
			if (unmarshaller == null) {
				JAXBContext jc = JAXBContext.newInstance("org.iisc.mile.ocr.model");
				unmarshaller = jc.createUnmarshaller();
			}
			if (!new File(xmlFilePath).exists()) {
				return null;
			}
			Object object = unmarshaller.unmarshal(new File(xmlFilePath));
			OcrPage ocrPage = ((JAXBElement<OcrPage>) object).getValue();
			return ocrPage;
		} catch (JAXBException e) {
			logger.log(Level.SEVERE, "", e);
		}
		return null;
	}

	public void saveOcrOutput(OcrPage ocrPage, String xmlFilePath) {
		new File(xmlFilePath).getParentFile().mkdirs();
		try {
			org.iisc.mile.ocr.model.ObjectFactory objectFactory = new org.iisc.mile.ocr.model.ObjectFactory();
			marshaller.marshal(objectFactory.createPage(ocrPage), new File(xmlFilePath));
		} catch (JAXBException e) {
			logger.log(Level.SEVERE, "", e);
		}
	}

}
