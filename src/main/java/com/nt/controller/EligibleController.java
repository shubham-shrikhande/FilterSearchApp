package com.nt.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lowagie.text.DocumentException;
import com.nt.binding.FilterModel;
import com.nt.entity.EligibilityDetails;
import com.nt.files.ExcelGenerator;
import com.nt.files.PdfGenerator;
import com.nt.reponse.ResponseDetails;
import com.nt.service.EligibilityServiceImp;

@RestController
public class EligibleController {

	@Autowired
	private EligibilityServiceImp service;
	
	@GetMapping("/getName")
	public List<String> getAllPlanNames(){
		return service.getAllPlanName();
	}
	@GetMapping("/getStatus")
	public List<String> getAllPlanStatus(){
		return service.getAllPlanStatus();
	}
	
	@PostMapping("/add")
	public String registerDetails(@RequestBody EligibilityDetails details) {
		return service.registerEntry(details);
		
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<EligibilityDetails>> getAllDetails() {
		List<EligibilityDetails> list=service.getAllEntries();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@PostMapping("/filter")
	public ResponseEntity<List<ResponseDetails>> getFilteredDate(@RequestBody FilterModel model){
		List<ResponseDetails> list=service.getDataWithOrWithoutFilter(model);
		for(ResponseDetails d:list) {
			System.out.println(d);
		}
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
	@GetMapping("/excel")
	public void downloadExcel(HttpServletResponse response) throws IOException {
		response.setContentType("application/octet-stram");
		String headerKey="Content-Disposition";
		String headerValue="attachment; filename=Plans.xls";
		response.setHeader(headerKey, headerValue);
		
		List<ResponseDetails> details=service.getDataWithOrWithoutFilter(null);
		ExcelGenerator excel=new ExcelGenerator();
		excel.generateExcelFile(details, response);
	}
	
	@GetMapping("/pdf")
	public void downloadPdf(HttpServletResponse response) throws DocumentException, IOException {
		response.setContentType("application/pdf");
		String headerKey="Content-Disposition";
		String headerValue="attachment; filename=Plans.pdf";
		response.setHeader(headerKey, headerValue);
		
		List<ResponseDetails> details=service.getDataWithOrWithoutFilter(null);
		PdfGenerator pdf=new PdfGenerator();
		pdf.generatePdf(details, response);
	}
}
