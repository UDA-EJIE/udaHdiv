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
/*
 * Copyright (c) 2014. Escalon System-Entwicklung, Dietrich Schulten
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
 */

package com.ejie.hdiv.services;

import java.util.List;

public class StringOptions implements Options<SuggestObjectWrapper> {

	/**
	 * Allows to specify possible values for an argument. This allows an {@link ActionDescriptor} to determine possible values for an action
	 * argument. The example below defines four possible values for the <code>mood</code> parameter.
	 * 
	 * <pre>
	 * &#0064;RequestMapping(value = "/customer", method = RequestMethod.GET, params = { "mood" })
	 * public HttpEntity&lt;SamplePersonResourcegt; showPersonByMood(
	 *     &#0064;RequestParam &#0064;Select({ "angry", "happy", "grumpy", "bored" })
	 *     String mood) {
	 *     ...
	 * }
	 * </pre>
	 */
	public List<Suggest<SuggestObjectWrapper>> get(final String[] value, final Object... args) {
		return SimpleSuggest.wrap(value);
	}
}
