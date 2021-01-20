package com.hska.avg.versicherungsantrag;

import java.util.Date;
import java.util.List;

import org.camunda.bpm.engine.delegate.BpmnError;

//import java.util.logging.Logger;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Invocation;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

public class InformationEinholenDelegate implements JavaDelegate {
	// private final Logger LOGGER =
	// Logger.getLogger(LoggerDelegate.class.getName());
	
	private String ERROR_CODE = "kundenverwaltungError";

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		String vorname = (String) execution.getVariable("vorname");
		String name = (String) execution.getVariable("name");
		
		if(vorname == null || name == null) {
			execution.setVariable("neukunde", true);
			return; 
		}

		KundeDaten kunde = getKunde(vorname, name);

		if (kunde == null) {
			execution.setVariable("neukunde", true);
		} else {
			execution.setVariable("neukunde", false);
			if (kunde.getRisiko() != null) {
				execution.setVariable("risiko", kunde.getRisiko());
			}
		}
	}

	public KundeDaten getKunde(String vorname, String name) {
		try {
			Client client = ClientBuilder.newClient();
			WebTarget webTarget = client.target("http://localhost:3000/customers").queryParam("prename", vorname)
					.queryParam("surname", name);
			Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
			List<KundeDaten> kunden = invocationBuilder.get(new GenericType<List<KundeDaten>> () {});
			if (kunden != null && kunden.size() == 1) {
				return kunden.get(0);
			}
			return null;
		} catch (Exception e) {
			throw new BpmnError(ERROR_CODE, "Kundenverwaltung nicht verfuegbar");
		}
	}

}
