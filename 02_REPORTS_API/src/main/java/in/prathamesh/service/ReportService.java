package in.prathamesh.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import in.prathamesh.request.SearchRequest;
import in.prathamesh.response.SearchResponse;

public interface ReportService {

	public List<String> getUniquePlanNames();

	public List<String> getUniquePlanStatuses();

	public List<SearchResponse> search(SearchRequest request);

	public void generateExcel(HttpServletResponse response) throws Exception;
   //public HttpServletResponse generateExcel();

	public void generatePdf(HttpServletResponse response) throws Exception;

}
