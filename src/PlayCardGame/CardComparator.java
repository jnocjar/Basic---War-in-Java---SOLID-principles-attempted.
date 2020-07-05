package PlayCardGame;

public class CardComparator 
{
    public enum Op{ EQUALS, GTHAN, LTHAN };

    public CardComparator() {}

    //
    // Returns true if d1 is greater than d2,
    // false otherwise(including equeals).
    //
    public boolean operate(Op op, Card c1, Card c2, GamePolicy policy)
    {
        switch (op)
        {
            case EQUALS:
                return (c1.getValue().getCardValue() == c2.getValue().getCardValue() ? true : false);

            case GTHAN:
                return (c1.getValue().getCardValue() > c2.getValue().getCardValue() ? true : false);

            case LTHAN:
                return (c1.getValue().getCardValue() < c2.getValue().getCardValue() ? true : false);

            default:
                return false;
        }
    }
    
}