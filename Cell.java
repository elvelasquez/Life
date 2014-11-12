package edu.amherst.cs112.lab9;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Cell extends BlankCell {
	
	private WidgetComponent wc;
	private static final long serialVersionUID = 1L;
	Color color = Color.white;
	Color newcolor;
	
	Cell (int size, WidgetComponent c) {
		super(size);	
		wc = c;
		setBackground(color);
		addMouseListener(new MyMouseListener());
	}
	
	void kill() {
		newcolor = Color.white;
		setBackground(newcolor);
		repaint();
	}
	
	void live() {
		newcolor = Color.blue;
		setBackground(newcolor);
		repaint();
	}
	
	void clear() {
		color = Color.white;
		newcolor = null;
		setBackground(color);
		repaint();
	}
	
	void update() {
		color = newcolor;
	}
	
	class MyMouseListener extends MouseAdapter {
		public void mouseEntered (MouseEvent e){
			if (color == Color.white) {
				if (wc.toggle == true)
					color = Color.blue;
				else
					color = Color.gray;
				setBackground(color);
				repaint();
			}
		}
		
		public void mouseExited (MouseEvent e) {
			if (color == Color.gray) {
				color = Color.white;
				setBackground(color);
				repaint();
			}
		}

		public void mouseReleased (MouseEvent e) {
			if (color == Color.blue) {
				color = Color.white;
				setBackground(color);
				repaint();
			} else {
				color = Color.blue;
				setBackground(color);
				repaint();
			}			
		}		
	}
}
