package org.edu.prj.langton.lapie.ihm.impl;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import org.edu.prj.langton.LangtonEngine;
import org.edu.prj.langton.LangtonGUI;
import org.edu.prj.langton.utils.UIMatrix;
import java.awt.GridLayout;

public class Terrain extends JPanel implements LangtonGUI{
	private UIMatrix uiMatrix = new UIMatrix();
	/**
	 * Create the panel.
	 */
	public Terrain() {
		setLayout(new GridLayout(1, 0, 0, 0));
		add(uiMatrix, BorderLayout.CENTER);
		
		//setVisible(true);
	}

	@Override
	public void addFourmi(LangtonEngine arg0) {
		uiMatrix.update(arg0.getState());
		
	}
	
	
}
