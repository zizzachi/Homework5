package edu.grinnell.sortingvisualizer.sorts;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import edu.grinnell.sortingvisualizer.sortevents.SortEvent;

public class SortsTest {
	
	//@Test/
	public static void applyTest(String sort) {
		/* Arrays */
		Integer[] arr1 = new Integer[] {};
		Integer[] copyArr1 = Arrays.copyOf(arr1, arr1.length);
		List<SortEvent<Integer>> eventsArr1;
		Integer[] sortedArr1 = new Integer[] {};
		
		Integer[] arr2 = new Integer[] {1};
		Integer[] copyArr2 = Arrays.copyOf(arr2, arr2.length);
		List<SortEvent<Integer>> eventsArr2;
		Integer[] sortedArr2 = new Integer[] {1};
		
		Integer[] arr3 = new Integer[] {-5, 0, -2, 20, 14, 3};
		Integer[] copyArr3 = Arrays.copyOf(arr3, arr3.length);
		List<SortEvent<Integer>> eventsArr3;
		Integer[] sortedArr3 = new Integer[] {-5, -2, 0, 3, 14, 20};
		
		Integer[] arr4 = new Integer[] {-4, -4, 2, 0, 0, 2, 3, 3, 5, 1};
		Integer[] copyArr4 = Arrays.copyOf(arr4, arr4.length);
		List<SortEvent<Integer>> eventsArr4;
		Integer[] sortedArr4 = new Integer[] {-4, -4, 0, 0, 1, 2, 2, 3, 3, 5};
		
		
		/* Tests */
		switch (sort) {
        case "Selection":
        	eventsArr1 = Sorts.selectionSort(arr1);
        	eventsArr2 = Sorts.selectionSort(arr2);
        	eventsArr3 = Sorts.selectionSort(arr3);
        	eventsArr4 = Sorts.selectionSort(arr4);
    		break;
        case "Insertion":
        	eventsArr1 = Sorts.insertionSort(arr1);
        	eventsArr2 = Sorts.insertionSort(arr2);
        	eventsArr3 = Sorts.insertionSort(arr3);
        	eventsArr4 = Sorts.insertionSort(arr4);
    		break;
        case "Bubble":
        	eventsArr1 = Sorts.bubbleSort(arr1);
        	eventsArr2 = Sorts.bubbleSort(arr2);
        	eventsArr3 = Sorts.bubbleSort(arr3);
        	eventsArr4 = Sorts.bubbleSort(arr4);
    		break;
        case "Merge":
        	eventsArr1 = Sorts.mergeSort(arr1);
        	eventsArr2 = Sorts.mergeSort(arr2);
        	eventsArr3 = Sorts.mergeSort(arr3);
        	eventsArr4 = Sorts.mergeSort(arr4);
    		break;
        case("Quick"):
        	eventsArr1 = Sorts.quickSort(arr1);
        	eventsArr2 = Sorts.quickSort(arr2);
        	eventsArr3 = Sorts.quickSort(arr3);
			eventsArr4 = Sorts.quickSort(arr4);
			break;
        case("Shell"):
        	eventsArr1 = Sorts.shellSort(arr1);
        	eventsArr2 = Sorts.shellSort(arr2);
        	eventsArr3 = Sorts.shellSort(arr3);
        	eventsArr4 = Sorts.shellSort(arr4);
			break;
        default:
            throw new IllegalArgumentException("generateEvents");
        }
		
		assertArrayEquals(sort + "(arr1) == {}", sortedArr1,  arr1);
		Sorts.eventSort(copyArr1, eventsArr1);
		assertArrayEquals(sort + "(arr1) == {}", sortedArr1, copyArr1);
		
		assertArrayEquals(sort + "(arr2) == {1}", sortedArr2, arr2);
		Sorts.eventSort(copyArr2, eventsArr2);
		assertArrayEquals(sort + "(arr2) == {1}", sortedArr2, copyArr2);
		
		assertArrayEquals(sort + "(arr3) == {-5, -2, 0, 3, 14, 20}", sortedArr3, arr3);
		Sorts.eventSort(copyArr3, eventsArr3);
		assertArrayEquals(sort + "(arr3) == {-5, -2, 0, 3, 14, 20}", sortedArr3, copyArr3);
		
		assertArrayEquals(sort + "(arr4) == {-4, -4, 0, 0, 1, 2, 2, 3, 3, 5}", sortedArr4, arr4);
		Sorts.eventSort(copyArr4, eventsArr4);
		assertArrayEquals(sort + "(arr4) == {-4, -4, 0, 0, 1, 2, 2, 3, 3, 5}", sortedArr4, copyArr4);
	}

	@Test
	public void testSelectionSort() {
		applyTest("Selection");
	}
		
	
	@Test
	public void testInsertionSort() {
		applyTest("Insertion");
	}
	
	@Test
	public void testBubbleSort() {
		applyTest("Bubble");
	}
	
	@Test
	public void testMergeSort() {
		applyTest("Merge");
	}
	
	@Test
	public void testQuickSort() {
		applyTest("Quick");
	}
	
	@Test
	public void testShellSort() {
		applyTest("Shell");
	}
}