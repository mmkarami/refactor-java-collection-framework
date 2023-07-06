package com.mmkarami.collection;

import java.util.Objects;
import java.util.function.Consumer;

public interface Iterable<T> {

	Iterator<T> iterator();

	default void forEach(Consumer<? super T> action) {
		Objects.requireNonNull(action);
		Iterator<T> iterator = iterator();
		while (iterator.hasNext()) {
			action.accept(iterator.next());
		}
	}
}