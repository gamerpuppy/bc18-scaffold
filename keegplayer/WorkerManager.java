import bc.Direction;
import bc.GameController;
import bc.UnitType;

import java.util.ArrayList;

class WorkerManager {

    static GameController gc = Player.get_gc();

    static final int MAX_WORKERS = 50;
    static ArrayList<Integer> workers = new ArrayList<>();
    static ArrayList<Integer> factories = new ArrayList<>();
    static ArrayList<Loc> bluePrints = new ArrayList<>();

    static void turn(){
        for(Integer w : workers){
            Bot worker = UnitManager.entities[w];

            boolean didBuild = false;
            for(Integer f : factories) {
                Bot fac = UnitManager.entities[f];
                boolean built = gc.unit(fac.id).structureIsBuilt() == 1;
                if (!built &&  worker.loc.isAdj(fac.loc) && gc.canBuild(worker.id, fac.id)) {
                    gc.build(worker.id,fac.id);
                    didBuild = true;
                }
            }

            if (!didBuild) {
                if (factories.size() < 2) {
                    boolean canBlueprint = gc.canBlueprint(worker.id, UnitType.Factory, Direction.Northeast);
                    if (canBlueprint) {
                        gc.blueprint(worker.id, UnitType.Factory, Direction.East);
                    }
                }
            }
        }

        for (Integer f : factories) {
            Bot fac = UnitManager.entities[f];
            boolean built = gc.unit(fac.id).structureIsBuilt() == 1;
            if(built) {
                Debug.println("fac built!", fac.id);
            } else {
                Debug.println(fac.hp);
            }

        }
    }

    static void addWorker(int idx){
        workers.add(idx);
    }

    static void addFactory(int idx){
        factories.add(idx);
    }

}
