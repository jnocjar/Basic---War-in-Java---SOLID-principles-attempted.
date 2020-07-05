import PlayCardGame.*;

public class Sim 
{
    public Sim() {}

    static public void main(String[] args) 
    {
        System.out.println("Running Simulation...");

        GamePolicy policy = new GamePolicy("War");


        Game game = new Game(policy);

        game.play();

/*        Deck d = new Deck(game);

        System.out.println("Before Dealing");
        d.dump();

        //
        // Split the deck into 2 hands.
        //
        // 'd' should be empty afterwards.
        //
        Hand h1 = new Hand(d, game.getGameHandSize());
        Hand h2 = new Hand(d, game.getGameHandSize());

        System.out.println("Hand 1:");
        h1.dump();

        System.out.println("Hand 2:");
        h2.dump();

        if (h1.overlap(h2))
        {
            System.out.println("!!!!!Bad Deck!!!!!");
        }

        System.out.println("After Dealing");
        d.dump();
        */
    }
}