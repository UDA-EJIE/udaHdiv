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

import java.util.List;

import com.ejie.hdiv.context.RequestContextHolder;

public interface EntityStateRecorder<T> {

	public void registerEntity(final List<T> links, final Class<?> entityClass, final String idValue, final String propertyName,
			final RequestContextHolder ctx);

	public Object ofuscate(final Object value, final Class<?> target, final String propertyName);
}
