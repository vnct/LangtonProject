package org.edu.prj.langton.lapie;

import java.awt.BorderLayout;
import java.awt.Color;
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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridLayout;
import java.awt.CardLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.Timer;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class LangtonMain extends JFrame implements ActionListener {

	private JPanel contentPane;
	private Fourmi myFourmi = new Fourmi();
	private Terrain myterrain= new Terrain();
	private JTextField textField_positionX;
	private JTextField textField_positionY;
	Integer largeur = 300;
	Integer hauteur = 300;
	private JTextField textField_step;

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
		
			
		setTitle("Fourmi de Langton");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 492, 370);
		setResizable(false);
		
		/* IHM -->   */
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnMore = new JMenu("More");
		menuBar.add(mnMore);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mntmAbout.addActionListener(this);
		mnMore.add(mntmAbout);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(this);
		mnMore.add(mntmExit);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		
		JPanel settings = new JPanel();
		GridBagLayout gbl_settings = new GridBagLayout();
		gbl_settings.columnWidths = new int[]{69, 0, 0};
		gbl_settings.rowHeights = new int[]{23, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_settings.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_settings.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		settings.setLayout(gbl_settings);
		
		JButton btnNextgeneration = new JButton("Next Generation");
		btnNextgeneration.addActionListener(this);
		
		JButton btnSimulation = new JButton("Start / Stop");
		btnSimulation.addActionListener(this);
		GridBagConstraints gbc_btnSimulation = new GridBagConstraints();
		gbc_btnSimulation.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSimulation.gridwidth = 2;
		gbc_btnSimulation.insets = new Insets(0, 0, 5, 0);
		gbc_btnSimulation.gridx = 0;
		gbc_btnSimulation.gridy = 0;
		settings.add(btnSimulation, gbc_btnSimulation);
		
		JLabel lblStep = new JLabel("Step :");
		GridBagConstraints gbc_lblStep = new GridBagConstraints();
		gbc_lblStep.insets = new Insets(10, 0, 5, 5);
		gbc_lblStep.gridx = 0;
		gbc_lblStep.gridy = 1;
		settings.add(lblStep, gbc_lblStep);
		
		textField_step = new JTextField();
		textField_step.setText("200");
		GridBagConstraints gbc_textField_step = new GridBagConstraints();
		gbc_textField_step.insets = new Insets(10, 0, 5, 0);
		gbc_textField_step.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_step.gridx = 1;
		gbc_textField_step.gridy = 1;
		settings.add(textField_step, gbc_textField_step);
		textField_step.setColumns(10);
		
		GridBagConstraints gbc_btnNextgeneration = new GridBagConstraints();
		gbc_btnNextgeneration.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNextgeneration.gridwidth = 2;
		gbc_btnNextgeneration.insets = new Insets(0, 0, 5, 0);
		gbc_btnNextgeneration.anchor = GridBagConstraints.NORTH;
		gbc_btnNextgeneration.gridx = 0;
		gbc_btnNextgeneration.gridy = 2;
		settings.add(btnNextgeneration, gbc_btnNextgeneration);
		
		JLabel lblPositionFourmi = new JLabel("Position Fourmi :");
		GridBagConstraints gbc_lblPositionFourmi = new GridBagConstraints();
		gbc_lblPositionFourmi.gridwidth = 2;
		gbc_lblPositionFourmi.insets = new Insets(20, 0, 5, 0);
		gbc_lblPositionFourmi.gridx = 0;
		gbc_lblPositionFourmi.gridy = 3;
		settings.add(lblPositionFourmi, gbc_lblPositionFourmi);
		
		JLabel lblPositionX = new JLabel("Position X :");
		GridBagConstraints gbc_lblPositionX = new GridBagConstraints();
		gbc_lblPositionX.insets = new Insets(0, 0, 5, 5);
		gbc_lblPositionX.gridx = 0;
		gbc_lblPositionX.gridy = 4;
		settings.add(lblPositionX, gbc_lblPositionX);
		
		textField_positionX = new JTextField();
		textField_positionX.setText("0");
		GridBagConstraints gbc_textField_positionX = new GridBagConstraints();
		gbc_textField_positionX.insets = new Insets(0, 0, 5, 0);
		gbc_textField_positionX.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_positionX.gridx = 1;
		gbc_textField_positionX.gridy = 4;
		settings.add(textField_positionX, gbc_textField_positionX);
		textField_positionX.setColumns(8);
		
		JLabel lblPositionY = new JLabel("Position Y :");
		GridBagConstraints gbc_lblPositionY = new GridBagConstraints();
		gbc_lblPositionY.insets = new Insets(0, 0, 5, 5);
		gbc_lblPositionY.gridx = 0;
		gbc_lblPositionY.gridy = 5;
		settings.add(lblPositionY, gbc_lblPositionY);
		
		textField_positionY = new JTextField();
		textField_positionY.setText("0");
		GridBagConstraints gbc_textField_positionY = new GridBagConstraints();
		gbc_textField_positionY.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_positionY.insets = new Insets(0, 0, 5, 0);
		gbc_textField_positionY.gridx = 1;
		gbc_textField_positionY.gridy = 5;
		settings.add(textField_positionY, gbc_textField_positionY);
		textField_positionY.setColumns(6);
		
		//Terrain myterrain = new Terrain();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(myterrain, GroupLayout.PREFERRED_SIZE, largeur, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(settings, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(129))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(myterrain, GroupLayout.PREFERRED_SIZE, hauteur, GroupLayout.PREFERRED_SIZE)
						.addComponent(settings, GroupLayout.PREFERRED_SIZE, hauteur, GroupLayout.PREFERRED_SIZE))
					.addGap(22))
		);
		
		JButton btnRestart = new JButton("Restart");
		btnRestart.addActionListener(this);
		GridBagConstraints gbc_btnRestart = new GridBagConstraints();
		gbc_btnRestart.insets = new Insets(0, 0, 5, 0);
		gbc_btnRestart.gridwidth = 2;
		gbc_btnRestart.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnRestart.gridx = 0;
		gbc_btnRestart.gridy = 6;
		settings.add(btnRestart, gbc_btnRestart);
		
		JButton btnSwitchColor = new JButton("Switch Color");
		GridBagConstraints gbc_btnSwitchColor = new GridBagConstraints();
		gbc_btnSwitchColor.insets = new Insets(40, 0, 0, 0);
		gbc_btnSwitchColor.anchor = GridBagConstraints.SOUTH;
		gbc_btnSwitchColor.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSwitchColor.gridwidth = 2;
		gbc_btnSwitchColor.gridx = 0;
		gbc_btnSwitchColor.gridy = 7;
		btnSwitchColor.addActionListener(this);
		settings.add(btnSwitchColor, gbc_btnSwitchColor);
		contentPane.setLayout(gl_contentPane);

		/* <-- IHM    */
		initFourmi(largeur,hauteur,150,100);
   
    	

	}
	Timer mySwingTimer = new Timer(10, new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
        	myFourmi.nextGeneration();
			myterrain.addFourmi(myFourmi);
        }
     });
	
	public void initFourmi(Integer largeur, Integer hauteur,Integer posX, Integer posY)
	{
		myFourmi.initPosition();
		myFourmi.initialise(largeur,hauteur);
        myFourmi.startAt(posX,posY);
        myterrain.addFourmi(myFourmi);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		String cmd = arg0.getActionCommand();
		switch (cmd) {
		case "About":
			System.out.println("About");
			break;
		case "Exit":
			System.exit(0);
			break;
		case "Next Generation":
			try{
				nextGeneration(Integer.parseInt(textField_step.getText()));
			}
			catch(Exception exception)
			{
				System.out.println("E");
			}
			
			break;
		case "Start / Stop":
			
			 if(mySwingTimer.isRunning())
			 {
				 mySwingTimer.stop();
			 }
			 else
			 {
				 
				 mySwingTimer.start();
			 }
		      
				
			break;
		case "Restart":
			try{
				initFourmi(largeur,hauteur,Integer.parseInt(textField_positionX.getText()),Integer.parseInt(textField_positionY.getText()));
			}
			catch(Exception e)
			{
				System.err.println("e");
			}
			
			break;
		case "Switch Color":
			myterrain.switchColor();
			myterrain.addFourmi(myFourmi);
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
			myterrain.addFourmi(myFourmi);
		}
	}
}
