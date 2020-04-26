import model.*;
import view.*;
import controller.*;

public class Driver {
    public static void main(String[] args)
    {
        Deck deck = new Deck("Easy");
        LayoutCards cards = new LayoutCards(deck);
        FullGameBoard game = new FullGameBoard(cards);
        game.createBoard(800);
        MemoryController gameController = new MemoryController(deck, game, cards);
    }
}