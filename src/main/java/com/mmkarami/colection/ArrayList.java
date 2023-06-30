package com.mmkarami.colection;

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

public class ArrayList<E> implements List<E>, Cloneable {

	private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

	private static final Object[] EMPTY_ELEMENTDATA = {};

	private static final int DEFAULT_CAPACITY = 10;

	private int size;

	private transient Object[] elementData;

	public ArrayList() {
		elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
	}

	public ArrayList(int initialCapacity) {
		if (initialCapacity > 0) {
			elementData = new Object[initialCapacity];
		} else if (initialCapacity == 0) {
			elementData = EMPTY_ELEMENTDATA;
		}
	}

	public ArrayList(Collection<? extends E> collection) {
		Objects.requireNonNull(collection);
		Object[] array = collection.toArray();
		if ((size = array.length) == 0) {
			elementData = EMPTY_ELEMENTDATA;
		} else {
			if (collection.getClass() == ArrayList.class) {
				elementData = array;
			} else {
				elementData = Arrays.copyOf(array, size, Object[].class);
			}
		}
	}

	public void trimToSize() {
		if (elementData.length > size) {
			elementData = (size == 0) ? EMPTY_ELEMENTDATA : Arrays.copyOf(elementData, size);
		}
	}

	public int size() {
		return size;
	}

	public void ensureCapacity(int minCapacity) {
		if (minCapacity > elementData.length
				&& !(elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA && minCapacity <= DEFAULT_CAPACITY)) {
			grow(minCapacity);
		}
	}

	private Object[] grow(int minCapacity) {
		int oldCapacity = elementData.length;
		if (oldCapacity > 0 || elementData != DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
			/*
			 * int newCapacity = ArraysSupport.newLength(oldCapacity, minCapacity -
			 * oldCapacity, minimum growth oldCapacity >> 1 preferred growth );
			 */
			return elementData = Arrays.copyOf(elementData, minCapacity);
		} else {
			return elementData = new Object[Math.max(DEFAULT_CAPACITY, minCapacity)];
		}
	}

	public Object clone() {
		try {
			ArrayList<?> arrayList = (ArrayList<?>) super.clone();
			arrayList.elementData = Arrays.copyOf(elementData, size);
			return arrayList;
		} catch (CloneNotSupportedException e) {
			// this shouldn't happen, since we are Cloneable
			throw new InternalError(e);
		}
	}

	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	public ListIterator<E> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	public E get(int index) {
		Objects.checkIndex(index, size);
		return elementData(index);
	}

	public E set(int index, E element) {
		Objects.checkIndex(index, size);
		E oldValue = elementData(index);
		elementData[index] = element;
		return oldValue;
	}

	@SuppressWarnings("unchecked")
	E elementData(int index) {
		return (E) elementData[index];
	}

	private void add(E e, Object[] elementData, int index) {
		if (index == elementData.length)
			elementData = grow();
		elementData[index] = e;
		size = index + 1;
	}

	public boolean add(E e) {
		add(e, elementData, size);
		return true;
	}

	public void add(int index, E element) {
		final int s;
		Object[] elementData;
		if ((s = size) == (elementData = this.elementData).length)
			elementData = grow();
		System.arraycopy(elementData, index, elementData, index + 1, s - index);
		elementData[index] = element;
		size = s + 1;
	}
	
	private Object[] grow() {
        return grow(size + 1);
    }
}