// import the API.
// See xxx for the javadocs.
import bc.*;

public class Player {
    public static void main(String[] args) {
        
        GameController gc = new GameController();

        while (true) {
            gc.nextTurn();
        }
    }
}