package com.mmkarami.colection;

import java.util.Objects;

public interface Collection<E> extends Iterable<E> {

	int size();

	default boolean isEmpty() {
		return size() == 0;
	}

	default boolean contains(Object obj) {
		Iterator<E> iterator = iterator();
		if (obj == null) {
			while (iterator.hasNext()) {
				if (iterator.next() == null)
					return true;
			}
		} else {
			while (iterator.hasNext()) {
				if (obj.equals(iterator.next())) {
					return true;
				}
			}
		}
		return false;
	}

	default boolean add(E e) {
		throw new UnsupportedOperationException("add");
	}

	default boolean remove(E e) {
		Iterator<E> iterator = this.iterator();
		if (e == null) {
			while (iterator.hasNext()) {
				if (iterator.next() == null) {
					iterator.remove();
					return true;
				}
			}
		} else {
			while (iterator.hasNext()) {
				if (e.equals(iterator.hasNext())) {
					iterator.remove();
					return true;
				}
			}
		}
		return false;
	}

	default boolean containsAll(Collection<?> c) {
		Iterator<?> iterator = c.iterator();
		while (iterator.hasNext())
			if (!this.contains(iterator.next()))
				return false;
		return true;
	}

	default boolean addAll(Collection<? extends E> c) {
		boolean modified = false;
		Iterator<? extends E> iterator = c.iterator();
		while (iterator.hasNext()) {
			if (add(iterator.next()))
				modified = true;
		}
		return modified;
	}

	default boolean removeAll(Collection<? extends E> c) {
		Objects.requireNonNull(c);
		boolean modified = false;
		Iterator<? extends E> iterator = c.iterator();
		while (iterator.hasNext()) {
			if (this.contains(iterator.next()))
				this.remove(iterator.next());
		}
		return modified;
	}

	default void clear() {
		Iterator<E> iterator = this.iterator();
		while (iterator.hasNext()) {
			iterator.next();
			iterator.remove();
		}
	}
	
	public Object[] toArray();
}