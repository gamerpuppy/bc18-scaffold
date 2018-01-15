import bc.*;

public class Player {

    static GameController gc = null;
    static short turn = 0;
    static Team team;

    public static void main(String args[]){
        gc = get_gc();
        team = gc.team();

        if (gc.planet() == Planet.Earth){
            Map.init();
            UnitManager.init();
            runEarth();
        }
        else {
            runMars();
        }
    }

    static void runEarth(){
        while (true) {
            UnitManager.update();

            for(int i = 0; i < UnitManager.newLen; i++){

                int idx = UnitManager.newUnits[i];
                Bot bot = UnitManager.entities[idx];

                if (bot.type == UnitType.Worker) {
                    Debug.println("adding worker",bot);
                    WorkerManager.addWorker(idx);
                } else if (bot.type == UnitType.Factory){
                    Debug.println("adding factory",bot);
                    WorkerManager.addFactory(idx);
                }

            }
            WorkerManager.turn();


            nextTurn();
        }
    }

    static void runMars(){
        while (true) {



            nextTurn();
        }
    }

    static void nextTurn(){
        turn++;
        try {
            Debug.bw.flush();
        } catch (Exception e){}
        gc.nextTurn();
    }

    static GameController get_gc(){
        if (gc == null)
            gc = new GameController();
        return gc;
    }

}

