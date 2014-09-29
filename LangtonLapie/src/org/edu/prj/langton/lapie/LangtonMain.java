package org.edu.prj.langton.lapie;


import java.awt.EventQueue;

import javax.swing.JFrame;

import org.edu.prj.langton.LangtonEngine;
import org.edu.prj.langton.LangtonGUI;
import org.edu.prj.langton.lapie.calculateur.impl.Fourmi;
import org.edu.prj.langton.lapie.ihm.impl.Terrain;
import org.edu.prj.langton.utils.LMatrix;
import org.edu.prj.langton.utils.UIMatrix;

public class LangtonMain {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					/** build fourmi */
	                LangtonEngine myFourmi = new Fourmi();
	                myFourmi.initialise(200,200);
	                myFourmi.startAt(100,100);
	                Integer max=13000;
	                for(Integer n=0;n<max;n++)
	                {
	                	myFourmi.nextGeneration();
	                }
	                /** build terrain */
	                
	                LangtonGUI terrain = new Terrain();
	                
	                /** add fourmi and show gui */
	                terrain.addFourmi(myFourmi);
	                terrain.show();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
