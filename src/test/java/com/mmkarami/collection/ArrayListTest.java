package com.mmkarami.collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ArrayListTest {

	@Test
	public void testEmtyInitialization_whenInitialArrayListEmpty_thenArrayListSizeShouldBeZero() {
		// Arrange
		ArrayList<String> arrayList;

		// Act
		arrayList = new ArrayList<String>();

		// Assert
		assertEquals(0, arrayList.size(), "Expecting 0 value.");
	}

	@Test
	public void testInitializationBySpecificSize_whenInitialArrayListViaSpecificSize_thenArrayListSizeMustBeZero() {
		// Arrange
		ArrayList<Integer> arrayList;

		// Act
		arrayList = new ArrayList<>(7);

		// Assert
		assertEquals(0, arrayList.size(), "Expecting 7 value.");
	}
	
	@Test
	public void testSize_whenAddOneElement_thenSizeMustBeOne() {
		// Arrange
		ArrayList<String> arrayList = new ArrayList<String>(10);
		
		//Act
		arrayList.add("First");
		
		//Assert
		assertEquals(1, arrayList.size(), "Expecting 1.");
	}
	
	@Test
	public void testGrow_whenAddMoreThanDefaultCapacity_thenArrayListSizeMustBeGrow() {
		//Arrange
		ArrayList<Integer> arrayList = new ArrayList<>();
		
		//Act
		arrayList.add(1);
		arrayList.add(2);
		arrayList.add(3);
		arrayList.add(4);
		arrayList.add(5);
		arrayList.add(6);
		arrayList.add(7);
		arrayList.add(8);
		arrayList.add(9);
		arrayList.add(10);
		arrayList.add(11);
		
		//Assert
		assertEquals(11, arrayList.size(), "Expecting 11.");
	}
}