package edu.grinnell.sortingvisualizer.sorts;

import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

public class SortsTest {

	@Test
	public void testSelectionSort() {
		
		//Sorts<Integer> sort = new Sorts<Integer>();
		
		/* Arrays */
		Integer[] arr1 = new Integer[] {};
		Integer[] sortedArr1 = new Integer[] {};
		
		Integer[] arr2 = new Integer[] {1};
		Integer[] sortedArr2 = new Integer[] {1};
		
		Integer[] arr3 = new Integer[] {-5, 0, -2, 20, 14, 3};
		Integer[] sortedArr3 = new Integer[] {-5, -2, 0, 3, 14, 20};
		
		Integer[] arr4 = new Integer[] {-4, -4, 2, 0, 0, 2, 3, 3, 5, 1};
		Integer[] sortedArr4 = new Integer[] {-4, -4, 0, 0, 1, 2, 2, 3, 3, 5};
		
		
		/* Tests */
		Sorts.selectionSort(arr1);
		assertArrayEquals("selectionSort(arr1) == {}", sortedArr1, arr1);
		
		Sorts.selectionSort(arr2);
		assertArrayEquals("selectionSort(arr2) == {1}", sortedArr2, arr2);
		
		Sorts.selectionSort(arr3);
		assertArrayEquals("selectionSort(arr3) == {-5, -2, 0, 3, 14, 20}", sortedArr3, arr3);
		
		Sorts.selectionSort(arr4);
		assertArrayEquals("selectionSort(arr4) == {-4, -4, 0, 0, 1, 2, 2, 3, 3, 5}", sortedArr4, arr4);
	}
	
	@Test
	public void testInsertionSort() {
		/* Arrays */
		Integer[] arr1 = new Integer[] {};
		Integer[] sortedArr1 = new Integer[] {};
		
		Integer[] arr2 = new Integer[] {1};
		Integer[] sortedArr2 = new Integer[] {1};
		
		Integer[] arr3 = new Integer[] {-5, 0, -2, 20, 14, 3};
		Integer[] sortedArr3 = new Integer[] {-5, -2, 0, 3, 14, 20};
		
		Integer[] arr4 = new Integer[] {-4, -4, 2, 0, 0, 2, 3, 3, 5, 1};
		Integer[] sortedArr4 = new Integer[] {-4, -4, 0, 0, 1, 2, 2, 3, 3, 5};
		
		
		/* Tests */
		Sorts.insertionSort(arr1);
		assertArrayEquals("selectionSort(arr1) == {}", sortedArr1, arr1);
		
		Sorts.insertionSort(arr2);
		assertArrayEquals("selectionSort(arr2) == {1}", sortedArr2, arr2);
		
		Sorts.insertionSort(arr3);
		assertArrayEquals("selectionSort(arr3) == {-5, -2, 0, 3, 14, 20}", sortedArr3, arr3);
		
		Sorts.insertionSort(arr4);
		assertArrayEquals("selectionSort(arr4) == {-4, -4, 0, 0, 1, 2, 2, 3, 3, 5}", sortedArr4, arr4);
	}
	
	@Test
	public void testBubbleSort() {
		/* Arrays */
		Integer[] arr1 = new Integer[] {};
		Integer[] sortedArr1 = new Integer[] {};
		
		Integer[] arr2 = new Integer[] {1};
		Integer[] sortedArr2 = new Integer[] {1};
		
		Integer[] arr3 = new Integer[] {-5, 0, -2, 20, 14, 3};
		Integer[] sortedArr3 = new Integer[] {-5, -2, 0, 3, 14, 20};
		
		Integer[] arr4 = new Integer[] {-4, -4, 2, 0, 0, 2, 3, 3, 5, 1};
		Integer[] sortedArr4 = new Integer[] {-4, -4, 0, 0, 1, 2, 2, 3, 3, 5};
		
		
		/* Tests */
		Sorts.bubbleSort(arr1);
		assertArrayEquals("selectionSort(arr1) == {}", sortedArr1, arr1);
		
		Sorts.bubbleSort(arr2);
		assertArrayEquals("selectionSort(arr2) == {1}", sortedArr2, arr2);
		
		Sorts.bubbleSort(arr3);
		assertArrayEquals("selectionSort(arr3) == {-5, -2, 0, 3, 14, 20}", sortedArr3, arr3);
		
		Sorts.bubbleSort(arr4);
		assertArrayEquals("selectionSort(arr4) == {-4, -4, 0, 0, 1, 2, 2, 3, 3, 5}", sortedArr4, arr4);
	}
	
	@Test
	public void testMergeSort() {
		/* Arrays */
		Integer[] arr1 = new Integer[] {};
		Integer[] sortedArr1 = new Integer[] {};
		
		Integer[] arr2 = new Integer[] {1};
		Integer[] sortedArr2 = new Integer[] {1};
		
		Integer[] arr3 = new Integer[] {-5, 0, -2, 20, 14, 3};
		Integer[] sortedArr3 = new Integer[] {-5, -2, 0, 3, 14, 20};
		
		Integer[] arr4 = new Integer[] {-4, -4, 2, 0, 0, 2, 3, 3, 5, 1};
		Integer[] sortedArr4 = new Integer[] {-4, -4, 0, 0, 1, 2, 2, 3, 3, 5};
		
		
		/* Tests */
		Sorts.mergeSort(arr1);
		assertArrayEquals("selectionSort(arr1) == {}", sortedArr1, arr1);
		
		Sorts.mergeSort(arr2);
		assertArrayEquals("selectionSort(arr2) == {1}", sortedArr2, arr2);
		
		Sorts.mergeSort(arr3);
		assertArrayEquals("selectionSort(arr3) == {-5, -2, 0, 3, 14, 20}", sortedArr3, arr3);
		
		Sorts.mergeSort(arr4);
		assertArrayEquals("selectionSort(arr4) == {-4, -4, 0, 0, 1, 2, 2, 3, 3, 5}", sortedArr4, arr4);
	}
	
	@Test
	public void testQuickSort() {
		/* Arrays */
		Integer[] arr1 = new Integer[] {};
		Integer[] sortedArr1 = new Integer[] {};
		
		Integer[] arr2 = new Integer[] {1};
		Integer[] sortedArr2 = new Integer[] {1};
		
		Integer[] arr3 = new Integer[] {-5, 0, -2, 20, 14, 3};
		Integer[] sortedArr3 = new Integer[] {-5, -2, 0, 3, 14, 20};
		
		Integer[] arr4 = new Integer[] {-4, -4, 2, 0, 0, 2, 3, 3, 5, 1};
		Integer[] sortedArr4 = new Integer[] {-4, -4, 0, 0, 1, 2, 2, 3, 3, 5};
		
		
		/* Tests */
		Sorts.quickSort(arr1);
		assertArrayEquals("selectionSort(arr1) == {}", sortedArr1, arr1);
		
		Sorts.quickSort(arr2);
		assertArrayEquals("selectionSort(arr2) == {1}", sortedArr2, arr2);
		
		Sorts.quickSort(arr3);
		assertArrayEquals("selectionSort(arr3) == {-5, -2, 0, 3, 14, 20}", sortedArr3, arr3);
		
		Sorts.quickSort(arr4);
		assertArrayEquals("selectionSort(arr4) == {-4, -4, 0, 0, 1, 2, 2, 3, 3, 5}", sortedArr4, arr4);
	}
	
	@Test
	public void testShellSort() {
		/* Arrays */
		Integer[] arr1 = new Integer[] {};
		Integer[] sortedArr1 = new Integer[] {};
		
		Integer[] arr2 = new Integer[] {1};
		Integer[] sortedArr2 = new Integer[] {1};
		
		Integer[] arr3 = new Integer[] {-5, 0, -2, 20, 14, 3};
		Integer[] sortedArr3 = new Integer[] {-5, -2, 0, 3, 14, 20};
		
		Integer[] arr4 = new Integer[] {-4, -4, 2, 0, 0, 2, 3, 3, 5, 1};
		Integer[] sortedArr4 = new Integer[] {-4, -4, 0, 0, 1, 2, 2, 3, 3, 5};
		
		
		/* Tests */
		Sorts.shellSort(arr1);
		assertArrayEquals("selectionSort(arr1) == {}", sortedArr1, arr1);
		
		Sorts.shellSort(arr2);
		assertArrayEquals("selectionSort(arr2) == {1}", sortedArr2, arr2);
		
		Sorts.shellSort(arr3);
		assertArrayEquals("selectionSort(arr3) == {-5, -2, 0, 3, 14, 20}", sortedArr3, arr3);
		
		Sorts.shellSort(arr4);
		assertArrayEquals("selectionSort(arr4) == {-4, -4, 0, 0, 1, 2, 2, 3, 3, 5}", sortedArr4, arr4);
	}
}