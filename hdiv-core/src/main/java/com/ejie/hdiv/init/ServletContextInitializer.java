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
package com.ejie.hdiv.init;

import javax.servlet.ServletContext;

/**
 * Initializes and destroys {@link ServletContext} scoped attributes.
 * 
 * @since 2.1.10
 */
public interface ServletContextInitializer {

	/**
	 * Initialize {@link ServletContext} scoped attributes.
	 * 
	 * @param servletContext {@link ServletContext} instance
	 */
	void initializeServletContext(ServletContext servletContext);

	/**
	 * Clean {@link ServletContext} scoped attributes.
	 * 
	 * @param servletContext {@link ServletContext} instance
	 */
	void destroyServletContext(ServletContext servletContext);
}
