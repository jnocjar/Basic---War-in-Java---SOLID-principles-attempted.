package PlayCardGame;

public enum CardValue 
{
    TWO(2, "Two"),
    THREE(3, "Three"),
    FOUR(4, "Four"),
    FIVE(5, "Five"),
    SIX(6, "Six"),
    SEVEN(7, "Seven"),
    EIGHT(8, "Eight"),
    NINE(9, "Nine"),
    TEN(9, "Ten"),
    JACK(10, "Jack"),
    QUEEN(11, "Queen"),
    KING(12, "King"),
    ACE(13, "Ace");

    private final int _value;
    private final String _valueString;

    public int getCardValue() { return this._value; }
    public String getCardValueString() { return this._valueString; }

    private CardValue(int value, String valueString) 
    {   
        this._value = value; 
        this._valueString = valueString; 
    }
}