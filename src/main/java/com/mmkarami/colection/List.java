package com.mmkarami.colection;

public interface List<E> extends Collection<E>, ListIterable<E> {

	default public void add(int index, E element) {
		throw new UnsupportedOperationException("add.");
	}

	default public boolean add(E element) {
		add(size(), element);
		return true;
	}

	public E get();

	public E set(int idex, E element);

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
}
