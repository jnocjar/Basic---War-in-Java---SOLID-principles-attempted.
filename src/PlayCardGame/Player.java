package PlayCardGame;

import java.util.*;

public class Player {

    public Player(String name, Deck deck, GamePolicy game)
    {
        _name = name;

        // Deal our hand from deck.
        _hand = new Hand(deck, game.getGameHandSize());

        // initialize an empty kitty deck.
        _kitty = new Deck();

        // initialize the play deck to empty.
        _play = new Deck();
    }

    public void playCard()
    {
        //
        // Move the next card in _hand to the end of _play
        // NOTE:  this is an ASSUMPTION.
        //
        // Specific strategies go here.
        //
        _lastCardPlayed = _hand.getCard();
        _play.add(_lastCardPlayed);

        //System.out.printf("Pl: %s\n", _lastCardPlayed.toString());
    }

    public void shuffle() { _hand.shuffle(); }

    public Card getLastCardPlayed()
    {
        return _lastCardPlayed;
    }

    public void clearPlayCards() { _play.clear(); }

    public void addToHand(Deck deck)
    {
        for (Card c : deck.getCards()) _hand.addCard(c);
    }

    public void addToKitty(List<Card> cards)
    {
        for (Card c : cards) _kitty.add(c);
    }

    public Deck getPlayDeck()
    {
        return _play;
    }

    public String playerName(String name)
    {
        if (name != null)
        {
            _name = name;
        }
        return (_name);
    }

    @Override
    public String toString()
    {
        String playerString;

        playerString = "Player[" + _name + "] Cards Left " + this.cardsLeft() + " hand: " + 
            this._hand.toString() + "\nplay:" + 
            this._play.toString() + "\n";

            return(playerString);
    }

    public int cardsLeft() { return _hand.getHand().size(); }
    public int rewards() { return _kitty.size(); }

    private Card _lastCardPlayed;
    private Deck _play;
    private Hand _hand;
    private Deck _kitty;

    private String _name;
}