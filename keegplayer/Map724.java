import bc.GameController;
import bc.MapLocation;
import bc.PlanetMap;
import bc.VecUnit;

public class Map724 {

    static GameController gc = Player.get_gc();

    enum State {
        REFLECTED,
        ROTATED,
        NONE
    }

    public static PlanetMap map;
    public static State state;
    public static int width;
    public static int height;
    public static boolean passable[][];

    public static void initMap(){
        map = gc.startingMap(gc.planet());
        width = (int) map.getWidth();
        height = (int) map.getHeight();
        passable = new boolean[width][height];
        state = typeOfSymmetry();

        long time = System.nanoTime();

        MapLocation loc = new MapLocation(gc.planet(),0,0);

        for (int x = 0; x < width; x++){
            for (int y = 0; y < height; y++){
                loc.setX(x);
                loc.setY(y);
                passable[x][y] = map.isPassableTerrainAt(loc) == 1;
            }
        }
//        Debug.printMap();

        time = System.nanoTime() - time;
        System.out.println("Time for method 1: "+time);

        boolean passable2[][] = new boolean[width][height];

        long time2 = System.nanoTime();

        for (int x = 0; x < width; x++){
            for (int y = 0; y < height; y++){
                loc.setX(x);
                loc.setY(y);
                passable2[x][y] = passable2[x][y];
            }
        }

        time2 = System.nanoTime() - time2;
        System.out.println("Time for method 2: "+time2);
    }

    static State typeOfSymmetry(){
        VecUnit initialUnits = map.getInitial_units();
        System.out.println("Initial units list size -> "+initialUnits.size());
        for(int i = 0; i < initialUnits.size(); i++){
            System.out.println("Initial unit : "+i+" team: "+initialUnits.get(i).team());
            System.out.println("Unit loc :"+initialUnits.get(i).location());

        }
        return State.NONE;
    }

}
