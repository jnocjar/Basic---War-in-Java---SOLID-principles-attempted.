package PlayCardGame;

import java.util.*;

public class Deck 
{
    static final int shuffleLoad = (56 * 2);

    public Deck ()
    {
        this(new GamePolicy("None"));
    }

    //
    // Constructor meant to be called by the dealer to setup their deck at game init.
    //
    public Deck (GamePolicy game)
    {
        _cards = new ArrayList<Card>(game.getGameDeckSize());

        if (game.getGameDeckSize() != 0)
        {
            //
            // For now init a deck appropriate for a game of War.
            //
            // NOTE-Cohesion: This init sequence allows addition
            // of differing Suits and Values without modification here.
            //
            // NOTE-Dependency Control: The activiting of initializing
            // the Deck should be contained in the ConcreteDeckPolicy Object
            // still to be defined- then no need to depend on CardValue or
            // CardSuit
            //
            // NOTE-Dependency Control:  Would be better
            // if Deck did not know about CardValue and CardSuit.
            //
            for (CardValue v : CardValue.values()) {
                for (CardSuit s : CardSuit.values()) {
                    _cards.add(new Card(v, s));
                }
            }
        }

        //
        // Do the initial shuffle of the deck
        //
        shuffle(shuffleLoad);
    }

    public Deck(List<Card> cards)
    {
        //
        // If you already have a Collection of Cards 
        // initialize your Deck here. 
        //
        // Note: there will be no shuffle.
        //
        _cards = new ArrayList<Card>(cards);
    }

    //
    // Function to shuffle the deck
    //
    public void shuffle() { this.shuffle (shuffleLoad); }
    protected void shuffle(int load)
    {
        if (_cards.size() > 0) 
        {
            // Get a random number between 0 and size.
            Random rand = new Random();

            //
            // One shuffle opeation consists of swapping
            // two cards at Random().
            //
            for (int i = 0; i < load; ++i) {
                int idx1 = rand.nextInt(_cards.size());
                int idx2 = rand.nextInt(_cards.size());

                // _cards.add(_cards.remove(rand.nextInt(_cards.size())));
                Collections.swap(_cards, idx1, idx2);
            }
        }
    }

    //
    // Function to return the next card FROM THE BEGINNING of the 'dealers' deck.
    //
    public Card deal()
    {
        //
        // Return the first card in the deck.
        //
        if (_cards.size() > 0)
        {
            return (_cards.remove(0));
        }
        else
        {
            System.exit(-1);
        }

        return null;
    }

    //
    // Function used to add card to the back deck.
    //
    public void add(Card card)
    {
        _cards.add(card);
    }

    public Card getLastCard()
    {
        return _cards.get(_cards.size() -1);
    }

    //
    // Function used to remove card from the deck.
    // 
    //
    public void remove(Card card)
    {
        _cards.remove(card);
    }

    //
    // Function to empty the deck of cards.
    //
    public void clear()
    {
        _cards.clear();
    }

    //
    // Return the number of Cards in the Deck.
    //
    public int size()
    {
        return _cards.size();
    }

    //
    // Function to return the List of Cards.
    //
    // This function is OO-heresy!!  Refactoring needed.
    //
    public List<Card> getCards()
    {
        return _cards;
    }

    //
    // Test function
    //
    public boolean overlap(Deck d)
    {
        for (Card c : _cards)
        {
            if (d._cards.contains(c))
            {
                return true;
            }
        }

        return false;
    }

    @Override
    public String toString() { return _cards.toString(); }

    public void dump()
    {
        //
        // NOTE-Cohestion:  This sequence also does not need to 
        // change with differing Suits and Values.
        //
        Iterator<Card> i = _cards.iterator();

        System.out.println(_cards.size());
        while (i.hasNext())
        {
            System.out.println(i.next());
        }
    }

    //
    // The Set of unique Cards currently held in 
    // the Deck.  As the Deck is dealt and a game
    // is simulated the contents of _cards will change.
    //
    // However, at the beginning and end of each simulation
    // the Deck 'should' be whole().
    //
    private List<Card> _cards;
}