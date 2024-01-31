package studio2;

import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
		int startAmount, winLimit, currentAmount;
		double winChance;
		
		System.out.println("How much are you starting with?");
		Scanner in = new Scanner(System.in);
		startAmount = in.nextInt();
		
		System.out.println("What is your win limit?");
		winLimit = in.nextInt();
		
		System.out.println("What is the win chance (between 0 and 1)?");
		winChance = in.nextDouble();
		
		currentAmount = startAmount;
		double result;
		int numGames = 0;
		
		System.out.println("How many days to simulate?");
		int numSimulations = in.nextInt();
		
		int losses = 0; 
		
		double alpha = (1-winChance)/winChance;
		double expRuin;
		
		if (winChance == 0.5)
		{
			expRuin = 1 - (double)startAmount/(double)winLimit;
		}
		else
			expRuin = (Math.pow(alpha,startAmount) - Math.pow(alpha, winLimit))/(1-Math.pow(alpha, winLimit));
		
		for(int i = 1; i <= numSimulations; i++)
		{
		while(currentAmount < winLimit && currentAmount > 0)
		{
			numGames++;
			result = Math.random();
			if(result < winChance)
			{
				currentAmount++;
			}
			else
			{
				currentAmount--;
			}
		}
		
		if(currentAmount >= winLimit)
		{
			System.out.println("Simulation " + i + ": " + numGames + " WIN");
		}
		else
		{
			System.out.println("Simulation " + i + ": " + numGames + " LOSE");
			losses++;
		}
		currentAmount = startAmount;
		numGames = 0;
	}
		System.out.println("Losses: " + losses + " Simulations: " + numSimulations);
		System.out.println("Ruin rate from simulation: " + (double)losses/(double)numSimulations + " Expected ruin rate: " + expRuin);
	}
}
