package org.edu.prj.langton.lapie.calculateur.impl;

import org.edu.prj.langton.LangtonEngine;
import org.edu.prj.langton.utils.LMatrix;

public class Fourmi implements LangtonEngine{

	private String name;
	private LMatrix lMatrix;
	private Integer positionX;
	private Integer positionY;
	private enum Direction 	{
			aucune, ouest, est, nord, sud
		};
	private Direction direction;
	
	public Fourmi() {
		lMatrix = null;
		direction = Direction.ouest;
	}
	public Fourmi(String sname) {
		lMatrix = null;
		name = sname;
		
	}


	//Return the name of author 
	@Override
	public String getName() {
		
		return name;
		
	}

	//Return the current matrix 
	@Override
	public LMatrix getState() {
		return lMatrix;
	}
	
	//set size of land 
	@Override
	public void initialise(int nb_col, int nb_line) {
		lMatrix = new LMatrix(nb_col, nb_line);
		
	}
	
	public void nextPosition(Integer posX,Integer posY)
	{
		this.positionX = posX;
		this.positionY = posY;
	}

	@Override
	public void nextGeneration() {
		// TEST LE DEPLACEMENT DE LA FOURMI. DEPLACEMENT CON POUR LE MOMENT

		Boolean cellwhite = lMatrix.getValue(this.positionX, this.positionY);
		if(cellwhite)
		{
			lMatrix.unActivateCell(this.positionX, this.positionY);
		}
		else
		{
			lMatrix.activateCell(this.positionX, this.positionY);
		}

		/*
    Si la fourmi est sur une case noire, elle tourne de 90° vers la droite
    change la couleur de la case en blanc et avance d’une case.
    Si la fourmi est sur une case blanche, elle tourne de 90° vers la gauche
    change la couleur de la case en noir et avance d’une case.

		 */
		switch (direction) {
		case aucune:
			
			break;
		case est:
			if(cellwhite)
			{
				direction = Direction.nord;
				nextPosition(this.positionX, this.positionY-1);
			}
			else
			{
				direction = Direction.sud;	
				nextPosition(this.positionX, this.positionY+1);
			}
			break;	
		case nord:
			if(cellwhite)
			{
				direction = Direction.ouest;
				nextPosition(this.positionX-1, this.positionY);
			}
			else
			{
				direction = Direction.est;
				nextPosition(this.positionX+1, this.positionY);
			}
			break;	
		case ouest:
			if(cellwhite)
			{
				direction = Direction.sud;
				nextPosition(this.positionX, this.positionY+1);
			}
			else
			{
				direction = Direction.nord;
				nextPosition(this.positionX, this.positionY-1);
			}	
			break;	
		case sud:
			if(cellwhite)
			{
				direction = Direction.est;
				nextPosition(this.positionX+1, this.positionY);
			}
			else
			{
				direction = Direction.ouest;
				nextPosition(this.positionX-1, this.positionY);
			}
			break;	
		default:
			break;
		}





	/*	this.positionX=this.positionX+10;
		this.positionY=this.positionY+30;
		
		lMatrix.activateCell(this.positionX, this.positionY);*/
		
	}

	//set position to start the ants (fourmi) 
	@Override
	public void startAt(int posx, int posy) {
		lMatrix.activateCell(posx, posy);
		this.positionX=posx;
		this.positionY = posy;
		
	}

}
