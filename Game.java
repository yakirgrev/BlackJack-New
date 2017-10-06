import java.util.Scanner;

public class Game {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Hand player = new Hand();
		Hand computer = new Hand();
		Money playersMoney = new Money();
		int chosen=0;
		int bet=0;

		System.out.println("Welcome to BlackJack!\n\nPlace your bets:");
		bet = scan.nextInt();
		while(bet>playersMoney.getCash()){
			System.out.println("You don't have enough money for that bet..\nYou can bet on "+playersMoney.getCash()+"$ or less");
			bet = scan.nextInt();
		}		
		playersMoney.placeBet(bet);
		while(chosen==0 && playersMoney.getCash()>0){
			System.out.println("Choose: (1)Hit, (2)Stand (3)Quit");
			chosen = scan.nextInt();
			
			switch (chosen){
			case 1: 
				player.hit();
				System.out.println(player);
				if(player.stand()>21){//bust
					playersMoney.setCash(playersMoney.getCash()-playersMoney.getBet());
					System.out.println("Bust!.."+player.stand());				
					chosen=4;
				}else
					chosen=0;
				break;
			case 2: 
				if(player.stand()>computer.stand()){
				System.out.println("You Win! Your cards are:\n"+player+"\nThe computer's cards are:\n"+computer);
				playersMoney.setCash(playersMoney.getCash()+playersMoney.getBet());
				System.out.println("You have "+playersMoney.getCash()+"$");
				}
				else if(player.stand()==computer.stand()){
					System.out.println("Tie");
					chosen=0;
				}
				else{
					System.out.println("Computer Wins");
					playersMoney.setCash(playersMoney.getCash()-playersMoney.getBet());
					System.out.println("You have "+playersMoney.getCash()+"$");
				}		
				break;
			}
			if(chosen==2 || chosen==4){
				if(playersMoney.getCash()==0){System.out.println("No money left.. Good Game!");return;}
				System.out.println("Would you like another hand? (Y) YES (N) NO");
				String playAgain = scan.next();			
				if(playAgain.charAt(0) == 'Y' || playAgain.charAt(0)=='y'){
					player = new Hand();
					computer = new Hand();
					System.out.println("Place your bets:");
					bet = scan.nextInt();
					while(bet>playersMoney.getCash()){
						System.out.println("You don't have enough money for that bet..\nYou can bet on "+playersMoney.getCash()+"$ or less");
						bet = scan.nextInt();
					}
					playersMoney.placeBet(bet);
					System.out.println("You have: "+playersMoney.getCash()+"$\nAnd these cards:\n"+player+"\n");
					chosen = 0;				
				}else
				if(playAgain.charAt(0) == 'N' || playAgain.charAt(0)=='n')chosen = 3;
			}			
			}
		if(playersMoney.getCash()==0){System.out.println("No money left.. Good Game!");return;}		
		}		
	}
