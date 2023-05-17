/**
 * Copyright 2005-2016 hdiv.org
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 	http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ejie.hdiv.config.annotation.jsf;

import com.ejie.hdiv.components.support.OutcomeTargetComponentProcessor;
import com.ejie.hdiv.components.support.OutputLinkComponentProcessor;
import com.ejie.hdiv.config.HDIVConfig;
import com.ejie.hdiv.config.annotation.condition.ConditionalOnFramework;
import com.ejie.hdiv.config.annotation.condition.SupportedFramework;
import com.ejie.hdiv.config.multipart.JsfMultipartConfig;
import com.ejie.hdiv.context.RedirectHelper;
import com.ejie.hdiv.dataComposer.DataComposerFactory;
import com.ejie.hdiv.dataValidator.IDataValidator;
import com.ejie.hdiv.filter.IValidationHelper;
import com.ejie.hdiv.filter.JsfValidatorErrorHandler;
import com.ejie.hdiv.filter.JsfValidatorHelper;
import com.ejie.hdiv.filter.ValidatorErrorHandler;
import com.ejie.hdiv.filter.ValidatorHelperRequest;
import com.ejie.hdiv.session.ISession;
import com.ejie.hdiv.state.StateUtil;
import com.ejie.hdiv.state.scope.StateScopeManager;
import com.ejie.hdiv.urlProcessor.BasicUrlProcessor;
import com.ejie.hdiv.urlProcessor.LinkUrlProcessor;
import com.ejie.hdiv.validation.DefaultComponentTreeValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * Contains the configuration beans for JavaServer Faces framework support.
 * 
 * @since 2.1.7
 */
@Configuration
@ConditionalOnFramework(SupportedFramework.JSF)
public class JsfConfigurationSupport {

	@Autowired
	protected StateUtil stateUtil;

	@Autowired
	protected HDIVConfig config;

	@Autowired
	protected ISession session;

	@Autowired
	protected IDataValidator dataValidator;

	@Autowired
	protected BasicUrlProcessor basicUrlProcessor;

	@Autowired
	protected DataComposerFactory dataComposerFactory;

	@Autowired
	protected LinkUrlProcessor linkUrlProcessor;

	@Autowired
	protected StateScopeManager stateScopeManager;

	@Bean
	@Primary
	public ValidatorErrorHandler validatorErrorHandler() {
		JsfValidatorErrorHandler validatorErrorHandler = new JsfValidatorErrorHandler();
		validatorErrorHandler.setConfig(config);
		return validatorErrorHandler;
	}

	@Bean
	@Primary
	public IValidationHelper jsfValidatorHelper() {

		ValidatorHelperRequest validatorHelperRequest = new JsfValidatorHelper();
		validatorHelperRequest.setStateUtil(stateUtil);
		validatorHelperRequest.setHdivConfig(config);
		validatorHelperRequest.setSession(session);
		validatorHelperRequest.setDataValidator(dataValidator);
		validatorHelperRequest.setUrlProcessor(basicUrlProcessor);
		validatorHelperRequest.setDataComposerFactory(dataComposerFactory);
		validatorHelperRequest.setStateScopeManager(stateScopeManager);
		validatorHelperRequest.init();
		return validatorHelperRequest;
	}

	@Bean
	public DefaultComponentTreeValidator componentTreeValidator() {

		DefaultComponentTreeValidator componentTreeValidator = new DefaultComponentTreeValidator();
		componentTreeValidator.setConfig(config);
		componentTreeValidator.createComponentValidators();
		return componentTreeValidator;
	}

	@Bean
	public RedirectHelper redirectHelper() {

		RedirectHelper redirectHelper = new RedirectHelper();
		redirectHelper.setLinkUrlProcessor(linkUrlProcessor);
		return redirectHelper;
	}

	@Bean
	public JsfMultipartConfig jsfMultipartConfig() {
		return new JsfMultipartConfig();
	}

	@Bean
	public OutcomeTargetComponentProcessor outcomeTargetComponentProcessor() {

		OutcomeTargetComponentProcessor processor = new OutcomeTargetComponentProcessor();
		processor.setConfig(config);
		processor.setLinkUrlProcessor(linkUrlProcessor);
		return processor;
	}

	@Bean
	public OutputLinkComponentProcessor outputLinkComponentProcessor() {

		OutputLinkComponentProcessor processor = new OutputLinkComponentProcessor();
		processor.setConfig(config);
		processor.setLinkUrlProcessor(linkUrlProcessor);
		return processor;
	}

}