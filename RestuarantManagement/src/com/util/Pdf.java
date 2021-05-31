package com.util;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class Pdf {

	public static void main(String[] args) {
		String filename = "C:\\Users\\Raisul Zulfikar\\Desktop\\Resturant Management\\PDF\\chillyfacts.pdf";
		Document document = new Document();
		
		try {
			PdfWriter.getInstance(document, new FileOutputStream(new File(filename)));
			document.open();
			document.add(new Paragraph(new Date().toString()));
			Paragraph para = new Paragraph("Text1");
			
			para.setAlignment(Element.ALIGN_CENTER);
			
			document.add(para);
			
			Paragraph para2 = new Paragraph("Text2");
			
			para2.add(para);
			
			document.add(para2);
			
			Font font = new Font();
			font.setStyle(Font.BOLD);
			font.setSize(8);
			
			String q="Quantity";
	         String n="Name";
	         
	        Paragraph name=new Paragraph(n); 
	        Paragraph qty=new Paragraph(q); 
	        

	        //   PdfPTable table = new Table(1);
	     
	        
	        //name.add(qty.toString().re);
	        // name.add(p2); 
	        
	        document.add(name);
	        document.add(qty);
           
	        document.add(new Paragraph("This is my paragraph 3", font));
	        // document.add(Image.getInstance("D:\\java_pdf\\chillyfacts.png"));
	        document.close();
	        System.out.println("Done");
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
