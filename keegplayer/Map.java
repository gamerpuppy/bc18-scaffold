import bc.*;

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
    static boolean base[][];
    static boolean pass[][];

    static void init(){
        map = gc.startingMap(gc.planet());
        width = (int) map.getWidth();
        height = (int) map.getHeight();
        pass = new boolean[width][height];
        base = new boolean[width][height];
//        state = typeOfSymmetry();
        state = State.NONE;

        MapLocation loc = new MapLocation(gc.planet(),0,0);
        for (int x = 0; x < width; x++){
            for (int y = 0; y < height; y++){
                loc.setX(x);
                loc.setY(y);
                pass[x][y] = map.isPassableTerrainAt(loc) == 1;
                base[x][y] = map.isPassableTerrainAt(loc) == 1;
            }
        }
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


    static void reversePass(Entity active[], int len){
        for(int i = 0; i < len; i++) {
            Entity e = active[i];
            short x = e.loc.x;
            short y = e.loc.y;
            pass[x][y] = true;
        }
    }

    static boolean onMap(Loc loc){
        boolean xCond =  loc.x >= 0 && loc.x < width;
        return xCond && loc.y >= 0 && loc.y < height;
    }


}
