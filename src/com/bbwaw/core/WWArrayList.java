package com.bbwaw.core;

/**
 * This class holds an array which grows dynamically
 * 
 * @author Web@Work websolutions
 * @since 1.0.0
 */
public class WWArrayList {
	
	/**
	 * The initial capacity of the array
	 */
	protected int startCapacity = 5;
	
	/**
	 * Counter for storing elements 
	 */
	protected int counter = 0;
	
	/**
	 * The array to array the objects in
	 */
	protected Object[] array;
	
	/**
	 * Create an ArrayList, which holds an array. 
	 * Operations such as add, delete and replacing are supported
	 */
	public WWArrayList() {
		
		array = new Object[startCapacity];
	}

	/**
	 * 
	 * @param elements
	 */
	public WWArrayList( Object[] elements ) {
		
		int c = 0;
		for(int i=0; i < elements.length; i++) {
			if( elements[i] != null ) {
				c++;
			}
		}
		
		counter = c;
		array = elements;
	}
	
	/**
	 * Constructor
	 * @param initialCapacity
	 */
	public WWArrayList(int capacity) {
		
		 if (capacity < 0) {
			 throw new IllegalArgumentException();
		 }
		 
		array = new Object[capacity];
	}

	/**
	 *  Insert element at a position in the array
	 *  
	 * @param index
	 * @param element
	 */
	public void add ( int index, Object element ) {
		
		if(element == null) {
			throw new NullPointerException();
		}
		if ( ! this.contains(element) ) { 
		
			if( index < array.length ) {
				
				array[index] = element;
			}
			else {
				
				int newSize = index + startCapacity;
				Object[] newStore = new Object[newSize];
				System.arraycopy(array, 0, newStore, 0, array.length);
				array = newStore;
				array[index] = element;
			}
			counter++;
		}
	}
	
	/**
	 * Insert element at the last position in the array.
	 * 
	 * @param element	object
	 */
	public boolean add ( Object element ) {
		
		if(element == null) return false;
		if ( this.contains(element) ) return false; 
		
		if( counter < array.length ) {
			
			array[ counter ] = element;
			counter++;
		}
		else {

			//
			// First check if the array doesn't contains null values
			//
			int r = hasNullValue ();
			if( r != -1 ) {
				array[ r ] = element;
				counter++;
			}
			else {
				this.increaseArray(element);
				array[ counter ] = element;
				counter++;
			}
		}
		return true;
	}
	
	/**
	 * Check if the array contains null values
	 * 
	 * @return	the first index which has a null value
	 */
	private int hasNullValue () {
		
		for( int i = array.length-1; i >= 0; i-- ) {
			
			if( array[i] == null ) {
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * Icrease the size of the array dynamically
	 * 
	 * @param element
	 */
	private void increaseArray ( Object element ) {
		
		int newSize = array.length + startCapacity;
		Object[] newStore = new Object[newSize];
		System.arraycopy(array, 0, newStore, 0, array.length);
		array = newStore;
	}
	
	/**
	 * Removes all of the elements from this list.
	 */
	public void clear () {
		
		array = new Object[startCapacity];
		counter = 0;
	}
	
	/**
	 * Returns a shallow copy of this ArrayList instance.
	 * @return Object	WWArrayList
	 */
	public WWArrayList clone() {
		
		WWArrayList tmp = new WWArrayList( array );
		return tmp;
	}
	
	/**
	 * Returns true if this list contains the specified element.
	 * 
	 * @param element
	 * @return	boolean	true on success
	 */
	public boolean contains ( Object element ) {
		
		if( element == null ) return false;
		
		for( int i = 0; i < array.length; i++ ) {
			
			if(  array[i] != null &&  array[i].equals(element ) ) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 *  Returns element at the given position
	 *  
	 * @param index
	 * @return	
	 */
	public Object get (int index) {
		
		if( index < array.length ) {
			
			return array[index];
		}
		throw new IndexOutOfBoundsException( "IndexOutOfBoundsException" );
	}
	
	/**
	 *  Tests if this list has no elements.
	 * @return	true on success
	 */
	public boolean isEmpty () {
		
		for( int i = 0; i < array.length; i++ ) {
			if( array[i] != null ) return false;
		}
		return true;
	}
	
	/**
	 * Removes the element at the specified position in this list.
	 * 
	 * @param index
	 */
	public boolean remove (int index) {
		
		if( index < 0 ) {
			return false;
		}
		
		if( index < array.length ) {

			int newSize = array.length ;
			Object[] newStore = new Object[newSize];
			
			for( int i = 0; i < array.length; i++ ) {
				if( i != index ) {
					newStore[i] = array[i];
				}
			}
			array = newStore;
			if( counter > 0 ) counter--;
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * Removes the element
	 * 
	 * @param index
	 */
	public boolean remove (Object element) {
		
		for( int i = 0; i < array.length; i++ ) {
			if(  array[i] != null &&  array[i].equals(element ) ) {
				this.remove(i);	
			}
		}
		return false;
	}
	
	/**
	 * Replaces the element at the specified position in this list with the specified element.
	 * 
	 * @param index
	 * @param element
	 * @return
	 */
	public Object set (int index, Object element ) {
		
		if( index < array.length ) {
			
			array[index] = element;
			counter++;
		}
		return element;
	}
	
	/**
	 * Returns the number of elements in this list.
	 * 
	 * @return int size
	 */
	public int size () {

		return counter;
	}
	
	/**
	 * Returns an array containing all of the elements in this list in the correct order.
	 * 
	 * @return
	 */
	public Object[] toArray() {
		
		Object[] result = new Object[counter];
		
		int c = 0;
		for( int i = 0; i < array.length; i++ ) {
			if( array[i] != null ) {
				result[c] = array[i];
				c++;       
			}
		}
		return result;
	}
	
}