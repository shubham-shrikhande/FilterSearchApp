package com.nt.files;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.nt.reponse.ResponseDetails;

public class ExcelGenerator {

	public void generateExcelFile(List<ResponseDetails> response,HttpServletResponse res) throws IOException {
		HSSFWorkbook workbook=new HSSFWorkbook();
		HSSFSheet sheet=workbook.createSheet("Plans");
		HSSFRow headerRow= sheet.createRow(0);
		
		headerRow.createCell(0).setCellValue("S.No");
		headerRow.createCell(1).setCellValue("Holder Name");
		headerRow.createCell(2).setCellValue("Hoder SSN");
		headerRow.createCell(3).setCellValue("Plan Name");
		headerRow.createCell(4).setCellValue("Plan Status");
		headerRow.createCell(5).setCellValue("Start Date");
		headerRow.createCell(6).setCellValue("End Date");
		headerRow.createCell(7).setCellValue("Benefit Amount");
		headerRow.createCell(8).setCellValue("Denial Reason");
		
		for(int i=0; i<response.size(); i++) {
			HSSFRow dataRow =sheet.createRow(i+1);
			ResponseDetails record=response.get(i);
			dataRow.createCell(0).setCellValue(record.getHolderName());
			dataRow.createCell(1).setCellValue(record.getHolderSsn());
			dataRow.createCell(2).setCellValue(record.getPlanName());
			dataRow.createCell(3).setCellValue(record.getPlanStatus());
			dataRow.createCell(4).setCellValue(String.valueOf(record.getStartDate()));
			dataRow.createCell(4).setCellValue(String.valueOf(record.getEndDate()));
			dataRow.createCell(4).setCellValue(String.valueOf(record.getBenefitAmt()));
			dataRow.createCell(4).setCellValue(String.valueOf(record.getDenialReason()));
		}
		workbook.write(res.getOutputStream());
		workbook.close();
	}
}
