import IntfSim.*;

public class Sim 
{
    public Sim() {}

    static public void main(String[] args) 
    {
        System.out.println("Testing ConcreteInterface through a NocjarInterface");

        NocjarInterface ni = new ConcreteClass();

        ni.testNocjarInterface("implementing testNocjarInterface");
    }
}