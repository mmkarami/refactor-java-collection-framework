package com.mmkarami.colection;

public interface ListIterator<E> extends Iterator<E> {

	boolean hasNext();
	
	E next();
	
	int nextIndex();
	
	boolean hasPrevious();
	
	E previous();
	
	int previousIndex();
	
	void remove();
	
	void set();
	
	void add();
}