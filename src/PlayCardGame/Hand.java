package PlayCardGame;

public class Hand 
{
    public Hand(Deck deck, int sz /*, Again Deck Policy should be be here */)
    {
        //
        // Initialize the deck that will represent this hand.
        //
        _deck= new Deck();

        //
        // Since we are defaulting to "War" deal half the deck
        // to this hand and each other hand(only one since War
        // only has 2 players).
        for (int i = 0; i < sz; i++)
        {
            _deck.add(deck.deal());
        }
    }

    public Card getCard() { return _deck.deal(); }
    public void addCard(Card c) { _deck.add(c); }
    public void shuffle() { _deck.shuffle(); } 

    @Override
    public String toString() { return(_deck.toString()); }

    public Deck getHand() { return _deck; }
    public boolean overlap(Hand h)
    {
        return(this._deck.overlap(h._deck));
    }

    // Debug function
    public void dump()
    {
        _deck.dump();
    } 

    private Deck _deck;
}