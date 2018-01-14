import bc.*;

import java.util.ArrayList;

public class Player {

    static GameController gc = null;
    static ArrayList<Group> army = new ArrayList<>();

    public static void main(String args[]){
        gc = get_gc();
        if (gc.planet() == Planet.Earth){
            Map724.initMap();
            System.out.println(gc.unit(gc.units().get(0).id()).location().mapLocation());
            runEarth();
        }
        else {
            runMars();
        }

    }

    static void runEarth(){
        while (true) {
//            for (Group group : army)
//                group.turn();

            gc.nextTurn();
        }
    }

    static void runMars(){
        while (true) {



            gc.nextTurn();
        }
    }

    static GameController get_gc(){
        if (gc == null)
            gc = new GameController();
        return gc;
    }

    public class Location724 {
        public int x;
        public int y;
    }

    public class Bot724 {
        public int id;
        public UnitType type;
        public Location724 loc;
        public int move_cd;
        public int attack_cd;
        public int active_cd;
    }

}

