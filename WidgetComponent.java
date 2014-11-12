package edu.amherst.cs112.lab9;

import javax.swing.*;
import java.awt.*;

class WidgetComponent extends JPanel {

	private static final long serialVersionUID = 1L;
	final static int LINE_WIDTH = 1;
	final static int ROWS = 40;
	final static int COLUMNS = 40;
	final static int CELL_SIZE = 10;
	boolean toggle;

	Cell[][] cc;

	WidgetComponent() {		
		setLayout (new GridLayout(ROWS, COLUMNS, LINE_WIDTH, LINE_WIDTH));
		cc = new Cell[ROWS][COLUMNS];
		
		for (int i=0; i<ROWS; ++i) 
			for (int j=0; j<COLUMNS; ++j) {
				cc[i][j] = new Cell(CELL_SIZE, this);
				add(cc[i][j]);	
			}
	}
	
	void run() {		
		int count;
		for (int i=0; i<ROWS; ++i) { 
			for (int j=0; j<COLUMNS; ++j) {
				count = neighborCount(i, j);
				if (cc[i][j].color == Color.blue) {
					if (count > 3 || count < 2)
						cc[i][j].kill();
					else
						cc[i][j].live();
				} else {
					if (count == 3)
						cc[i][j].live();
					else 
						cc[i][j].kill();
				}
			}
		}
		update();
	}	
	
	void update() {
		for (int i=0; i<ROWS; ++i) { 
			for (int j=0; j<COLUMNS; ++j) 
				cc[i][j].update();	
		}
	}
	
	int neighborCount(int row, int col) {
		int count = 0;
		if (cc[row][col].color == Color.blue)
			count = -1;
		for (int i=0; i<3; ++i) {
			for (int j=0; j<3; ++j) {
				try {
					if (cc[row - 1 + i][col - 1 + j].color == Color.blue)
						count = count + 1;
				} catch (ArrayIndexOutOfBoundsException e) {
					
				}	
				
			}
		}		
		return count;
	}
	
	
	void clear() {
		for (int i=0; i<ROWS; ++i) { 
			for (int j=0; j<COLUMNS; ++j) {
				cc[i][j].clear();
			}
		}
	}
	
}
