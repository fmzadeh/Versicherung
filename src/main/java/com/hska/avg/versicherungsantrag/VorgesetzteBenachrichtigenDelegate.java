package com.hska.avg.versicherungsantrag;

import java.util.logging.Logger;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

/**
 * This is an easy adapter implementation
 * illustrating how a Java Delegate can be used
 * from within a BPMN 2.0 Service Task.
 */
public class VorgesetzteBenachrichtigenDelegate implements JavaDelegate {
 
  private final Logger LOGGER = Logger.getLogger(VorgesetzteBenachrichtigenDelegate.class.getName());
  
  public void execute(DelegateExecution execution) throws Exception {
    
    LOGGER.info("\n\n Der Vorgesetzte wurde benachrichtigt.");
    
  }

}
