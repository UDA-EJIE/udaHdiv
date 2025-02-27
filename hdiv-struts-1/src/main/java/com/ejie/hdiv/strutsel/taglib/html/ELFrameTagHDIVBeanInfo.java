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

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.beans.SimpleBeanInfo;
import java.util.ArrayList;

/**
 * This is the <code>BeanInfo</code> descriptor for the <code>com.ejie.hdiv.strutsel.taglib.html.ELFrameTagHDIV</code> class. It is needed to
 * override the default mapping of custom tag attribute names to class attribute names.
 * <p>
 * This is because the value of the unevaluated EL expression has to be kept separately from the evaluated value, which is stored in the
 * base class. This is related to the fact that the JSP compiler can choose to reuse different tag instances if they received the same
 * original attribute values, and the JSP compiler can choose to not re-call the setter methods, because it can assume the same values are
 * already set.
 * 
 * @author Gorka Vicente
 * @since HDIV 2.0
 */
@SuppressWarnings("unchecked")
public class ELFrameTagHDIVBeanInfo extends SimpleBeanInfo {

	@Override
	public PropertyDescriptor[] getPropertyDescriptors() {
		ArrayList proplist = new ArrayList();

		try {
			proplist.add(new PropertyDescriptor("action", ELFrameTagHDIV.class, null, "setActionExpr"));
		}
		catch (IntrospectionException ex) {
		}

		try {
			proplist.add(new PropertyDescriptor("module", ELFrameTagHDIV.class, null, "setModuleExpr"));
		}
		catch (IntrospectionException ex) {
		}

		try {
			proplist.add(new PropertyDescriptor("anchor", ELFrameTagHDIV.class, null, "setAnchorExpr"));
		}
		catch (IntrospectionException ex) {
		}

		try {
			proplist.add(new PropertyDescriptor("bundle", ELFrameTagHDIV.class, null, "setBundleExpr"));
		}
		catch (IntrospectionException ex) {
		}

		try {
			proplist.add(new PropertyDescriptor("forward", ELFrameTagHDIV.class, null, "setForwardExpr"));
		}
		catch (IntrospectionException ex) {
		}

		try {
			proplist.add(new PropertyDescriptor("frameborder", ELFrameTagHDIV.class, null, "setFrameborderExpr"));
		}
		catch (IntrospectionException ex) {
		}

		try {
			proplist.add(new PropertyDescriptor("frameName", ELFrameTagHDIV.class, null, "setFrameNameExpr"));
		}
		catch (IntrospectionException ex) {
		}

		try {
			proplist.add(new PropertyDescriptor("href", ELFrameTagHDIV.class, null, "setHrefExpr"));
		}
		catch (IntrospectionException ex) {
		}

		try {
			proplist.add(new PropertyDescriptor("longdesc", ELFrameTagHDIV.class, null, "setLongdescExpr"));
		}
		catch (IntrospectionException ex) {
		}

		try {
			proplist.add(new PropertyDescriptor("marginheight", ELFrameTagHDIV.class, null, "setMarginheightExpr"));
		}
		catch (IntrospectionException ex) {
		}

		try {
			proplist.add(new PropertyDescriptor("marginwidth", ELFrameTagHDIV.class, null, "setMarginwidthExpr"));
		}
		catch (IntrospectionException ex) {
		}

		try {
			proplist.add(new PropertyDescriptor("name", ELFrameTagHDIV.class, null, "setNameExpr"));
		}
		catch (IntrospectionException ex) {
		}

		try {
			proplist.add(new PropertyDescriptor("noresize", ELFrameTagHDIV.class, null, "setNoresizeExpr"));
		}
		catch (IntrospectionException ex) {
		}

		try {
			proplist.add(new PropertyDescriptor("page", ELFrameTagHDIV.class, null, "setPageExpr"));
		}
		catch (IntrospectionException ex) {
		}

		try {
			proplist.add(new PropertyDescriptor("paramId", ELFrameTagHDIV.class, null, "setParamIdExpr"));
		}
		catch (IntrospectionException ex) {
		}

		try {
			proplist.add(new PropertyDescriptor("paramName", ELFrameTagHDIV.class, null, "setParamNameExpr"));
		}
		catch (IntrospectionException ex) {
		}

		try {
			proplist.add(new PropertyDescriptor("paramProperty", ELFrameTagHDIV.class, null, "setParamPropertyExpr"));
		}
		catch (IntrospectionException ex) {
		}

		try {
			proplist.add(new PropertyDescriptor("paramScope", ELFrameTagHDIV.class, null, "setParamScopeExpr"));
		}
		catch (IntrospectionException ex) {
		}

		try {
			proplist.add(new PropertyDescriptor("property", ELFrameTagHDIV.class, null, "setPropertyExpr"));
		}
		catch (IntrospectionException ex) {
		}

		try {
			proplist.add(new PropertyDescriptor("scope", ELFrameTagHDIV.class, null, "setScopeExpr"));
		}
		catch (IntrospectionException ex) {
		}

		try {
			proplist.add(new PropertyDescriptor("scrolling", ELFrameTagHDIV.class, null, "setScrollingExpr"));
		}
		catch (IntrospectionException ex) {
		}

		try {
			proplist.add(new PropertyDescriptor("style", ELFrameTagHDIV.class, null, "setStyleExpr"));
		}
		catch (IntrospectionException ex) {
		}

		try {
			proplist.add(new PropertyDescriptor("styleClass", ELFrameTagHDIV.class, null, "setStyleClassExpr"));
		}
		catch (IntrospectionException ex) {
		}

		try {
			proplist.add(new PropertyDescriptor("styleId", ELFrameTagHDIV.class, null, "setStyleIdExpr"));
		}
		catch (IntrospectionException ex) {
		}

		try {
			proplist.add(new PropertyDescriptor("title", ELFrameTagHDIV.class, null, "setTitleExpr"));
		}
		catch (IntrospectionException ex) {
		}

		try {
			proplist.add(new PropertyDescriptor("titleKey", ELFrameTagHDIV.class, null, "setTitleKeyExpr"));
		}
		catch (IntrospectionException ex) {
		}

		try {
			proplist.add(new PropertyDescriptor("transaction", ELFrameTagHDIV.class, null, "setTransactionExpr"));
		}
		catch (IntrospectionException ex) {
		}

		PropertyDescriptor[] result = new PropertyDescriptor[proplist.size()];

		return (PropertyDescriptor[]) proplist.toArray(result);
	}
}
