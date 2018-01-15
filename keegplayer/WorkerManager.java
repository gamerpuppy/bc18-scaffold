import bc.Direction;
import bc.GameController;
import bc.UnitType;

import java.util.ArrayList;

public class WorkerManager {

    static GameController gc = Player.get_gc();

    static final int MAX_WORKERS = 50;
    static ArrayList<Bot> workers = new ArrayList<>();

    static void turn(){
        for(Bot bot : workers){
            if (gc.canBlueprint(bot.id, UnitType.Factory, Direction.North))
                gc.blueprint(bot.id, UnitType.Factory, Direction.North);
//            gc.build(bot.id,);



        }
    }

}
