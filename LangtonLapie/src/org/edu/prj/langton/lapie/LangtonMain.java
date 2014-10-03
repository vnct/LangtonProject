package org.edu.prj.langton.lapie;


import org.edu.prj.langton.LangtonEngine;
import org.edu.prj.langton.LangtonGUI;
import org.edu.prj.langton.lapie.calculateur.impl.Fourmi;
import org.edu.prj.langton.lapie.ihm.impl.Terrain;


public class LangtonMain{
	
	 public static void main(String[] args) {
	 /** build fourmi */
		Fourmi myFourmi = new Fourmi();
    	myFourmi.initialise(300, 300);
    	myFourmi.startAt(250,100);
    
    /** build terrain */
    	LangtonGUI terrain = new Terrain();
    
    /** add fourmi and show gui */
    	terrain.addFourmi(myFourmi);
    	terrain.show(); 
	 }


}
