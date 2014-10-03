package org.edu.prj.langton.lapie.ihm.impl;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import org.edu.prj.langton.LangtonEngine;
import org.edu.prj.langton.LangtonGUI;
import org.edu.prj.langton.utils.LMatrix;
import org.edu.prj.langton.utils.UIMatrix;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.FlowLayout;

import net.miginfocom.swing.MigLayout;

public class Terrain extends JPanel implements LangtonGUI{
	private UIMatrix uiMatrix = new UIMatrix();
	/**
	 * Create the panel.
	 */
	public Terrain() {
		setLayout(new GridLayout(1, 1));
	
		
		add(uiMatrix);
		
		
		
		//setVisible(true);
	}


	@Override
	public void addFourmi(LangtonEngine arg0) {
		uiMatrix.update(arg0.getState());
		uiMatrix.setBounds(0, 0, arg0.getState().getNumberOfColumn(),arg0.getState().getNumberOfLine());
	}
	public void switchColor()
	{
		Color co = uiMatrix.getBackgroundColor();
		uiMatrix.setBackgroundColor(uiMatrix.getCellColor());
		uiMatrix.setCellColor(co);
		
	}
	
}
