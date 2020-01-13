package Assignment4_DiceRolling;

/**
 *
 * @author CHIRAG BARANDA
 * Student number : 000759867
 * Date : March 10,2018.
 * I hereby informed that I didn't copy my code from anyone and I don't allow to anyone copy my code.
 */

/*
*******************************UML******************
* -int numberOfSides
* -int currentDiceSide
*
*
*
*
*
*
*
*
*/



public class Dice {
    //create geter and seter method.
    	private int numberOfSides;//intialize total number of sides
	private int currentDiceSide;//initialize current dice side
	
	public Dice()  //default constrator with default values 0
        { 
		this.numberOfSides = 0;//intialize total number of side with 0.
		this.currentDiceSide = 0;//intialize the current dice side with 0.
	}
	
	public Dice(int numberOfSides) //constructor with the single parameter
        {
		this.numberOfSides = numberOfSides;
		this.currentDiceSide = 1;
	}
	
	public int getSideNumber() {//create geter method for sidenumber.
		return numberOfSides;
	}
	public void setSideNumber(int numberOfSides) {//create seter method for sidenumber.
		this.numberOfSides = numberOfSides;
	}
	public int getTopSide() {//create geter topside method. 
		return currentDiceSide;
	}
	public void setTopSide(int currentDiceSide) {//create a seter top side method.
		this.currentDiceSide = currentDiceSide;
	}
	
	public void rollTheDice(){//create roll method.
		currentDiceSide = (int) (Math.random()*numberOfSides) + 1;
	}

	@Override
	public String toString() {
		return "D" + numberOfSides + " : " + currentDiceSide;
	}
	
}
