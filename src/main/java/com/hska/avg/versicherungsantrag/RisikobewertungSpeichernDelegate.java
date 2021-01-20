package com.hska.avg.versicherungsantrag;

import java.util.List;

//import java.util.logging.Logger;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.Invocation;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;

public class RisikobewertungSpeichernDelegate implements JavaDelegate {
	 //private final Logger LOGGER = Logger.getLogger(LoggerDelegate.class.getName());


	@Override
	public void execute(DelegateExecution execution) throws Exception {
		String vorname = (String) execution.getVariable("vorname");
		String name = (String) execution.getVariable("name");
		Long risiko = (Long) execution.getVariable("risiko");

		
		if(vorname == null || name == null || risiko == null) {
			execution.setVariable("neukunde", true);
			return; 
		}
		risikoSpeichen(vorname, name, risiko);
	}

	public void risikoSpeichen(String vorname, String name, Long risiko) {
		try {
			Client client = ClientBuilder.newClient();
			WebTarget webTarget = client.target("http://localhost:3000/customers");
			Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
			KundeDaten kunde = new KundeDaten(vorname, name, risiko);
			invocationBuilder.post(Entity.entity(kunde, MediaType.APPLICATION_JSON));
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
	}

}
