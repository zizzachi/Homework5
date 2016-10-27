package edu.grinnell.sortingvisualizer.sorts;

import java.util.*;

import edu.grinnell.sortingvisualizer.sortevents.CompareEvent;
import edu.grinnell.sortingvisualizer.sortevents.CopyEvent;
import edu.grinnell.sortingvisualizer.sortevents.SortEvent;
import edu.grinnell.sortingvisualizer.sortevents.SwapEvent;

public class SortEventsTesting {
	
	private static <T> void swap(T[] arr, int i, int j) {
		T temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	private static <T extends Comparable<T>> int findMedianIndex(T[] arr, int i, int j, int k) {
		T val1 = arr[i];
		T val2 = arr[j];
		T val3 = arr[k];
		if((val1.compareTo(val2) <= 0 && val1.compareTo(val3) >= 0)
				|| (val1.compareTo(val2) >= 0 && val1.compareTo(val3) <= 0)) {
			return i;
		} else if((val2.compareTo(val1) <= 0 && val2.compareTo(val3) >= 0)
				|| (val2.compareTo(val1) >= 0 && val2.compareTo(val3) <= 0)) {
			return j;
		} else {
			return k;
		}
	}
	
	/** Takes an array and sorts it one element at a time by walking through the array and
	 * finding a minimum value before moving it to the end of the sorted sub-array at the front
	 * of the array
	 * @param arr and array of integers
	 */
	public static <T extends Comparable<T>> List<SortEvent<T>> selectionSort(T[] arr) {
		List<SortEvent<T>> events = new ArrayList<SortEvent<T>>();
		for(int i = 0; i < arr.length; i++) {
			int min = i;
			
			for(int j = i; j < arr.length; j++) {
				if(arr[j].compareTo(arr[min]) < 0) {
					events.add(new CompareEvent<T>(j, min));
					min = j;
				}
			}
			
			events.add(new SwapEvent<T>(i, min));
			swap(arr, i, min);
		}
		return events;
	}
	
	/** Takes an array and inserts next element of the unsorted sub-array into its proper
	 * location in the sorted sub-array
	 * @param arr and array of integers
	 */
	public static <T extends Comparable<T>> List<SortEvent<T>> insertionSort(T[] arr) {
		List<SortEvent<T>> events = new ArrayList<SortEvent<T>>();
		for(int i = 1; i < arr.length; i++) {
			int j = i; //index of unsorted element
			
			while(j > 0 && arr[j - 1].compareTo(arr[j]) > 0) {
				
				/* Add events */
				events.add(new CompareEvent<T>(j - 1, j));
				events.add(new SwapEvent<T>(j - 1, j));
				
				swap(arr, j - 1, j);
				j--;
			}
		}
		return events;
	}
	
	/** Takes an array and performs the sorting algorithm mergeSort on it
	 * 
	 * Takes an array and recursively sorts it by breaking the array into two halves
	 * and sorts those halves recursively.
	 * 
	 * @param arr an array of type T
	 */
	public static <T extends Comparable<T>> List<SortEvent<T>> mergeSort(T[] arr) {
		List<SortEvent<T>> events = new ArrayList<SortEvent<T>>();
		T[] trash = Arrays.copyOf(arr, arr.length);
		mergeSort(arr, 0, arr.length, trash, events);
		
		return events;
	}
	
	/** Recursively sorts arr by recursively breaking it into two sub-arrays and then merges
	 * the two sorted sub-arrays together into a sorted whole array, arr
	 * @param arr an array of type T
	 * @param low lower bound of arr
	 * @param high upper bound of arr
	 */
	private static <T extends Comparable<T>> void mergeSort(T[] arr, int low, int high,
			T[] trash, List<SortEvent<T>> events) {
		
		if(high - low > 1) {
			int mid = (high + low)/2;
			
			mergeSort(arr, low, mid, trash, events);
			mergeSort(arr, mid, high, trash, events);
			merge(arr, low, mid, high, trash, events);
		} 
	}
	
	/** Merges two sub-arrays together into a whole sorted array
	 * @param arr an array of type T
	 * @param low lower bound of first subarray
	 * @param mid upper bound of first subarray, and lower bound of second subarray
	 * @param high upper bound of second subarray
	 * @return arr a sorted array
	 */
	public static <T extends Comparable<T>> void merge(T[] arr, int low, int mid, int high,
			T[] trash, List<SortEvent<T>> events) {
		
		int i = low;
		int j = mid;
		int k = low;
		
		/* Determine whether an element from the first or second sorted sub-array is
		 * needed to be put into arr at the given index
		 */
		while(i < mid && j < high) {
			events.add(new CompareEvent<T>(i, j));
			
			if(trash[i].compareTo(trash[j]) < 0) {
				events.add(new CopyEvent<T>(k, trash[i]));
				arr[k++] = trash[i++];
			} else {
				events.add(new CopyEvent<T>(k, trash[j]));
				arr[k++] = trash[j++];
			}
		}
		/* Fill in the rest of arr with the first sorted sub-array */
		while(i < mid) {
			events.add(new CopyEvent<T>(k, trash[i]));
			arr[k++] = trash[i++];
		}
		/* Fill in the rest of arr with the second sorted sub-array */
		while(j < high) {
			events.add(new CopyEvent<T>(k, trash[j]));
			arr[k++] = trash[j++];
		}
		/* Sort appropriate trash array elements */
		for(int x = low; x < high; x ++) {
			trash[x] = arr[x];
		}
	}
	
	/** Takes an array and performs the sorting algorithm quickSort on it
	 * @param arr an array of type T
	 */
	public static <T extends Comparable<T>> List<SortEvent<T>> quickSort(T[] arr) {
		List<SortEvent<T>> events = new ArrayList<SortEvent<T>>();
		quickSort(arr, 0, arr.length - 1, events);
		
		return events;
	}
	
	/** Takes an array and finds the pivot point within the array. Then sorts
	 * the array relative to that pivot point to achieve the correct position for 
	 * that pivot point. Then recursively sorts the remaining two halves of the array
	 * in a similar fashion
	 * @param arr an array of type T
	 * @param low the lower bound of the array being sorted
	 * @param high the upper bound of the array being sorted
	 */
	public static <T extends Comparable<T>> void quickSort(T[] arr, int low, int high,
			List<SortEvent<T>> events) {
		
		if(high - low > 0) {
		    int pivotIndex = findMedianIndex(arr, low, high, (high - low)/2 + low);
			int i = low;
			int j = high;
			
//			System.out.println("pivotIndex is: " + pivotIndex);
//			System.out.println("low is: " + low);
//			System.out.println("high is: " + high);
//			System.out.println("arr is: " + Arrays.toString(arr));
			swap(arr, low, pivotIndex);
			T pivot = arr[low];
			
			
			while(i < j) {
				while(arr[j].compareTo(pivot) > 0) {
					events.add(new CompareEvent<T>(j, low));
					j--;
				}
				events.add(new CopyEvent<T>(i, arr[j]));
				arr[i] = arr[j];

				while(arr[i].compareTo(pivot) <= 0) {
					events.add(new CompareEvent<T>(i, low));
					if(i < j) {
						i++;
					} else {
						break;
					}
				}
				events.add(new CopyEvent<T>(j, arr[i]));
				arr[j] = arr[i];

			}
			events.add(new CopyEvent<T>(i, pivot));
			arr[i] = pivot;
			
			if(low < i - 1) {
				quickSort(arr, low, i - 1, events);
			}
			if(i + 1 < high) {
				quickSort(arr, i + 1, high, events);
			}
		}
	}

	/** Takes an array and "bubbles" the largest values to the top until the array is sorted
	 * @param arr an array of type T
	 */
	public static<T extends Comparable<T>> List<SortEvent<T>> bubbleSort(T[] arr) {
		List<SortEvent<T>> events = new ArrayList<SortEvent<T>>();
		for(int i = arr.length; i > 1; i--) {
			for(int j = 0; j < i - 1; j++) {	
				if(arr[j].compareTo(arr[j + 1]) > 0) {		
					events.add(new CompareEvent<T>(j, j + 1));
					events.add(new SwapEvent<T>(j, j + 1));
					
					swap(arr, j, j + 1);
				}
			}
		}
		return events;
	}
	
	/** Takes an array and sorts it by comparing and sorting elements within the array
	 * that are far apart and then progressively decreases the gap size until the entire
	 * array is sorted
	 * @param arr
	 */
	public static <T extends Comparable<T>> List<SortEvent<T>> shellSort(T[] arr) {
		List<SortEvent<T>> events = new ArrayList<SortEvent<T>>();
	    // loop over the gaps
	    for (int gap = arr.length / 2; gap > 0; gap /= 2) {
	        // do the insertion sort
	        for (int i = gap; i < arr.length; i++) {
	            T val = arr[i];
	            int j;
	            
	            for (j = i; j >= gap && arr[j - gap].compareTo(val) > 0; j -= gap) {
	            	events.add(new CompareEvent<T>(j - gap, i));
	            	events.add(new CopyEvent<T>(j, arr[j - gap]));
	            	
	                arr[j] = arr[j - gap];
	            }
	            
	            events.add(new CopyEvent<T>(j, val));
	            arr[j] = val;
	        }
	    }
	    return events;
	}
	
	/** Applies the list of SortEvents to the array in-order
	 * @param arr an array of type T
	 * @param events a list of SortEvents
	 */
	public static <T extends Comparable<T>> void eventSort(T[] arr, List<SortEvent<T>> events) {
		int i = 0;
		while(i < events.size()) {
			events.get(i).apply(arr);
			i++;
		}
	}

	public static void main(String[] args) {
		List<SortEvent<Integer>> events = new ArrayList<SortEvent<Integer>>();
		Integer[] arr = new Integer[] {0, -7, 1, 32, 56, 100, 1};
		
		events = quickSort(arr);

		Integer[] arr1 = new Integer[] {0, -7, 1, 32, 56, 100, 1};
		System.out.println(Arrays.toString(arr1));
		eventSort(arr1, events);
		System.out.println(Arrays.toString(arr1));
	}

}
