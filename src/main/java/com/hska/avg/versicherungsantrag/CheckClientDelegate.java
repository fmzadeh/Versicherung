package com.hska.avg.versicherungsantrag;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class CheckClientDelegate implements JavaDelegate {
	
	@Override
	public void execute(DelegateExecution execution) throws Exception {
		execution.setVariable("test", "fati");
		execution.setVariable("checkOk", "false");
		
		// code logig
	}

}
