package Assignment4_DiceRolling;
/**
 *
 * @author CHIRAG BARANDA
 * Student number : 000759867
 * Date : March 10,2018.
 * I hereby informed that I didn't copy my code from anyone and I don't allow to anyone copy my code.
 */





import java.util.Arrays;

public class diceCollection {
    /**create variable and set method according to that.**/
	private int numberOfDices;//variable for number of dice.
	private Dice[] dice;//variable instance(object) for dice.
	private int MaximumPossibleSumForRolledDice;//maximum possible sum when dice is rolled. i.e 1 for each
	private int minimumPossibleSumForRolledDice;//minimum possible sum when dice is rolled. i.e side of dise for each
	private int sumOfRolledDice;//total sum of dices after rolled.
	int rollResult[];
	
	public diceCollection(int numberOfDices, int[] diceSides) //create constructor for DiceCollection with two parameter.
        {
		this.numberOfDices = numberOfDices;//Assign parameter value to the local variable numberOfDices 
		
		this.dice = new Dice[numberOfDices];//Assign parameter value to the local variable dice which generate the number of dices 
		int sum = 0;//intialize local varible "sum" to 0, which will be helpful to set as as maximim numbr of sum
		
		for(int i = 0; i < numberOfDices; i++)//loop for setting dice sides
                {
			this.dice[i] = new Dice(diceSides[i]); //set dice sides using loop and array.
			sum += diceSides[i];//counting the number of dices.
		}
		
		this.minimumPossibleSumForRolledDice = numberOfDices;//set number of dices to minimum sum posible.
		this.sumOfRolledDice = numberOfDices;//set number of dices to cuurrentsum.
		this.MaximumPossibleSumForRolledDice = sum;//set sum to maximumsumpossible.
	}
	
	public void rollDices(int NumberOfRollForDice)//create method to roll the dices.
        {
		rollResult = new int[MaximumPossibleSumForRolledDice - minimumPossibleSumForRolledDice + 1]; //set condition for rolled dice result.
		for(int i = 0; i < NumberOfRollForDice; i++){//create for loop for the times we are rolling the dice such as once or thoudsand hundred times.
			rollAllDices(); //calling to the rollAllDices method			
                        getSumOfTopSides(); //calling this method to get the sum of the all current sides for each dice
			rollResult[sumOfRolledDice-minimumPossibleSumForRolledDice]++; //increment indec in array to store the next roll result.
		}
	}

	private void getSumOfTopSides() 
        {
		sumOfRolledDice = 0;
		for(Dice d : dice)
                {
			sumOfRolledDice += d.getTopSide();//increment sum.
		}
	}

	private void rollAllDices() 
        {
		for(Dice d : dice)
                {
			d.rollTheDice();//call the roll through object.
		}
	}
        
        public char[] showCount(int NumberOfRollForDice) {
		System.out.println();
		for(int i = 0; i < MaximumPossibleSumForRolledDice - minimumPossibleSumForRolledDice + 1; i++){//create for loop.
			System.out.printf("%3d : %5d ", (i+minimumPossibleSumForRolledDice), rollResult[i]);
			int stars = rollResult[i] / 1000; //set stars condition.
			for(int j = 0; j < stars; j++){//create a j loop for stars display columnwise. 
				System.out.print("*");
			}
			System.out.println();
		}
		return null;
	}

	@Override
	public String toString() {
		return Arrays.toString(dice)+"\n"+"MAX = "+ MaximumPossibleSumForRolledDice +" MIN = " + minimumPossibleSumForRolledDice+", CURRENT=" + sumOfRolledDice + "\n";
	}

		
	public int getMinSumPosible() {//create a minimum sum method.
		return minimumPossibleSumForRolledDice;
	}

	public int[] getRollResult() {//create get method for rollrsult.
		return rollResult;
	}
}

