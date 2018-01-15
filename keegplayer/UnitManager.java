import bc.GameController;
import bc.Unit;
import bc.VecUnit;

import java.util.HashMap;

public class UnitManager {

    static GameController gc;

    static final int UNIT_MAP_SIZE = 5000;
    static final int MAX_UNITS = 5000;
    static final int NEW_ARRAY_SIZE = 100;

    static HashMap<Integer, Integer> unitMap;
    static Bot units[];
    static int nextIdx = 0;
    static int newUnits[];
    static int newLen = 0;

    public static void init(){
        gc =  Player.get_gc();
        unitMap = new HashMap<Integer, Integer>(UNIT_MAP_SIZE);
        newUnits = new int[NEW_ARRAY_SIZE];

        units = new Bot[MAX_UNITS];
        for(int i = 0; i < MAX_UNITS; i++){
            units[i] = new Bot();
        }
    }

    public static void update(){
        newLen = 0;
        VecUnit unitList = gc.myUnits();
        long listSize = gc.units().size();

        for(int i = 0; i < listSize; i++){

            Unit unit = unitList.get(i);
            int id = unit.id();
            Integer value = unitMap.get(id);
            if (value == null){
                unitMap.put(id, nextIdx);
                units[nextIdx].createBot(unit);
                newUnits[newLen] = nextIdx;
                newLen++;
                nextIdx++;
            } else {
                units[value].last_seen = Player.turn;
                units[value].hp = (short) unit.health();
            }
        }
    }

}

