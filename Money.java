
public class Money {
	private int cash;
	private int bet;
	
	public Money(){
		cash=100;
	}
	
	public boolean placeBet(int bet){
		if(bet<=cash && bet>-1){
			this.bet=bet;
			return true;
		}
		return false;
	}
	
	public int getCash(){
		return cash;
	}
	
	public int getBet(){
		return bet;
	}

	public void setCash(int cash) {
		this.cash = cash;
	}

	public void setBet(int bet) {
		this.bet = bet;
	}
	
	
}
