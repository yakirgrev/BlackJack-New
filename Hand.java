
public class Hand {
	private Card hand [];
	private int cardCounter;
	private int totalValue;
		
	public Hand(){
		hand = new Card[5];
		hand[0]=new Card();
		hand[1]=new Card();
		cardCounter=2;
		totalValue=Card.whatValueIsIt(hand[0].getJ())+Card.whatValueIsIt(hand[1].getJ());
		aceFix(true);
	}
	
	public void hit(){
		if(totalValue==21)return;//call stand method to finish
		if(cardCounter<5){
			hand[cardCounter] = new Card();
			totalValue+=Card.whatValueIsIt(hand[cardCounter].getJ());
			cardCounter++;
		}
		if(totalValue>99)aceFix(false);
	}
	
	public int stand(){
		return totalValue;
	}
	
	public void aceFix(boolean forCostructor){
		if(forCostructor){
			if(totalValue==200)totalValue=20;
			else
			if(totalValue>=100)totalValue-=90;
		}
		else{
			if(totalValue-90<=21)totalValue-=90;
			else totalValue-=99;
		}
	}
	
	public String toString(){
		String ans="";
		for(int i=0; i<cardCounter; i++){
			ans+=hand[i].whatCardIsIt(hand[i].getI(), hand[i].getJ())+"\n";
		}
		ans+="The total value is:"+totalValue;
		return ans;
	}
}
