package PlayCardGame;

import java.util.*;

public class Game {

    public Game(GamePolicy policy)
    {
        String players[] = {"Player1", "Player2"};

        // set the policy
        _policy = policy;

        // Initialize the deck.
        _deck = new Deck(_policy);

        // Initialize the card comparator.
        _cc = new CardComparator();

        // Initialize the players
        _players = new ArrayList<Player>(_policy.getGamePlayers());

        // I HATE this loop...
        for (int p = 0; p < _policy.getGamePlayers(); p++)
        {
            _players.add(new Player(players[p], _deck, _policy));
        }

        // init our stats.
        _handsPlayed = 0;
    }

    public void play()
    {
        // Begin turn-based play.
        //
        // Each Player should have an initialized hand, an empty play and an empty
        // kitty.
        //
        // Continue until we are out of cards.
        // while (_deck.size() > 0)
        //
        // Note - War specific code. Needs to be injected by the policy.
        while (_players.get(0).cardsLeft() > 0 && _players.get(1).cardsLeft() > 0) 
        {
            //
            // Determine the results of the round.
            //
            playWar();
        }

        //
        // Display and Check the results
        //
        for (Player p : _players) 
        {
            System.out.printf("GAME OVER.  Hands Playerd: %d\n", _handsPlayed);

            if (p.cardsLeft() == 0 || p.cardsLeft() == _policy.getGameDeckSize())
            {
                // Valid result.
                System.out.printf(p.toString());
            }
            else
            {
                // Error result
                System.out.printf("Error:" + p.toString());
            }
        }
    }

    //
    // This behavior should be in the policy
    //
    private void playWar()
    {
        //
        // for WAR, see if player1 or player2 won or tied.
        //
        _handsPlayed++;
        if ((_handsPlayed % _policy.getGameDeckSize()) == 0)
        {
            // Every 26 hands, shuffle each player's decks.
            for (Player p : _players) {
                p.shuffle();
            }

            /*
            System.out.printf("Hands: %d\n playWar()- %d, %d\n",
                _handsPlayed,
                _players.get(0).cardsLeft(),
                _players.get(1).cardsLeft());

                if (_handsPlayed > 8000) System.exit(-1);
            */
        }

        if (_players.get(0).cardsLeft() > 0 && _players.get(1).cardsLeft() > 0)
        {
            // 
            // Each player plays a card.
            //
            for (Player p : _players) {
                p.playCard();
            }

            if (_cc.operate(CardComparator.Op.GTHAN,
                    _players.get(0).getLastCardPlayed(),
                    _players.get(1).getLastCardPlayed(),
                    _policy))
            {
                // Add  player[0] _play and player[1] _play to player[0] _hand
                _players.get(0).addToHand(_players.get(0).getPlayDeck());
                _players.get(0).addToHand(_players.get(1).getPlayDeck());

                _players.get(0).clearPlayCards();
                _players.get(1).clearPlayCards();

            }
            else if (_cc.operate(CardComparator.Op.LTHAN,
                    _players.get(0).getLastCardPlayed(),
                    _players.get(1).getLastCardPlayed(),
                    _policy))
            {
                // Add  player[0] _play and player[1] _play to player[1] _hand
                _players.get(1).addToHand(_players.get(0).getPlayDeck());
                _players.get(1).addToHand(_players.get(1).getPlayDeck());

                _players.get(0).clearPlayCards();
                _players.get(1).clearPlayCards();

            }
            else if (_cc.operate(CardComparator.Op.EQUALS,
                    _players.get(0).getLastCardPlayed(),
                    _players.get(1).getLastCardPlayed(),
                    _policy))
            {
                //  WE ARE AT WAR!
                System.out.println("We are at WAR");

                //
                // Each player plays an extra card here since
                // we'll re-entre and deal another card at the top.
                // This enforces the rules of War.
                //
                // The winner gets all the cards.
                //
                // Note:  this is recursive until we don't have a tie.
                //
                // if either player has 0 cardsLeft then both players
                // need to reconcile _play w/_hand and continue.
                if (_players.get(0).cardsLeft() == 0 || _players.get(1).cardsLeft() == 0)
                {
                    _players.get(0).addToHand(_players.get(0).getPlayDeck());
                    _players.get(1).addToHand(_players.get(1).getPlayDeck());

                    _players.get(0).clearPlayCards();
                    _players.get(1).clearPlayCards();
                }

                //
                // Now play another card.
                //
                for (Player p : _players) { p.playCard(); } 
                  
                // Here we go again!!!
                playWar();

                System.out.println("We ended a WAR");
            }
            else
            {
                // Throw an exception
                System.out.println("Failed Comparison");
            }

        }
        else
        {
            //
            // At least one player is out of cards.
            //
            // Scenario - Went to War and played the initial down card, but
            // one player did not have another to play - need to reconcile _play back
            // to _hand and play another hand.
                _players.get(0).addToHand(_players.get(0).getPlayDeck());
                _players.get(1).addToHand(_players.get(1).getPlayDeck());

                _players.get(0).clearPlayCards();
                _players.get(1).clearPlayCards();
        }
    }
 
    private ArrayList<Player> _players;
    private GamePolicy _policy;
    private Deck _deck;
    private CardComparator _cc;

    private int _handsPlayed;
}