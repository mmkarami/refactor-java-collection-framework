package com.mmkarami.colection;

import java.util.Arrays;

public interface List<E> extends Collection<E>, ListIterable<E> {

	default public void add(int index, E element) {
		throw new UnsupportedOperationException("add.");
	}

	default public boolean add(E element) {
		add(size(), element);
		return true;
	}

	public E get(int index);

	public E set(int index, E element);

	default public int indexOf(E e) {
		ListIterator<E> iterator = listIterator();

		if (e == null) {
			while (iterator.hasNext()) {
				if (iterator.next() == null)
					return iterator.previousIndex();
			}
		} else {
			while (iterator.hasNext()) {
				if (e.equals(iterator.next())) {
					return iterator.previousIndex();
				}
			}
		}
		return -1;
	}

	default public int lastIndexOf(E e) {
		ListIterator<E> iterator = listIterator();

		if (e == null) {
			while (iterator.hasPrevious()) {
				if (iterator.previous() == null) {
					return iterator.previousIndex();
				}
			}
		} else {
			while (iterator.hasPrevious()) {
				if (e.equals(iterator.previous())) {
					return iterator.previousIndex();
				}
			}
		}
		return -1;
	}

	default void clear() {
		removeRange(0, size());
	}

	private void removeRange(int fromIndex, int toIndex) {
		Iterator<E> iterator = iterator();
		for (int i = fromIndex, n = toIndex - fromIndex; i < n; i++) {
			iterator.next();
			iterator.remove();
		}
	}

	default boolean addAll(int index, Collection<? extends E> c) {
		boolean modified = false;
		Iterator<E> iterator = iterator();
		while (iterator.hasNext()) {
			add(index++, iterator.next());
			modified = true;
		}
		return modified;
	}

	default public Object[] toArray() {
		Object[] newArray = new Object[size()];
		Iterator<E> it = iterator();
		for (int i = 0; i < newArray.length; i++) {
			if (!it.hasNext()) {// fewer elements than expected
				Object[] trimedArray = Arrays.copyOf(newArray, i);
				return trimedArray;
			}
			newArray[i] = it.next();
		}
		return it.hasNext() ? finishToArray(newArray, it) : newArray;
	}

	private Object[] finishToArray(Object[] r, Iterator<?> it) {
		int len = r.length;
		int i = len;
		while (it.hasNext()) {
			if (i == len) {
				/*
				 * len = ArraysSupport.newLength(len, 1, minimum growth (len >> 1) + 1 preferred
				 * growth );
				 */
				r = Arrays.copyOf(r, len);
			}
			r[i++] = (Object) it.next();
		}
		// trim if overallocated
		return (i == len) ? r : Arrays.copyOf(r, i);
	}
}
