package model;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Servlet implementation class InquiriesAPI
 */
@WebServlet("/ConsumptionAPI")
public class consumptionAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
	consumption consumptionObj = new consumption();
    
    public consumptionAPI() {
        super();
        
    }
    
    

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("come to post");
		//Consumption Consumption = new Consumption();
		String output = consumptionObj.insertConsumption(request.getParameter("CusName"),
				 request.getParameter("PeakHoursUnit"),
				request.getParameter("NormalHoursUnit"),
				request.getParameter("Month"),
				request.getParameter("AccNumber"));
				response.getWriter().write(output);
				
	}

	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("came here");
		Consumption Consumption = new Consumption();
		// TODO Auto-generated method stub
		Map paras = getParasMap(request);
		 String output = Consumption.updateConsumption(paras.get("hidTrackIdSave").toString(),
		 paras.get("CusName").toString(),
		paras.get("PeakHoursUnit").toString(),
		paras.get("NormalHoursUnit").toString(),
		paras.get("Month").toString(),
		paras.get("AccNumber").toString()
		);
		response.getWriter().write(output);
		
	}

	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Consumption Consumption = new Consumption();
		Map paras = getParasMap(request);
		 String output = Consumption.deleteConsumptions(paras.get("TrackId").toString());
		response.getWriter().write(output);
	}
	
	// Convert request parameters to a Map
	private static Map getParasMap(HttpServletRequest request)
		{
			Map<String, String> map = new HashMap<String, String>();
	try
	 	{
			Scanner scanner = new Scanner(request.getInputStream(), "UTF-8");
			String queryString = scanner.hasNext() ?
			scanner.useDelimiter("\\A").next() : "";
			scanner.close();
			String[] params = queryString.split("&");
			for (String param : params)
				{ 
					String[] p = param.split("=");
					map.put(p[0], p[1]);
				 }
	 	}
		catch (Exception e)
			 {
			 	}
		return map;
				}

}
