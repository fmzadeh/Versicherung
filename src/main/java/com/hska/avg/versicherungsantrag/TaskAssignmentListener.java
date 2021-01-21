/*
 * Copyright Camunda Services GmbH and/or licensed to Camunda Services GmbH
 * under one or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information regarding copyright
 * ownership. Camunda licenses this file to you under the Apache License,
 * Version 2.0; you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.hska.avg.versicherungsantrag;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.camunda.bpm.engine.IdentityService;
import org.camunda.bpm.engine.delegate.DelegateTask;
import org.camunda.bpm.engine.delegate.TaskListener;
import org.camunda.bpm.engine.identity.User;
import org.camunda.bpm.engine.impl.context.Context;

public class TaskAssignmentListener implements TaskListener {

	private final static Logger LOGGER = Logger.getLogger(TaskAssignmentListener.class.getName());

	public void notify(DelegateTask delegateTask) {

		String assignee = delegateTask.getAssignee();
		String taskId = delegateTask.getId();
		
		delegateTask.getExecution().setVariable("asigneeId", assignee);
		delegateTask.getExecution().setVariable("taskId", taskId);

		if (assignee != null) {
			// Get User Profile from User Management
			IdentityService identityService = Context.getProcessEngineConfiguration().getIdentityService();
			User user = identityService.createUserQuery().userId(assignee).singleResult();
			if (user != null) {
				delegateTask.getExecution().setVariable("sachbearbeiter", user.getFirstName() + " " + user.getLastName());
			} else {
				delegateTask.getExecution().setVariable("sachbearbeiter", assignee);
			}
		}
	}

}
