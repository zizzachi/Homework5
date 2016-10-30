package edu.grinnell.sortingvisualizer.rendering;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Arrays;

import javax.swing.JPanel;

import edu.grinnell.sortingvisualizer.audio.NoteIndices;

@SuppressWarnings("serial")
public class ArrayPanel extends JPanel {

    private NoteIndices notes;
    
    /**
     * Constructs a new ArrayPanel that renders the given note indices to
     * the screen.
     * @param notes the indices to render
     * @param width the width of the panel
     * @param height the height of the panel
     */
    public ArrayPanel(NoteIndices notes, int width, int height) {
        this.notes = notes;
        this.setPreferredSize(new Dimension(width, height));
    }

    /** Paints the given rectangle the sets color with respect to the number of elements in
     * notes and their value.
     * @param g a Graphics object
     */
    @Override
    public void paintComponent(Graphics g) {
    	Integer[] indexNotes = notes.getNotes();
        int width = this.getWidth()/indexNotes.length;
        int heightIncrement = this.getHeight()/indexNotes.length;
        int colorIncrement = 200/indexNotes.length;
        
        for (int i = 0; i < indexNotes.length; i++) {
        	if(notes.isHighlighted(i)) {
        		System.out.println("I got to isHighlighted: " + Arrays.toString(indexNotes));
            	g.setColor(Color.YELLOW);
    			g.fillRect(width*i, this.getHeight() - (10 + Math.abs(indexNotes[i])*heightIncrement), 
    					width, 10 + indexNotes[i]*heightIncrement);
        	} else {
        		int grey = indexNotes[i] * colorIncrement;
        		Color color = new Color(grey, grey, grey);
        		g.setColor(color);
        		g.fillRect(width*i, this.getHeight() - (10 + Math.abs(indexNotes[i])*heightIncrement), 
        				width, 10 + indexNotes[i]*heightIncrement);
        	}
		}
    }
}