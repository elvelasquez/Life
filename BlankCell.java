package edu.amherst.cs112.lab9;

import javax.swing.*;
import java.awt.*;

class BlankCell extends JPanel {

	private static final long serialVersionUID = 1L;

	BlankCell(int size) {
		setPreferredSize (new Dimension(size,size));
		setBackground(Color.LIGHT_GRAY);
	}
}
