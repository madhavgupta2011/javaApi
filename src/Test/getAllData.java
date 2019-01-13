package Test;

import javax.ws.rs.GET;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.core.MediaType;

import java.util.ArrayList;

import javax.json.JsonObject;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@Path("/getAllData")
public class getAllData {
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String sayHello(@DefaultValue("0")@QueryParam("from") int from,@DefaultValue("100")@QueryParam("to") int to)
	{
		ArrayList<String> arr = new ArrayList();
		ArrayList<String> arr2 = new ArrayList();
		try {
			arr=connect.getPatient();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(to==100) {
			to=arr.size();
		}
		
		for(int i=from;i<to;i++) {
			arr2.add(arr.get(i));
		}
		String resource=""+arr2+"";
		return resource;
	}
	
}
