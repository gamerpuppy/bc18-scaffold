import bc.GameController;
import bc.MapLocation;
import bc.PlanetMap;
import bc.VecUnit;

class Map {

    static GameController gc = Player.get_gc();

    //TODO USE THIS INFO SOMEHOW
    enum State {
        REFLECTED,
        ROTATED,
        NONE
    }

    static PlanetMap map;
    static State state;
    static int width;
    static int height;
    static boolean wall[][];

    static void init(){
        map = gc.startingMap(gc.planet());
        width = (int) map.getWidth();
        height = (int) map.getHeight();
        wall = new boolean[width][height];
//        state = typeOfSymmetry();
        state = State.NONE;

        MapLocation loc = new MapLocation(gc.planet(),0,0);

        for (int x = 0; x < width; x++){
            for (int y = 0; y < height; y++){
                loc.setX(x);
                loc.setY(y);
                wall[x][y] = map.isPassableTerrainAt(loc) == 0;
            }
        }

//        Debug.printMap();

    }

    //TODO MAKE THIS WORK
    static State typeOfSymmetry(){
        VecUnit initialUnits = map.getInitial_units();
        System.out.println("Initial entities list size -> "+initialUnits.size());
        for(int i = 0; i < initialUnits.size(); i++){
            System.out.println("Initial unit : "+i+" team: "+initialUnits.get(i).team());
            System.out.println("Unit loc :"+initialUnits.get(i).location());

        }
        return State.NONE;
    }

}
