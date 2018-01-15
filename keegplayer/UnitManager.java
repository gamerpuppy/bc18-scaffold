import bc.GameController;
import bc.Unit;
import bc.VecUnit;

import java.util.HashMap;

class UnitManager {

    static GameController gc;

    private static final int UNIT_MAP_SIZE = 5000;
    private static final int NEW_ARRAY_SIZE = 100;

    static HashMap<Integer, Integer> unitMap;
    static Entity active[];
    private static int nextIdx = 0;
    static int newUnits[];
    static int newLen = 0;

    static void init(){
        gc =  Player.get_gc();
        unitMap = new HashMap<Integer, Integer>(UNIT_MAP_SIZE);
        newUnits = new int[NEW_ARRAY_SIZE];

        active = new Entity[200];
        for(int i = 0; i < active.length; i++){
            active[i] = new Entity();
        }



    }

    static void update(){
        newLen = 0;
        VecUnit unitList = gc.myUnits();
        long listSize = gc.units().size();

        for(int i = 0; i < listSize; i++){

            Unit unit = unitList.get(i);
            int id = unit.id();
            Integer value = unitMap.get(id);
            if (value == null){
                unitMap.put(id, nextIdx);
                entities[nextIdx].init(unit);
                newUnits[newLen] = nextIdx;
                newLen++;
                nextIdx++;
            } else {
                entities[value].last_seen = Player.turn;
                entities[value].hp = (short) unit.health();
            }
        }
    }

}

