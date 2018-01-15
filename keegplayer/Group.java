import bc.GameController;

public abstract class Group {
    static GameController gc = Player.get_gc();

    public int bots[];

    public abstract void turn();

}
