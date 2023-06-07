package com.nt.files;

import java.awt.Color;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.nt.reponse.ResponseDetails;

public class PdfGenerator {
	public void generatePdf(List<ResponseDetails> response, HttpServletResponse res)
			throws DocumentException, IOException {

		Document document = new Document();
		PdfWriter writer = PdfWriter.getInstance(document, res.getOutputStream());
		document.open();

		Font font = new Font(Font.HELVETICA, 16, Font.BOLDITALIC, Color.RED);
		Paragraph para = new Paragraph("Eligibility Details", font);
		document.add(para);
		PdfPTable table = new PdfPTable(9);
		table.addCell("S.No");
		table.addCell("Holder Name");
		table.addCell("Holder SSN");
		table.addCell("Plan Name");
		table.addCell("Plan Status");
		table.addCell("Start Date");
		table.addCell("End Date");
		table.addCell("Benefit Amount");
		table.addCell("Denial Reason");

		int sno = 0;
		for (ResponseDetails record : response) {
			table.addCell(String.valueOf(sno));
			table.addCell(record.getHolder_name());
			table.addCell(String.valueOf(record.getHolder_ssn()));
			table.addCell(record.getPlan_name());
			table.addCell(record.getPlan_status());
			table.addCell(String.valueOf(record.getStart_date()));
			table.addCell(String.valueOf(record.getEnd_date()));
			table.addCell(record.getBenefit_amt());
			table.addCell(String.valueOf(record.getDenial_reason()));
			sno++;
		}
		document.add(table);
		document.close();
		writer.close();

	}

}
