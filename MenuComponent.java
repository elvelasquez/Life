package edu.amherst.cs112.lab9;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MenuComponent extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	final static int LINE_WIDTH = 1;
	final static int ROWS = 16;
	final static int COLUMNS = 1;
    
    Animator animator;
    
    boolean toggle = true;
    boolean brush = true;
	
	JButton powerButton;
	JToggleButton toggleButton;
	WidgetPanel widgetPanel;
	JButton clearButton;
	JButton helpButton;
	JToggleButton brushButton;

	MenuComponent(WidgetPanel wp) {


		widgetPanel = wp;
		brushButton = new JToggleButton("Brush");
		setLayout (new GridLayout(ROWS, COLUMNS, 0, LINE_WIDTH));
		powerButton = new JButton("Generate");
		helpButton = new JButton("About");
		toggleButton = new JToggleButton("Run");
		clearButton = new JButton("Clear");
		
		add(powerButton);
		add(toggleButton);
		add(brushButton);
		add(Box.createVerticalStrut(0));
		add(clearButton);
		for (int i = 0; i < 10; i++)
			add(Box.createVerticalStrut(0));
		add(helpButton);
		
		powerButton.addActionListener(this);
		toggleButton.addActionListener(this);
		clearButton.addActionListener(this);
		brushButton.addActionListener(this);
		animator = new Animator(this);
		helpButton.addActionListener(this);

	}
	
	public void actionPerformed (ActionEvent e) {
		
		if (e.getSource().equals(helpButton)) {
			JOptionPane.showMessageDialog(this,"Conway's Game of Life. Copyright 2013 Luis Velasquez and Phong Hoang. All rights reserved.");
		}
		
		if (e.getSource().equals(powerButton)) {
			widgetPanel.widgetComponent.run();
		}
		
		if (e.getSource().equals(toggleButton)) {
			if (toggle) {
				toggle = false;
				animator.ok = true;
				new Thread(animator).start();
			} else {
				toggle = true;
				animator.ok = false;
			}
		}
		
		if (e.getSource().equals(brushButton)) {
			if (brush) {
				brush = false;
				widgetPanel.widgetComponent.toggle = true;
			} else {
				brush = true;
				widgetPanel.widgetComponent.toggle = false;
			}
		}
		
		if (e.getSource().equals(clearButton)) {
			widgetPanel.widgetComponent.clear();
		}
	}
	
}
