package com;

import model.consumption;

//for REST Service
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

//for JSON
import com.google.gson.*;

//for XML
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;

@Path("/Consumptions")
public class PowerConsumptionService {
	
	consumption consumptionObj = new consumption();
	
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readconsumptions() {
		
		return consumptionObj.readConsumptions();
		
		
		
		
	}
	
	
	@POST
	@Path("/")
	@Produces(MediaType.APPLICATION_FORM_URLENCODED)
	public String insertConsumptions(
							
							@FormParam("PeakHoursUnit") String PeakHoursUnit,
							@FormParam("NormalHoursUnit") String NormalHoursUnit,
							@FormParam("Month") String Month,
							@FormParam("AccNumber") String AccNumber)
							
	{
		
		String output = consumptionObj.insertConsumptions(PeakHoursUnit, NormalHoursUnit, Month, AccNumber);
		return output;
		
	}
	
	
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateConsumption(String consumptionData)
	{
		//Convert input string to a JSON object
		JsonObject consumptionObject = new JsonParser().parse(consumptionData).getAsJsonObject();
		
		//Read values from JSON object
		String TrackId = consumptionObject.get("TrackId").getAsString();
		String PeakHoursUnit = consumptionObject.get("PeakHoursUnit").getAsString();
		String NormalHoursUnit = consumptionObject.get("NormalHoursUnit").getAsString();
		String Month = consumptionObject.get("Month").getAsString();
		String AccNumber = consumptionObject.get("AccNumber").getAsString();

		
		String output = consumptionObject.updateConsumption(TrackId, PeakHoursUnit, NormalHoursUnit, Month, AccNumber);
		return output;
		
	}
	
	
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteConsumptions(String ConsumptionData)
	{
		//Convert input string to a JSON object
		Document doc = Jsoup.parse(ConsumptionData, "", Parser.xmlParser());
		
		//Read values from JSON object
		String TrackId = doc.select("TrackId").text();
		
		String output = consumptionObj.deleteConsumptions(TrackId);
		return output;
		
	}

}
