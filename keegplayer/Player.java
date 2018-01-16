import bc.*;

public class Player {

    static GameController gc = null;
    static short turn = 0;
    static Team team;

    public static void main(String args[]){
        gc = get_gc();
        team = gc.team();

        if (gc.planet() == Planet.Earth){
            Debug.startTime("map");
            Map.init();
            Debug.endTime("map");

            Loc loc = new Loc(5,2);
            Loc loc2 = new Loc(5,2);
            Debug.println("equals?",loc.equals(loc2));
            Path path = Path.getPathBFS(new Loc(10,2),new Loc(10,8));
            Debug.println(path.locList.size());
            Debug.printPath(path);
            UnitManager.init();
            runEarth();
        }
        else {
            runMars();
        }
    }

    static void runEarth(){
        while (true) {
            /* START TURN */
            UnitManager.update();




            /* END TURN */
            UnitManager.finishTurn();
            turn++;
            gc.nextTurn();
        }
    }

    static void runMars() {
        while (true) {

            gc.nextTurn();
        }
    }

    static GameController get_gc(){
        if (gc == null)
            gc = new GameController();
        return gc;
    }

}

