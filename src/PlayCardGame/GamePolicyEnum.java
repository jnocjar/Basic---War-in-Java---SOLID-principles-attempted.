package PlayCardGame;

//
// FOR NOW- this is an Enum with little game-specific attributes
// other than a name and the size of the deck.
//
// Future extensions would be to add the'suits' the 'values' and
// other game-specific things such as "the trump behavior of black jacks in Spades".
// etc...  Perhaps a Class in the future?
//
public enum GamePolicyEnum {

    NONE("None", 0, 0, 0),
    WAR("War", 52, 2, 26),
    NEXT("Next", 0, 0, 0);

    // constructor //
    private GamePolicyEnum(String name, int sz, int plyrs, int hand) 
    { _name = name; _size = sz; _players = plyrs; _handSize = hand; }

    // member get's
    public int getGameSize() { return _size; }
    public int getGameHandSize() { return _handSize; }
    public int getGamePlayers() { return _players; }
    public String getGameName() { return _name; }

    private final int _size;
    private final int _handSize;
    private final int _players;
    private final String _name;
}