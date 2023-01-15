package in.prathamesh.rest;

import java.net.http.HttpResponse;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.prathamesh.request.SearchRequest;
import in.prathamesh.response.SearchResponse;
import in.prathamesh.service.ReportServiceImpl;

@RestController
public class ReportRestController {

	@Autowired
	private ReportServiceImpl service;

	@GetMapping("/plans")
	public ResponseEntity<List<String>> getPlanNames() {
		List<String> planNames = service.getUniquePlanNames();
		return new ResponseEntity<>(planNames, HttpStatus.OK);
	}

	@GetMapping("/statuses")
	public ResponseEntity<List<String>> getPlanStatuses() {
		List<String> planStatuses = service.getUniquePlanStatuses();
		return new ResponseEntity<>(planStatuses, HttpStatus.OK);
	}

	@PostMapping("/search")
	public ResponseEntity<List<SearchResponse>> search(@RequestBody SearchRequest request) {
		List<SearchResponse> response = service.search(request);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping("/excel")
	public void excelReport(HttpServletResponse response) throws Exception {
		response.setContentType("application/octet-stream");

		String headerKey = "Content-Disposition";
		String headerValue = "attachment;filename=data.xlsx";
		response.setHeader(headerKey, headerValue);
		service.generateExcel(response);
	}
	
	@GetMapping("/pdf")
	public void pdfReport(HttpServletResponse response) throws Exception {
		response.setContentType("application/pdf");

		String headerKey = "Content-Disposition";
		String headerValue = "attachment;filename=data.pdf";
//		  String currentDateTime = dateFormatter.format(new Date());
//	         
//	        String headerKey = "Content-Disposition";
//	        String headerValue = "attachment; filename=Data_" + currentDateTime + ".pdf";
		response.setHeader(headerKey, headerValue);
		service.generatePdf(response);
		
//		 UserPDFExporter exporter = new UserPDFExporter(listUsers);
	 //       exporter.export(response);
	}
	

}
