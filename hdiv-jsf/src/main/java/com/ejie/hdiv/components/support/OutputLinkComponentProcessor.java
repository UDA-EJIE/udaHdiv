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
package com.ejie.hdiv.components.support;

import javax.faces.FacesException;
import javax.faces.component.UIComponent;
import javax.faces.component.UIParameter;
import javax.faces.component.html.HtmlOutputLink;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import com.ejie.hdiv.context.RequestContextHolder;
import com.ejie.hdiv.dataComposer.IDataComposer;
import com.ejie.hdiv.urlProcessor.UrlData;
import com.ejie.hdiv.util.Constants;
import com.ejie.hdiv.util.HDIVUtil;
import com.ejie.hdiv.util.Method;
import com.ejie.hdiv.util.UtilsJsf;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OutputLinkComponentProcessor extends AbstractComponentProcessor {

	private static final Logger log = LoggerFactory.getLogger(OutputLinkComponentProcessor.class);

	public void processOutputLink(final FacesContext context, final HtmlOutputLink component) {

		try {
			ExternalContext externalContext = context.getExternalContext();
			HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();

			String url = component.getValue().toString();
			RequestContextHolder requestContext = HDIVUtil.getRequestContext(request);
			String hdivParameter = requestContext.getHdivParameterName();
			UrlData urlData = linkUrlProcessor.createUrlData(url, Method.GET, hdivParameter, requestContext);
			if (urlData.isHdivStateNecessary(config)) {

				boolean hasUIParams = UtilsJsf.hasUIParameterChild(component);

				// if url hasn't got parameters, we do not have to include HDIV's state
				if (!config.isValidationInUrlsWithoutParamsActivated() && !urlData.containsParams() && !hasUIParams) {

					// Do nothing
					return;
				}

				IDataComposer dataComposer = HDIVUtil.getRequestContext(request).getDataComposer();
				dataComposer.beginRequest(Method.GET, urlData.getUrlWithoutContextPath());

				urlData.setComposedUrlParams(dataComposer.composeParams(urlData.getUrlParams(), Method.GET, Constants.ENCODING_UTF_8));

				if (hasUIParams) {

					for (UIComponent comp : component.getChildren()) {
						if (comp instanceof UIParameter) {
							UIParameter param = (UIParameter) comp;
							String name = param.getName();
							String value = param.getValue().toString();

							dataComposer.compose(name, value, false);
						}
					}

					String stateParam = dataComposer.endRequest();

					url = linkUrlProcessor.getProcessedUrl(dataComposer.getBuilder(), urlData);

					component.setValue(url);

					// Add a children UIParam component with Hdiv's state
					UIParameter paramComponent = (UIParameter) context.getApplication().createComponent(UIParameter.COMPONENT_TYPE);

					paramComponent.setName(hdivParameter);
					paramComponent.setValue(stateParam);
					component.getChildren().add(paramComponent);
				}
				else {

					String stateParam = dataComposer.endRequest();

					// Add state directly in the outputLink's value
					url = linkUrlProcessor.getProcessedUrlWithHdivState(dataComposer.getBuilder(), hdivParameter, urlData, stateParam);
					component.setValue(url);
				}
			}
		}
		catch (FacesException e) {
			log.error("Error in OutputLinkComponentProcessor.processOutputLink: " + e.getMessage());
			throw e;
		}

	}
}
