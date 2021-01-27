package org.iisc.mile.ocr;

import java.util.List;

import org.iisc.mile.ocr.model.OcrBlock;
import org.iisc.mile.ocr.model.OcrLine;
import org.iisc.mile.ocr.model.OcrPage;
import org.iisc.mile.ocr.model.OcrWord;
import org.iisc.mile.ocr.model.mets_alto.Alto;
import org.iisc.mile.ocr.model.mets_alto.PageSpaceType;
import org.iisc.mile.ocr.model.mets_alto.StringType;
import org.iisc.mile.ocr.model.mets_alto.TextBlockType;
import org.iisc.mile.ocr.model.mets_alto.TextBlockType.TextLine.SP;

public class MileXmlToAltoXmlConverter {

	public static Alto createAltoXML(OcrPage ocrPage) {
		int pageHeight = 0;
		int pageWidth = 0;

		Alto alto = new Alto();
		Alto.Layout layout = new Alto.Layout();

		Alto.Layout.Page page = new Alto.Layout.Page();
		String pageId = "P1";
		page.setID(pageId);
		// page.setPHYSICALIMGNR(pageNumberPrintedOnThePage);
		page.setHEIGHT(pageHeight);
		page.setWIDTH(pageWidth);
		// page.setACCURACY((float)0.0);

		PageSpaceType topMargin = new PageSpaceType();
		topMargin.setID(pageId + "_TM00001");
		topMargin.setHPOS((float) 0.0);
		topMargin.setVPOS((float) 0.0);
		topMargin.setWIDTH(pageWidth);
		topMargin.setHEIGHT((float) 0.0);
		page.setTopMargin(topMargin);

		PageSpaceType leftMargin = new PageSpaceType();
		leftMargin.setID(pageId + "_LM00001");
		leftMargin.setHPOS((float) 0.0);
		leftMargin.setVPOS((float) 0.0);
		leftMargin.setWIDTH((float) 0.0);
		leftMargin.setHEIGHT(pageHeight);
		page.setLeftMargin(leftMargin);

		PageSpaceType rightMargin = new PageSpaceType();
		rightMargin.setID(pageId + "_RM00001");
		rightMargin.setHPOS(pageWidth);
		rightMargin.setVPOS((float) 0.0);
		rightMargin.setWIDTH((float) 0.0);
		rightMargin.setHEIGHT(pageHeight);
		page.setRightMargin(rightMargin);

		PageSpaceType bottomMargin = new PageSpaceType();
		bottomMargin.setID(pageId + "_BM00001");
		bottomMargin.setHPOS((float) 0.0);
		bottomMargin.setVPOS(pageHeight);
		bottomMargin.setWIDTH(pageWidth);
		bottomMargin.setHEIGHT((float) 0.0);
		page.setBottomMargin(bottomMargin);

		PageSpaceType printSpace = new PageSpaceType();
		printSpace.setID(pageId + "_PS00001");
		printSpace.setHPOS((float) 0.0);
		printSpace.setVPOS((float) 0.0);
		printSpace.setWIDTH(pageWidth);
		printSpace.setHEIGHT(pageHeight);
		int wordStringCount = 1;
		int spaceCount = 1;

		ocrPage.sortBlocks();
		for (OcrBlock ocrBlock : ocrPage.getBlock()) {
			if (OcrBlock.BLOCK_TYPE_IMAGE.equalsIgnoreCase(ocrBlock.getType())) {
				continue;
			}
			TextBlockType textBlock = new TextBlockType();
			textBlock.setID(pageId + "_TB0000" + ocrBlock.getBlockNumber());
			textBlock.setHPOS(ocrBlock.getColStart());
			textBlock.setVPOS(ocrBlock.getRowStart());
			textBlock.setWIDTH(ocrBlock.getColEnd() - ocrBlock.getColStart() + 1);
			textBlock.setHEIGHT(ocrBlock.getRowEnd() - ocrBlock.getRowStart() + 1);
			// textBlock.getSTYLEREFS().add("TXT_" + block.blockNumber + " PAR_BLOCK");

			ocrBlock.sortLines();
			for (OcrLine ocrLine : ocrBlock.getLine()) {
				TextBlockType.TextLine textLine = new TextBlockType.TextLine();
				textLine.setID(pageId + "_TL" + String.format("%05d", ocrLine.getLineNumber()));
				textLine.setHPOS(ocrLine.getColStart());
				textLine.setVPOS(ocrLine.getRowStart());
				textLine.setWIDTH(ocrLine.getColEnd() - ocrLine.getColStart() + 1);
				textLine.setHEIGHT(ocrLine.getRowEnd() - ocrLine.getRowStart() + 1);

				ocrLine.sortWords();
				List<OcrWord> words = ocrLine.getWord();
				for (int w = 0; w < words.size(); w++) {
					OcrWord ocrWord = words.get(w);
					if (w > 0) {
						OcrWord prevOcrWord = words.get(w - 1);
						SP sp = new SP();
						sp.setID(pageId + "_SP" + String.format("%05d", spaceCount++));
						sp.setHPOS((float) prevOcrWord.getColEnd());
						sp.setVPOS((float) prevOcrWord.getRowEnd());
						sp.setWIDTH((float) (ocrWord.getColStart() - prevOcrWord.getColEnd() - 1));
						textLine.getStringAndSP().add(sp);
					}

					StringType wordString = new StringType();
					wordString.setID(pageId + "_ST" + String.format("%05d", wordStringCount++));
					wordString.setHPOS((float) ocrWord.getColStart());
					wordString.setVPOS((float) ocrWord.getRowStart());
					wordString.setWIDTH((float) (ocrWord.getColEnd() - ocrWord.getColStart() + 1));
					wordString.setHEIGHT((float) (ocrWord.getRowEnd() - ocrWord.getRowStart() + 1));
					wordString.setCONTENT(ocrWord.getUnicode());
					wordString.setWC((float) 1.0);
					textLine.getStringAndSP().add(wordString);
				}
				textBlock.getTextLine().add(textLine);
			}
			printSpace.getTextBlockOrIllustrationOrGraphicalElement().add(textBlock);
		}
		page.setPrintSpace(printSpace);

		layout.getPage().add(page);
		alto.setLayout(layout);
		return alto;
	}

}
