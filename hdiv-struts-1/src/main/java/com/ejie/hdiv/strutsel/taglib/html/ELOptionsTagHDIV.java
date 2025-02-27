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
package com.ejie.hdiv.strutsel.taglib.html;

import javax.servlet.jsp.JspException;

import org.apache.strutsel.taglib.utils.EvalHelper;
import com.ejie.hdiv.taglib.html.OptionsTagHDIV;

/**
 * Tag for creating multiple &lt;select&gt; options from a collection. The associated values displayed to the user may optionally be
 * specified by a second collection, or will be the same as the values themselves. Each collection may be an array of objects, a Collection,
 * an Enumeration, an Iterator, or a Map. <b>NOTE</b> - This tag requires a Java2 (JDK 1.2 or later) platform.
 * <p>
 * This class is a subclass of the class <code>com.ejie.hdiv.taglib.html.OptionsTagHDIV</code> which provides most of the described
 * functionality. This subclass allows all attribute values to be specified as expressions utilizing the JavaServer Pages Standard Library
 * expression language.
 * 
 * @author Gorka Vicente
 * @since HDIV 2.0
 */
public class ELOptionsTagHDIV extends OptionsTagHDIV {

	/**
	 * Instance variable mapped to "collection" tag attribute. (Mapping set in associated BeanInfo class.)
	 */
	private String collectionExpr;

	/**
	 * Instance variable mapped to "filter" tag attribute. (Mapping set in associated BeanInfo class.)
	 */
	private String filterExpr;

	/**
	 * Instance variable mapped to "labelName" tag attribute. (Mapping set in associated BeanInfo class.)
	 */
	private String labelNameExpr;

	/**
	 * Instance variable mapped to "labelProperty" tag attribute. (Mapping set in associated BeanInfo class.)
	 */
	private String labelPropertyExpr;

	/**
	 * Instance variable mapped to "name" tag attribute. (Mapping set in associated BeanInfo class.)
	 */
	private String nameExpr;

	/**
	 * Instance variable mapped to "property" tag attribute. (Mapping set in associated BeanInfo class.)
	 */
	private String propertyExpr;

	/**
	 * Instance variable mapped to "style" tag attribute. (Mapping set in associated BeanInfo class.)
	 */
	private String styleExpr;

	/**
	 * Instance variable mapped to "styleClass" tag attribute. (Mapping set in associated BeanInfo class.)
	 */
	private String styleClassExpr;

	/**
	 * Getter method for "collection" tag attribute. (Mapping set in associated BeanInfo class.)
	 */
	public String getCollectionExpr() {
		return (collectionExpr);
	}

	/**
	 * Getter method for "filter" tag attribute. (Mapping set in associated BeanInfo class.)
	 */
	public String getFilterExpr() {
		return (filterExpr);
	}

	/**
	 * Getter method for "labelName" tag attribute. (Mapping set in associated BeanInfo class.)
	 */
	public String getLabelNameExpr() {
		return (labelNameExpr);
	}

	/**
	 * Getter method for "labelProperty" tag attribute. (Mapping set in associated BeanInfo class.)
	 */
	public String getLabelPropertyExpr() {
		return (labelPropertyExpr);
	}

	/**
	 * Getter method for "name" tag attribute. (Mapping set in associated BeanInfo class.)
	 */
	public String getNameExpr() {
		return (nameExpr);
	}

	/**
	 * Getter method for "property" tag attribute. (Mapping set in associated BeanInfo class.)
	 */
	public String getPropertyExpr() {
		return (propertyExpr);
	}

	/**
	 * Getter method for "style" tag attribute. (Mapping set in associated BeanInfo class.)
	 */
	public String getStyleExpr() {
		return (styleExpr);
	}

	/**
	 * Getter method for "styleClass" tag attribute. (Mapping set in associated BeanInfo class.)
	 */
	public String getStyleClassExpr() {
		return (styleClassExpr);
	}

	/**
	 * Setter method for "collection" tag attribute. (Mapping set in associated BeanInfo class.)
	 */
	public void setCollectionExpr(String collectionExpr) {
		this.collectionExpr = collectionExpr;
	}

	/**
	 * Setter method for "filter" tag attribute. (Mapping set in associated BeanInfo class.)
	 */
	public void setFilterExpr(String filterExpr) {
		this.filterExpr = filterExpr;
	}

	/**
	 * Setter method for "labelName" tag attribute. (Mapping set in associated BeanInfo class.)
	 */
	public void setLabelNameExpr(String labelNameExpr) {
		this.labelNameExpr = labelNameExpr;
	}

	/**
	 * Setter method for "labelProperty" tag attribute. (Mapping set in associated BeanInfo class.)
	 */
	public void setLabelPropertyExpr(String labelPropertyExpr) {
		this.labelPropertyExpr = labelPropertyExpr;
	}

	/**
	 * Setter method for "name" tag attribute. (Mapping set in associated BeanInfo class.)
	 */
	public void setNameExpr(String nameExpr) {
		this.nameExpr = nameExpr;
	}

	/**
	 * Setter method for "property" tag attribute. (Mapping set in associated BeanInfo class.)
	 */
	public void setPropertyExpr(String propertyExpr) {
		this.propertyExpr = propertyExpr;
	}

	/**
	 * Setter method for "style" tag attribute. (Mapping set in associated BeanInfo class.)
	 */
	public void setStyleExpr(String styleExpr) {
		this.styleExpr = styleExpr;
	}

	/**
	 * Setter method for "styleClass" tag attribute. (Mapping set in associated BeanInfo class.)
	 */
	public void setStyleClassExpr(String styleClassExpr) {
		this.styleClassExpr = styleClassExpr;
	}

	/**
	 * Resets attribute values for tag reuse.
	 */
	public void release() {
		super.release();
		setCollectionExpr(null);
		setFilterExpr(null);
		setLabelNameExpr(null);
		setLabelPropertyExpr(null);
		setNameExpr(null);
		setPropertyExpr(null);
		setStyleExpr(null);
		setStyleClassExpr(null);
	}

	/**
	 * Process the start tag.
	 * 
	 * @throws JspException if a JSP exception has occurred
	 */
	public int doStartTag() throws JspException {
		evaluateExpressions();

		return (super.doStartTag());
	}

	/**
	 * Processes all attribute values which use the JSTL expression evaluation engine to determine their values.
	 * 
	 * @throws JspException if a JSP exception has occurred
	 */
	private void evaluateExpressions() throws JspException {
		String string = null;
		Boolean bool = null;

		if ((string = EvalHelper.evalString("collection", getCollectionExpr(), this, pageContext)) != null) {
			setCollection(string);
		}

		if ((bool = EvalHelper.evalBoolean("filter", getFilterExpr(), this, pageContext)) != null) {
			setFilter(bool.booleanValue());
		}

		if ((string = EvalHelper.evalString("labelName", getLabelNameExpr(), this, pageContext)) != null) {
			setLabelName(string);
		}

		if ((string = EvalHelper.evalString("labelProperty", getLabelPropertyExpr(), this, pageContext)) != null) {
			setLabelProperty(string);
		}

		if ((string = EvalHelper.evalString("name", getNameExpr(), this, pageContext)) != null) {
			setName(string);
		}

		if ((string = EvalHelper.evalString("property", getPropertyExpr(), this, pageContext)) != null) {
			setProperty(string);
		}

		if ((string = EvalHelper.evalString("style", getStyleExpr(), this, pageContext)) != null) {
			setStyle(string);
		}

		if ((string = EvalHelper.evalString("styleClass", getStyleClassExpr(), this, pageContext)) != null) {
			setStyleClass(string);
		}

		// Note that in contrast to other elements which have "style" and
		// "styleClass" attributes, this tag does not have a "styleId"
		// attribute. This is because this produces the "id" attribute, which
		// has to be unique document-wide, but this tag can generate more than
		// one "option" element. Thus, the base tag, "Options" does not
		// support this attribute.
	}
}
