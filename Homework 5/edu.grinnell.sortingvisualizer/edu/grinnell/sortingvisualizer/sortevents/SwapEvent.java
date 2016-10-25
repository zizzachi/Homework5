package edu.grinnell.sortingvisualizer.sortevents;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SwapEvent<T> implements SortEvent<T> {
	
	/* indices being swapped */
	public int i;
	public int j;
	
	/* Constructor */
	public SwapEvent(int val1, int val2) {
		this.i = val1;
		this.j = val2;
	}

	public void apply(T[] arr) {
		T temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public List<Integer> getAffectedIndices() {
		List<Integer> list = new LinkedList<Integer>();
		list.add(this.i); ////////////////////////////////
		list.add(this.j); ////////////////////////////////
		return list;
	}

	public boolean isEmphasized() {
		return true;
	}
	
	public static void main(String[] args) {
		SwapEvent<Integer> swap = new SwapEvent<Integer>(1, 3);
		Integer[] arr = new Integer[] {0, 4, 6, -2, 5};
		
		System.out.println(Arrays.toString(arr));
		swap.apply(arr);
		System.out.println(swap.getAffectedIndices());
		System.out.println(Arrays.toString(arr));
	}
}
