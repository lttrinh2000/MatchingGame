public class Driver
{
    public static void main(String []args)
    {
	Deck d = new Deck();
	d.setDifficulty('h');

        Prototype memoryPrototype = new Prototype(400,d);
    }
}

