package edu.grinnell.sortingvisualizer;

import java.util.Arrays;

/**
 * A collection of indices into a Scale object.
 * These indices are the subject of the various sorting algorithms
 * in the program.
 */
public class NoteIndices {
	
	int[] indices;

    /**
     * @param n the size of the scale object that these indices map into
     */
    public NoteIndices(int n) {
        indices = new int[n];
        for(int i = 0; i < n; i++) {
        	indices[i] = i;
        }
    }
    
    /**
     * Reinitializes this collection of indices to map into a new scale object
     * of the given size.  The collection is also shuffled to provide an
     * initial starting point for the sorting process.
     * @param n the size of the scale object that these indices map into
     */
    public void initializeAndShuffle(int n) {
        indices = Arrays.copyOf(indices, n);
        for(int i = 0; i < n; i++) {
        	indices[i] = i;
        }
    }
    
    /** @return the indices of this NoteIndices object */
    public Integer[] getNotes() { 
        // TODO: fill me in
        return null;
    }
    
    /**
     * Highlights the given index of the note array
     * @param index the index to highlight
     */
    public void highlightNote(int index) {
        // TODO: fill me in
    }
    
    /** @return true if the given index is highlighted */
    public boolean isHighlighted(int index) {
        // TODO: fill me in
        return false;
    }
    
    /** Clears all highlighted indices from this collection */
    public void clearAllHighlighted() {
        // TODO: fill me in
    }
}
