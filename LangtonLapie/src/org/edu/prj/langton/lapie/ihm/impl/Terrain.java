package org.edu.prj.langton.lapie.ihm.impl;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.edu.prj.langton.LangtonEngine;
import org.edu.prj.langton.LangtonGUI;
import org.edu.prj.langton.lapie.calculateur.impl.Fourmi;
import org.edu.prj.langton.utils.LMatrix;
import org.edu.prj.langton.utils.UIMatrix;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JButton;

public class Terrain extends JFrame implements LangtonGUI{

	private JPanel contentPane;
	private UIMatrix uiMatrix = new UIMatrix();


	/**
	 * Create the frame.
	 */
	public Terrain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnAbout = new JMenu("About");
		menuBar.add(mnAbout);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.EAST);
		
		JButton btnNextGeneration = new JButton("Next Generation");
		panel.add(btnNextGeneration);
		
		contentPane.add(uiMatrix, BorderLayout.CENTER);
		
		
	}


	//add fourmi in gui
	@Override
	public void addFourmi(LangtonEngine fourmi) {
		uiMatrix.update(fourmi.getState());
	
		
	}
	
	@SuppressWarnings("deprecation")
	public void show()
	{
		super.show();
	}

}
