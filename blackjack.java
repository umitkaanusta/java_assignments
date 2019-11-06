import java.util.Scanner;

public class Blackjack {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		int userTotal = 0;
		int compTotal = 0;
		
		int userFirstCard = 2 + (int) (Math.random() * 10);
		int userSecondCard = 2 + (int) (Math.random() * 10);
		int compFirstCard = 2 + (int) (Math.random() * 10);
		int compSecondCard = 2 + (int) (Math.random() * 10);
		
		int turn = 1;
		
		userTotal = userTotal + userFirstCard + userSecondCard;
		compTotal = compTotal + compFirstCard + compSecondCard;
		
		System.out.println("--------------------BLACKJACK--------------------");
		
		System.out.println("\n" + "----------------------------------------------------");
		System.out.printf("You pick a %d and a %d.", userFirstCard, userSecondCard);
		System.out.printf("\n" + "Your total is: %d", userTotal);
		
		System.out.println("\n" + "----------------------------------------------------");
		System.out.printf("Dealer picks a %d and a hidden card.", compFirstCard);
		System.out.println("\n" + "The dealer's initial total is also hidden.");
		
		while(true) {
			
			if(turn == 1) {
				
				if(userTotal > 21) {
					System.out.println("\n" + "You have exceeded 21. You lose."); 
					break;
				}
				
				System.out.print("\n" + "Do you want to hit(1) or stay(0):");
				int hitStay = input.nextInt();
				
				switch(hitStay) {
				case 0: turn++; break;
				case 1: int randomValue = 2 + (int) (Math.random() * 10);
				System.out.println("You draw a " + randomValue);
				userTotal += randomValue;
				System.out.println("Your total is: " + userTotal); break;
				}
				
			}
			
			else if(turn == 2) {
				
				if(compTotal > 21) {
					System.out.println("Dealer has exceeded 21. You WIN!");
					break;
				}
				
				int hitStay = (compTotal >= 19) ? 0 : 1;
				
				switch(hitStay) {
				case 0: turn++; break;
				case 1: int randomValue = 2 + (int) (Math.random() * 10);
				System.out.println("Dealer draws a" + randomValue);
				compTotal += randomValue;
				System.out.println("Dealer's total is:" + compTotal); break;
				}
					
			}
			
			if ((userTotal < 21 && compTotal < 21) && turn > 2) {
				
				if(userTotal > compTotal) {
					System.out.printf("\n" + "Dealer has %d against your %d. "
							+ "You WIN!", compTotal, userTotal);
					break;
				}
					
				if(userTotal < compTotal) {
					System.out.printf("\n" + "Dealer has %d against your %d. "
							+ "You lose.", compTotal, userTotal);
					break;
				}
				
				else if(compTotal == userTotal) {
					System.out.printf("\n" + "It is a tie. (%d - %d) "
							+ "You lose.", compTotal, userTotal);
					break;
				}
					
			}
			
			
		}
		
		input.close();

	}

}
