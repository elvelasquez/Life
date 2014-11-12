package edu.amherst.cs112.lab9;

import javax.swing.*;

public class Life extends JFrame {	
	
	// Conway's Game of Life
	// A collaboration between Phong Hoang and Luis Velasquez.
	
	Life () {
		super("Game of Life");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setContentPane(new WidgetPanel());
		pack();
		setVisible(true);
	}

	public static void main (String[] args) {
		new Life();
	}
}
