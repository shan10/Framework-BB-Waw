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
 * WWNotificationCenter is a class which notify objects which have subscribed. 
 * 
 * @author Web@Work websolutions
 * @since 1.0.0
 */
public final class WWNotificationCenter  {

	/**
	 * A static notification center;
	 */
	private static WWObservable center;
	
	public static WWObservable getDefault () {
		
		if( center == null ) {
			center = new WWObservable();
		}
		return center;
	}

	/**
	 * Get the total of observers
	 * @return	size	
	 */	
	public static int getObserversCount () {
		
		return center.getObserversCount ();
	}
	
	/**
	 * @param	IWWObserver o	An observer object
	 */
	public static void addObserver(IWWObserver o) {

		if( center == null ) {
			center = new WWObservable();
		}
		center.addObserver(o);
		
		System.out.println( center.getObserversCount() );
	}

	/**
	 * @param	IWWObserver o	An observer object
	 */
	public static void deleteObserver(IWWObserver o) {

		if( center == null ) {
			center = new WWObservable();
		}
		center.deleteObserver(o);
	}

	/**
	 * @param	IWWObserver o	The observer object
	 */
	public static void notifyObservers( IWWNotification notification ) {
		
		if( center == null ) {
			center = new WWObservable();
		}
		center.notifyObservers(notification);
	}

}
