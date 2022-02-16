package casino;
import java.util.Random;
/**
 * A stack of more than one deck used in a casino game
 *
 */
public class DeckStack {
	private Deck [] decks ;
	private int numDecks;
	private int totalCards;
	public DeckStack(int numDecks) 
	{
		this.numDecks = numDecks;
		this.decks = new Deck[numDecks];
		this.totalCards = this.numDecks * 52;
		restoreDecks();
	}
	
	public Card dealTopCard() 
	{
		Random rand = new Random();
		return decks[rand.nextInt(decks.length+1)].dealTopCard();
	}
	
	protected void restoreDecks() 
	{
		for(int i=0;i<decks.length;i++)
		{
			decks[i].shuffle();
		}
	}
	
	public int cardsLeft() 
	{
		int total = 0;
		for(int i=0;i<decks.length;i++)
		{
			total += decks[i].cardsLeft();
		}
		return total;
	}
	
	
}
