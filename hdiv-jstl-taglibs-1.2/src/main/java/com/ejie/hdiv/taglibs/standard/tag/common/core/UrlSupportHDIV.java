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
package com.ejie.hdiv.taglibs.standard.tag.common.core;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.BodyTagSupport;

import org.apache.taglibs.standard.resources.Resources;
import org.apache.taglibs.standard.tag.common.core.ParamParent;
import org.apache.taglibs.standard.tag.common.core.ParamSupport;
import org.apache.taglibs.standard.tag.common.core.Util;
import com.ejie.hdiv.taglibs.standard.util.UrlUtil;
import com.ejie.hdiv.urlProcessor.LinkUrlProcessor;
import com.ejie.hdiv.util.HDIVUtil;

/**
 * <p>
 * Support for tag handlers for &lt;url&gt;, the URL creation and rewriting tag in JSTL 1.0.
 * </p>
 * 
 * @author Gorka Vicente
 * @since HDIV 2.0
 */
public abstract class UrlSupportHDIV extends BodyTagSupport implements ParamParent {

	/** 'value' attribute */
	protected String value;

	/** 'context' attribute */
	protected String context;

	/** 'var' attribute */
	private String var;

	/** processed 'scope' attr */
	private int scope;

	/** added parameters */
	private ParamSupport.ParamManager params;

	/**
	 * Constructor and initialization
	 */
	public UrlSupportHDIV() {
		super();
		init();
	}

	private void init() {
		value = var = null;
		params = null;
		context = null;
		scope = PageContext.PAGE_SCOPE;
	}

	public void addParameter(final String name, final String value) {
		params.addParameter(name, value);
	}

	/**
	 * Resets any parameters that might be sent
	 */
	@Override
	public int doStartTag() throws JspException {
		params = new ParamSupport.ParamManager();
		return EVAL_BODY_BUFFERED;
	}

	/**
	 * Gets the right value, encodes it, and prints or stores it
	 */
	@Override
	public int doEndTag() throws JspException {

		String result; // the eventual result

		// add (already encoded) parameters
		String baseUrl = resolveUrl(value, context, pageContext);
		result = params.aggregateParams(baseUrl);

		// if the URL is relative, rewrite it
		if (!UrlUtil.isAbsoluteUrl(result)) {
			HttpServletResponse response = (HttpServletResponse) pageContext.getResponse();
			result = response.encodeURL(result);
		}

		// Call to HDIV
		LinkUrlProcessor linkUrlProcessor = HDIVUtil.getLinkUrlProcessor(pageContext.getServletContext());
		result = linkUrlProcessor.processUrl(HDIVUtil.getRequestContext(pageContext.getRequest()), result);

		// store or print the output
		if (var != null) {
			pageContext.setAttribute(var, result, scope);
		}
		else {
			try {
				pageContext.getOut().print(result);
			}
			catch (java.io.IOException ex) {
				throw new JspTagException(ex.toString(), ex);
			}
		}

		return EVAL_PAGE;
	}

	/**
	 * Releases any resources we may have (or inherit)
	 */
	@Override
	public void release() {
		init();
	}

	public static String resolveUrl(final String url, final String context, final PageContext pageContext) throws JspException {

		// don't touch absolute URLs
		if (UrlUtil.isAbsoluteUrl(url)) {
			return url;
		}

		// normalize relative URLs against a context root
		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
		if (context == null) {
			if (url.startsWith("/")) {
				return request.getContextPath() + url;
			}
			else {
				return url;
			}
		}
		else {
			if (!context.startsWith("/") || !url.startsWith("/")) {
				throw new JspTagException(Resources.getMessage("IMPORT_BAD_RELATIVE"));
			}
			if (context.equals("/")) {
				// Don't produce string starting with '//', many
				// browsers interpret this as host name, not as
				// path on same host.
				return url;
			}
			else {
				return context + url;
			}
		}
	}

	public void setVar(final String var) {
		this.var = var;
	}

	public void setScope(final String scope) {
		this.scope = Util.getScope(scope);
	}

}
