package com.Accolite.app;

import org.apache.commons.lang3.*;

/*

 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * Unit tests for {@link org.apache.commons.lang3.text.CompositeFormat}.
 */
@Deprecated
public class App {

	public String reverseString(String originalString) {

		String reversedString = StringUtils.reverse(originalString);
		return reversedString;
	}

	public boolean containsCheck(String string) {
		boolean contained = StringUtils.containsAny(string, 'a', 'b', 'c');
		return contained;
	}

	public boolean containsCheckInsensitive(String string) {
		boolean contained = StringUtils.containsIgnoreCase(string, "ACBAELDUNG");
		return contained;

	}

	public static void main(String[] args) {

	}

}