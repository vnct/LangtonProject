package org.edu.prj.langton.lapie.calculateur.impl;

import org.edu.prj.langton.LangtonEngine;
import org.edu.prj.langton.utils.LMatrix;

import junit.framework.TestCase;

/**
 * 
 * @author toto
 * @version 1.0, 24/06/2010
 */
public class TestFourmi extends TestCase {

        /**
         * @param args
         */
        public static void main(String[] args) {
                
                /** build fourmi */
                LangtonEngine myFourmi = new Fourmi();
                myFourmi.initialise(30, 20);
                myFourmi.startAt(15, 10);
                
                System.out.println("Test de la fourmi :" + myFourmi.getName());
                
                int nbgen = 1000; // nombre de génération maximal
                
                for (int g=0; g<nbgen; g++) {
                        myFourmi.nextGeneration();
                        LMatrix matrix = myFourmi.getState();

                        for (int i=0; i<matrix.getNumberOfLine(); i++) {
                                for (int j=0; j<matrix.getNumberOfColumn(); j++) {
                                        if (matrix.getValue(i, j))
                                                System.out.print("X");
                                        else 
                                                System.out.print(".");
                                }
                                System.out.println();
                        }

                        try {
                                Thread.sleep(100);
                        } catch (InterruptedException e) {
                        }
                }
                
        }
}
