import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class FetchingDataFromPDF {

	public static void main(String[] args) throws Throwable 
	{
	  File File = new File ("C:\\Users\\vishn\\OneDrive\\Desktop\\VishnuPriya main resume.pdf");
	  PDDocument doc = PDDocument.load(File);
	  //int pages = doc.getNumberOfPages();
	  //System.out.println(pages);//fetches the number of pages
	 PDFTextStripper pdfData = new PDFTextStripper();
	 // String readdata = pdfData.getText(doc);
	 // System.out.println(readdata);
	 
	 //if want to print multiple pages 
	// pdfData.setStartPage(2);
	// String pagedata = pdfData.getText(doc);
	 //System.out.println(pagedata);
	 
	// to print the one particular pages
	 pdfData.setStartPage(2);
	 pdfData.setEndPage(2);
	 String pagedat = pdfData.getText(doc);
	 System.out.println(pagedat);
	  
	}

}
