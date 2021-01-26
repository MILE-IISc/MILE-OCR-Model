package org.iisc.mile.ocr;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.iisc.mile.ocr.model.mets_alto.Alto;

public class AltoXmlHandler {
	private static Logger logger = Logger.getLogger(AltoXmlHandler.class.toString());

	private Marshaller marshaller;
	private Unmarshaller unmarshaller = null;

	private static AltoXmlHandler uniqueInstance = null;

	private AltoXmlHandler() {
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance("org.iisc.mile.ocr.model.mets_alto");
			marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		} catch (JAXBException e) {
			logger.log(Level.SEVERE, "", e);
		}
	}

	public static synchronized AltoXmlHandler getInstance() {
		// http://www.ibm.com/developerworks/java/library/j-dcl/index.html
		if (uniqueInstance == null) {
			uniqueInstance = new AltoXmlHandler();
		}
		return uniqueInstance;
	}

	public Alto loadOcrOutput(String xmlFilePath) {
		try {
			if (unmarshaller == null) {
				JAXBContext jc = JAXBContext.newInstance("org.iisc.mile.ocr.model.mets_alto");
				unmarshaller = jc.createUnmarshaller();
			}
			if (!new File(xmlFilePath).exists()) {
				return null;
			}
			Alto alto = (Alto) unmarshaller.unmarshal(new File(xmlFilePath));
			return alto;
		} catch (JAXBException e) {
			logger.log(Level.SEVERE, "", e);
		}
		return null;
	}

	public void saveOcrOutput(Alto alto, String xmlFilePath) {
		new File(xmlFilePath).getParentFile().mkdirs();
		try {
			marshaller.marshal(alto, new File(xmlFilePath));
		} catch (JAXBException e) {
			logger.log(Level.SEVERE, "", e);
		}
	}

}
