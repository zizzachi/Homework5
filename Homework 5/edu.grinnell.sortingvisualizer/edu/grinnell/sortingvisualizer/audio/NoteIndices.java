package edu.grinnell.sortingvisualizer.audio;

import java.util.Arrays;
import java.util.Collections;

/**
 * A collection of indices into a Scale object.
 * These indices are the subject of the various sorting algorithms
 * in the program.
 */
public class NoteIndices {
	
	Integer[] indices;

    /**
     * @param n the size of the scale object that these indices map into
     */
    public NoteIndices(int n) {
    	indices = new Integer[n];
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
    	indices = new Integer[n];
        for(int i = 0; i < n; i++) {
        	indices[i] = i;
        }
        Collections.shuffle(Arrays.asList(indices));
    }
    
    /** @return the indices of this NoteIndices object */
    public Integer[] getNotes() { 
        return indices;
    }
    
    /**
     * Highlights the given index of the note array
     * @param index the index to highlight
     */
    public void highlightNote(int index) {
        indices[index] = -1 * index;
    }
    
    /** @return true if the given index is highlighted */
    public boolean isHighlighted(int index) {
    	return indices[index] < 0;
    }
    
    /** Clears all highlighted indices from this collection */
    public void clearAllHighlighted() {
        for(int i = 0; i < indices.length; i++) {
        	indices[i] = Math.abs(indices[i]);
        }
    }
}
