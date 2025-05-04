
public class Card {
	private String suit;
	private int rank;
	
	public Card(String suit, int rank) {
		this.suit = suit;
		this.rank = rank;
	}
	public void setSuit(String suit) {
		this.suit = suit;
	}
	public String getSuit() {
		return suit;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public int getRank() {
		return rank;
	}
	
	public int sameRank(Card c) {
		int n = 0;
		if(rank == c.getRank()) {
			n = 1;
		}
		return n;
	}
	
	public boolean isOneA(Card c) {
		int r2 = c.getRank();
		return(rank == 1 && r2 != 1);
		
	}
	public int isStraight(Card c) {
		int n = 0;
		if(rank == 1 && c.getRank() == 10) {
			n = 1;
		}else if(rank == 2 && c.getRank() == 11) {
			n = 1;
		}else if(rank == 3 && c.getRank() == 12) {
			n = 1;
		}else if(rank == 4 && c.getRank() == 13) {
			n = 1;
		}else if(c.getRank() - rank == 1){
			n = 1;
		}
		return n;
	}
	public boolean isFlush(Card c) {
		return suit.equals(c.getSuit());
	}
	public boolean isFullHouse(Card c) {
		return rank == c.getRank();
	}
	public boolean isFourOfaKing(Card c) {
		return rank != c.getRank();
	}

	
	
	
	
	
}
