package org.edu.prj.langton.lapie.ihm.impl;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.edu.prj.langton.LangtonEngine;
import org.edu.prj.langton.LangtonGUI;
import org.edu.prj.langton.utils.LMatrix;
import org.edu.prj.langton.utils.UIMatrix;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JButton;

public class Terrain extends JFrame  implements LangtonGUI{

	private JPanel contentPane;


	/**
	 * Create the frame.
	 */
	public Terrain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 666, 443);
		
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
		
		UIMatrix uiMatrix = new UIMatrix();
		contentPane.add(uiMatrix, BorderLayout.CENTER);
		
	}


	@Override
	public void addFourmi(LangtonEngine arg0) {
		// TODO Auto-generated method stub
		
	}

}
