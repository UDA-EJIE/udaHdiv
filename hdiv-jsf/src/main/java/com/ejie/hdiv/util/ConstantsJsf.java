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
package com.ejie.hdiv.util;

/**
 * Constants used in HDIV for JSF
 * 
 * @author Gotzon Illarramendi
 */
public class ConstantsJsf {

	public static final String HDIV_STATE_MANAGER_ATTRIBUTE_KEY = "HDIV_STATE_MANAGER_ATTRIBUTE_KEY";

	public static final String HDIV_STATE_HOLDER_ATTRIBUTE_KEY = "HDIV_STATE_HOLDER_ATTRIBUTE_KEY";

	/** Name of the state parameter for each of the implementations */
	public static final String[] FACES_VIEWSTATE_PARAMNAMES = { "com.sun.faces.VIEW", "javax.faces.ViewState", // SUN RI
			"javax.faces.ViewState", // Since version 1.1.5 of MyFaces
			"jsf_state_64", "jsf_state" // Before version 1.1.5 of MyFaces
			, "jsf_sequence" }; // MyFaces 1.2

	private ConstantsJsf() {
	}
}
