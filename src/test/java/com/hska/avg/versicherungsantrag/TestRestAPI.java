package com.hska.avg.versicherungsantrag;

import org.apache.ibatis.logging.LogFactory;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.test.Deployment;
import org.camunda.bpm.engine.test.ProcessEngineRule;
import org.camunda.bpm.extension.process_test_coverage.junit.rules.TestCoverageProcessEngineRuleBuilder;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

import com.hska.avg.versicherungsantrag.ProcessConstants;

import static org.camunda.bpm.engine.test.assertions.ProcessEngineTests.*;
import static org.junit.Assert.*;

/**
 * Test case starting an in-memory database-backed Process Engine.
 */
public class TestRestAPI {

  static {
    LogFactory.useSlf4jLogging(); // MyBatis
  }

  @Before
  public void setup() {
  }

  @Test
  public void testReatAPIGet( ) {
	  InformationEinholenDelegate infoDel = new InformationEinholenDelegate();
	 // KundeDaten k = infoDel.getKunde("Callie", "Oliver");
  }
  
  @Test
  public void testReatAPIPost( ) {
	  RisikobewertungSpeichernDelegate risikoDel = new RisikobewertungSpeichernDelegate();
	  
    // risikoDel.risikoSpeichen("Fatemeh", "Mohammadzadeh", 50l);
	  
	  
  }
  
  
}
