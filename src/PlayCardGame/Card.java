package PlayCardGame;

public class Card 
{
    public Card() {}

    public Card(CardValue value, CardSuit suit)
    {
        _suit = suit;
        _value = value;
    }    

    // equals as will be used to determine if a Card
    // is unique as part of a Set<Card>.
    public boolean equals(Card card)
    {
        return ((this._suit == card.getSuit() &&
            this._value == card.getValue()) ? true : false);
        
    }

    @Override
    public String toString()
    {
        return ("Card[" + _value.getCardValueString() + " of " + _suit.getSuitString() + "]");
    }

    public CardSuit getSuit() { return _suit; }
    private CardSuit _suit;

    public CardValue getValue() { return _value; }
    private CardValue _value;
}