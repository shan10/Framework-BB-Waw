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
 * WWObservable is a class which holds an array of observers to be notified 
 * when certain events occur. 
 * 
 * @author Web@Work websolutions
 * @since 1.0.0
 */
public class WWObservable implements IWWObservable  {

	/**
	 * The Hashtable which holds the observers
	 */
	private WWArrayList observers;

	/**
	 * Create an Observable class which notifies the subscribed objects
	 */
	public WWObservable() {
		
	}

	/**
	 * Get the total of observers
	 * @return	size	
	 */
	public int getObserversCount () {
		
		return observers.size();
	}
	
	/**
	 * @param	IWWObserver o	An observer object
	 */
	public void addObserver(IWWObserver o) {

		if( observers == null ) {
			observers = new WWArrayList();
		}
		observers.add( o );	
	}

	/**
	 * @param	IWWObserver o	An observer object
	 */
	public void deleteObserver(IWWObserver o) {

		if( observers == null ) {
			observers = new WWArrayList();
		}
		
		if( observers.contains(o) ) {
			observers.remove(o);
		}
	}

	/**
	 * @param	IWWObserver o	The observer object
	 */
	public void notifyObservers( IWWNotification notification ) {
		
		if( observers == null ) {
			observers = new WWArrayList();
		}
		
		if( observers != null ) {
			
			Object[] result = observers.toArray();

			if( result.length > 0 ) {

				IWWObserver[] obs = new IWWObserver[result.length];
					
				for(int i = 0; i < result.length; i++ ) {
					
					if( result[i] != null ) {
						obs[i] = (IWWObserver) result[i];
						obs[i].update(notification);
					}
				}
			}
		}
	}
	
}
