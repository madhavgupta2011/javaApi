package Test;


import javax.ws.rs.GET;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;

import java.util.ArrayList;

import javax.json.JsonObject;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@Path("/enterData")
public class Hello {
	
	
	@POST
	
	  @Produces(MediaType.TEXT_PLAIN)
	  @Consumes(MediaType.APPLICATION_JSON)
	public String sayPlainTextHello(JsonObject inputJsonObj) throws Exception {
		String name = inputJsonObj.getString("name");
		int age = inputJsonObj.getInt("age");
		String email = inputJsonObj.getString("email");
		String outputJsonObj = "Patient Entered in Database";
		System.out.println(name);
		int count=connect.addPatient(name, age, email);
		Email.sendMail(name,age,email);
		System.out.println(count+" Rows Affected");
	    return outputJsonObj;
	  }

	

}

