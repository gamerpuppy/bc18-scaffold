import bc.GameController;
import bc.Unit;
import bc.VecUnit;
import java.util.HashMap;

class UnitManager {

    static GameController gc = Player.get_gc();

    // Key: id Value: idx to store array
    private static HashMap<Integer, Integer> unitMap = new HashMap<>(5000);
    private static Entity store[] = new Entity[1000];
    private static int storeIdx = 0;

    static Entity active[] = new Entity[500];
    static Entity newUnits[] = new Entity[30];
    static Entity enemies[] = new Entity[300];
    static int activeLen = 0;
    static int newLen = 0;
    static int enemyLen = 0;

    static void init(){
        for(int i = 0; i < store.length; i++){
            store[i] = new Entity();
        }
    }

    static void update(){
        activeLen = 0;
        newLen = 0;
        enemyLen = 0;

        VecUnit unitList = gc.units();

        for(int i = 0; i < gc.units().size(); i++){

            Unit unit = unitList.get(i);
            int id = unit.id();
            Integer value = unitMap.get(id);
            boolean myteam = unit.team() == Player.team;

            Entity entity;
            if (value == null) {
                unitMap.put(id, storeIdx);
                entity = store[storeIdx++];
                entity.loc.set(unit.location().mapLocation());
            } else {
                entity = store[value];
                if (!myteam)
                    entity.loc.set(unit.location().mapLocation());
            }

            entity.seen = Player.turn;
            entity.myTeam = myteam;

            active[activeLen++] = entity;
            if (unit.team() == Player.team){
                newUnits[newLen++] = entity;
            } else {
                enemies[enemyLen++] = entity;
            }
        }

        updatePass();
    }

    private static void updatePass(){
        for (int i = 0; i < activeLen; i++) {
            Entity e = active[i];
            short x = e.loc.x;
            short y = e.loc.y;
            Map.pass[x][y] = false;
        }
    }

    static void finishTurn(){
        for (int i = 0; i < activeLen; i++) {
            Entity e = active[i];
            short x = e.loc.x;
            short y = e.loc.y;
            Map.pass[x][y] = false;
        }
    }


}

