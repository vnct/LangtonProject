package org.edu.prj.langton.lapie.ihm.impl;

import java.awt.BorderLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.edu.prj.langton.LangtonEngine;
import org.edu.prj.langton.LangtonGUI;
import org.edu.prj.langton.lapie.calculateur.impl.Fourmi;
import org.edu.prj.langton.utils.LMatrix;
import org.edu.prj.langton.utils.UIMatrix;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import net.miginfocom.swing.MigLayout;

public class Terrain extends JFrame implements LangtonGUI,ActionListener{
	private UIMatrix uiMatrix = new UIMatrix();
	private JPanel contentPane;
	private Fourmi myFourmi = null;
	private JTextField textField_positionX;
	private JTextField textField_positionY;
	private JTextField textField_step;
	private JTextField textField_nbColonne;
	private JTextField textField_nbLigne;
	private JSlider sliderSpeed;
	/**
	 * Create the panel.
	 */
	public Terrain() {
		
		setIHM();
		setVisible(true);
	}


	private void setIHM()
	{
		setTitle("Fourmi de Langton");
		
		setBounds(100, 100, 658, 431);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		 getContentPane().add(panel, BorderLayout.EAST);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblSelectSpeed = new JLabel("Select Speed");
		lblSelectSpeed.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblSelectSpeed);
		
		sliderSpeed = new JSlider();
		panel.add(sliderSpeed);
		sliderSpeed.setMinimum(1);
		sliderSpeed.setMaximum(100);
		sliderSpeed.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				mySwingTimer.setDelay(sliderSpeed.getValue());
				
			}
		});
		
		JButton btnStart = new JButton("Start");
		panel.add(btnStart);
		btnStart.addActionListener(this);
		
		JButton btnStop = new JButton("Stop");
		panel.add(btnStop);
		btnStop.addActionListener(this);
		
		JPanel panel_steps = new JPanel();
		panel.add(panel_steps);
		panel_steps.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNewLabel_Step = new JLabel("Steps :");
		lblNewLabel_Step.setHorizontalAlignment(SwingConstants.CENTER);
		panel_steps.add(lblNewLabel_Step);
		
		textField_step = new JTextField();
		panel_steps.add(textField_step);
		textField_step.setColumns(10);
		textField_step.setText("200");
		
		JButton btnNextGeneration = new JButton("Next Generation");
		panel.add(btnNextGeneration);
		btnNextGeneration.addActionListener(this);
		
		JPanel panel_nbColonne = new JPanel();
		panel.add(panel_nbColonne);
		panel_nbColonne.setLayout(new GridLayout(0, 2, 0, 0));
		

		JLabel lblNewLabel_nbColonne = new JLabel("Nb Colonnes : ");
		lblNewLabel_nbColonne.setHorizontalAlignment(SwingConstants.CENTER);
		panel_nbColonne.add(lblNewLabel_nbColonne);
		
		textField_nbColonne = new JTextField();
		panel_nbColonne.add(textField_nbColonne);
		textField_nbColonne.setText("400");
		textField_nbColonne.setColumns(10);
		
		JPanel panel_nbLigne= new JPanel();
		panel.add(panel_nbLigne);
		panel_nbLigne.setLayout(new GridLayout(0, 2, 0, 0));
		

		JLabel lblNewLabel_nbLigne = new JLabel("Nb Lignes :");
		lblNewLabel_nbLigne.setHorizontalAlignment(SwingConstants.CENTER);
		panel_nbLigne.add(lblNewLabel_nbLigne);
		
		textField_nbLigne = new JTextField();
		panel_nbLigne.add(textField_nbLigne);
		textField_nbLigne.setText("300");
		textField_nbLigne.setColumns(10);
		
		JPanel panel_positionX = new JPanel();
		panel.add(panel_positionX);
		panel_positionX.setLayout(new GridLayout(0, 2, 0, 0));
		
		
		
		JLabel lblNewLabel_PositionX = new JLabel("Position X :");
		lblNewLabel_PositionX.setHorizontalAlignment(SwingConstants.CENTER);
		panel_positionX.add(lblNewLabel_PositionX);
		
		textField_positionX = new JTextField();
		panel_positionX.add(textField_positionX);
		textField_positionX.setText("100");
		textField_positionX.setColumns(10);
		
		JPanel panel_positionY = new JPanel();
		panel.add(panel_positionY);
		panel_positionY.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNewLabel_PositionY = new JLabel("Position Y :");
		
		lblNewLabel_PositionY.setHorizontalAlignment(SwingConstants.CENTER);
		panel_positionY.add(lblNewLabel_PositionY);
		
		textField_positionY = new JTextField();
		panel_positionY.add(textField_positionY);
		textField_positionY.setColumns(10);
		textField_positionY.setText("150");
		
		JButton btnRestart = new JButton("Restart");
		panel.add(btnRestart);
		btnRestart.addActionListener(this);
		
		JButton btnSwitch = new JButton("Switch Color");
		panel.add(btnSwitch);
		btnSwitch.addActionListener(this);
		
			 getContentPane().add(uiMatrix, BorderLayout.CENTER);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnMore = new JMenu("More");
		menuBar.add(mnMore);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mnMore.add(mntmAbout);
		mntmAbout.addActionListener(this);
		
		JMenuItem mntmQuit = new JMenuItem("Quit");
		mnMore.add(mntmQuit);
		mntmQuit.addActionListener(this);

	}
	@Override
	public void addFourmi(LangtonEngine arg0) {
	
		if(myFourmi==null)
		{
			myFourmi = (Fourmi) arg0;
			textField_nbColonne.setText(String.valueOf(myFourmi.getState().getNumberOfColumn()));
			textField_nbLigne.setText(String.valueOf(myFourmi.getState().getNumberOfLine()));
		}

		uiMatrix.update(myFourmi.getState());
	//	uiMatrix.setBounds(0, 0, myFourmi.getState().getNumberOfColumn(),myFourmi.getState().getNumberOfLine());
	}
	public void switchColor()
	{
		Color co = uiMatrix.getBackgroundColor();
		uiMatrix.setBackgroundColor(uiMatrix.getCellColor());
		uiMatrix.setCellColor(co);
		
	}
	Timer mySwingTimer = new Timer(10, new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
        	myFourmi.nextGeneration();
			addFourmi(myFourmi);
        }
     });
	
	public void initFourmi(Integer nb_col, Integer nb_line,Integer posX, Integer posY)
	{
		
		myFourmi.initialise(nb_col,nb_line);
		System.out.println("toto");
        myFourmi.startAt(posX,posY);
        addFourmi(myFourmi);
	}

	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		String cmd = arg0.getActionCommand();
		switch (cmd) {
		case "About":
			JOptionPane.showMessageDialog(getParent(), "Créé par Vincent dans le cadre d'un cours JAVA","About",1);
			
			break;
		case "Quit":
			System.exit(0);
			break;
		case "Next Generation":
			try{
				nextGeneration(Integer.parseInt(textField_step.getText()));
			}
			catch(Exception exception)
			{
				
			}
			
			break;
		case "Start":
			
			
			
			 if(mySwingTimer.isRunning())
			 {
				 mySwingTimer.stop();
			 }
			 else
			 {
				 
				 mySwingTimer.start();
			 }
		      
				
			break;
		case "Stop":
			
			 if(mySwingTimer.isRunning())
			 {
				 mySwingTimer.stop();
			 }
			
		      	
			break;
		case "Restart":
			try{
			
				initFourmi(Integer.parseInt(textField_nbColonne.getText()),Integer.parseInt(textField_nbLigne.getText()),Integer.parseInt(textField_positionX.getText()),Integer.parseInt(textField_positionY.getText()));
			}
			catch(Exception e)
			{
				e.printStackTrace();
				JOptionPane.showMessageDialog(getParent(), "Position X entre : o et " + myFourmi.getState().getNumberOfColumn() +
						System.lineSeparator() + "Position Y entre : o et " + myFourmi.getState().getNumberOfLine(),"Erreur Saisie",0);
				
			}
			
			break;
		case "Switch Color":
			switchColor();
			addFourmi(myFourmi);
			break;
		default:
			System.out.println(cmd);
			break;
		}
		
		
	}
	public void nextGeneration(Integer pas)
	{
		for(Integer n=0;n<pas;n++)
		{
			myFourmi.nextGeneration();
			addFourmi(myFourmi);
		}
	}




	
}
