package edu.grinnell.sortingvisualizer.sorts;

import java.util.Arrays;
import java.util.List;
import edu.grinnell.sortingvisualizer.sortevents.*;

public class Sorts<T> {
	
	/** Takes an array and sorts it one element at a time by walking through the array and
	 * finding a minimum value before moving it to the end of the sorted sub-array at the front
	 * of the array
	 * @param arr and array of integers
	 */
	public static <T extends Comparable<T>> void selectionSort(T[] arr) {
		for(int i = 0; i < arr.length; i++) {
			int min = i;
			for(int j = i; j < arr.length; j++) {
				if(arr[j].compareTo(arr[min]) < 0) {
					min = j;
				}
			}
			T temp = arr[i];
			arr[i] = arr[min];
			arr[min] = temp;
		}
	}
	
	/** Takes an array and inserts next element of the unsorted sub-array into its proper
	 * location in the sorted sub-array
	 * @param arr and array of integers
	 */
	public static <T extends Comparable<T>> void insertionSort(T[] arr) {
		for(int i = 1; i < arr.length; i++) {
			int j = i; //index of unsorted element
			while(j > 0 && arr[j - 1].compareTo(arr[j]) > 0) {
				T temp = arr[j];
				arr[j] = arr[j - 1];
				arr[j - 1] = temp;
				j--;
			}
		}
	}
	
	/** Takes an array and performs the sorting algorithm mergeSort on it
	 * 
	 * Takes an array and recursively sorts it by breaking the array into two halves
	 * and sorts those halves recursively.
	 * 
	 * @param arr an array of type T
	 */
	public static <T extends Comparable<T>> void mergeSort(T[] arr) {
		mergeSort(arr, 0, arr.length);
	}
	
	/** Recursively sorts arr by recursively breaking it into two sub-arrays and then merges
	 * the two sorted sub-arrays together into a sorted whole array, arr
	 * @param arr an array of type T
	 * @param low lower bound of arr
	 * @param high upper bound of arr
	 */
	private static <T extends Comparable<T>> void mergeSort(T[] arr, int low, int high) {
		if(high - low > 1) {
			int mid = (high + low)/2;
			mergeSort(arr, low, mid);
			mergeSort(arr, mid, high);
			merge(arr, low, mid, high);
		}
	}
	
	/** Merges two sub-arrays together into a whole sorted array
	 * @param arr an array of type T
	 * @param low lower bound of first subarray
	 * @param mid upper bound of first subarray, and lower bound of second subarray
	 * @param high upper bound of second subarray
	 * @return arr a sorted array
	 */
	public static <T extends Comparable<T>> T[] merge(T[] arr, int low, int mid, int high) {
		//http://stackoverflow.com/questions/529085/how-to-create-a-generic-array-in-java
		//T[] newarr = (T[])new Object[high - low];
		T[] newarr = Arrays.copyOf(arr, arr.length);
		int i = low;
		int j = mid;
		int k = low;
		while(i < mid && j < high) {
			if(newarr[i].compareTo(newarr[j]) < 0) {
				arr[k++] = newarr[i++];
			} else {
				arr[k++] = newarr[j++];
			}
		}
		while(i < mid) {
			arr[k++] = newarr[i++];
		}
		while(j < high) {
			arr[k++] = newarr[j++];
		}
		return arr;
	}
	
	/** Takes an array and performs the sorting algorithm quickSort on it
	 * @param arr an array of type T
	 */
	public static <T extends Comparable<T>> void quickSort(T[] arr) {
		quickSort(arr, 0, arr.length - 1);
	}
	
	/** Takes an array and finds the pivot point within the array. Then sorts
	 * the array relative to that pivot point to achieve the correct position for 
	 * that pivot point. Then recursively sorts the remaining two halves of the array
	 * in a similar fashion
	 * @param arr an array of type T
	 * @param low the lower bound of the array being sorted
	 * @param high the upper bound of the array being sorted
	 */
	public static <T extends Comparable<T>> void quickSort(T[] arr, int low, int high) {
		if(high - low > 0) {
		    T pivot = arr[low];
			int i = low;
			int j = high;
			while(i < j) {
				while(arr[j].compareTo(pivot) > 0) {
					j--;
				}
				arr[i] = arr[j];

				while(arr[i].compareTo(pivot) <= 0) {
					if(i < j) {
						i++;
					} else {
						break;
					}
				}
				arr[j] = arr[i];

			}
			arr[i] = pivot;
			
			if(low < i - 1) {
				quickSort(arr, low, i - 1);
			}
			if(i + 1 < high) {
				quickSort(arr, i + 1, high);
			}
		}
	}
	
	
	public static <T extends Comparable<T>> void onePass(T[] arr, int n) {
		for(int i = 0; i < n - 1; i++) {
			if(arr[i].compareTo(arr[i + 1]) > 0) {
				T temp = arr[i];
				arr[i] = arr[i + 1];
				arr[i + 1] = temp;
			}
		}
	}
	
	/** Takes an array and "bubbles" the largest values to the top until the array is sorted
	 * @param arr an array of type T
	 */
	public static<T extends Comparable<T>> void bubbleSort(T[] arr) {
		for(int i = arr.length; i > 1; i--) {
			//onePass(arr, i);
			for(int j = 0; j < i - 1; j++) {
				if(arr[j].compareTo(arr[j + 1]) > 0) {
					T temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}
	
	/** Takes an array and sorts it by comparing and sorting elements within the array
	 * that are far apart and then progressively decreases the gap size until the entire
	 * array is sorted
	 * @param arr
	 */
	public static <T extends Comparable<T>> void shellSort(T[] arr) {
	    // loop over the gaps
	    for (int gap = arr.length / 2; gap > 0; gap /= 2) {
	        // do the insertion sort
	        for (int i = gap; i < arr.length; i++) {
	            T val = arr[i];
	            int j;
	            for (j = i; j >= gap && arr[j - gap].compareTo(val) > 0; j -= gap) {
	                arr[j] = arr[j - gap];
	            }
	            arr[j] = val;
	        }
	    }
	}
	
	/** Applies the list of SortEvents to the array in-order
	 * @param arr an array of type T
	 * @param events a list of SortEvents
	 */
	public static <T extends Comparable<T>> void eventSort(T[] arr, List<SortEvent<T>> events) {
		
	}
	
	
	////create linked list, list
	////when swap occurs: list.add(new SwapEvent(index1, index2));
	
}
