package org.iisc.mile.ocr.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.junit.Test;

public class MarshallUnmarshallTest {

	@Test
	public void testMarshall() throws JAXBException {
		// <page skew="2.5" BookCode="0165" PageNumber="3">
		OcrPage ocrPage = new OcrPage();
		ocrPage.setSkew(2.5);
		OcrBlock ocrBlock = new OcrBlock();
		// <block rowStart="458" rowEnd="593" colStart="476" colEnd="926" type="text">
		ocrBlock.setRowStart(458);
		ocrBlock.setRowEnd(593);
		ocrBlock.setColStart(476);
		ocrBlock.setColEnd(926);
		ocrBlock.setType("text");
		ocrPage.getBlock().add(ocrBlock);
		// <line rowStart="460" rowEnd="587" >
		OcrLine ocrLine = new OcrLine();
		ocrLine.setRowStart(460);
		ocrLine.setRowEnd(587);
		ocrBlock.getLine().add(ocrLine);
		// <word colStart="485" colEnd="915" unicode="ಅಣ್ಣಪ್ಪದೈವ">
		OcrWord ocrWord = new OcrWord();
		ocrWord.setColStart(485);
		ocrWord.setColEnd(915);
		ocrWord.setUnicode("ಅಣ್ಣಪ್ಪದೈವ");
		ocrLine.getWord().add(ocrWord);
		// <symbol rowStart="479" rowEnd="540" colStart="485" colEnd="556" recognizedClass="a"/>
		OcrSymbol ocrSymbol = new OcrSymbol();
		ocrSymbol.setRowStart(479);
		ocrSymbol.setRowEnd(540);
		ocrSymbol.setColStart(485);
		ocrSymbol.setColEnd(556);
		ocrSymbol.setClassName("a");
		ocrWord.getSymbol().add(ocrSymbol);

		ocrSymbol = new OcrSymbol();
		// <symbol rowStart="481" rowEnd="540" colStart="564" colEnd="640" recognizedClass="Na"/>
		ocrSymbol = new OcrSymbol();
		ocrSymbol.setRowStart(481);
		ocrSymbol.setRowEnd(540);
		ocrSymbol.setColStart(564);
		ocrSymbol.setColEnd(640);
		ocrSymbol.setClassName("Na");
		ocrWord.getSymbol().add(ocrSymbol);
		// <symbol rowStart="542" rowEnd="580" colStart="618" colEnd="666" recognizedClass="NOttu"/>
		ocrSymbol = new OcrSymbol();
		ocrSymbol.setRowStart(542);
		ocrSymbol.setRowEnd(580);
		ocrSymbol.setColStart(618);
		ocrSymbol.setColEnd(666);
		ocrSymbol.setClassName("NOttu");
		ocrWord.getSymbol().add(ocrSymbol);

		// <symbol rowStart="463" rowEnd="540" colStart="651" colEnd="720" recognizedClass="pa"/>
		ocrSymbol = new OcrSymbol();
		ocrSymbol.setRowStart(463);
		ocrSymbol.setRowEnd(540);
		ocrSymbol.setColStart(651);
		ocrSymbol.setColEnd(720);
		ocrSymbol.setClassName("pa");
		ocrWord.getSymbol().add(ocrSymbol);
		// <symbol rowStart="541" rowEnd="570" colStart="695" colEnd="740" recognizedClass="pOttu"/>
		ocrSymbol = new OcrSymbol();
		ocrSymbol.setRowStart(541);
		ocrSymbol.setRowEnd(570);
		ocrSymbol.setColStart(695);
		ocrSymbol.setColEnd(740);
		ocrSymbol.setClassName("pOttu");
		ocrWord.getSymbol().add(ocrSymbol);

		// <symbol rowStart="460" rowEnd="541" colStart="728" colEnd="798" recognizedClass="_de"/>
		ocrSymbol = new OcrSymbol();
		ocrSymbol.setRowStart(460);
		ocrSymbol.setRowEnd(541);
		ocrSymbol.setColStart(728);
		ocrSymbol.setColEnd(798);
		ocrSymbol.setClassName("_de");
		ocrWord.getSymbol().add(ocrSymbol);
		// <symbol rowStart="526" rowEnd="587" colStart="796" colEnd="842" recognizedClass="vowel_sign_ai"/>
		ocrSymbol = new OcrSymbol();
		ocrSymbol.setRowStart(526);
		ocrSymbol.setRowEnd(587);
		ocrSymbol.setColStart(796);
		ocrSymbol.setColEnd(842);
		ocrSymbol.setClassName("vowel_sign_ai");
		ocrWord.getSymbol().add(ocrSymbol);

		// <symbol rowStart="463" colStart="542" rowEnd="843" colEnd="915" recognizedClass="va"/>
		ocrSymbol = new OcrSymbol();
		ocrSymbol.setRowStart(463);
		ocrSymbol.setRowEnd(542);
		ocrSymbol.setColStart(843);
		ocrSymbol.setColEnd(915);
		ocrSymbol.setClassName("va");
		ocrWord.getSymbol().add(ocrSymbol);

		JAXBContext jc = JAXBContext.newInstance("org.iisc.mile.ocr.model");
		Marshaller marshaller = jc.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		ObjectFactory objectFactory = new ObjectFactory();
		marshaller.marshal(objectFactory.createPage(ocrPage), new File("src/test/resources/test_output.xml"));
	}

	@Test
	public void testUnMarshall() throws JAXBException {
		JAXBContext jc = JAXBContext.newInstance("org.iisc.mile.ocr.model");
		Unmarshaller unmarshaller = jc.createUnmarshaller();
		Object object = unmarshaller.unmarshal(new File("src/test/resources/ocr_output.xml"));
		assertTrue(object != null);
		OcrPage ocrPage = ((JAXBElement<OcrPage>) object).getValue();
		assertTrue(ocrPage != null);
		assertTrue(new Double(2.5).compareTo(ocrPage.getSkew()) == 0);
		assertTrue(ocrPage.getBlock() != null);
		ArrayList<OcrBlock> ocrBlocks = (ArrayList<OcrBlock>) ocrPage.getBlock();
		assertEquals(4, ocrBlocks.size());
		for (int b = 0; b < ocrBlocks.size(); b++) {
			OcrBlock ocrBlock = ocrBlocks.get(b);
			assertTrue(ocrBlock != null);
		}
	}

}
