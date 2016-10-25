package edu.grinnell.sortingvisualizer.sortevents;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CopyEvent<T> implements SortEvent<T> {

	/* index and element being copied into that index */
	public int i;
	public T copy;
	
	/* Constructor */
	public CopyEvent(int index, T val) {
		this.i = index;
		this.copy = val;
	}
	
	public void apply(T[] arr) {
		arr[i] = this.copy;
	}

	public List<Integer> getAffectedIndices() {
		List<Integer> list = new LinkedList<Integer>();
		list.add(this.i); ////////////////////////////////
		return list;
	}

	public boolean isEmphasized() {
		return true;
	}
	
	public static void main(String[] args) {
		CopyEvent<Integer> copy = new CopyEvent<Integer>(4, 2);
		Integer[] arr = new Integer[] {0, 4, 6, -2, 5};
		
		System.out.println(Arrays.toString(arr));
		copy.apply(arr);
		System.out.println(copy.getAffectedIndices());
		System.out.println(Arrays.toString(arr));
	}
}