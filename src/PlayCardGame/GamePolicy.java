package PlayCardGame;

public class GamePolicy 
{
    //
    // The String game should be specified via
    // dependency injection (command line perhaps or read
    // from an input file).
    // Long Term, this details of the entire GamePolicy class
    // should be injected - all game-specific attributes
    // should not be assumed and then hard-coded into this
    // Class.
    public GamePolicy(String game)
    {
        switch (game)
        {
            case "War":
                _policy = GamePolicyEnum.WAR;
                break;

            case "None":
            default:
                _policy = GamePolicyEnum.NONE;
                break;
        }
    }

    public int getGameDeckSize() { return _policy.getGameSize(); }
    public int getGameHandSize() { return _policy.getGameHandSize(); }
    public int getGamePlayers() { return _policy.getGamePlayers(); }
    public String getGameName() { return _policy.getGameName(); }

    private GamePolicyEnum _policy;
}