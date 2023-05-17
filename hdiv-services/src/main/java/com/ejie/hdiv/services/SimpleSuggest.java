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
package com.ejie.hdiv.services;

import java.util.ArrayList;
import java.util.List;

public class SimpleSuggest<T> extends SuggestImpl<SuggestObjectWrapper> {

	public SimpleSuggest(final String svalue) {
		this(new SuggestObjectWrapper(svalue));
	}

	public SimpleSuggest(final SuggestObjectWrapper wrapper) {
		super(wrapper, SuggestObjectWrapper.ID);
	}

	public static <T> List<Suggest<SuggestObjectWrapper>> wrap(final T[] values) {
		List<Suggest<SuggestObjectWrapper>> suggests = new ArrayList<Suggest<SuggestObjectWrapper>>(values.length);
		for (int i = 0; i < values.length; i++) {
			suggests.add(new SimpleSuggest<T>(new SuggestObjectWrapper(String.valueOf(values[i]))));
		}
		return suggests;
	}

}
