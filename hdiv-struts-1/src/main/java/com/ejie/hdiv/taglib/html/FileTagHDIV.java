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

import org.apache.struts.taglib.html.FileTag;
import com.ejie.hdiv.dataComposer.IDataComposer;
import com.ejie.hdiv.util.HDIVUtil;

/**
 * <p>
 * Renders an HTML &lt;input&gt; element of type file, defaulting to the specified value or the specified property of the bean associated
 * with our current form. This tag is only valid when nested inside a form tag body.
 * </p>
 * <p>
 * As with the corresponding HTML &lt;input&gt; element, the enclosing form element must specify "POST" for the <code>method</code>
 * attribute, and "multipart/form-data" for the <code>enctype</code> attribute. For example:
 * </p>
 * 
 * @author Gorka Vicente
 * @see org.apache.struts.taglib.html.FileTag
 */
public class FileTagHDIV extends FileTag {

	/**
	 * Universal version identifier. Deserialization uses this number to ensure that a loaded class corresponds exactly to a serialized
	 * object.
	 */
	private static final long serialVersionUID = 850549719352687445L;

	/**
	 * Process the start of this tag.
	 * 
	 * @exception JspException if a JSP exception has occurred
	 * @see com.ejie.hdiv.dataComposer.IDataComposer#composeFormField(String, String, boolean, String)
	 */
	@Override
	public int doStartTag() throws JspException {

		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
		IDataComposer dataComposer = HDIVUtil.getRequestContext(request).getDataComposer();

		// this property is editable and we must check it
		if (dataComposer != null) {
			dataComposer.composeFormField(prepareName(), "", true, null);
		}

		return super.doStartTag();
	}

}
