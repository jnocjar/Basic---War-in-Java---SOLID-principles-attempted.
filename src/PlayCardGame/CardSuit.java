package PlayCardGame;

public enum CardSuit {

    HEARTS("Hearts"),
    SPADES("Spades"),
    DIAMONDS("Diamonds"),
    CLUBS("Clubs");

    public String getSuitString() { return this._suitString; }

    private CardSuit(String suit) { this._suitString = suit; }
    private final String _suitString;
}