<%@page import="com.model.AssetOrder"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="java.util.ArrayList" %>

    
<%@page import="com.itextpdf.text.pdf.PdfWriter"%>
<%@page import="com.itextpdf.text.Image"%>
<%@page import="com.itextpdf.text.Font"%>
<%@page import="com.itextpdf.text.Element"%>
<%@page import="com.itextpdf.text.*"%>
<%@page import="com.itextpdf.text.Paragraph"%>
<%@page import="com.itextpdf.text.Document"%>
<%@page import="com.itextpdf.text.pdf.PdfPTable"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Date" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Supplier Orders Placed </title>
</head>
<body>

	<% 
	  AssetOrder order=new AssetOrder();
	  order = (AssetOrder)request.getAttribute("order");
	  ArrayList<AssetOrder> summary=new ArrayList<>();
      summary= order.getAssetorderarray();
	  
	  response.setContentType("application/pdf");
	  Rectangle pageSize = new Rectangle(700,1000);
	  Document document = new Document(pageSize);
	  PdfWriter writer=PdfWriter.getInstance(document, response.getOutputStream());
	  document.open();
	  
	
      Font subtopic = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
      Font subtopic1 = new Font(Font.FontFamily.HELVETICA, 22, Font.BOLDITALIC);
      Phrase subtitle = new Phrase("Cafe 4 U",subtopic1);
      Phrase subtitle1 = new Phrase(order.getSupplierID() + " Supplier Orders Placed",subtopic);
     
    
      Paragraph p = new Paragraph();
      Paragraph p1 = new Paragraph();
      
      p.add(subtitle);
      p1.add(subtitle1);
      
      p.setAlignment(Element.ALIGN_CENTER);
      document.add(p);
      document.add( Chunk.NEWLINE );
      
      p1.setAlignment(Element.ALIGN_CENTER);
      document.add(p1);
      document.add( Chunk.NEWLINE );
      
      document.add( Chunk.NEWLINE ); 
      document.add(new Paragraph("                  "+"Date&Time : "+new Date().toString()));
      document.add( Chunk.NEWLINE );
      document.add( Chunk.NEWLINE ); 

      
      Font boldFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
      
      float [] pointColumnWidths = {1f, 1f, 1f, 1f, 1f, 1f};  
      
      
      Phrase h1 = new Phrase("Supplier Order ID", boldFont );
      Phrase h2 = new Phrase("Supplier ID", boldFont);
      Phrase h3 = new Phrase("Asset ID", boldFont );
      Phrase h4 = new Phrase("Ordered Quantity", boldFont );
      Phrase h5 = new Phrase("Total Order Cost", boldFont );
      Phrase h6 = new Phrase("Date Ordered", boldFont );

      PdfPTable table = new PdfPTable(pointColumnWidths);
      table.addCell(h1);
      table.addCell(h2);
      table.addCell(h3);
      table.addCell(h4);
      table.addCell(h5);
      table.addCell(h6);

      
      
	  
		for(AssetOrder ord:summary){ 
			
				table.addCell(String.valueOf(ord.getSupp_orderID()));
				table.addCell(String.valueOf(ord.getSupplierID()));
                table.addCell(String.valueOf(ord.getAssetID()));
                table.addCell(String.valueOf(ord.getOrderAssetQty()));
                table.addCell(String.valueOf(ord.getTotalAssetPrice()));
                table.addCell(String.valueOf(ord.getDateOrdered()));
		
		}
		
		document.add(table);

		document.add( Chunk.NEWLINE );
		document.add( Chunk.NEWLINE );
		document.add( Chunk.NEWLINE );
		
		document.add( Chunk.NEWLINE );
		PdfPTable table2 = new PdfPTable(pointColumnWidths);
		table2.getDefaultCell().setBorder(0);
		table2.addCell(" ");
		table2.addCell(" ");
		table2.addCell(" ");
		table2.addCell(" ");
		table2.addCell(" ");
		table2.addCell("-------------------");
		
		
		table2.addCell(" ");
		table2.addCell(" ");
		table2.addCell(" ");
		table2.addCell(" ");
		table2.addCell(" ");
		table2.addCell("Inventory and Asset Manager.");

		document.add(table2);
		document.close();
		
		
	%>

</body>
</html>