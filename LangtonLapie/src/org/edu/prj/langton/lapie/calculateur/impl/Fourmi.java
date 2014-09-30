package org.edu.prj.langton.lapie.calculateur.impl;

import java.util.Random;

import org.edu.prj.langton.LangtonEngine;
import org.edu.prj.langton.utils.LMatrix;

public class Fourmi implements LangtonEngine{

	protected String name;
	protected LMatrix lMatrix;
	protected Integer positionX;
	protected Integer positionY;
	protected enum Direction 	{
			aucune, ouest, est, nord, sud
		};
		protected Direction direction;
	
	public Fourmi() {
		lMatrix = null;
		chooseDirection(getRandom(1, 4));
	}
	public Fourmi(String sname) {
		lMatrix = null;
		name = sname;
		chooseDirection(getRandom(1, 4));
		
	}

	protected int getRandom(int min,int max)
	{
		Random rand = new Random();
		return rand.nextInt(max - min + 1) + min;
	}
	protected void chooseDirection(Integer i)
	{
		switch (i) {
		case 1:
			direction = Direction.ouest;
			break;
		case 2:
			direction = Direction.nord;
			break;
		case 3:
			direction = Direction.est;
			break;	
		case 4:
			direction = Direction.sud;
			break;
		default:
			break;
		}
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


		Boolean cellIsWhite = lMatrix.getValue(this.positionX, this.positionY);
		if(cellIsWhite)
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
			if(cellIsWhite)
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
			if(cellIsWhite)
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
			if(cellIsWhite)
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
			if(cellIsWhite)
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
