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
package com.ejie.hdiv.taglib.html;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;

import org.apache.struts.taglib.TagUtils;
import org.apache.struts.taglib.html.HiddenTag;
import com.ejie.hdiv.dataComposer.IDataComposer;
import com.ejie.hdiv.util.HDIVUtil;
import org.slf4j.LoggerFactory;

/**
 * Renders an HTML <b>&lt;input&gt;</b> element of type hidden, populated from the specified value or the specified property of the bean
 * associated with our current form. This tag is only valid when nested inside a form tag body.
 * 
 * @author Gorka Vicente
 * @see org.apache.struts.taglib.html.HiddenTag
 */
public class HiddenTagHDIV extends HiddenTag {

	/**
	 * Universal version identifier. Deserialization uses this number to ensure that a loaded class corresponds exactly to a serialized
	 * object.
	 */
	private static final long serialVersionUID = 8200582308056745466L;

	/**
	 * Commons logging instance
	 */
	private static final org.slf4j.Logger log = LoggerFactory.getLogger(HiddenTagHDIV.class);

	/**
	 * Generated encoded value by HDIV composer
	 */
	private String encodedValue = null;

	/**
	 * Generate the required input tag, followed by the optional rendered text. Support for <code>write</code> property since Struts 1.1.
	 * 
	 * @exception JspException if a JSP exception has occurred
	 * @see com.ejie.hdiv.dataComposer.IDataComposer#composeFormField(String, String, boolean, String)
	 */
	@SuppressWarnings("deprecation")
	@Override
	public int doStartTag() throws JspException {

		try {
			String hiddenValue = value;
			Object lookupValue = null;

			if (value == null) {
				// locate and return the specified property of the specified bean
				lookupValue = TagUtils.getInstance().lookup(pageContext, name, property, null);

				if (lookupValue != null) {
					hiddenValue = lookupValue.toString();
				}
			}

			HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
			IDataComposer dataComposer = HDIVUtil.getRequestContext(request).getDataComposer();
			encodedValue = dataComposer != null ? dataComposer.composeFormField(prepareName(), hiddenValue, false, null, true)
					: hiddenValue;

			// Render the result to the output writer
			TagUtils.getInstance().write(pageContext, renderInputElement());

			// Is rendering the value separately requested?
			if (!write) {
				return EVAL_BODY_TAG;
			}

			// Calculate the value to be rendered separately
			// * @since Struts 1.1
			String results = null;
			if (value != null) {
				results = TagUtils.getInstance().filter(value);
			}
			else {
				if (lookupValue == null) {
					results = "";
				}
				else {
					results = TagUtils.getInstance().filter(lookupValue.toString());
				}
			}

			// Render the result to the output writer
			TagUtils.getInstance().write(pageContext, results);
			return EVAL_BODY_TAG;

		}
		catch (JspException e) {
			log.debug(e.getMessage());
			throw e;
		}
	}

	/**
	 * Render the value element.
	 * 
	 * @param results The StringBuffer that output will be appended to.
	 */
	@Override
	protected void prepareValue(final StringBuffer results) throws JspException {

		results.append(" value=\"");

		if (encodedValue != null) {
			results.append(formatValue(encodedValue));

		}
		else if (redisplay || !"password".equals(type)) {
			Object lookupValue = TagUtils.getInstance().lookup(pageContext, name, property, null);
			results.append(formatValue(lookupValue));
		}
		results.append("\"");
	}

}
