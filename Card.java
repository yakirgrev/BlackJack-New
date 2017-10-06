import java.util.Random;

public class Card {
	private int i;
	private int j;
	private static int [][] validCards = new int [3][13];
	
	public Card(){
		Random rand = new Random();
		i = rand.nextInt(3);
		j = rand.nextInt(13);
		
		while(validCards[i][j]==1){
			i = rand.nextInt(2);
			j = rand.nextInt(12);
		}
		validCards[i][j]=1;
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public int getJ() {
		return j;
	}

	public void setJ(int j) {
		this.j = j;
	}

	public static int[][] getValidCards() {
		return validCards;
	}
	
	//method to interpret cards by location
	public String whatCardIsIt(int i,int j){
		String suit="";
		switch (i){
		case 0: suit="Red Diamonds";break;
		case 1: suit="Black Clubs";break;
		case 2: suit="Red Hearts";break;
		case 3: suit="Black Spades";break;
		}
		return whatValueIsIt(j)+" "+suit;		
	}
	
	public static int whatValueIsIt(int j){
		if(j>=8 && j<=11)return 10;			
		if(j==12)return 100;
		return j+2;
	}
	
	
}
