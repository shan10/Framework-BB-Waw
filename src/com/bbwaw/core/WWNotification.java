/*
 *
 * Copyright 2010 by Web@Work websolutions (www.web-atwork.com)
 *
 *
 * ====================================================================
 *    Licensed to the Apache Software Foundation (ASF) under one
 *    or more contributor license agreements.  See the NOTICE file
 *    distributed with this work for additional information
 *    regarding copyright ownership.  The ASF licenses this file
 *    to you under the Apache License, Version 2.0 (the
 *    "License"); you may not use this file except in compliance
 *    with the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing,
 *    software distributed under the License is distributed on an
 *    "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *    KIND, either express or implied.  See the License for the
 *    specific language governing permissions and limitations
 *    under the License.
 * ====================================================================
 */

package com.bbwaw.core;

/**
 * @author Web@Work websolutions
 * @since 1.0.0
 */
public class WWNotification implements IWWNotification {
	
	private final Object object;
	
	private final Object propertyId;
	
	public WWNotification ( Object o, Object id) {
		
		this.object = o;
		this.propertyId = id;
	}

	/**
	 * Get the object
	 * @return Object
	 */
    public Object getObject()
    {
    	return object;
    }

    /**
     * Get the property object
     * @return Object
     */
    public Object getPropertyId()
    {
    	return propertyId;
    }	
}
