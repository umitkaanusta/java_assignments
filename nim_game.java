// nim game

import java.util.Scanner;

public class Nim {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		int turn = 1;
		
		int coinsAt_A = 3;
		int coinsAt_B = 4;
		int coinsAt_C = 5;
		
		System.out.println("-------------------- NIM GAME ---------------------");
		
		System.out.print("Player 1, enter your name:");
		String Player1 = input.nextLine();
		
		System.out.print("Player 2, enter your name:");
		String Player2 = input.nextLine();
		
		System.out.println("A: 3  B: 4  C:5");
		
		while(true) {
			
			if (turn %2 == 1) {
				System.out.print("\n" + Player1 + ", choose a pile (A, B, C):");
				String pileChosen = input.next();
				
				if(pileChosen.equals("a") || pileChosen.equals("A")) {
					System.out.println("You have chosen pile A.");
					System.out.print("How many to remove from pile A:");
					int pileRemoved_A = input.nextInt();
					coinsAt_A -= pileRemoved_A;
					System.out.printf("A: %d  B: %d  C: %d", coinsAt_A, coinsAt_B, coinsAt_C);
					turn++;
				}
				
				else if(pileChosen.equals("b") || pileChosen.equals("B")) {
					System.out.println("You have chosen pile B.");
					System.out.print("How many to remove from pile B:");
					int pileRemoved_B = input.nextInt();
					coinsAt_B -= pileRemoved_B;
					System.out.printf("A: %d  B: %d  C: %d", coinsAt_A, coinsAt_B, coinsAt_C);
					turn++;
				}
				
				else if(pileChosen.equals("c") || pileChosen.equals("C")) {
					System.out.println("You have chosen pile C.");
					System.out.print("How many to remove from pile C:");
					int pileRemoved_C = input.nextInt();
					coinsAt_C -= pileRemoved_C;
					System.out.printf("A: %d  B: %d  C: %d", coinsAt_A, coinsAt_B, coinsAt_C);
					turn++;
				}
			
			}
			
			
			else if (turn %2 == 0) {
				System.out.print("\n" + Player2 + ", choose a pile (A, B, C):");
				String pileChosen_2 = input.next();
				
				if(pileChosen_2.equals("a") || pileChosen_2.equals("A")) {
					System.out.println("You have chosen pile A.");
					System.out.print("How many to remove from pile A:");
					int pileRemoved_A = input.nextInt();
					coinsAt_A -= pileRemoved_A;
					System.out.printf("A: %d  B: %d  C: %d", coinsAt_A, coinsAt_B, coinsAt_C);
					turn++;
				}
				
				else if(pileChosen_2.equals("b") || pileChosen_2.equals("B")) {
					System.out.println("You have chosen pile B.");
					System.out.print("How many to remove from pile B:");
					int pileRemoved_B = input.nextInt();
					coinsAt_B -= pileRemoved_B;
					System.out.printf("A: %d  B: %d  C: %d", coinsAt_A, coinsAt_B, coinsAt_C);
					turn++;
				}
				
				else if(pileChosen_2.equals("c") || pileChosen_2.equals("C")) {
					System.out.println("You have chosen pile C.");
					System.out.print("How many to remove from pile C:");
					int pileRemoved_C = input.nextInt();
					coinsAt_C -= pileRemoved_C;
					System.out.printf("A: %d  B: %d  C: %d", coinsAt_A, coinsAt_B, coinsAt_C);
					turn++;
				}
				
			}
			
			if(coinsAt_A == 0 && coinsAt_B == 0 && coinsAt_C == 0) {
				switch(turn%2) {
				case 0: System.out.println("\n" + Player2 + " WON!"); break;
				case 1: System.out.println("\n" + Player1 + " WON!"); break;
				}
				break;
			}
			
			if(coinsAt_A < 0 || coinsAt_B < 0 || coinsAt_C < 0) {
				switch(turn%2) {
				case 0: System.out.println("\n" + "Cheat detected. " + Player2 + " WON!"); break;
				case 1: System.out.println("\n" + "Cheat detected. " + Player1 + " WON!"); break;
				}
				break;
			}
			
		}
		
		input.close();
		
	}

}
