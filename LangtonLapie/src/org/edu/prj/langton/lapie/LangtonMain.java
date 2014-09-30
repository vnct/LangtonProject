package org.edu.prj.langton.lapie;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.edu.prj.langton.LangtonEngine;
import org.edu.prj.langton.LangtonGUI;
import org.edu.prj.langton.lapie.calculateur.impl.Fourmi;
import org.edu.prj.langton.lapie.ihm.impl.Terrain;

import javax.swing.JInternalFrame;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LangtonMain extends JFrame {

	private JPanel contentPane;
	private LangtonEngine myFourmi = new Fourmi();
	private Terrain terrain= new Terrain();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LangtonMain frame = new LangtonMain();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LangtonMain() {
		System.out.println("Test");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.EAST);
		
		JButton btnNextgeneration = new JButton("nextGeneration");
		btnNextgeneration.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				for(Integer n=0;n<200;n++)
					{
					myFourmi.nextGeneration();
					terrain.addFourmi(myFourmi);
					
					}
			}
		});
		panel.add(btnNextgeneration);
		
	/*	
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.EAST);
		*/
		
		
		/* Build Terrain */

		
  
    	myFourmi.initialise(200,200);
    
        myFourmi.startAt(10,100);
        
        terrain.addFourmi(myFourmi);
		contentPane.add(terrain, BorderLayout.CENTER);		
   
    
		

	}

}
