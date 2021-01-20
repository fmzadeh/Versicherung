package com.hska.avg.versicherungsantrag;

//import java.util.logging.Logger;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class RisikobewertungUebernehmenDelegate implements JavaDelegate {
	
	  //private final Logger LOGGER = Logger.getLogger(LoggerDelegate.class.getName());

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		execution.setVariable("test", "fati");
		execution.setVariable("checkOk", false);
	}

}
