package Assignment4_DiceRolling;
/**
 *
 * @author CHIRAG BARANDA
 * Student number : 000759867
 * Date : March 10,2018.
 * I hereby informed that I didn't copy my code from anyone and I don't allow to anyone copy my code.
 */



import java.util.Scanner;
import javafx.application.Application;


public class RollDice 
{
    /**This class describe a main class.
     * where ask the user to number of dice.
     * number of side of each dice.
     * switch case for number of choices.
     * @CHIRAG BARANDA
     */

	private static final int MaximumRollingTime = 100000; //set maximum roll time.
	private static Scanner input = new Scanner(System.in); //create a scanner object.
	public static int[] rollResult; //result of the rolled dice.
	public static int minSum; //minimum variable.
	
	public static void main(String[] args) {
            //main method.
		System.out.print("Enter number of Dice : ");
		
		int numberOfDices = input.nextInt();//set variable for number of dice.
		
		System.out.println("Enter nu1mber of side of each die : ");
		int[] numberOfSidesForEachDice = new int[numberOfDices];//set variable for number of side of each dice.
		for(int i = 0; i < numberOfDices; i++){//creat a loop that will be excuted till dicenumber.
			numberOfSidesForEachDice[i] = input.nextInt();
		}
                
		diceCollection dc = new diceCollection(numberOfDices, numberOfSidesForEachDice);//pass the variable of dicenumber and dicesides.
		
		int userInput = 1;
		do //user input for program either user want to roll a dice once, hundred thousand times or he wants to exit
                {			
			switch(userInput) 
                        {
			case 1:
				dc.rollDices(1);
				System.out.println(dc.toString());//converted dice to roll dice.
				break;
			case 2: 
				dc.rollDices(MaximumRollingTime);//set maximum roll time.
                                dc.showCount(MaximumRollingTime);
				minSum =dc.getMinSumPosible();
				rollResult = dc.getRollResult();
                                System.out.println(dc.toString());//converted dice to roll dice.
                                
				break;
                        default:
                               System.out.println("Wrong input! Please enter valid Input 1 2 or 3!! ");
                               break;
			}
                        System.out.println("****************Please Enter Input!! **************** \n 1. Roll dice once 2. Roll dice  3. Exit");
			System.out.print("Enter your choice : ");
			userInput = input.nextInt();//set variable for choice.
		}   while(userInput!=3);
		System.out.println("Thank You Using Application!! Good Bye!!");
	}


}
