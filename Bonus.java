import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Bonus {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String[] suits = input.nextLine().split(",");
		String[] Ranks = input.nextLine().split(",");
		
		int[] ranks = new int[5];
		for(int i = 0; i < 5; i++) {
			
			ranks[i] = getIntRank(Ranks[i]);
		}
		Card c1 = new Card(suits[0], ranks[0]);
		Card c2 = new Card(suits[1], ranks[1]);
		Card c3 = new Card(suits[2], ranks[2]);
		Card c4 = new Card(suits[3], ranks[3]);
		Card c5 = new Card(suits[4], ranks[4]);
		ArrayList<Card> hands = new ArrayList<Card>();
		hands.add(c1);
		hands.add(c2);
		hands.add(c3);
		hands.add(c4);
		hands.add(c5);
		
		//sort the hands by its rank value
		Collections.sort(hands, new Comparator<Card>() {
			public int compare(Card c1, Card c2) {
				return Integer.valueOf(c1.getRank()).compareTo(c2.getRank());
			}
		}		
		);
		
		int pt = 0;
		int r = 0; //check how many two cards' rank that close to each other are same
		int diff = 0; //check how many two cards' rank that close to each other differ 1
					  // if = 4, then it is a  straight
		boolean flush = true; //check if the hands is flush
		
		for(int i = 0; i < 4; i++) {
			r = r + hands.get(i).sameRank(hands.get(i+1));
		}
		
		for(int i = 0; i < 4; i++) {
			diff = diff + hands.get(i).isStraight(hands.get(i+1));
			
		}
		
		for(int i = 0; i < 4; i++) {
			if(! hands.get(i).isFlush(hands.get(i+1))) {
				flush = false;
				break;
			}
		}
			
	
		if(r == 3) { //is full house or four of a king
			if(hands.get(0).isFourOfaKing(hands.get(1)) || hands.get(3).isFourOfaKing(hands.get(4))) {
				pt = pt + 20;
			}else {
				pt = pt +10;
			}
		}else if(r == 2) { //having two pairs
			pt = pt + 4;
			if(hands.get(0).isOneA(hands.get(1))) {
				pt = pt +1;
			}
		}else if(r == 1) { //having one pair
			pt = pt + 2;
			if(hands.get(0).isOneA(hands.get(1))) {
				pt = pt +1;
			}
		}else { 
			if(flush && diff==4) { //is straight flush
				pt = 100;
			}else if(diff == 4) { //is straight
				pt = pt + 5;
			}else if(flush) { //is flush
				pt = pt + 3;
				if(hands.get(0).isOneA(hands.get(1))) {
					pt = pt +1;
				}
			}else {
				if(hands.get(0).isOneA(hands.get(1))) {
					pt = pt +1;
				}
			}
		}
		
		System.out.print(pt);
		
		input.close();
	}
	
	public static int getIntRank(String s) {
		String[] sRanks = {"0","A","2","3","4","5","6","7","8","9","10","J","Q","K"};
		int RANK = 0;
		for(int i = 0; i < sRanks.length; i++) {
			if(s.equals(sRanks[i])) {
				RANK = i;
			}
		}
		return RANK;
	}

}
